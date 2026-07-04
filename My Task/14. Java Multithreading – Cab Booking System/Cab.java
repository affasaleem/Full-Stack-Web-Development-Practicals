/**
 * Cab.java
 *
 * Represents a single cab that is shared among multiple customer
 * threads. This is the critical shared resource in the system.
 *
 * ---------------- SYNCHRONIZATION ----------------
 * The bookCab() method is declared synchronized. This means only
 * ONE thread can execute it at a time. All other threads that
 * call bookCab() while one is already inside will WAIT until
 * the executing thread finishes and releases the lock on this
 * Cab object. This prevents race conditions — without
 * synchronization, two threads could both read isAvailable as
 * true at the same instant and both succeed in booking the same
 * cab (double booking).
 */
public class Cab {

    // ---------- Attributes ----------
    private String cabId;
    private boolean isAvailable;  // true = available, false = booked

    /**
     * Constructor to create a new cab that starts out available.
     *
     * @param cabId unique identifier for this cab
     */
    public Cab(String cabId) {
        this.cabId = cabId;
        this.isAvailable = true;
    }

    public String getCabId() {
        return cabId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Attempts to book the cab on behalf of a customer.
     *
     * SYNCHRONIZED: The JVM places a mutex lock on this Cab object
     * when a thread enters this method. Any other thread trying to
     * call bookCab() on the SAME Cab object must wait at the
     * method entrance until the lock is released. This guarantees
     * that the check-then-act logic (read isAvailable → change
     * isAvailable) is atomic — no other thread can interleave.
     *
     * @param customerName the name of the customer attempting the booking
     */
    public synchronized void bookCab(String customerName) {
        if (isAvailable) {
            // --- Cab is free: grant the booking ---
            isAvailable = false;  // change status to booked immediately
            System.out.println(customerName
                    + " successfully booked cab [" + cabId + "].");
        } else {
            // --- Cab is already booked: reject the request ---
            System.out.println(customerName
                    + " failed to book cab [" + cabId + "]. Cab is already booked.");
        }
    }

    /**
     * Displays the current availability status of the cab.
     */
    public void displayStatus() {
        System.out.println("Cab [" + cabId + "] status: "
                + (isAvailable ? "Available" : "Booked"));
    }
}
