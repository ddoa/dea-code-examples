package nl.oose.dea.sorter;

import java.util.Random;

public class SortInputGenerator {
    public static final int MAX_ELEMENTS = 1000;

    private static final int MAX_WORD_LENGTH = 10;

    private Random r = new Random();

    /**
     * Generates a random collection of size MAX_ELEMENTS using' the nextRandom
     * function.
     *
     * @param type
     * @return a random collection of values with type is type
     */
    public Comparable[] generateCollection(String type) {
        Comparable[] collection = new Comparable[MAX_ELEMENTS];
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            collection[i] = nextRandom(type, MAX_ELEMENTS);
        }
        return collection;
    }

    /**
     * Using the Random class generate a random value of type 'type'
     *
     * @param type
     * @param max
     * @return the next random value of type 'type'
     * @see java.util.Random
     */
    private Comparable nextRandom(String type, int max) {
        if (type.equals("Integer"))
            return new Integer(r.nextInt(max));
        if (type.equals("String")) {
            String newString = "";
            for (int i = 0; i < r.nextInt(MAX_WORD_LENGTH); i++) {
                int next = 97 + r.nextInt(26);
                newString += (char) (next);
            }
            return newString;
        }
        return null;
    }
}
