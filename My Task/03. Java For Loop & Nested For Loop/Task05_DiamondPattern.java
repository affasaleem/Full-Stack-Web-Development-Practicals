/**
 * Task 05: Diamond Star Pattern
 * Prints a diamond made of stars using nested for loops:
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 *  *******
 *   *****
 *    ***
 *     *
 *
 * The diamond is built in two halves:
 *   1. The upper half (increasing star count with decreasing leading spaces).
 *   2. The lower half (decreasing star count with increasing leading spaces).
 */
public class Task05_DiamondPattern {
    public static void main(String[] args) {
        final int NUMBER_OF_ROWS = 5; // number of rows in the upper half (and lower half)

        // ----- Upper half of the diamond -----
        for (int row = 1; row <= NUMBER_OF_ROWS; row++) {
            int spaceCount = NUMBER_OF_ROWS - row;
            for (int space = 1; space <= spaceCount; space++) {
                System.out.print(" ");
            }

            int starCount = (2 * row) - 1;
            for (int star = 1; star <= starCount; star++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // ----- Lower half of the diamond -----
        for (int row = NUMBER_OF_ROWS - 1; row >= 1; row--) {
            int spaceCount = NUMBER_OF_ROWS - row;
            for (int space = 1; space <= spaceCount; space++) {
                System.out.print(" ");
            }

            int starCount = (2 * row) - 1;
            for (int star = 1; star <= starCount; star++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
