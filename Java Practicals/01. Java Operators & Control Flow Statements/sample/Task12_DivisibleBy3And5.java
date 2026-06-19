import java.util.Scanner;

/**
 * Task 12: Check whether a number is divisible by both 3 and 5.
 */
public class Task12_DivisibleBy3And5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer number: ");
        int number = input.nextInt();

        if (number % 3 == 0 && number % 5 == 0) {
            System.out.println(number + " is divisible by both 3 and 5.");
        } else {
            System.out.println(number + " is NOT divisible by both 3 and 5.");
        }

        input.close();
    }
}
