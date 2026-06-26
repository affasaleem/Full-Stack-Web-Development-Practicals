import java.util.Scanner;

/**
 * Task 08: Count the frequency of each character in a string.
 * Logic: Use a frequency table (array of size 256) to count occurrences
 * of every character, then print each distinct character once along
 * with its total count.
 */
public class Task08_CharacterFrequency {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        int[] frequencyTable = new int[256];

        // Build frequency table for every character (including spaces)
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            frequencyTable[currentChar]++;
        }

        System.out.println("\n--- Character Frequency ---");

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            boolean alreadyPrinted = false;

            // Avoid printing the same character more than once
            for (int j = 0; j < i; j++) {
                if (inputString.charAt(j) == currentChar) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (!alreadyPrinted) {
                if (currentChar == ' ') {
                    System.out.println("'space' -> " + frequencyTable[currentChar] + " time(s)");
                } else {
                    System.out.println("'" + currentChar + "' -> " + frequencyTable[currentChar] + " time(s)");
                }
            }
        }

        scanner.close();
    }
}
