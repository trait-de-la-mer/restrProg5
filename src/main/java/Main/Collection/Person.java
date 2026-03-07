package Main.Collection;

import Main.Collection.Color;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private double weight; //Значение поля должно быть больше 0
    private Color eyeColor; //Поле не может быть null

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("имя не может быть null");
        this.name = name;
    }

    public void setWeight(double weight) {
        if (weight <= 0) throw new IllegalArgumentException("ты явно весишь больше");
        this.weight = weight;
    }

    public void setEyeColor(Color eyeColor) {
        if (eyeColor == null) throw new IllegalArgumentException("цвет не может быть null");
        this.eyeColor = eyeColor;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public Color getEyeColor() {
        return eyeColor;
    }
    @Override
    public String toString() {
        return "name = " + name + ";" + "weight = " + weight + ";" + eyeColor;
    }
}