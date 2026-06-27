/**
 * Book.java
 *
 * ---------------- ENCAPSULATION ----------------
 * All attributes (bookId, title, author, price) are private and
 * can only be accessed or modified through public getter and
 * setter methods. This protects the internal state of the object
 * from being changed in an uncontrolled way from outside the class.
 *
 * ---------------- ABSTRACTION ----------------
 * Book extends the abstract class LibraryItem and provides a
 * concrete implementation of displayInfo(), fulfilling the
 * contract defined by the abstract class.
 *
 * ---------------- INTERFACE ----------------
 * Book implements Borrowable, providing its own version of
 * borrowItem() and returnItem() that reflects a book's
 * availability status.
 */
public class Book extends LibraryItem implements Borrowable {

    // ---------- Private Attributes (Encapsulation) ----------
    private int bookId;
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    /**
     * No-argument (default) constructor.
     * Required so a Book can be created simply with `new Book()`
     * and its details set later using the setter methods.
     */
    public Book() {
        this.bookId = 0;
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        this.isAvailable = true;
    }

    /**
     * Parameterized constructor to create a fully initialized Book.
     *
     * @param bookId the unique ID of the book
     * @param title  the title of the book
     * @param author the author of the book
     * @param price  the price of the book
     */
    public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }

    // ---------- Getter and Setter Methods (Encapsulation) ----------

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Invalid price. Price cannot be negative.");
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    /**
     * ---------------- POLYMORPHISM (Method Overriding) ----------------
     * Overrides the abstract displayInfo() method from LibraryItem
     * to print the specific details of this Book.
     */
    @Override
    public void displayInfo() {
        System.out.println("Book ID    : " + bookId);
        System.out.println("Title      : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Price      : " + price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Borrowed"));
    }

    /**
     * Implements borrowItem() from the Borrowable interface.
     * Marks the book as unavailable if it is currently available.
     */
    @Override
    public void borrowItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("\"" + title + "\" has been borrowed successfully.");
        } else {
            System.out.println("\"" + title + "\" is currently not available for borrowing.");
        }
    }

    /**
     * Implements returnItem() from the Borrowable interface.
     * Marks the book as available again.
     */
    @Override
    public void returnItem() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("\"" + title + "\" has been returned successfully.");
        } else {
            System.out.println("\"" + title + "\" was not borrowed, so it cannot be returned.");
        }
    }
}
