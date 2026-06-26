import java.util.Scanner;

/**
 * Task 10: Find the longest word in a given sentence.
 * Logic: Scan through the sentence character by character, building up
 * the current word. Whenever a space (or the end of the sentence) is
 * reached, compare the completed word's length with the longest word
 * found so far and update if necessary.
 */
public class Task10_LongestWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String inputSentence = scanner.nextLine();

        String currentWord = "";
        String longestWord = "";

        for (int i = 0; i < inputSentence.length(); i++) {
            char currentChar = inputSentence.charAt(i);

            if (currentChar != ' ') {
                currentWord = currentWord + currentChar;
            } else {
                if (currentWord.length() > longestWord.length()) {
                    longestWord = currentWord;
                }
                currentWord = "";
            }
        }

        // Check the final word after the loop ends
        if (currentWord.length() > longestWord.length()) {
            longestWord = currentWord;
        }

        System.out.println("Sentence    : " + inputSentence);
        System.out.println("Longest word: " + longestWord);
        System.out.println("Length      : " + longestWord.length());

        scanner.close();
    }
}
