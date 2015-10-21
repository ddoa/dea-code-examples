package nl.ica.ddoa.dda.springexample;

import org.junit.Test;

import nl.han.ica.oose.dea.examples.designpatterns.AlmostWorkingDatabaseManager;

public class DatabaseManagerTest {

	@Test(expected = NullPointerException.class)
	public void testConnectNull() {
		AlmostWorkingDatabaseManager.getInstance().connect(null);
	}

	@Test
	public void testConnect() {
		AlmostWorkingDatabaseManager.getInstance().connect("user=rody;pass=henkie");
	}

}
