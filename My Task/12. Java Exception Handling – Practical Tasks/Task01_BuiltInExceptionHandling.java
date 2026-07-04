import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Task01_BuiltInExceptionHandling.java
 *
 * Accepts two integers from the user and performs division.
 * Demonstrates handling of two built-in exceptions:
 *
 *  - InputMismatchException: thrown by Scanner when the user enters
 *    something that is not a valid integer (e.g. "abc" or "3.5").
 *
 *  - ArithmeticException: thrown by Java when an integer is divided
 *    by zero (e.g. 10 / 0).
 */
public class Task01_BuiltInExceptionHandling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first integer (dividend) : ");
            int dividend = scanner.nextInt();

            System.out.print("Enter the second integer (divisor) : ");
            int divisor = scanner.nextInt();

            // This line will throw ArithmeticException if divisor is 0
            int result = dividend / divisor;

            System.out.println("Result of " + dividend + " / " + divisor + " = " + result);

        } catch (InputMismatchException exception) {
            // Catches non-integer input such as letters or decimal numbers
            System.out.println("Error: Invalid input. Please enter whole integer numbers only.");

        } catch (ArithmeticException exception) {
            // Catches division by zero
            System.out.println("Error: Division by zero is not allowed. The divisor cannot be 0.");
        }

        scanner.close();
    }
}
