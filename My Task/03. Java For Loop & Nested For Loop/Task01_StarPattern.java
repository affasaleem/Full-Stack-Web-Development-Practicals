/**
 * Task 01: Pattern Printing
 * Prints an increasing star pattern using a nested for loop:
 * *
 * **
 * ***
 * ****
 * *****
 */
public class Task01_StarPattern {
    public static void main(String[] args) {
        final int NUMBER_OF_ROWS = 5;

        for (int row = 1; row <= NUMBER_OF_ROWS; row++) {
            for (int column = 1; column <= row; column++) {
                System.out.print("*");
            }
            System.out.println(); // move to the next line after each row
        }
    }
}
