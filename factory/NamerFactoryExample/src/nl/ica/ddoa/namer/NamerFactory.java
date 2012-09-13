package nl.ica.ddoa.namer;

public class NamerFactory {
    private static NamerFactory instance;

    private NamerFactory() {
    }

    public static NamerFactory getInstance() {
        if (instance == null) {
            instance = new NamerFactory();
        }
        return instance;
    }

    public Namer getNamer(String language) {
        if (language.equals("NL"))
            return new DutchNamer();
        else if (language.equals("EN"))
            return new TakatoekalandNamer();
        else
            return null;
    }

}
