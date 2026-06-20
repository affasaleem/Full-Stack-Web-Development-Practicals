import java.util.Scanner;

/**
 * Task 05: Check whether a number is positive, negative, or zero.
 */
public class Task05_PositiveNegativeZero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        double number = input.nextDouble();

        if (number > 0) {
            System.out.println(number + " is a POSITIVE number.");
        } else if (number < 0) {
            System.out.println(number + " is a NEGATIVE number.");
        } else {
            System.out.println("The number is ZERO.");
        }

        input.close();
    }
}
