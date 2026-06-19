import java.util.Scanner;

/**
 * Task 01: Perform addition, subtraction, multiplication, and division
 * of two numbers entered by the user.
 */
public class Task01_ArithmeticOperations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read two numbers from the user
        System.out.print("Enter the first number: ");
        double firstNumber = input.nextDouble();

        System.out.print("Enter the second number: ");
        double secondNumber = input.nextDouble();

        // Perform arithmetic operations
        double sum = firstNumber + secondNumber;
        double difference = firstNumber - secondNumber;
        double product = firstNumber * secondNumber;

        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Addition: " + firstNumber + " + " + secondNumber + " = " + sum);
        System.out.println("Subtraction: " + firstNumber + " - " + secondNumber + " = " + difference);
        System.out.println("Multiplication: " + firstNumber + " * " + secondNumber + " = " + product);

        // Handle division separately to avoid division by zero
        if (secondNumber != 0) {
            double quotient = firstNumber / secondNumber;
            System.out.println("Division: " + firstNumber + " / " + secondNumber + " = " + quotient);
        } else {
            System.out.println("Division: Cannot divide by zero.");
        }

        input.close();
    }
}
