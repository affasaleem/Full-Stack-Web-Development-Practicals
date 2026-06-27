/**
 * LibraryManagementTest.java
 *
 * Main class that brings together and demonstrates all five major
 * OOP concepts in a single Library Management System:
 *
 *  1. Encapsulation - Book's private fields accessed via getters/setters
 *  2. Inheritance   - Student and Librarian inheriting from Person
 *  3. Abstraction   - LibraryItem hiding implementation details
 *  4. Polymorphism  - Overridden displayInfo()/displayPersonInfo() called
 *                     through parent-type references
 *  5. Interface     - Borrowable implemented by both Book and Student
 */
public class LibraryManagementTest {

    public static void main(String[] args) {

        // ============================================================
        // 1. ENCAPSULATION: Creating and initializing a Book object
        //    using its constructor, then reading/updating values
        //    only through getter and setter methods.
        // ============================================================
        System.out.println("===== Encapsulation: Book Details =====");
        Book book1 = new Book(101, "Clean Code", "Robert C. Martin", 2500.00);
        book1.setPrice(2300.00); // updating price through the setter
        System.out.println("Book Title (via getter): " + book1.getTitle());
        System.out.println("Book Price (via getter): " + book1.getPrice());

        // ============================================================
        // 2. INHERITANCE: Student and Librarian both inherit
        //    name/age fields and displayPersonInfo() from Person.
        // ============================================================
        System.out.println("\n===== Inheritance: Student Details =====");
        Student student1 = new Student("Nimal Perera", 21, 5001);
        student1.displayPersonInfo();

        System.out.println("\n===== Inheritance: Librarian Details =====");
        Librarian librarian1 = new Librarian("Kamala Silva", 35, 9001);
        librarian1.displayPersonInfo();
        librarian1.addBookToLibrary(book1);

        // ============================================================
        // 3 & 4. ABSTRACTION + POLYMORPHISM (Runtime):
        //    A LibraryItem reference holds a Book object. The actual
        //    displayInfo() that runs is determined at runtime based
        //    on the real object type (Book), not the reference type.
        // ============================================================
        System.out.println("\n===== Abstraction & Polymorphism: LibraryItem =====");
        LibraryItem item = new Book(102, "The Pragmatic Programmer", "Andrew Hunt", 3200.00);
        item.displayInfo();

        // ============================================================
        // 5. INTERFACE: Both Book and Student implement Borrowable,
        //    each giving borrowItem()/returnItem() its own meaning.
        // ============================================================
        System.out.println("\n===== Interface: Borrowable Behavior =====");

        Borrowable borrowableBook = book1;
        borrowableBook.borrowItem();
        borrowableBook.returnItem();

        Borrowable borrowableStudent = student1;
        borrowableStudent.borrowItem();
        borrowableStudent.returnItem();

        // Final state check on the book after borrow/return cycle
        System.out.println("\n===== Final Book Status =====");
        book1.displayInfo();
    }
}
