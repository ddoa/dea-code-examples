package nl.oose.dea.drawing.withlsp;

public class Triangle implements Shape {
    private int base;
    private int height;

    public void setBase(int base) {
        this.base = base;
    }

    public int getBase() {
        return base;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int area() {
        return (base * height) / 2;
    }
}
