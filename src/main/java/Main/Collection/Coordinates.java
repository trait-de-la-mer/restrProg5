package Main.Collection;

public class Coordinates {
    private int x;
    private Double y; //Поле не может быть null

    public void setX(Integer x) {
        if (x == null) throw new IllegalArgumentException("x не может быть null");
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return x + ";" + y;
    }

    public int getX() {
        return x;
    }

    public Double getY() {
        return y;
    }
}