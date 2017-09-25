package nl.han.dea.exercises.model;

import nl.han.dea.exercises.exceptions.NoAttendeesException;
import nl.han.dea.exercises.exceptions.NoTeacherException;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Course {

    Teacher teacher;
    List<Observer> attendees;

    public Course() {
        attendees = new ArrayList<Observer>();
    }

    public void startCourse() throws NoTeacherException, NoAttendeesException {
        if (teacher == null) {
            throw new NoTeacherException();
        } else if (attendees.isEmpty()) {
            throw new NoAttendeesException();
        }
        for (Observer attendee : attendees) {
            teacher.addObserver(attendee);
        }
        teacher.teach();
    }

    public void addAttendee(Observer attendee) {
        attendees.add(attendee);
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void leave(Observer attendee) {
        this.teacher.deleteObserver(attendee);
    }
}
