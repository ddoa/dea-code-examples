package nl.ica.ddoa.dda.springexample;

public interface DatabaseManager {

	public abstract void save(Person p);

	public abstract void connect(String connectionString);

}