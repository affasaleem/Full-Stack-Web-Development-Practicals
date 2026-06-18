import java.util.Scanner;

/**
 * Task 03: Find the largest of two numbers entered by the user.
 */
public class Task03_LargestOfTwo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double firstNumber = input.nextDouble();

        System.out.print("Enter the second number: ");
        double secondNumber = input.nextDouble();

        // Compare the two numbers using the ternary operator
        double largest = (firstNumber > secondNumber) ? firstNumber : secondNumber;

        if (firstNumber == secondNumber) {
            System.out.println("Both numbers are equal: " + firstNumber);
        } else {
            System.out.println("The largest number is: " + largest);
        }

        input.close();
    }
}
