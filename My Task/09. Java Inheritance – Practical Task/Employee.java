/**
 * Employee.java
 *
 * Parent (base) class that holds the attributes and behavior
 * common to every kind of employee. Both FullTimeEmployee and
 * PartTimeEmployee inherit from this class, reusing its fields
 * and displayInfo() method instead of duplicating that logic.
 */
public class Employee {

    // ---------- Common Fields (shared by all employee types) ----------
    protected String name;
    protected int id;

    /**
     * Constructor for the Employee base class.
     * Subclasses call this using super(name, id) to initialize
     * the shared fields.
     *
     * @param name the employee's name
     * @param id   the employee's unique ID
     */
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Displays the employee's name and ID.
     * This method is inherited as-is by both subclasses, but each
     * subclass overrides it to also show the calculated salary.
     */
    public void displayInfo() {
        System.out.println("Employee Name : " + name);
        System.out.println("Employee ID   : " + id);
    }
}
