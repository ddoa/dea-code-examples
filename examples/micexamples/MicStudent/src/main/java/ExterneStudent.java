/**
 * Created by Michel Koolwaaij on 26-09-16.
 */
public class ExterneStudent {
    private String vnaam;
    private String anaam;
    private String mail;
    private int studentnummer;

    public ExterneStudent(String vnaam, String anaam, String mail, int studentnummer){
        this.vnaam=vnaam;
        this.anaam=anaam;
        this.mail=mail;
        this.studentnummer=studentnummer;
    }

    public String getVnaam() {
        return vnaam;
    }

    public String getAnaam() {
        return anaam;
    }

    public String getMail() {
        return mail;
    }

    public int getStudentnummer() {
        return studentnummer;
    }
}
