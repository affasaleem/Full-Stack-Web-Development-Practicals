import java.util.Scanner;

/**
 * Task03_ThrowKeyword.java
 *
 * Accepts a student's age and explicitly throws an
 * IllegalArgumentException using the 'throw' keyword if the
 * age is below 18.
 *
 * Key concept — the difference between caught and thrown exceptions:
 *  - Exceptions like ArithmeticException are thrown AUTOMATICALLY
 *    by the JVM when something goes wrong (e.g. divide by zero).
 *  - The 'throw' keyword lets the PROGRAMMER throw an exception
 *    manually to enforce a business rule (e.g. "age must be >= 18").
 */
public class Task03_ThrowKeyword {

    /**
     * Validates a student's age.
     * Uses the 'throw' keyword to manually raise an
     * IllegalArgumentException if the provided age is under 18.
     *
     * @param studentAge the age value to validate
     */
    public static void validateStudentAge(int studentAge) {
        if (studentAge < 18) {
            // Manually throwing an exception to signal an invalid age
            throw new IllegalArgumentException(
                "Invalid age: " + studentAge + ". A student must be at least 18 years old to enroll.");
        }
        System.out.println("Age " + studentAge + " is valid. Student can be enrolled.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the student's age: ");
        int inputAge = scanner.nextInt();

        try {
            // The throw inside validateStudentAge() will be caught here
            validateStudentAge(inputAge);

        } catch (IllegalArgumentException exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        scanner.close();
    }
}
