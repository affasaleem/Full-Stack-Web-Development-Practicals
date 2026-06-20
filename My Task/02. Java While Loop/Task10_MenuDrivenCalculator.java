import java.util.Scanner;

/**
 * Task 10: Menu-driven calculator using a while loop.
 * The program keeps showing the menu and performing calculations
 * until the user chooses to exit.
 */
public class Task10_MenuDrivenCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int ADD = 1;
        final int SUBTRACT = 2;
        final int MULTIPLY = 3;
        final int DIVIDE = 4;
        final int EXIT = 5;

        boolean continueProgram = true;

        System.out.println("===== Menu-Driven Calculator =====");

        while (continueProgram) {
            // Display the menu on every iteration
            System.out.println("\n1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = input.nextInt();

            if (choice == EXIT) {
                System.out.println("Exiting the calculator. Goodbye!");
                continueProgram = false;
            } else if (choice >= ADD && choice <= DIVIDE) {
                System.out.print("Enter the first number: ");
                double firstNumber = input.nextDouble();

                System.out.print("Enter the second number: ");
                double secondNumber = input.nextDouble();

                switch (choice) {
                    case ADD:
                        System.out.println("Result: " + firstNumber + " + " + secondNumber
                                + " = " + (firstNumber + secondNumber));
                        break;
                    case SUBTRACT:
                        System.out.println("Result: " + firstNumber + " - " + secondNumber
                                + " = " + (firstNumber - secondNumber));
                        break;
                    case MULTIPLY:
                        System.out.println("Result: " + firstNumber + " * " + secondNumber
                                + " = " + (firstNumber * secondNumber));
                        break;
                    case DIVIDE:
                        if (secondNumber == 0) {
                            System.out.println("Error: Division by zero is not allowed.");
                        } else {
                            System.out.println("Result: " + firstNumber + " / " + secondNumber
                                    + " = " + (firstNumber / secondNumber));
                        }
                        break;
                }
            } else {
                System.out.println("Invalid choice. Please select a number between 1 and 5.");
            }
        }

        input.close();
    }
}
