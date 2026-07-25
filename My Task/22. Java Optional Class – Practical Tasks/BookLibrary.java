import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * BookLibrary.java
 * Task 03 - Book Library
 *
 * Demonstrates the use of Optional<Book> together with ifPresent()
 * to print book details only when a matching book is found, without
 * ever needing to check for or return null.
 */
public class BookLibrary {

    private List<Book> books;

    public BookLibrary() {
        books = new ArrayList<>();
        // Sample data
        books.add(new Book(1, "Clean Code", "Robert C. Martin"));
        books.add(new Book(2, "Effective Java", "Joshua Bloch"));
        books.add(new Book(3, "Head First Design Patterns", "Eric Freeman"));
    }

    /**
     * Searches for a book by title (case-insensitive).
     * Returns an Optional<Book> instead of null so the caller can
     * safely chain operations such as ifPresent().
     */
    public Optional<Book> findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        BookLibrary bookLibrary = new BookLibrary();
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Book Library (Optional Class Demo) =====");
        System.out.print("Enter Book Title to search: ");
        String title = scanner.nextLine().trim();

        Optional<Book> result = bookLibrary.findBookByTitle(title);

        // isPresent() - explicit check, used here just to show the outcome
        if (!result.isPresent()) {
            System.out.println("Book not found in the library.");
        }

        // ifPresent() - prints the book details only when a book is found,
        // avoiding any null checks or manual "if not null" logic.
        result.ifPresent(book -> System.out.println("Book Found: " + book));

        scanner.close();
    }
}
