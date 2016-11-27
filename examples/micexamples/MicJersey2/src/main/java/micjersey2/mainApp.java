package micjersey2;

import micjersey2.server.Student;
import micjersey2.server.StudentDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Michel Koolwaaij on 10-10-16.
 */
public class mainApp {
    private static StudentDAO dao = new StudentDAO();
    private static List<Student> studentList = dao.makeStudentList();

    public static void main(String[] args) throws SQLException {
        dao.closeConnection();
        System.out.println("hoera");

        for (Student student: studentList){
            System.out.println(student);
        }


    }
}
