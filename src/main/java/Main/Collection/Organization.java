package Main.Collection;

import java.time.LocalDate;

public class Organization implements Comparable<Organization>{
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double annualTurnover; //Значение поля должно быть больше 0
    private String fullName; //Значение этого поля должно быть уникальным, Поле может быть null
    private OrganizationType type; //Поле может быть null
    private Address postalAddress; //Поле не может быть null

    public void setCreationDate(LocalDate creationDate) {
        if (creationDate == null) throw new IllegalArgumentException("время создания не может быть null");
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public double getAnnualTurnover() {
        return annualTurnover;
    }

    public String getFullName() {
        return fullName;
    }

    public OrganizationType getType() {
        return type;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public void setId(Long id) {
        if (id <= 0) throw new IllegalArgumentException("Id должно быть > 0");
        this.id = id;
    }


    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("имя не может быть null");
        if (name.isEmpty()) throw new IllegalArgumentException("имя не может быть пустым");
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) throw new IllegalArgumentException("координаты не могут быть null");
        this.coordinates = coordinates;
    }

    public void setAnnualTurnover(Double annualTurnover) {
        if (annualTurnover == null) throw new IllegalArgumentException("оборот не может быть null");
        if (annualTurnover <= 0) throw new IllegalArgumentException("оборот должен быть > 0");
        this.annualTurnover = annualTurnover;
    }

    public void setFullName(String fullName) {
        if (fullName == null) throw new IllegalArgumentException("полное имя не может быть null");
        if (fullName.length() > 1354) throw new IllegalArgumentException("слишком длинное!");
        this.fullName = fullName;
    }

    public void setType(OrganizationType type) {
        if (type == null) throw new IllegalArgumentException("тип не может быть null");
        this.type = type;
    }

    public void setPostalAddress(Address postalAddress) {
        if (postalAddress == null) throw new IllegalArgumentException("адрес не может быть null");
        this.postalAddress = postalAddress;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", annualTurnover=" + annualTurnover +
                ", fullName='" + fullName + '\'' +
                ", type=" + type +
                ", postalAddress=" + postalAddress +
                '}';
    }

    @Override
    public int compareTo(Organization o) {
        return (int)(this.annualTurnover - o.annualTurnover);
    }
}