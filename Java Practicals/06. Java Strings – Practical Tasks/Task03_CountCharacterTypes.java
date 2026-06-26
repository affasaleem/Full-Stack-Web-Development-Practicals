import java.util.Scanner;

/**
 * Task 03: Count the number of vowels, consonants, digits,
 * and special characters in a string.
 * Logic: Loop through each character and classify it using
 * conditional checks (letter, vowel/consonant, digit, or other).
 */
public class Task03_CountCharacterTypes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        int vowelCount = 0;
        int consonantCount = 0;
        int digitCount = 0;
        int specialCharCount = 0;
        int spaceCount = 0;

        for (int index = 0; index < inputString.length(); index++) {
            char currentChar = inputString.charAt(index);
            char lowerChar = Character.toLowerCase(currentChar);

            if (Character.isLetter(currentChar)) {
                if (lowerChar == 'a' || lowerChar == 'e' || lowerChar == 'i'
                        || lowerChar == 'o' || lowerChar == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            } else if (Character.isDigit(currentChar)) {
                digitCount++;
            } else if (currentChar == ' ') {
                spaceCount++;
            } else {
                specialCharCount++;
            }
        }

        System.out.println("\n--- Character Analysis ---");
        System.out.println("Vowels           : " + vowelCount);
        System.out.println("Consonants       : " + consonantCount);
        System.out.println("Digits           : " + digitCount);
        System.out.println("Spaces           : " + spaceCount);
        System.out.println("Special Characters: " + specialCharCount);

        scanner.close();
    }
}
