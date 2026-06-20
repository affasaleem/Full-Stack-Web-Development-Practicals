import java.util.Scanner;

/**
 * Task 03: Find the sum of all even numbers from 1 to n.
 * The value of n is entered by the user.
 */
public class Task03_SumOfEvenNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = input.nextInt();

        int sum = 0;
        int number = 1;

        while (number <= n) {
            if (number % 2 == 0) {
                sum += number;
            }
            number++;
        }

        System.out.println("Sum of all even numbers from 1 to " + n + " is: " + sum);

        input.close();
    }
}
