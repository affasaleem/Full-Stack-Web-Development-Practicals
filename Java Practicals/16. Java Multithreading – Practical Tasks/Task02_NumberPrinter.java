/**
 * Task02_NumberPrinter.java
 *
 * Task 02 – Number Printer
 *
 * Demonstrates:
 *  - One thread printing ODD numbers (1, 3, 5, … 19)
 *  - One thread printing EVEN numbers (2, 4, 6, … 20)
 *  - sleep() to create a visible delay between prints
 *  - A synchronized print method to prevent output from the two
 *    threads mixing on the same console line
 *
 * Because the print method is synchronized on a shared NumberPrinter
 * object, even though both threads run concurrently, only one can
 * print at a time — the output lines stay clean and unbroken.
 */
public class Task02_NumberPrinter {

    public static void main(String[] args) {

        // Shared printer — both threads synchronize on this same object
        NumberPrinter numberPrinter = new NumberPrinter();

        Thread oddThread  = new Thread(new OddPrinterTask(numberPrinter),  "OddThread");
        Thread evenThread = new Thread(new EvenPrinterTask(numberPrinter), "EvenThread");

        System.out.println("===== Number Printer =====");
        System.out.println("Odd thread and Even thread running concurrently...\n");

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException interruptedException) {
            System.out.println("Main thread interrupted: " + interruptedException.getMessage());
        }

        System.out.println("\nAll numbers printed. Both threads have finished.");
    }

    // ---------- Shared synchronized printer ----------
    static class NumberPrinter {
        /**
         * synchronized prevents both threads from printing at the exact
         * same moment, which would interleave their characters on console.
         */
        public synchronized void printNumber(String threadLabel, int number) {
            System.out.printf("[%-10s] %s number: %d%n",
                    Thread.currentThread().getName(), threadLabel, number);
        }
    }

    // ---------- Odd number printer Runnable ----------
    static class OddPrinterTask implements Runnable {
        private NumberPrinter numberPrinter;

        public OddPrinterTask(NumberPrinter numberPrinter) {
            this.numberPrinter = numberPrinter;
        }

        @Override
        public void run() {
            for (int number = 1; number <= 19; number += 2) {
                numberPrinter.printNumber("Odd", number);

                try {
                    Thread.sleep(150); // delay to interleave with even thread visibly
                } catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    // ---------- Even number printer Runnable ----------
    static class EvenPrinterTask implements Runnable {
        private NumberPrinter numberPrinter;

        public EvenPrinterTask(NumberPrinter numberPrinter) {
            this.numberPrinter = numberPrinter;
        }

        @Override
        public void run() {
            for (int number = 2; number <= 20; number += 2) {
                numberPrinter.printNumber("Even", number);

                try {
                    Thread.sleep(150); // same delay to create fair interleaving
                } catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }
}
