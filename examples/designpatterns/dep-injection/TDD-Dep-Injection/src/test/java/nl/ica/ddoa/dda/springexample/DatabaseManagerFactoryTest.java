package nl.ica.ddoa.dda.springexample;

import static org.junit.Assert.*;

import org.junit.Test;

public class DatabaseManagerFactoryTest {

	@Test
	public void test() {
		DatabaseManagerFactory fact = new DatabaseManagerFactory();
		assertNotNull(fact.create());
	}

}
