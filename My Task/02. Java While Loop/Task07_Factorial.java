import java.util.Scanner;

/**
 * Task 07: Find the factorial of a number.
 * Example: 5! = 5 x 4 x 3 x 2 x 1 = 120
 */
public class Task07_Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a non-negative integer number: ");
        int number = input.nextInt();

        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long factorial = 1; // use long to support reasonably large results
            int counter = number;

            while (counter > 1) {
                factorial *= counter;
                counter--;
            }

            System.out.println("Factorial of " + number + " is: " + factorial);
        }

        input.close();
    }
}
