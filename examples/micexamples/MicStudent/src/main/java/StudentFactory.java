/**
 * Created by Michel Koolwaaij on 28-09-16.
 */
public class StudentFactory {
    static private IMicStudent student;
    public static IMicStudent createStudent(StudentType type, String vnaam, String anaam, String mail, int id) {
        switch (type){
            case Extern: ExterneStudent externeStudent = new ExterneStudent(vnaam,anaam,mail,id);
                student = new StudentAdapter(externeStudent);
                break;
            case Intern: student = new MicStudent(vnaam,anaam);
                break;
        }
        return student;
    }
}
