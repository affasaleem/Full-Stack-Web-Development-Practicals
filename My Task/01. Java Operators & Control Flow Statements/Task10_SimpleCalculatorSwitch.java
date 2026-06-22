import java.util.Scanner;

public class Task10_SimpleCalculatorSwitch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        int num1 = input.nextInt();

        System.out.print("Choose an operation (+, -, *, /): ");
        char operator = input.next().charAt(0);

        System.out.print("Enter number 2: ");
        int num2 = input.nextInt();

        int result;
        boolean validOperation = true;

        switch (operator) {
            case '+':
            result = num1 + num2;
            break;

            case '-':
            result = num1 - num2;
            break;

            case '*':
            result = num1 * num2;
            break;

            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    
                } else {
                    System.out.println("Division: Cannot divide by zero.");
                    result = 0;
                    validOperation = false;
                }
            break;

            default:
                System.out.println("invalid input");
                result = 0;
                validOperation = false;
        }

        if (validOperation) {
            System.out.println("Result: " + num1 + " " + operator + " " + num2 + " = " + result);
        }

        input.close();
    }
        
}
