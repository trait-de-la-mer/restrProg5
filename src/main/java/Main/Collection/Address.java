package Main.Collection;

public class Address {
    private String zipCode; //Поле может быть null

    public void setZipCode(String zipCode) {
        if (zipCode == null) throw new IllegalArgumentException("индекс не может быть null");
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "zipCode='" + zipCode;
    }
}