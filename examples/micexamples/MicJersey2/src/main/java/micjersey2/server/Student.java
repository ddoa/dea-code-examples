package micjersey2.server;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Michel Koolwaaij on 26-09-16.
 */
@XmlRootElement
public class Student {
    private String vnaam;
    private String anaam;
    private String mail;
    private int studentnummer;

    public Student(){}

    public Student(String vnaam, String anaam, String mail, int studentnummer){
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

    public void setVnaam(String vnaam) {
        this.vnaam = vnaam;
    }

    public void setAnaam(String anaam) {
        this.anaam = anaam;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setStudentnummer(int studentnummer) {
        this.studentnummer = studentnummer;
    }
}
