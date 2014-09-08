package nl.ica.ddoa.namer;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TakatoekalandNamerTest {
    Namer namer;

    @Before
    public void setup() {
        namer = new TakatoekalandNamer();
    }

    @Test(expected = InvalidNameException.class)
    public void emptyStringLeadsToInvalidNameException() throws InvalidNameException {
        namer.parseName("");
    }

    @Test(expected = InvalidNameException.class)
    public void stringWithoutSpacesLeadsToInvalidNameException() throws InvalidNameException {
        namer.parseName("Middelkoop");
    }

    @Test
    public void stringWithSpaceIsCorrectlyParsed() {
        try {
            namer.parseName("Rody Middelkoop");
            assertEquals("Middelkoop", namer.getFirstName());
            assertEquals("Rody", namer.getLastName());
        } catch (InvalidNameException e) {
            fail();
        }
    }

}
