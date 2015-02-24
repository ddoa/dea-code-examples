package nl.oose.dea.drawing.withoutlsp;

/**
 * We use overloading here to create area-implementations for different types.
 *
 * It violates a principle called "Tell, don't ask". Rectangle and Square both
 * need to expose their properties to calculate the area. We're going to refactor that, because we
 * decoupled behaviour from state which is not a good example of information hiding.
 */
public class AreaCalculator {
    public static int calulateArea(Rectangle rectangle) {
        return rectangle.getHeight() * rectangle.getWidth();
    }

    public static int calulateArea(Square square) {
        return square.getHeight() * square.getHeight();
    }
}
