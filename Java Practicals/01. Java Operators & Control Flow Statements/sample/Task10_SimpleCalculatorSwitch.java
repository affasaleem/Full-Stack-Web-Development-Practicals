import java.util.Scanner;

/**
 * Task 10: Simple calculator using a switch statement.
 * Supports addition, subtraction, multiplication, and division.
 */
public class Task10_SimpleCalculatorSwitch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double firstNumber = input.nextDouble();

        System.out.print("Enter the second number: ");
        double secondNumber = input.nextDouble();

        System.out.print("Choose an operation (+, -, *, /): ");
        char operator = input.next().charAt(0);

        double result;
        boolean validOperation = true;

        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    result = 0;
                    validOperation = false;
                } else {
                    result = firstNumber / secondNumber;
                }
                break;
            default:
                System.out.println("Error: Invalid operator entered.");
                result = 0;
                validOperation = false;
        }

        if (validOperation) {
            System.out.println("Result: " + firstNumber + " " + operator + " " + secondNumber + " = " + result);
        }

        input.close();
    }
}
