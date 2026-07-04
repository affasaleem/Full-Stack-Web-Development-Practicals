/**
 * Customer.java
 *
 * Represents a customer who attempts to book a cab. Each Customer
 * runs in its own thread, simulating real-world concurrent access
 * where multiple people try to book the same cab at the same time.
 *
 * ---------------- MULTITHREADING ----------------
 * Customer implements the Runnable interface so it can be wrapped
 * in a Thread object and run concurrently. The run() method
 * defines what each customer thread does when it starts.
 *
 * Using Runnable (rather than extending Thread directly) is the
 * preferred Java practice because it keeps the task logic separate
 * from the threading mechanism, and allows the class to extend
 * another class in the future if needed.
 */
public class Customer implements Runnable {

    // ---------- Attributes ----------
    private String customerName;
    private Cab cab;   // the shared Cab resource all customers will try to book

    /**
     * Constructor to initialize the customer with a name and
     * a reference to the shared cab they will attempt to book.
     *
     * @param customerName the name of this customer
     * @param cab          the shared Cab object to book
     */
    public Customer(String customerName, Cab cab) {
        this.customerName = customerName;
        this.cab = cab;
    }

    /**
     * The entry point for this customer's thread.
     * When Thread.start() is called, the JVM creates a new thread
     * of execution and calls this run() method inside it.
     * Each customer thread immediately attempts to book the shared cab.
     */
    @Override
    public void run() {
        System.out.println(customerName + " is attempting to book the cab...");
        cab.bookCab(customerName);
    }
}
