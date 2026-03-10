package Main.Utils;
import Main.Collection.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class JParser {
    static String file;
    CollectionManager collectionManager;
    public JParser(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    public HashMap<Integer, LabWork> parse(String file){
        JParser.file = file;
        HashMap<Integer, LabWork> organizationsMap = new HashMap<>();
        JSONParser parser = new JSONParser();

        try (InputStreamReader reader = new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            for (Object key : jsonObject.keySet()) {
                String orgKey = (String) key;
                JSONObject orgJson = (JSONObject) jsonObject.get(orgKey);
                LabWork lab = new LabWork();
                Long id = (Long.valueOf(orgJson.get("id").toString()));
                if (id > collectionManager.getLastId()){collectionManager.setLastId(id);}
                lab.setId(id);
                lab.setName(orgJson.get("name").toString());
                JSONObject coordinatesJson = (JSONObject) orgJson.get("coordinates");
                Coordinates coordinates = new Coordinates();
                coordinates.setX(Long.parseLong(coordinatesJson.get("x").toString()));
                coordinates.setY(Integer.valueOf(coordinatesJson.get("y").toString()));
                lab.setCoordinates(coordinates);

                JSONObject personJson = (JSONObject) orgJson.get("person");
                Person person = new Person();
                person.setName(personJson.get("personName").toString());
                person.setWeight(Double.parseDouble(personJson.get("personWeight").toString()));
                String personEyeType = personJson.get("eye").toString();
                person.setEyeColor(Color.fromString(personEyeType));
                lab.setAuthor(person);

                String creationDateStr = orgJson.get("creationDate").toString();
                lab.setCreationDate(LocalDate.parse(creationDateStr));
                lab.setMinimalPoint(Double.parseDouble(orgJson.get("minimalPoints").toString()));
                String typeStr = orgJson.get("difficulty").toString();
                lab.setDifficulty(Difficulty.fromString(typeStr));
                organizationsMap.put(Integer.valueOf(orgKey), lab);
            }

        } catch (FileNotFoundException e ){
            Consoll.printSmt("файл " + file + " не найден");
        } catch (NumberFormatException e){
            Consoll.printSmt("Проверь правильность введенных данных (возможно не тот тип данных)");
        } catch (IllegalArgumentException e){
            Consoll.printSmt(e.getMessage());
        } catch (IOException e) {
            Consoll.printSmt("Непредвиденная ошибка чтения файла " + file);
        } catch (ParseException e) {
          Consoll.printSmt("Что-то не так с данными файла");
        } catch (NullPointerException e) {
            Consoll.printSmt("Ошибка, возможно что-то не так с названиями полей");
        } catch (Exception e) {
            System.err.println("Критическая ошибка");;
        }
        return organizationsMap;
    }


        public void convertToJson(HashMap<Integer, LabWork> organizations) {
            JSONObject orgJ = new JSONObject();
            try (PrintWriter writer = new PrintWriter(new FileOutputStream(file))) {
                for (Integer key : organizations.keySet()) {
                    LabWork lab = organizations.get(key);
                    JSONObject orgJson = new JSONObject();
                    orgJson.put("id", lab.getId());
                    orgJson.put("name", lab.getName());
                    orgJson.put("creationDate", lab.getCreationDate().toString());
                    orgJson.put("minimalPoints", lab.getMinimalPoint());
                    orgJson.put("difficulty", lab.getDifficulty().toString());


                    JSONObject coordinatesJson = new JSONObject();
                    coordinatesJson.put("x", lab.getCoordinates().getX());
                    coordinatesJson.put("y", lab.getCoordinates().getY());
                    orgJson.put("coordinates", coordinatesJson);


                    JSONObject personJson = new JSONObject();
                    personJson.put("personName", lab.getAuthor().getName());
                    personJson.put("personWeight", lab.getAuthor().getWeight());
                    personJson.put("eye", lab.getAuthor().getEyeColor().toString());
                    orgJson.put("person", personJson);
                    orgJ.put(key, orgJson);
                }
                writer.write(orgJ.toJSONString());
                writer.flush();
            } catch (Exception e) {
                Consoll.printSmt("Произошла ошибка при записи в файл " );
            }
        }
    }
