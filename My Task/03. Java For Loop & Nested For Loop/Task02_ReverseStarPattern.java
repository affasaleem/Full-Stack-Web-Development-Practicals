/**
 * Task 02: Reverse Pattern Printing
 * Prints a decreasing star pattern using a nested for loop:
 * *****
 * ****
 * ***
 * **
 * *
 */
public class Task02_ReverseStarPattern {
    public static void main(String[] args) {
        final int NUMBER_OF_ROWS = 5;

        for (int row = NUMBER_OF_ROWS; row >= 1; row--) {
            for (int column = 1; column <= row; column++) {
                System.out.print("*");
            }
            System.out.println(); // move to the next line after each row
        }
    }
}
