import java.util.Scanner;

/**
 * Task 05: Reverse a given number.
 * Example: 1234 -> 4321
 */
public class Task05_ReverseNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer number: ");
        int originalNumber = input.nextInt();

        // Work with the absolute value so negative numbers are handled correctly
        int numberToReverse = Math.abs(originalNumber);
        int reversedNumber = 0;

        while (numberToReverse != 0) {
            int lastDigit = numberToReverse % 10;
            reversedNumber = (reversedNumber * 10) + lastDigit;
            numberToReverse /= 10;
        }

        // Restore the negative sign if the original number was negative
        if (originalNumber < 0) {
            reversedNumber = -reversedNumber;
        }

        System.out.println("Original number: " + originalNumber);
        System.out.println("Reversed number: " + reversedNumber);

        input.close();
    }
}
