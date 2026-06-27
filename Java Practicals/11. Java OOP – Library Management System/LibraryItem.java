/**
 * LibraryItem.java
 *
 * ---------------- ABSTRACTION ----------------
 * Abstract class representing any item that can exist in the
 * library system. It defines WHAT every library item must be
 * able to do (display its own information) without specifying
 * HOW each specific item type does it. Concrete subclasses
 * (like Book) are responsible for providing that detail.
 */
public abstract class LibraryItem {

    /**
     * Abstract method that every library item must implement
     * to display its own specific details.
     */
    public abstract void displayInfo();
}
