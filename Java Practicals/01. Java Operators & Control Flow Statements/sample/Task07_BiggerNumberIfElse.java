import java.util.Scanner;

/**
 * Task 07: Find the bigger number between two numbers using if-else.
 */
public class Task07_BiggerNumberIfElse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int firstNumber = input.nextInt();

        System.out.print("Enter the second number: ");
        int secondNumber = input.nextInt();

        if (firstNumber > secondNumber) {
            System.out.println(firstNumber + " is bigger than " + secondNumber);
        } else if (secondNumber > firstNumber) {
            System.out.println(secondNumber + " is bigger than " + firstNumber);
        } else {
            System.out.println("Both numbers are equal: " + firstNumber);
        }

        input.close();
    }
}
