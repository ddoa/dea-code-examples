package nl.ddoa.example.dice;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DobbelsteenTest 
{
    private Dobbelsteen ds;

    @Before
    public void setUp() throws Exception
    {
        ds = new Dobbelsteen();
    }

    @Test
    public void testDobbel()
    {
        for (int i = 0; i < 100; i++)
        {
            ds.dobbel();
            assertEquals(true, ds.getWaarde() <= 6);
            assertEquals(true, ds.getWaarde() >= 1);
        }
    }
}
