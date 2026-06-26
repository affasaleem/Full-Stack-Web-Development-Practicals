import java.util.Scanner;

/**
 * Task 04: Find the first non-repeated character in a string.
 * Logic: For every character, count how many times it appears in the
 * whole string using a nested loop. The first character whose count
 * is exactly 1 is the first non-repeated character.
 */
public class Task04_FirstNonRepeatedChar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        char firstNonRepeatedChar = '\0';
        boolean found = false;

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            int occurrenceCount = 0;

            // Count occurrences of currentChar in the entire string
            for (int j = 0; j < inputString.length(); j++) {
                if (inputString.charAt(j) == currentChar) {
                    occurrenceCount++;
                }
            }

            if (occurrenceCount == 1) {
                firstNonRepeatedChar = currentChar;
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("First non-repeated character: " + firstNonRepeatedChar);
        } else {
            System.out.println("No non-repeated character found in the string.");
        }

        scanner.close();
    }
}
