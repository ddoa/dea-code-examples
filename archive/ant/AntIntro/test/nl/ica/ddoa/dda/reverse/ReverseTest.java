package nl.ica.ddoa.dda.reverse;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReverseTest {
    private ReverseWord rw;

    @Before
    public void setUp() {
        rw = new ReverseWord();
    }

    @Test
    public void testEmptyString() {
        assertEquals("", rw.reverse(""));
    }

    @Test
    public void testOneLengthStringWithCharacterAAsContents() {
        assertEquals("a", rw.reverse("a"));
    }
    
    @Test
    public void testTwoLengthStringWithTwoDifferentCharacters()
    {
        assertEquals("ab", rw.reverse("ba"));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testNull()
    {
        rw.reverse(null);
    }

}
