package micjersey2.server;

import micjersey2.server.Student;
import micjersey2.server.StudentDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Michel Koolwaaij on 10-10-16.
 */
@Path("studenten")
public class StudentResource {
    private StudentDAO dao = new StudentDAO();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Student> getAllStudents(){

        List<Student> studenten = dao.makeStudentList();

        return studenten;
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{studentId}")
    public Response getStudent(@PathParam("studentId") int studentId){
        if (studentId <0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Student student = dao.findStudent(studentId);
        if (student == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(student).build();
    }


}
