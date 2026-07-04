/**
 * Task01_ThreadExecutionManager.java
 *
 * Task 01 – Thread Execution Manager
 *
 * Demonstrates:
 *  - Creating 3 threads using Runnable
 *  - start()   : launches the thread in a new OS-level thread of execution
 *  - join()    : makes the calling thread block until the target finishes
 *  - isAlive() : checks whether a thread is still running
 *  - synchronized method: ensures only one thread prints its details at a time,
 *    preventing output lines from multiple threads interleaving on the console
 */
public class Task01_ThreadExecutionManager {

    /**
     * Shared printer object. The synchronized method inside ensures
     * thread details are printed one thread at a time (no mixed output).
     */
    static final ThreadPrinter threadPrinter = new ThreadPrinter();

    public static void main(String[] args) {

        // Create three threads, each running a named worker task
        Thread thread1 = new Thread(new WorkerTask("Thread-1", 3), "Thread-1");
        Thread thread2 = new Thread(new WorkerTask("Thread-2", 4), "Thread-2");
        Thread thread3 = new Thread(new WorkerTask("Thread-3", 5), "Thread-3");

        System.out.println("===== Thread Execution Manager =====");

        // start() creates a new thread and calls run() inside it concurrently
        thread1.start();
        thread2.start();
        thread3.start();

        // Check isAlive() immediately after start — threads should still be running
        System.out.println("\n--- isAlive() check immediately after start() ---");
        System.out.println("Thread-1 alive: " + thread1.isAlive());
        System.out.println("Thread-2 alive: " + thread2.isAlive());
        System.out.println("Thread-3 alive: " + thread3.isAlive());

        // join() blocks the main thread until each target thread finishes
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException interruptedException) {
            System.out.println("Main thread interrupted: " + interruptedException.getMessage());
        }

        // After join() returns, all three threads must have finished
        System.out.println("\n--- isAlive() check after join() ---");
        System.out.println("Thread-1 alive: " + thread1.isAlive());
        System.out.println("Thread-2 alive: " + thread2.isAlive());
        System.out.println("Thread-3 alive: " + thread3.isAlive());

        System.out.println("\nAll threads have completed.");
    }

    // ---------- Inner Runnable Task ----------
    static class WorkerTask implements Runnable {
        private String taskName;
        private int iterationCount;

        public WorkerTask(String taskName, int iterationCount) {
            this.taskName = taskName;
            this.iterationCount = iterationCount;
        }

        @Override
        public void run() {
            for (int i = 1; i <= iterationCount; i++) {
                // Call the synchronized method so only ONE thread prints at a time
                threadPrinter.printThreadDetails(taskName, i, iterationCount);

                try {
                    Thread.sleep(100); // simulate some work
                } catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    // ---------- Shared synchronized printer ----------
    static class ThreadPrinter {
        /**
         * synchronized ensures this block runs for only one thread at a time.
         * Without it, multiple threads would interleave their output characters
         * on the same console line.
         */
        public synchronized void printThreadDetails(String threadName, int step, int total) {
            System.out.printf("[%-9s] Step %d of %d running on thread: %s%n",
                    threadName, step, total, Thread.currentThread().getName());
        }
    }
}
