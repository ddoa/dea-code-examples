package nl.ica.ddoa.dda.example;

/**
 * @author rodmiddel
 * 
 */
public class User {
    private int id = 0;
    private String naam = null;

    public User(int id, String naam) {
        this.id = id;
        this.naam = naam;

        if (id <= 0) {
            throw new IllegalArgumentException("Id moet >= 0 zijn");
        }
        if (naam == null || naam.equals("") || naam.length() == 0) {
            throw new IllegalArgumentException("Naam niet correct");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id moet >= 0 zijn");
        }
        this.id = id;
    }

    public String getName() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam == null || naam.length() == 0) {
            throw new IllegalArgumentException("Naam niet correct");
        }
        this.naam = naam;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        User e1 = new User(1, "mdkr");
        e1.setNaam("Rody Middelkoop");
    }
}
