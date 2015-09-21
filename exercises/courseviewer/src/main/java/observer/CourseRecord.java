package observer;

/**
 * Represents the name of a course and the number of students taking it.
 */
public class CourseRecord {
	/**
	 * Create a CourseRecord object
	 * 
	 * @param courseName
	 *            name of the course
	 * @param numOfStudents
	 *            number of students taking the course
	 */
	public CourseRecord(String courseName, int numOfStudents) {
		this.name = courseName;
		this.numOfStudents = numOfStudents;
	}

	/**
	 * Return the number of students taking course
	 * 
	 * @return number of students taking course
	 */
	public int getNumOfStudents() {
		return numOfStudents;
	}

	/**
	 * Return the name of the course
	 * 
	 * @return name of the course
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set number of students on course
	 * 
	 * @param numOfStudents
	 *            number of students on course
	 */
	public void setNumOfStudents(int numOfStudents) {
		this.numOfStudents = numOfStudents;
	}

	/**
	 * Convert course to string representation
	 * 
	 * @return course represented as a string
	 */
	public String toString() {
		return "Course = " + this.name + ", Number of Students = "
				+ this.numOfStudents;
	}

	private String name;

	private int numOfStudents;
}