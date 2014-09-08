package nl.ica.ddoa.namer;

public class TakatoekalandNamer implements Namer {
    private String firstName;
    private String lastName;

    /* (non-Javadoc)
     * @see nl.ica.ddoa.namer.Namer#parseName(java.lang.String)
     */
    @Override
    public void parseName(String name) throws InvalidNameException {
        if (name.length() == 0 || name.indexOf(" ") == -1)
            throw new InvalidNameException();
        firstName = name.substring(name.indexOf(" ") + 1, name.length());
        lastName = name.substring(0, name.indexOf(" "));
    }

    /* (non-Javadoc)
     * @see nl.ica.ddoa.namer.Namer#getFirstName()
     */
    @Override
    public String getFirstName() {
        // TODO Auto-generated method stub
        return firstName;
    }

    /* (non-Javadoc)
     * @see nl.ica.ddoa.namer.Namer#getLastName()
     */
    @Override
    public String getLastName() {
        // TODO Auto-generated method stub
        return lastName;
    }
}
