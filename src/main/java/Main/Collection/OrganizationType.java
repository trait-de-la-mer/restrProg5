package Main.Collection;

public enum OrganizationType {
    COMMERCIAL,
    GOVERNMENT,
    PRIVATE_LIMITED_COMPANY;

    public static OrganizationType fromString(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Вы не ввели тип организации!");
        }
        try {
            return valueOf(value.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Недопустимый тип организации");
        }
    }
}