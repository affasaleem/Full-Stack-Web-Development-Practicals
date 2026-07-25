/*
 * Task 01 - Printer and Scanner Resource Management (FIXED VERSION)
 *
 * Deadlock fix strategy: LOCK ORDERING.
 * Both User1 and User2 now always acquire the Printer lock FIRST and the
 * Scanner lock SECOND, no matter which user they are. Since every thread
 * requests the locks in the same fixed order, circular waiting can never
 * happen, so a deadlock cannot occur.
 *
 * Inter-thread communication: each resource (Printer / Scanner) tracks
 * whether it is currently busy. If a thread finds a resource busy, it
 * calls wait() and sleeps until the resource is released, at which point
 * notifyAll() wakes it back up.
 */
public class PrinterScannerFixed {

    // A shared resource that can be busy or free, with wait/notify support
    static class Resource {
        private final String name;
        private boolean busy = false;

        Resource(String name) {
            this.name = name;
        }

        // Blocks the calling thread until the resource is free, then marks it busy
        synchronized void acquire(String userName) throws InterruptedException {
            while (busy) {
                System.out.println(userName + ": " + name + " is busy, waiting...");
                wait(); // releases the lock on 'this' and waits to be notified
            }
            busy = true;
            System.out.println(userName + ": acquired the " + name + ".");
        }

        // Frees the resource and wakes up any threads waiting for it
        synchronized void release(String userName) {
            busy = false;
            System.out.println(userName + ": released the " + name + ".");
            notifyAll(); // wake up all threads waiting on this resource
        }
    }

    private static final Resource printer = new Resource("Printer");
    private static final Resource scanner = new Resource("Scanner");

    public static void main(String[] args) {

        Runnable userTask = () -> {
            String userName = Thread.currentThread().getName();
            try {
                // Fixed lock ordering: always Printer first, then Scanner
                printer.acquire(userName);
                scanner.acquire(userName);

                System.out.println(userName + ": using both Printer and Scanner.");
                Thread.sleep(150); // simulate doing the print/scan job

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // Release in reverse order (good practice, though order here is not critical)
                scanner.release(userName);
                printer.release(userName);
                System.out.println(userName + ": finished using both resources.");
            }
        };

        Thread user1 = new Thread(userTask, "User1");
        Thread user2 = new Thread(userTask, "User2");

        user1.start();
        user2.start();
    }
}
