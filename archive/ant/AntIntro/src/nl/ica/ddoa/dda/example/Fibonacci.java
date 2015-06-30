package nl.ica.ddoa.dda.example;

/**
 * @author rodmiddel
 * Implementation of Fibonacci formula:
 * http://nl.wikipedia.org/wiki/Rij_van_Fibonacci
 */
public final class Fibonacci {

    /**
     * Empty constructor, because of the static method.
     * We don't need a constructor actually, so we make it hidden.
     */
    private Fibonacci() {
    }

    /**
     * Implements Fibonacci formula which approaches the expansion of rabbit
     * families. Uses recursion.
     * @param k Number of rabbits to calculate the number of children for
     * @return Number of children, given k
     */
    public static int maakKonijntjes(final int k) {
        if (k == 0 || k == 1) {
            return k;
        }
        else if (k >= 2) {
            return maakKonijntjes(k - 1) + maakKonijntjes(k - 2);
        } else {
            return 0;
        }
    }
}
