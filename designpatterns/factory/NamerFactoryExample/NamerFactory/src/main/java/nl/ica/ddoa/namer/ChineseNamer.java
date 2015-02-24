package nl.ica.ddoa.namer;

public class ChineseNamer implements Namer {
    String name;

    @Override
    public void parseName(String name) throws InvalidNameException {
        this.name = name;
    }

    @Override
    public String getFirstName() {
        return "Li";
    }

    @Override
    public String getLastName() {
        return name;
    }
}
