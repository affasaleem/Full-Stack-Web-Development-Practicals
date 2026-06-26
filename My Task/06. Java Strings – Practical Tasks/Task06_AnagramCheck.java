import java.util.Scanner;

/**
 * Task 06: Check whether two strings are anagrams of each other.
 * Logic: Two strings are anagrams if they contain exactly the same
 * characters with the same frequency (ignoring case and spaces).
 * A frequency table is built for the first string, then decremented
 * while scanning the second string. If all counts return to zero and
 * lengths match, the strings are anagrams.
 */
public class Task06_AnagramCheck {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string : ");
        String firstString = scanner.nextLine().toLowerCase().replace(" ", "");

        System.out.print("Enter second string: ");
        String secondString = scanner.nextLine().toLowerCase().replace(" ", "");

        boolean isAnagram = true;

        if (firstString.length() != secondString.length()) {
            isAnagram = false;
        } else {
            int[] frequencyTable = new int[256];

            // Increment counts for first string
            for (int i = 0; i < firstString.length(); i++) {
                frequencyTable[firstString.charAt(i)]++;
            }

            // Decrement counts for second string
            for (int i = 0; i < secondString.length(); i++) {
                frequencyTable[secondString.charAt(i)]--;
            }

            // If any count is not zero, they are not anagrams
            for (int i = 0; i < frequencyTable.length; i++) {
                if (frequencyTable[i] != 0) {
                    isAnagram = false;
                    break;
                }
            }
        }

        if (isAnagram) {
            System.out.println("The two strings ARE anagrams of each other.");
        } else {
            System.out.println("The two strings are NOT anagrams of each other.");
        }

        scanner.close();
    }
}
