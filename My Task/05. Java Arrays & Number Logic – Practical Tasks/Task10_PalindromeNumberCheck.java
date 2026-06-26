import java.util.Scanner;

/**
 * Task 10: Check whether a number is a Palindrome.
 * A palindrome number reads the same forwards and backwards (e.g., 121, 1331).
 */
public class Task10_PalindromeNumberCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer number: ");
        int originalNumber = input.nextInt();

        int number = Math.abs(originalNumber);
        int reversedNumber = 0;
        int temp = number;

        while (temp != 0) {
            int lastDigit = temp % 10;
            reversedNumber = (reversedNumber * 10) + lastDigit;
            temp /= 10;
        }

        if (number == reversedNumber) {
            System.out.println(originalNumber + " is a PALINDROME number.");
        } else {
            System.out.println(originalNumber + " is NOT a palindrome number.");
        }

        input.close();
    }
}
