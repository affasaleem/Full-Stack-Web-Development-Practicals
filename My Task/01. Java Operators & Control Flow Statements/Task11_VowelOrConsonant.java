import java.util.Scanner;

public class Task11_VowelOrConsonant {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a single alphabet character: ");
        char character = input.next().charAt(0);

        // Convert to lowercase so the check works for both cases
        char lowerCaseChar = Character.toLowerCase(character);

        if (!Character.isLetter(character)) {
            System.out.println("Error! input an alphabet character.");
        } else if (lowerCaseChar == 'a' || lowerCaseChar == 'e' || lowerCaseChar == 'i'
        || lowerCaseChar == 'o' || lowerCaseChar == 'u') {
            System.out.println(character + " is a VOWEL.");
        } else {
            System.out.println(character + " is a CONSONANT.");
        }

        input.close();

    }
}
