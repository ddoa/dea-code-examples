import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Michel Koolwaaij on 26-09-16.
 */
public class MicStudentTest {
    public IMicStudent student;
    @Before
    public void createStudent(){
        student = new MicStudent("Jawin","Netels");
    }
    @Test
    public void testVoornaam(){
        // Test
        String voornaam = student.getVoornaam();

        //Controle
        assertEquals("Jawin",voornaam);
    }

    @Test
    public void testAchternaam(){
        // Test
        String achternaam = student.getAchternaam();

        // Controle
        assertEquals("Netels",achternaam);
    }

    @Test
    public void testEmail(){
        //Test
        String email = student.getEmail();

        //Controle
        assertEquals("Jawin.Netels@han.nl",email);
    }

    @Test
    public void testId(){
        //Test
        int id = student.getId();

        //Controle
        assertTrue(id>0);
    }

    @Test
    public void testExterneStudent(){
        // Init
        ExterneStudent externeStudent = new ExterneStudent("Belle","Beest","Belle.Beest@anderschool.nl",600);
        IMicStudent conversieStudent = new StudentAdapter(externeStudent);

        // Test
        String email = conversieStudent.getEmail();

        // Controle
        assertEquals("Belle.Beest@anderschool.nl",email);

    }

    @Test
    public void testStudentFactoryExtern(){
        // Init
        IMicStudent eenStudent = StudentFactory.createStudent(StudentType.Extern,"Belle","Beest","Belle.Beest@anderschool.nl",600);

        //Test
        String email = eenStudent.getEmail();

        // Controle
        assertEquals("Belle.Beest@anderschool.nl",email);

    }
    @Test
    public void testStudentFactoryIntern(){
        // Init
        IMicStudent eenStudent = StudentFactory.createStudent(StudentType.Intern,"Belle","Beest","Belle.Beest@anderschool.nl",600);

        //Test
        String email = eenStudent.getEmail();

        // Controle
        assertEquals("Belle.Beest@han.nl",email);

    }

}
