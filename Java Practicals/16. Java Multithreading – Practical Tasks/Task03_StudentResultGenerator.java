/**
 * Task03_StudentResultGenerator.java
 *
 * Task 03 – Student Result Generator
 *
 * Demonstrates:
 *  - Multiple threads each calculating the result for one student
 *  - A shared ResultReport object written to via a synchronized method,
 *    ensuring no two threads corrupt the report content simultaneously
 *  - isAlive() polled immediately after start() to show threads are
 *    still running, then again after join() to confirm they have finished
 */
public class Task03_StudentResultGenerator {

    public static void main(String[] args) {

        // Shared report that all student threads write their results into
        ResultReport sharedReport = new ResultReport();

        // Each thread represents one student's result being calculated
        Thread t1 = new Thread(new StudentResultTask("Nimal Perera",
                new int[]{78, 85, 92, 70, 88}, sharedReport), "Student-1-Thread");
        Thread t2 = new Thread(new StudentResultTask("Amara Fernando",
                new int[]{65, 72, 80, 91, 60}, sharedReport), "Student-2-Thread");
        Thread t3 = new Thread(new StudentResultTask("Kamal Silva",
                new int[]{90, 88, 94, 76, 85}, sharedReport), "Student-3-Thread");

        System.out.println("===== Student Result Generator =====");
        System.out.println("Starting result calculation threads...\n");

        t1.start();
        t2.start();
        t3.start();

        // isAlive() immediately after start() — threads should be running
        System.out.println("--- isAlive() check while threads are working ---");
        System.out.println("Student-1-Thread alive: " + t1.isAlive());
        System.out.println("Student-2-Thread alive: " + t2.isAlive());
        System.out.println("Student-3-Thread alive: " + t3.isAlive());
        System.out.println();

        // join() — main thread waits until all result calculations complete
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException interruptedException) {
            System.out.println("Main thread interrupted: " + interruptedException.getMessage());
        }

        // isAlive() after join() — all threads must have finished
        System.out.println("\n--- isAlive() check after join() ---");
        System.out.println("Student-1-Thread alive: " + t1.isAlive());
        System.out.println("Student-2-Thread alive: " + t2.isAlive());
        System.out.println("Student-3-Thread alive: " + t3.isAlive());

        // Print the complete report once all threads have finished writing
        System.out.println();
        sharedReport.printFullReport();
    }

    // ---------- Runnable task: calculates and records one student's result ----------
    static class StudentResultTask implements Runnable {
        private String studentName;
        private int[] marks;
        private ResultReport report;

        public StudentResultTask(String studentName, int[] marks, ResultReport report) {
            this.studentName = studentName;
            this.marks = marks;
            this.report = report;
        }

        @Override
        public void run() {
            // Simulate the time taken to calculate results (grading, uploading, etc.)
            try {
                Thread.sleep((long) (Math.random() * 300 + 100));
            } catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                return;
            }

            // Calculate total marks and average
            int total = 0;
            for (int mark : marks) {
                total += mark;
            }
            double average = (double) total / marks.length;
            String grade = calculateGrade(average);

            // Write to the shared report via synchronized method
            report.addResult(studentName, total, average, grade);
        }

        private String calculateGrade(double average) {
            if (average >= 80) return "A";
            if (average >= 70) return "B";
            if (average >= 60) return "C";
            if (average >= 50) return "D";
            return "F";
        }
    }

    // ---------- Shared report written to concurrently by multiple threads ----------
    static class ResultReport {
        private String reportContent = "";

        /**
         * synchronized prevents two threads from writing to reportContent at
         * the same time, which would otherwise corrupt the accumulated string.
         */
        public synchronized void addResult(String studentName, int total,
                                           double average, String grade) {
            String resultLine = String.format(
                    "  Student: %-16s | Total: %3d | Average: %5.1f | Grade: %s%n",
                    studentName, total, average, grade);
            reportContent += resultLine;

            System.out.println("[" + Thread.currentThread().getName()
                    + "] Result recorded -> " + studentName + " | Grade: " + grade);
        }

        /** Prints the complete accumulated report after all threads have finished. */
        public void printFullReport() {
            System.out.println("===== Full Student Report =====");
            System.out.print(reportContent);
            System.out.println("===============================");
        }
    }
}
