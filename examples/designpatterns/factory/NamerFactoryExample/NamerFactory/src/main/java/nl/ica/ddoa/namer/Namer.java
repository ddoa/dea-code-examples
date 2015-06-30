package nl.ica.ddoa.namer;

public interface Namer {

    public void parseName(String name) throws InvalidNameException;

    public String getFirstName();

    public String getLastName();

}