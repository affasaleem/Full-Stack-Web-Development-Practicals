/**
 * Student.java
 *
 * ---------------- INHERITANCE ----------------
 * Student extends Person, inheriting the name and age fields
 * along with displayPersonInfo(), and adds its own field
 * (studentId) specific to a student.
 *
 * ---------------- INTERFACE ----------------
 * Student implements Borrowable, since a student is the person
 * who actually performs the borrowing/returning action in the
 * library system (as opposed to Book, which is the item being
 * borrowed).
 */
public class Student extends Person implements Borrowable {

    // ---------- Field specific to Student ----------
    private int studentId;

    /**
     * Constructor that initializes the inherited fields (name, age)
     * via super(), plus the studentId field unique to this class.
     *
     * @param name      the student's name
     * @param age       the student's age
     * @param studentId the student's unique ID
     */
    public Student(String name, int age, int studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * ---------------- POLYMORPHISM (Method Overriding) ----------------
     * Overrides displayPersonInfo() to show the basic person details
     * (inherited from Person) plus the studentId specific to a student.
     */
    @Override
    public void displayPersonInfo() {
        super.displayPersonInfo();
        System.out.println("Student ID: " + studentId);
    }

    /**
     * Implements borrowItem() from the Borrowable interface.
     * Represents the student's action of borrowing a book.
     */
    @Override
    public void borrowItem() {
        System.out.println(name + " is borrowing a book from the library.");
    }

    /**
     * Implements returnItem() from the Borrowable interface.
     * Represents the student's action of returning a book.
     */
    @Override
    public void returnItem() {
        System.out.println(name + " is returning a book to the library.");
    }
}
