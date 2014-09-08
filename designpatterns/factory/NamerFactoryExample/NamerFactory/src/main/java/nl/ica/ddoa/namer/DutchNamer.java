package nl.ica.ddoa.namer;

public class DutchNamer implements Namer {
    private String firstName;
    private String lastName;

    /**
     * 
     * @param name
     * @throws InvalidNameException
     *             thrown when name is empty or does not contain spaces
     */
    public void parseName(String name) throws InvalidNameException {
        if (name.length() == 0 || name.indexOf(" ") == -1)
            throw new InvalidNameException();
        firstName = name.substring(0, name.indexOf(" "));
        lastName = name.substring(name.indexOf(" ") + 1, name.length());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
