package nl.ica.ddoa.dda.example;

/**
 * @author rodmiddel
 * Verzameling methoden waarmee je 
 * rekenkundige trucjes kunt doen.
 */
public class MathTools {
    public static int max(int a, int b, int c) {
        // if (a > Integer.MAX_VALUE) throw new IllegalArgumentException();
        return Math.max(Math.max(a, b), c);
    }
}
