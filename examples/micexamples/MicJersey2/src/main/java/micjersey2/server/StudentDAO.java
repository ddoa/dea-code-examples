package micjersey2.server;

import micjersey2.server.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Michel Koolwaaij on 07-10-16.
 */
public class StudentDAO {
    private String URL = "jdbc:mariadb://localhost/piep";
    private String USER = "michel";
    private String PASS = "piep";
    private Connection connection;
    private PreparedStatement ps;
    Logger logger = Logger.getLogger("logger");

    public StudentDAO(){
        try {
            connection = DriverManager.getConnection(URL,USER,PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection==null) {
            logger.log(Level.WARNING,"Biebel");
        }
    }

    public void prepareStatement(){
        try {
            ps = connection.prepareStatement("SELECT * FROM STUDENT WHERE NR=?");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String getVoornaam(int id) throws SQLException {
        return getResults(id).getString("voornaam");

    }

    public String getAchternaam(int id) throws SQLException {
        return getResults(id).getString("achternaam");

    }

    public String getEmail(int id) throws SQLException {
        return getResults(id).getString("mail");

    }

    private ResultSet getResults(int id){
        ResultSet rs = null;
        try {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.first();
        } catch (SQLException e){
            System.out.println("Fout hierzo");
            e.printStackTrace();

        }

        return rs;

    }

    public Student findStudent (int id){
        prepareStatement();
        try {
            Student student=new Student(getVoornaam(id),getAchternaam(id),getEmail(id),id);
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> makeStudentList(){
        List<Student> students = new ArrayList<>();
        int id;
        String voornaam;
        String mail;
        String achternaam;
        int teller=0;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs=statement.executeQuery("select * from student");

            while (rs.next()){
                teller++;
                id = rs.getInt("NR");
                voornaam = rs.getString("voornaam");
                achternaam = rs.getString("achternaam");
                mail = rs.getString("mail");
                students.add(new Student(voornaam,achternaam,mail,id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
