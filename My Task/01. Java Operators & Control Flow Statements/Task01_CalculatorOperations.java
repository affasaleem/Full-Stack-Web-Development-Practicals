import java.util.Scanner;

public class Task01_CalculatorOperations {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Number 1: ");
        int num1 = input.nextInt();

        System.out.print("Enter Number 2: ");
        int num2 = input.nextInt();

        int add = num1 + num2;
        int sub = num1 - num2;
        int mul = num1 * num2;

        System.out.println("\n--- Results ---");
        System.out.println("Addition: " + add);
        System.out.println("Subtraction: " + sub);
        System.out.println("Multiplication: " + mul);
        

        if (num2 != 0) {
            int div = num1 / num2;
            System.out.println("Division: " + div);
        } else {
            System.out.println("Division: Cannot divide by zero.");
        }

        input.close();

    }
}
