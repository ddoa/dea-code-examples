package nl.ica.ddoa.namer;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class DutchNamerTest {
    DutchNamer namer;

    @Before
    public void setup() {
        namer = new DutchNamer();
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
            assertEquals("Rody", namer.getFirstName());
            assertEquals("Middelkoop", namer.getLastName());
        } catch (InvalidNameException e) {
            fail();
        }
    }

}
