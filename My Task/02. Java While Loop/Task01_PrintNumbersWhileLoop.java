/**
 * Task 01: Print numbers from 1 to 100 using a while loop.
 * No user input is required for this task; the range is fixed.
 */
public class Task01_PrintNumbersWhileLoop {
    public static void main(String[] args) {
        int number = 1;
        final int LIMIT = 100;

        System.out.println("Numbers from 1 to 100:");

        while (number <= LIMIT) {
            System.out.print(number + " ");
            number++;
        }

        System.out.println(); // move to a new line after the loop
    }
}
