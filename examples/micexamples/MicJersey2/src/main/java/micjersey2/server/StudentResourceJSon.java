package micjersey2.server;

import micjersey2.server.Student;
import micjersey2.server.StudentDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Michel Koolwaaij on 10-10-16.
 */
@Path("studenten2")
public class StudentResourceJSon {
    private StudentDAO dao = new StudentDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents(){

        List<Student> studenten = dao.makeStudentList();
        try {
            dao.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studenten;
    }


}
