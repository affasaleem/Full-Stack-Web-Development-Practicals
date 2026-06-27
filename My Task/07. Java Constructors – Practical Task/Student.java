/**
 * Student.java
 *
 * Demonstrates the three main types of constructors in Java:
 * 1. Default Constructor   - sets attributes to default placeholder values.
 * 2. Parameterized Constructor - sets attributes using values passed in.
 * 3. Copy Constructor      - creates a new object by copying the
 *                            attribute values of an existing Student object.
 */
public class Student {

    // ---------- Attributes ----------
    private int studentId;
    private String studentName;
    private String course;

    /**
     * Default Constructor
     * Called when no arguments are provided.
     * Initializes attributes with default placeholder values so the
     * object is always in a valid, predictable state.
     */
    public Student() {
        this.studentId = 0;
        this.studentName = "Not Assigned";
        this.course = "Not Assigned";
    }

    /**
     * Parameterized Constructor
     * Called when the caller wants to set all attribute values
     * immediately at the time of object creation.
     *
     * @param studentId   the unique ID of the student
     * @param studentName the name of the student
     * @param course      the course the student is enrolled in
     */
    public Student(int studentId, String studentName, String course) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
    }

    /**
     * Copy Constructor
     * Creates a brand-new Student object by copying the attribute
     * values from an already existing Student object. This produces
     * an independent object with the same data, not a reference
     * to the original object.
     *
     * @param otherStudent the existing Student object to copy values from
     */
    public Student(Student otherStudent) {
        this.studentId = otherStudent.studentId;
        this.studentName = otherStudent.studentName;
        this.course = otherStudent.course;
    }

    /**
     * Displays all the details of the student in a clean,
     * readable format.
     */
    public void displayDetails() {
        System.out.println("Student ID   : " + studentId);
        System.out.println("Student Name : " + studentName);
        System.out.println("Course       : " + course);
    }
}
