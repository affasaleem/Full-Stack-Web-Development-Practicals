/**
 * Person.java
 *
 * ---------------- INHERITANCE ----------------
 * Base (parent) class that holds the fields and behavior common
 * to every person in the library system. Both Student and
 * Librarian extend this class and reuse its fields/methods
 * instead of duplicating the same code in each subclass.
 */
public class Person {

    // ---------- Common Fields ----------
    protected String name;
    protected int age;

    /**
     * Constructor for the Person base class.
     * Subclasses call this using super(name, age).
     *
     * @param name the person's name
     * @param age  the person's age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Displays the common details of the person.
     * Subclasses override this to add their own specific details.
     */
    public void displayPersonInfo() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
}
