package nl.oose.dea.drawing.withlsp;

public class Rectangle implements Shape {
    private int height;
    private int width;

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int area() {
        return width * height;
    }
}
