package micjersey2.client;

import micjersey2.server.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Michel Koolwaaij on 10-10-16.
 */
public class StudentClientTest {
    @Test
    public void testGetList() throws Exception {
        StudentClient client = new StudentClient();

        List<Student> studenten = client.get();

        System.out.println (studenten);

        assertNotNull(studenten);
    }

    @Test
    public void testGet() throws Exception {
        StudentClient client = new StudentClient();

        Student student = client.get(722);

        System.out.println (student);

        assertNotNull(student);

    }



}