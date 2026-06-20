import java.util.Scanner;

/**
 * Task 04: Print the multiplication table of a given number using a while loop.
 */
public class Task04_MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number to print its multiplication table: ");
        int number = input.nextInt();

        final int TABLE_LIMIT = 10;
        int multiplier = 1;

        System.out.println("Multiplication table of " + number + ":");

        while (multiplier <= TABLE_LIMIT) {
            int result = number * multiplier;
            System.out.println(number + " x " + multiplier + " = " + result);
            multiplier++;
        }

        input.close();
    }
}
