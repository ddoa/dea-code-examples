package nl.han.ica.oose.dea.examples.designpatterns;

public class DatabaseManager {
	public void save(Person p) {
		// @TODO
	}

	public void connect(String connectionString) {
		connectionString.toString();
	}

	public static DatabaseManager getInstance() {
		if (instance == null) 
		{
			instance = new DatabaseManager();
		}
		return instance;
	}

	/**
	 * Constuctor made private due to the Singleton construction
	 */
	private DatabaseManager()
	{
	}
	
	private static DatabaseManager instance;
}
