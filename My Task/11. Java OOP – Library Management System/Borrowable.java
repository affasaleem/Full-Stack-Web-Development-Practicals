/**
 * Borrowable.java
 *
 * ---------------- INTERFACE ----------------
 * Defines a contract for anything that can be borrowed and
 * returned within the library system. Both a Book (the item
 * being borrowed) and a Student (the person doing the borrowing)
 * implement this interface, each giving the action a different
 * meaning depending on their role.
 */
public interface Borrowable {

    /**
     * Defines the action of borrowing an item.
     */
    void borrowItem();

    /**
     * Defines the action of returning an item.
     */
    void returnItem();
}
