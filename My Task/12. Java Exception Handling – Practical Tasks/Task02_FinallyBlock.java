import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Task02_FinallyBlock.java
 *
 * Performs division of two numbers and demonstrates the finally block.
 * The finally block always executes — whether the try block succeeds
 * normally, or whether a catch block handles an exception. This makes
 * it the right place to put cleanup actions or guaranteed messages.
 */
public class Task02_FinallyBlock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first number (dividend) : ");
            int dividend = scanner.nextInt();

            System.out.print("Enter the second number (divisor) : ");
            int divisor = scanner.nextInt();

            // May throw ArithmeticException if divisor is 0
            int result = dividend / divisor;

            System.out.println("Result: " + dividend + " / " + divisor + " = " + result);

        } catch (InputMismatchException exception) {
            System.out.println("Error: Invalid input. Please enter whole integer numbers only.");

        } catch (ArithmeticException exception) {
            System.out.println("Error: Division by zero is not allowed.");

        } finally {
            // The finally block runs regardless of whether an exception
            // occurred or was caught, making it the ideal place for
            // cleanup code or guaranteed output messages.
            System.out.println("Program execution completed.");
            scanner.close();
        }
    }
}
