/*
 * Task 01 - Printer and Scanner Resource Management (DEADLOCK VERSION)
 *
 * Two users (threads) each need BOTH the Printer and the Scanner.
 * User1 locks Printer first, then tries to lock Scanner.
 * User2 locks Scanner first, then tries to lock Printer.
 *
 * Because the locks are acquired in opposite order, each thread ends up
 * holding one resource while waiting for the other -> DEADLOCK.
 *
 * Run this class to SEE the deadlock happen (the program will hang and
 * never print "finished using both resources").
 */
public class PrinterScannerDeadlock {

    // Shared resource objects used purely as lock monitors
    private static final Object printer = new Object();
    private static final Object scanner = new Object();

    public static void main(String[] args) {

        // User1: locks Printer first, then Scanner
        Thread user1 = new Thread(() -> {
            synchronized (printer) {
                System.out.println("User1: locked the Printer.");
                sleep(100); // give User2 time to lock the Scanner

                System.out.println("User1: waiting for the Scanner...");
                synchronized (scanner) {
                    System.out.println("User1: locked the Scanner. Printing and scanning now.");
                }
            }
            System.out.println("User1: finished using both resources.");
        }, "User1");

        // User2: locks Scanner first, then Printer (OPPOSITE ORDER -> deadlock)
        Thread user2 = new Thread(() -> {
            synchronized (scanner) {
                System.out.println("User2: locked the Scanner.");
                sleep(100); // give User1 time to lock the Printer

                System.out.println("User2: waiting for the Printer...");
                synchronized (printer) {
                    System.out.println("User2: locked the Printer. Printing and scanning now.");
                }
            }
            System.out.println("User2: finished using both resources.");
        }, "User2");

        user1.start();
        user2.start();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
