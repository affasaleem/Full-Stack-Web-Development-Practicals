import java.util.Scanner;

/**
 * Task 06: Count the number of digits in a given number.
 */
public class Task06_CountDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer number: ");
        int originalNumber = input.nextInt();

        // Work with the absolute value so negative numbers are handled correctly
        int number = Math.abs(originalNumber);
        int digitCount = 0;

        // Special case: zero has exactly one digit
        if (number == 0) {
            digitCount = 1;
        } else {
            while (number != 0) {
                number /= 10;
                digitCount++;
            }
        }

        System.out.println("The number " + originalNumber + " has " + digitCount + " digit(s).");

        input.close();
    }
}
