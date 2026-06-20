/**
 * Task 02: Print all odd numbers between 1 and 50.
 * No user input is required for this task; the range is fixed.
 */
public class Task02_OddNumbers1To50 {
    public static void main(String[] args) {
        final int START = 1;
        final int END = 50;

        System.out.println("Odd numbers between 1 and 50:");

        int number = START;
        while (number <= END) {
            if (number % 2 != 0) {
                System.out.print(number + " ");
            }
            number++;
        }

        System.out.println(); // move to a new line after the loop
    }
}
