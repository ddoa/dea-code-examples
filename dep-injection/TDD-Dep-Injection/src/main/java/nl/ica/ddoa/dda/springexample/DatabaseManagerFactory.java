package nl.ica.ddoa.dda.springexample;

/**
 * Hides the fact that AlmostWorkingDatabaseManager is a singleton and could be extended in a way that other 
 * DatabaseManager can be used. Is however not necessary to obtain dependency inversion. Also think of the consequences: 
 * we now have a DatabaseManagerFactory created using the constructor, what if we made it a singleton, wait, maybe
 * we could design a DatabaseManagerFactoryFactory that creates DatabaseManagerFactory.....
 * 
 * @author mdkr
 */
public class DatabaseManagerFactory {
	public DatabaseManager create() {
		return AlmostWorkingDatabaseManager.getInstance();
	}

}
