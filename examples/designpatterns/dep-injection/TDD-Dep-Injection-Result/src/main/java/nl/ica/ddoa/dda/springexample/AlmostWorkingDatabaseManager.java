package nl.ica.ddoa.dda.springexample;

/**
 * Incomplete (so almost working....) databasemanager. Its purpose is to show what pain we're in when this
 * class actually depended upon an RDBMS.
 *  
 * @author mdkr
 */
public class AlmostWorkingDatabaseManager implements DatabaseManager {
	public void save(Person p) {
		// @TODO
	}

	public void connect(String connectionString) {
		connectionString.toString();
	}

	public static DatabaseManager getInstance() {
		if (instance == null) 
		{
			instance = new AlmostWorkingDatabaseManager();
		}
		return instance;
	}

	/**
	 * Constuctor made private due to the Singleton construction
	 */
	private AlmostWorkingDatabaseManager()
	{
	}
	
	private static DatabaseManager instance;
}
