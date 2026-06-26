import java.util.Scanner;

/**
 * Task 11: Check whether a number is an Armstrong number.
 * An Armstrong number equals the sum of its own digits, each raised to the
 * power of the total number of digits in the number.
 * Example: 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
 *
 * This program uses ONLY while loops, as required:
 *   1. One while loop to count the number of digits.
 *   2. One while loop to compute the sum of each digit raised to that power.
 */
public class Task11_ArmstrongNumberCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a non-negative integer number: ");
        int originalNumber = input.nextInt();

        // ----- Step 1: Count the number of digits using a while loop -----
        int digitCount = 0;
        int tempForCounting = originalNumber;

        if (tempForCounting == 0) {
            digitCount = 1; // zero has exactly one digit
        } else {
            while (tempForCounting != 0) {
                tempForCounting /= 10;
                digitCount++;
            }
        }

        // ----- Step 2: Compute the sum of each digit raised to digitCount -----
        int sumOfPowers = 0;
        int tempForSum = originalNumber;

        while (tempForSum != 0) {
            int digit = tempForSum % 10;

            // Manually raise 'digit' to the power of 'digitCount' using a while loop
            int power = 1;
            int exponentCounter = digitCount;
            while (exponentCounter > 0) {
                power *= digit;
                exponentCounter--;
            }

            sumOfPowers += power;
            tempForSum /= 10;
        }

        if (sumOfPowers == originalNumber) {
            System.out.println(originalNumber + " is an ARMSTRONG number.");
        } else {
            System.out.println(originalNumber + " is NOT an Armstrong number.");
        }

        input.close();
    }
}
