/**
 * Created by Michel Koolwaaij on 26-09-16.
 */
public class MicStudent implements IMicStudent {
    private String voornaam;
    private String achternaam;
    private String email;
    static int aantal;
    private int id;

    public MicStudent(String voornaam, String achternaam) {
        id = ++aantal;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = voornaam + "." + achternaam + "@han.nl";

    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
}
