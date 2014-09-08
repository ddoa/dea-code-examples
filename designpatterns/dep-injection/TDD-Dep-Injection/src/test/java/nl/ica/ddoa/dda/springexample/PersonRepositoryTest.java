package nl.ica.ddoa.dda.springexample;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PersonRepositoryTest {

	private PersonRepository pr;
	
	@Before
	public void setUp()
	{
		
		pr = new PersonRepository();
		pr.setMngr(new DatabaseManagerFactory().create());
	}
	
	@Test
	public void testEmptyRepository() {
		List<Person> klas = pr.list();
		assertEquals(0, klas.size());
	}

	@Test
	public void testRepositoryAfterAddingAPerson()
	{
		Person p = new Person();
		p.bsn = "1234567";
		p.name = "Rody";
		p.birthDate = Calendar.getInstance().getTime();
		pr.add(p);
		assertEquals(1, pr.list().size());
	}
}
