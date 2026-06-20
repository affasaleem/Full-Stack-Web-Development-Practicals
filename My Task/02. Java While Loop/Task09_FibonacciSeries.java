import java.util.Scanner;

/**
 * Task 09: Generate the Fibonacci series up to n terms.
 * The series starts with 0 and 1, and each subsequent term is the
 * sum of the two preceding terms.
 */
public class Task09_FibonacciSeries {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of terms (n): ");
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive number of terms.");
        } else {
            long firstTerm = 0;
            long secondTerm = 1;
            int count = 1;

            System.out.println("Fibonacci series up to " + n + " term(s):");

            while (count <= n) {
                System.out.print(firstTerm + " ");

                long nextTerm = firstTerm + secondTerm;
                firstTerm = secondTerm;
                secondTerm = nextTerm;

                count++;
            }

            System.out.println(); // move to a new line after the loop
        }

        input.close();
    }
}
