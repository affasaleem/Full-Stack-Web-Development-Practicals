import java.util.Scanner;

/**
 * Task 05: Find all duplicate characters and their occurrence counts.
 * Logic: Use a fixed-size array (size 256, for all extended ASCII values)
 * as a frequency table. Loop through the string once to fill the table,
 * then loop through the table to print characters whose count is more
 * than 1. A "printed" flag array stops the same character from being
 * reported multiple times.
 */
public class Task05_DuplicateCharacters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        int[] frequencyTable = new int[256];

        // Build frequency table
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            frequencyTable[currentChar]++;
        }

        System.out.println("\n--- Duplicate Characters ---");
        boolean duplicateFound = false;

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);

            // Print only the first time we encounter this duplicate character
            if (frequencyTable[currentChar] > 1) {
                boolean alreadyPrinted = false;

                for (int j = 0; j < i; j++) {
                    if (inputString.charAt(j) == currentChar) {
                        alreadyPrinted = true;
                        break;
                    }
                }

                if (!alreadyPrinted) {
                    System.out.println("'" + currentChar + "' occurs "
                            + frequencyTable[currentChar] + " times");
                    duplicateFound = true;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No duplicate characters found.");
        }

        scanner.close();
    }
}
