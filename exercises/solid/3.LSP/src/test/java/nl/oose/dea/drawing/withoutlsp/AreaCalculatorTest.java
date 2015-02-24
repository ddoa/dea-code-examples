package nl.oose.dea.drawing.withoutlsp;

import org.junit.Test;

import static org.junit.Assert.*;

public class AreaCalculatorTest {

    @Test
    public void sixFor2x3Rectangle() throws Exception {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(2);
        rectangle.setWidth(3);

        assertEquals(6, AreaCalculator.calulateArea(rectangle));
    }

    @Test
    public void nineFor3x3Square() throws Exception {
        Square square = new Square();
        square.setHeight(3);

        assertEquals(9, AreaCalculator.calulateArea(square));
    }

    @Test
    /**
     * Isn't supposed to fail, but it does because we did not apply the LSP-principle
     */
    public void twentyFor4x5RectangleFromSquare() throws Exception {
        Rectangle square = new Square();
        square.setHeight(5);
        square.setWidth(4);

        // It _is_ a Rectangle so we may expect the behaviour of the Rectangle class!
        assertEquals(20, AreaCalculator.calulateArea(square));
        // Apparently Square does not have the same behaviour as Rectangle, so it is _not_ a Rectangle
    }
}