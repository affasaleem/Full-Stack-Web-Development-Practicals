import java.util.Scanner;

/**
 * Task04_ThrowAndThrows.java
 *
 * Checks whether a number entered by the user is positive.
 * Demonstrates both 'throw' and 'throws':
 *
 *  - 'throw'  (inside the method): used to create and throw an
 *             exception object when a negative number is detected.
 *
 *  - 'throws' (in the method signature): declares that this method
 *             MAY throw an Exception, so the caller is required to
 *             either handle it with try-catch or declare it with
 *             throws as well. This is called a "checked" exception
 *             propagation pattern.
 */
public class Task04_ThrowAndThrows {

    /**
     * Checks if the given number is positive.
     * Uses 'throws Exception' in its declaration to inform the caller
     * that this method can propagate an exception.
     * Uses 'throw' inside the method to raise the exception when a
     * negative number is detected.
     *
     * @param number the number to check
     * @throws Exception if the number is negative
     */
    public static void checkPositiveNumber(int number) throws Exception {
        if (number < 0) {
            // 'throw' manually raises the exception here and passes
            // it to whoever called this method to handle.
            throw new Exception(
                "Invalid number: " + number + ". Only positive numbers are accepted.");
        }
        System.out.println(number + " is a positive number. Check passed successfully.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to check: ");
        int inputNumber = scanner.nextInt();

        try {
            // The 'throws' keyword on checkPositiveNumber forces us
            // to wrap the call in a try-catch block here in the
            // calling method (main), or re-declare throws in main too.
            checkPositiveNumber(inputNumber);

        } catch (Exception exception) {
            // Handles the exception thrown by checkPositiveNumber()
            System.out.println("Error: " + exception.getMessage());
        }

        scanner.close();
    }
}
