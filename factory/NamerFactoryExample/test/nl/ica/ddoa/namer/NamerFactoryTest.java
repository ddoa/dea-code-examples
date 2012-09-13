package nl.ica.ddoa.namer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NamerFactoryTest {
    private NamerFactory nf;

    @Before
    public void setup() {
        nf = NamerFactory.getInstance();
    }
    
    @Test
    public void seeIfGetInstanceAlwaysRefersToTheSameInstance()
    {
        assertNotNull(NamerFactory.getInstance());
        assertSame(NamerFactory.getInstance(), NamerFactory.getInstance());
    }

    @Test
    public void testIfTwoCallsLeadToDifferentInstances() {
        assertNotSame(nf.getNamer("NL"), nf.getNamer("NL"));
    }

    @Test
    public void testThatInvalidLanguageLeadsToNull() {
        assertNull(nf.getNamer(""));
    }

    @Test
    public void testDutch() {
        assertTrue(nf.getNamer("NL") instanceof DutchNamer);
    }

    @Test
    public void testTTL() {
        assertTrue(nf.getNamer("EN") instanceof TakatoekalandNamer);
    }

}
