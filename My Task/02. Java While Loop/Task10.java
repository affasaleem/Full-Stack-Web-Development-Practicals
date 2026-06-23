import java.util.Scanner;

/*
 * The program keeps showing the menu and performing calculations
   until the user chooses to exit.
 */
public class Task10 {
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
                System.out.println("Existing the calculator. Goodbye!");
                continueProgram = false;
            } else if (choice >= ADD && choice <= DIVIDE) {
                System.out.print("Enter Number 1: ");
                double num1 = input.nextDouble();

                System.out.print("Enter Number 2: ");
                double num2 = input.nextDouble();

                switch (choice) {
                    case ADD:
                        System.out.println("Result: " + num1 + " + " + num2 + " = " + (num1 + num2));
                        break;

                    case SUBTRACT:
                        System.out.println("Result: " + num1 + "  " + num2 + " = " + (num1 - num2));
                        break;

                    case MULTIPLY:
                        System.out.println("Result: " + num1 + " * " + num2 + " = " + (num1 * num2));
                        break;

                    case DIVIDE:
                        if (num2 == 0) {
                            System.out.println("Error: Division by zero is not allowed.");
                        } else {
                            System.out.println("Result: " + num1 + " / " + num2
                                    + " = " + (num1 / num2));
                        }
                        break;
                
                    default:
                        break;
                }
            } else {
                System.out.println("Invalid choice. Please select a number between 1 and 5.");
            }
        }

        input.close();
    }
}



