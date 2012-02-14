package nl.ica.ddoa.dda.reverse;

public class ReverseWord {

    /**
     * Reverses the input, eg. "ab" to "ba"
     * @param nonReversed
     * @return
     */
    public final Object reverse(final String nonReversed) {
        if (nonReversed == null) {
            throw new IllegalArgumentException("Null is niet toegestaan als invoer");
        }
        StringBuffer nonReversedStringBuffer = new StringBuffer(nonReversed);
        return nonReversedStringBuffer.reverse().toString();
    }
}
