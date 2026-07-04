/**
 * CabBookingTest.java
 *
 * Main class that sets up and runs the Cab Booking System simulation.
 *
 * Demonstrates:
 *  - Multithreading: multiple customer threads run concurrently.
 *  - Synchronization: only ONE thread can execute bookCab() at a
 *    time, preventing race conditions and double booking.
 *  - Thread safety: regardless of how many customers attempt to
 *    book simultaneously, only the first one succeeds.
 */
public class CabBookingTest {

    public static void main(String[] args) {

        // ---------- Create the single shared Cab resource ----------
        Cab sharedCab = new Cab("CAB-001");

        System.out.println("===== Cab Booking System Started =====");
        System.out.println("Initial status:");
        sharedCab.displayStatus();
        System.out.println();

        // ---------- Create multiple customer threads ----------
        // All five customers share the SAME Cab object, simulating
        // multiple people trying to book the same cab at once.
        Thread customerThread1 = new Thread(new Customer("Customer 1", sharedCab));
        Thread customerThread2 = new Thread(new Customer("Customer 2", sharedCab));
        Thread customerThread3 = new Thread(new Customer("Customer 3", sharedCab));
        Thread customerThread4 = new Thread(new Customer("Customer 4", sharedCab));
        Thread customerThread5 = new Thread(new Customer("Customer 5", sharedCab));

        System.out.println("===== Concurrent Booking Attempts =====");

        // ---------- Start all threads simultaneously ----------
        // start() creates a new OS-level thread and calls run() inside it.
        // All five threads are started almost at the same time to simulate
        // concurrent access. The synchronized keyword in Cab.bookCab()
        // ensures only one thread can execute the booking logic at a time.
        customerThread1.start();
        customerThread2.start();
        customerThread3.start();
        customerThread4.start();
        customerThread5.start();

        // ---------- Wait for all threads to finish ----------
        // join() makes the main thread wait until each customer thread
        // completes before reading the final cab status. Without join(),
        // the final status might be printed before all threads finish.
        try {
            customerThread1.join();
            customerThread2.join();
            customerThread3.join();
            customerThread4.join();
            customerThread5.join();
        } catch (InterruptedException interruptedException) {
            System.out.println("Main thread was interrupted: "
                    + interruptedException.getMessage());
        }

        // ---------- Display final result ----------
        System.out.println();
        System.out.println("===== Final Cab Status =====");
        sharedCab.displayStatus();
        System.out.println("Booking process complete. Only one customer succeeded.");
    }
}
