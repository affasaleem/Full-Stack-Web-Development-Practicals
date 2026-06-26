import java.util.Scanner;

/**
 * Task 09: Check whether a number is Prime.
 * A prime number is greater than 1 and has no divisors other than 1 and itself.
 */
public class Task09_PrimeNumberCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer number: ");
        int number = input.nextInt();

        boolean isPrime = true;

        if (number <= 1) {
            // Numbers less than or equal to 1 are not prime
            isPrime = false;
        } else {
            // Check divisibility from 2 up to (number - 1)
            for (int divisor = 2; divisor < number; divisor++) {
                if (number % divisor == 0) {
                    isPrime = false;
                    break; // a divisor was found, no need to check further
                }
            }
        }

        if (isPrime) {
            System.out.println(number + " is a PRIME number.");
        } else {
            System.out.println(number + " is NOT a prime number.");
        }

        input.close();
    }
}
