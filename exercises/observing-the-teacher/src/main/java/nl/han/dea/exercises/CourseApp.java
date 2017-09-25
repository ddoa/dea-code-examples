package nl.han.dea.exercises;

import nl.han.dea.exercises.exceptions.NoAttendeesException;
import nl.han.dea.exercises.exceptions.NoTeacherException;
import nl.han.dea.exercises.model.Course;
import nl.han.dea.exercises.model.Student;
import nl.han.dea.exercises.model.Teacher;

public class CourseApp {
    public static void main(String[] args) {
        Course course = new Course();
        course.addAttendee(new Student("Piet", course));
        course.addAttendee(new Student("Karel", course));
        course.addAttendee(new Student("Kees", course));
        course.addAttendee(new Student("Martine", course));
        course.addAttendee(new Teacher("Michel"));

        course.setTeacher(new Teacher("Meron"));

        try {
            course.startCourse();
        } catch (NoTeacherException e) {
            System.out.println("Course wasn't started, since there is no teacher available.");
        } catch (NoAttendeesException e) {
            System.out.println("Course wasn't started, since there are no students available.");
        }
    }
}
