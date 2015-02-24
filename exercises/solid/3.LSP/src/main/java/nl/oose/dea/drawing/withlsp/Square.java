package nl.oose.dea.drawing.withlsp;

public class Square implements Shape {
    private int sideLength;

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    public int area() {
        return sideLength * sideLength;
    }
}
