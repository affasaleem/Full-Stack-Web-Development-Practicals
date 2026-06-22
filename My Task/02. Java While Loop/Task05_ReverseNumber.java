import java.util.Scanner;

public class Task05_ReverseNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer number: ");
        int originalNumber = input.nextInt();

        // Math.abs() returns the positive version of a number.
        int numberToReverse = Math.abs(originalNumber);
        int reversedNumber = 0;

        while (numberToReverse != 0) {
            int lastDigit = numberToReverse % 10; // Ex: 123 % 10 = 3
            reversedNumber = (reversedNumber * 10) + lastDigit; //Ex: (0 * 10) + 3 = 3
            numberToReverse /= 10; //Ex: 123 / 10 = 12
        }

        // Restore the negative sign if the original number was negative
        if (originalNumber < 0) {
            reversedNumber = -reversedNumber;
        }

        System.out.println("Original number: " + originalNumber);
        System.out.println("Reversed number: " + reversedNumber);

        input.close();
    }
}

/*My Study Purpose:
% 10   -> Extract the last digit
/ 10   -> Remove the last digit
* 10   -> Shift digits left to build the reversed number
*/
