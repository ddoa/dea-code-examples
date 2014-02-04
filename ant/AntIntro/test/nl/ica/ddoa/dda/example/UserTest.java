package nl.ica.ddoa.dda.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserTest 
{	
	@Test
    public void correctConstructor()
    {
        int id = 1313;
        String name = "mdkr";
        User e1 = new User(id, name);
        assertEquals("Happy Path id test failed", id, e1.getId());
        assertEquals("Happy Path name test failed", name, e1.getName());
    }

	@Test(expected=IllegalArgumentException.class)
	public void testNegativeNumbers()
	{
        User e2 = new User(-123, "mdkr");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testEmptyString()
	{
        User e4 = new User(1,"");
	}

	@Test(expected=IllegalArgumentException.class)
	public void zeroId()
	{
        User e3 = new User(0, "mdkr");
	}	
}
