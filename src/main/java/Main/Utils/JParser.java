package Main.Utils;
import Main.Collection.Address;
import Main.Collection.Coordinates;
import Main.Collection.Organization;
import Main.Collection.OrganizationType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class JParser {
    CollectionManager collectionManager;
    public JParser(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    public HashMap<Integer, Organization> parse(String file){
        HashMap<Integer, Organization> organizationsMap = new HashMap<>();
        JSONParser parser = new JSONParser();

        try (InputStreamReader reader = new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            for (Object key : jsonObject.keySet()) {
                String orgKey = (String) key;
                JSONObject orgJson = (JSONObject) jsonObject.get(orgKey);
                Organization org = new Organization();
                Long id = (Long.valueOf(orgJson.get("id").toString()));
                if (id > collectionManager.getLastId()){collectionManager.setLastId(id);}
                org.setId(id);
                org.setName(orgJson.get("name").toString());
                JSONObject coordinatesJson = (JSONObject) orgJson.get("coordinates");
                Coordinates coordinates = new Coordinates();
                coordinates.setX(Integer.valueOf(coordinatesJson.get("x").toString()));
                coordinates.setY(Double.valueOf(coordinatesJson.get("y").toString()));
                org.setCoordinates(coordinates);
                String creationDateStr = orgJson.get("creationDate").toString();
                org.setCreationDate(LocalDate.parse(creationDateStr));
                org.setAnnualTurnover(Double.valueOf(orgJson.get("annualTurnover").toString()));
                org.setFullName(orgJson.get("fullName").toString());
                String typeStr = orgJson.get("type").toString();
                org.setType(OrganizationType.fromString(typeStr));
                JSONObject addressJson = (JSONObject) orgJson.get("postalAddress");
                Address address = new Address();
                address.setZipCode((String) addressJson.get("zipCode"));
                org.setPostalAddress(address);
                organizationsMap.put(Integer.valueOf(orgKey), org);
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


        public void convertToJson(HashMap<Integer, Organization> organizations, String file) {
            JSONObject orgJ = new JSONObject();
            try (PrintWriter writer = new PrintWriter(new FileOutputStream(file))) {
                for (Integer key : organizations.keySet()) {
                    Organization org = organizations.get(key);
                    JSONObject orgJson = new JSONObject();
                    orgJson.put("id", org.getId());
                    orgJson.put("name", org.getName());
                    orgJson.put("creationDate", org.getCreationDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
                    JSONObject coords = new JSONObject();
                    coords.put("x", org.getCoordinates().getX());
                    coords.put("y", org.getCoordinates().getY());
                    orgJson.put("coordinates", coords);
                    orgJson.put("annualTurnover", org.getAnnualTurnover());
                    orgJson.put("fullName", org.getFullName());
                    orgJson.put("type", org.getType().name());
                    JSONObject address = new JSONObject();
                    address.put("zipCode", org.getPostalAddress().getZipCode());
                    orgJson.put("postalAddress", address);
                    orgJ.put(key, orgJson);
                }
                writer.write(orgJ.toJSONString());
                writer.flush();
            } catch (Exception e) {
                Consoll.printSmt("Произошла ошибка при записи в файл " );
            }
        }
    }
