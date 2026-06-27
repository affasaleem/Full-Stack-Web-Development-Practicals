/**
 * Librarian.java
 *
 * ---------------- INHERITANCE ----------------
 * Librarian extends Person, inheriting the name and age fields
 * along with displayPersonInfo(), and adds its own field
 * (employeeId) specific to a librarian.
 */
public class Librarian extends Person {

    // ---------- Field specific to Librarian ----------
    private int employeeId;

    /**
     * Constructor that initializes the inherited fields (name, age)
     * via super(), plus the employeeId field unique to this class.
     *
     * @param name       the librarian's name
     * @param age        the librarian's age
     * @param employeeId the librarian's unique employee ID
     */
    public Librarian(String name, int age, int employeeId) {
        super(name, age);
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * ---------------- POLYMORPHISM (Method Overriding) ----------------
     * Overrides displayPersonInfo() to show the basic person details
     * (inherited from Person) plus the employeeId specific to a
     * librarian.
     */
    @Override
    public void displayPersonInfo() {
        super.displayPersonInfo();
        System.out.println("Employee ID: " + employeeId);
    }

    /**
     * Represents a librarian managing the addition of a new book
     * into the library's collection.
     *
     * @param book the book being added to the library
     */
    public void addBookToLibrary(Book book) {
        System.out.println(name + " has added \"" + book.getTitle() + "\" to the library collection.");
    }
}
