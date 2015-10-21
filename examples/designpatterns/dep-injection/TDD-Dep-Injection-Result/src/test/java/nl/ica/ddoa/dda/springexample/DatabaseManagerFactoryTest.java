package nl.ica.ddoa.dda.springexample;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.han.ica.oose.dea.examples.designpatterns.DatabaseManagerFactory;

public class DatabaseManagerFactoryTest {

	@Test
	public void test() {
		DatabaseManagerFactory fact = new DatabaseManagerFactory();
		assertNotNull(fact.create());
	}

}
