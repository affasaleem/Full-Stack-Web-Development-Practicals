import java.util.Scanner;

/**
 * Task 13: Find the smallest among three numbers entered by the user.
 */
public class Task13_SmallestOfThree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double firstNumber = input.nextDouble();

        System.out.print("Enter the second number: ");
        double secondNumber = input.nextDouble();

        System.out.print("Enter the third number: ");
        double thirdNumber = input.nextDouble();

        double smallest = firstNumber;

        if (secondNumber < smallest) {
            smallest = secondNumber;
        }
        if (thirdNumber < smallest) {
            smallest = thirdNumber;
        }

        System.out.println("The smallest number is: " + smallest);

        input.close();
    }
}
