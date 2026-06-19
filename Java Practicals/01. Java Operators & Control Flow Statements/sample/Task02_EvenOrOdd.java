import java.util.Scanner;

/**
 * Task 02: Check whether a number entered by the user is even or odd.
 */
public class Task02_EvenOrOdd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer number: ");
        int number = input.nextInt();

        // A number is even if it is divisible by 2 with no remainder
        if (number % 2 == 0) {
            System.out.println(number + " is an EVEN number.");
        } else {
            System.out.println(number + " is an ODD number.");
        }

        input.close();
    }
}
