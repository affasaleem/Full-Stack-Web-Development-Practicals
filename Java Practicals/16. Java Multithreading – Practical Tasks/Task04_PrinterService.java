/**
 * Task04_PrinterService.java
 *
 * Task 04 – Printer Service
 *
 * Demonstrates:
 *  - Multiple employee threads each sending print jobs to a shared printer
 *  - synchronized printDocument() so only one job prints at a time
 *  - setPriority() to give one employee a higher scheduling priority,
 *    making it more likely (though not guaranteed) to acquire the printer
 *    sooner than normal-priority threads
 *  - join() to ensure main waits until all print jobs complete
 *
 * NOTE on setPriority():
 *   Java thread priority is a HINT to the OS scheduler, not a hard rule.
 *   A MAX_PRIORITY thread will typically run more often / get the lock
 *   sooner, but the exact order still depends on the JVM and OS.
 */
public class Task04_PrinterService {

    public static void main(String[] args) {

        // Shared printer — only one thread can use it at a time
        SharedPrinter sharedPrinter = new SharedPrinter();

        // Four employee threads all competing to use the same printer
        Thread employee1 = new Thread(
                new PrintJobTask("Alice",   sharedPrinter, new String[]{"Q1 Report", "Budget Sheet"}),
                "Alice-Thread");

        Thread employee2 = new Thread(
                new PrintJobTask("Bob",     sharedPrinter, new String[]{"Project Plan", "Meeting Notes", "Invoice"}),
                "Bob-Thread");

        Thread employee3 = new Thread(
                new PrintJobTask("Charlie", sharedPrinter, new String[]{"Sales Forecast"}),
                "Charlie-Thread");

        Thread employee4 = new Thread(
                new PrintJobTask("Diana",   sharedPrinter, new String[]{"HR Policy", "Onboarding Guide"}),
                "Diana-Thread");

        // Give Diana MAX_PRIORITY — she has urgent documents to print
        // (other employees stay at NORM_PRIORITY = 5 by default)
        employee4.setPriority(Thread.MAX_PRIORITY);   // priority 10
        employee1.setPriority(Thread.NORM_PRIORITY);  // priority 5 (default)
        employee2.setPriority(Thread.NORM_PRIORITY);
        employee3.setPriority(Thread.NORM_PRIORITY);

        System.out.println("===== Printer Service =====");
        System.out.printf("Thread priorities — Alice: %d | Bob: %d | Charlie: %d | Diana: %d (HIGH)%n%n",
                employee1.getPriority(), employee2.getPriority(),
                employee3.getPriority(), employee4.getPriority());

        // Start all employee threads simultaneously
        employee1.start();
        employee2.start();
        employee3.start();
        employee4.start();

        // join() — main thread waits until every print job is complete
        try {
            employee1.join();
            employee2.join();
            employee3.join();
            employee4.join();
        } catch (InterruptedException interruptedException) {
            System.out.println("Main thread interrupted: " + interruptedException.getMessage());
        }

        System.out.println("\n===== All print jobs completed =====");
        System.out.println("Total documents printed: " + sharedPrinter.getTotalDocumentsPrinted());
    }

    // ---------- Runnable: one employee sending multiple print jobs ----------
    static class PrintJobTask implements Runnable {
        private String employeeName;
        private SharedPrinter printer;
        private String[] documents;

        public PrintJobTask(String employeeName, SharedPrinter printer, String[] documents) {
            this.employeeName = employeeName;
            this.printer = printer;
            this.documents = documents;
        }

        @Override
        public void run() {
            for (String document : documents) {
                printer.printDocument(employeeName, document);

                try {
                    Thread.sleep(50); // brief gap between this employee's own jobs
                } catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    // ---------- Shared printer with synchronized access ----------
    static class SharedPrinter {
        private int totalDocumentsPrinted = 0;

        /**
         * synchronized ensures the printer handles one document at a time.
         * Without this, output from multiple employees would interleave on
         * the same line, and totalDocumentsPrinted could be corrupted by
         * concurrent increments (a classic race condition).
         */
        public synchronized void printDocument(String employeeName, String documentName) {
            totalDocumentsPrinted++;
            System.out.printf("[%-14s] Printing: %-22s (Job #%d, Priority: %d)%n",
                    Thread.currentThread().getName(),
                    documentName,
                    totalDocumentsPrinted,
                    Thread.currentThread().getPriority());

            // Simulate the time taken to physically print the document
            try {
                Thread.sleep(200);
            } catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }

            System.out.printf("[%-14s] Done     : %-22s%n",
                    Thread.currentThread().getName(), documentName);
        }

        public synchronized int getTotalDocumentsPrinted() {
            return totalDocumentsPrinted;
        }
    }
}
