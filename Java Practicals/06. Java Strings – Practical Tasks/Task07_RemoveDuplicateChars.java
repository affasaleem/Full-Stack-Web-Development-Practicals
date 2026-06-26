import java.util.Scanner;

/**
 * Task 07: Remove duplicate characters from a string while preserving order.
 * Logic: Build a result string by checking, for each character, whether it
 * has already been added to the result. If not, append it; if it has,
 * skip it. This keeps the original order of first appearance.
 */
public class Task07_RemoveDuplicateChars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        String resultString = "";

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            boolean alreadyAdded = false;

            // Check if currentChar already exists in resultString
            for (int j = 0; j < resultString.length(); j++) {
                if (resultString.charAt(j) == currentChar) {
                    alreadyAdded = true;
                    break;
                }
            }

            if (!alreadyAdded) {
                resultString = resultString + currentChar;
            }
        }

        System.out.println("Original string         : " + inputString);
        System.out.println("String without duplicates: " + resultString);

        scanner.close();
    }
}
