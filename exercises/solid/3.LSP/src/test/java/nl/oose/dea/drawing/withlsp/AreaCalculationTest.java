package nl.oose.dea.drawing.withlsp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaCalculationTest {

    @Test
    public void sixFor2x3Rectangle() throws Exception {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(2);
        rectangle.setWidth(3);

        assertEquals(6, rectangle.area());
    }

    @Test
    public void nineFor3x3Square() throws Exception {
        Square square = new Square();
        square.setSideLength(3);

        assertEquals(9, square.area());
    }

    @Test
    public void twentyFor4x5RectangleFromSquare() throws Exception {
        final Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(4);

        final Square square = new Square();
        square.setSideLength(3);

        List<Shape> shapes = new ArrayList<Shape>() {{
            add(rectangle);
            add(square);
        }};

        List<Integer> areas = new ArrayList<Integer>();
        for(Shape shape:shapes)
        {
            areas.add(shape.area());
        }

        assertEquals(20, areas.get(0).intValue());
        assertEquals(9, areas.get(1).intValue());
    }
}