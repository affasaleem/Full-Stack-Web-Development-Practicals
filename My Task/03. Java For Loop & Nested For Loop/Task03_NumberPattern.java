/**
 * Task 03: Number Pattern
 * Prints an increasing number pattern using a nested for loop:
 * 1
 * 12
 * 123
 * 1234
 * 12345
 */
public class Task03_NumberPattern {
    public static void main(String[] args) {
        final int NUMBER_OF_ROWS = 5;

        for (int row = 1; row <= NUMBER_OF_ROWS; row++) {
            for (int column = 1; column <= row; column++) {
                System.out.print(column);
            }
            System.out.println(); // move to the next line after each row
        }
    }
}
