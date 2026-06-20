import java.util.Scanner;

/**
 * Task 06: Check whether a student has passed or failed based on marks.
 * The passing mark is assumed to be 40 out of 100.
 */
public class Task06_PassOrFail {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the student's marks (out of 100): ");
        int marks = input.nextInt();

        final int PASSING_MARK = 40;

        // Validate the input range
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks. Please enter a value between 0 and 100.");
        } else if (marks >= PASSING_MARK) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }

        input.close();
    }
}
