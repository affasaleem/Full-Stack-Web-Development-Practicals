/**
 * Task 04: Right Triangle Star Pattern
 * Prints a triangle of stars (odd counts) using a nested for loop:
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 *
 * Each row has leading spaces so the stars line up in a centered triangle,
 * and the number of stars increases by 2 on every row (1, 3, 5, 7, 9).
 */
public class Task04_RightTrianglePattern {
    public static void main(String[] args) {
        final int NUMBER_OF_ROWS = 5;

        for (int row = 1; row <= NUMBER_OF_ROWS; row++) {
            // Print the leading spaces needed to center this row's stars
            int spaceCount = NUMBER_OF_ROWS - row;
            for (int space = 1; space <= spaceCount; space++) {
                System.out.print(" ");
            }

            // Print the stars for this row (1, 3, 5, 7, 9, ...)
            int starCount = (2 * row) - 1;
            for (int star = 1; star <= starCount; star++) {
                System.out.print("*");
            }

            System.out.println(); // move to the next line after each row
        }
    }
}
