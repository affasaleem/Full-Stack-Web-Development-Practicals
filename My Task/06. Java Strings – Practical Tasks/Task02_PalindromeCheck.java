import java.util.Scanner;

/**
 * Task 02: Check whether a string is a palindrome.
 * Logic: Compare characters from the start and end moving towards the
 * middle. Case is normalized to lowercase so "Madam" is still detected
 * correctly as a palindrome.
 */
public class Task02_PalindromeCheck {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String inputString = scanner.nextLine();

        // Normalize case so the comparison is not case sensitive
        String normalizedString = inputString.toLowerCase();

        boolean isPalindrome = true;
        int leftIndex = 0;
        int rightIndex = normalizedString.length() - 1;

        while (leftIndex < rightIndex) {
            char leftChar = normalizedString.charAt(leftIndex);
            char rightChar = normalizedString.charAt(rightIndex);

            if (leftChar != rightChar) {
                isPalindrome = false;
                break;
            }

            leftIndex++;
            rightIndex--;
        }

        if (isPalindrome) {
            System.out.println("\"" + inputString + "\" is a palindrome.");
        } else {
            System.out.println("\"" + inputString + "\" is NOT a palindrome.");
        }

        scanner.close();
    }
}
