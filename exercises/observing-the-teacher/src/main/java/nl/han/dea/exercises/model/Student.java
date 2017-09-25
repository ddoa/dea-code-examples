package nl.han.dea.exercises.model;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Student implements Observer {

    private final String name;
    private final Course course;

    private int numberOfNotes = 10;

    public Student(String name, Course course) {

        this.name = name;
        this.course = course;
    }

    private void makeNotes(String note) {
        System.out.println("Student " + name + " made note: \n" + note);

        numberOfNotes--;

        if (numberOfNotes == 0) {
            System.out.println("Student " + name + " has left the classroom");
            course.leave(this);
        }
    }

    public void update(Observable o, Object arg) {
        makeNotes((String) arg);
    }
}
