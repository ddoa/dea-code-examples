package micjersey2.client;

import micjersey2.server.Student;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.util.List;

/**
 * Created by Michel Koolwaaij on 10-10-16.
 */
public class StudentClient {
    private Client client;

    public StudentClient(){
        client = ClientBuilder.newClient();
    }

    public Student get(int id){
        WebTarget target = client.target("http://localhost:8080/MicJersey2/webapi/");
        Student response = target.path("studenten/"+id).request().get(Student.class);

        return response;
    }

    public List<Student> get(){
        WebTarget target = client.target("http://localhost:8080/MicJersey2/webapi/");
        List<Student> response = target.path("studenten/").request().get(new GenericType<List<Student>>(){});

        return response;
    }
}
