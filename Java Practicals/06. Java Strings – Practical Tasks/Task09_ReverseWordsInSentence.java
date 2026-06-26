import java.util.Scanner;

/**
 * Task 09: Reverse the order of words in a sentence without reversing
 * the words themselves.
 * Logic: Manually split the sentence into words by scanning for spaces
 * and storing each word in an array, then build the result by appending
 * the words starting from the last one down to the first.
 */
public class Task09_ReverseWordsInSentence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String inputSentence = scanner.nextLine();

        // First, count how many words are in the sentence
        int wordCount = 0;
        boolean insideWord = false;

        for (int i = 0; i < inputSentence.length(); i++) {
            char currentChar = inputSentence.charAt(i);
            if (currentChar != ' ' && !insideWord) {
                wordCount++;
                insideWord = true;
            } else if (currentChar == ' ') {
                insideWord = false;
            }
        }

        // Store each word into an array
        String[] words = new String[wordCount];
        int wordIndex = 0;
        String currentWord = "";

        for (int i = 0; i < inputSentence.length(); i++) {
            char currentChar = inputSentence.charAt(i);

            if (currentChar != ' ') {
                currentWord = currentWord + currentChar;
            } else {
                if (currentWord.length() > 0) {
                    words[wordIndex] = currentWord;
                    wordIndex++;
                    currentWord = "";
                }
            }
        }

        // Add the last word (after loop ends, if any word remains)
        if (currentWord.length() > 0) {
            words[wordIndex] = currentWord;
            wordIndex++;
        }

        // Build the reversed-order sentence
        String reversedSentence = "";
        for (int i = wordCount - 1; i >= 0; i--) {
            reversedSentence = reversedSentence + words[i];
            if (i != 0) {
                reversedSentence = reversedSentence + " ";
            }
        }

        System.out.println("Original sentence: " + inputSentence);
        System.out.println("Reversed word order: " + reversedSentence);

        scanner.close();
    }
}
