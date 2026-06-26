import java.util.Scanner;

/**
 * Task 01: Reverse a given string without using built-in reverse methods.
 * Logic: Traverse the string from the last index to the first index
 * and build a new string by appending each character.
 */
public class Task01_ReverseString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to reverse: ");
        String inputString = scanner.nextLine();

        String reversedString = "";

        // Loop from the last character to the first character
        for (int index = inputString.length() - 1; index >= 0; index--) {
            char currentChar = inputString.charAt(index);
            reversedString = reversedString + currentChar;
        }

        System.out.println("Original string : " + inputString);
        System.out.println("Reversed string : " + reversedString);

        scanner.close();
    }
}
