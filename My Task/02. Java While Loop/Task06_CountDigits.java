import java.util.Scanner;

public class Task06_CountDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer number: ");
        int originalNumber = input.nextInt();

        // Work with the absolute value so negative numbers are handled correctly
        int number = Math.abs(originalNumber);
        int digitCount = 0;

        // Special case: zero has exactly one digit
        if (number == 0) {
            digitCount = 1;
        } else {
            while (number != 0) {
                number /= 10;
                digitCount++;
            }
        }

        System.out.println("The number " + originalNumber + " has " + digitCount + " digit(s).");

        input.close();

    }
    
}



/*FOR MY STUDY PURPOSE:

    Input Number
        |
        v
    Convert to positive (Math.abs)
        |
        v
    Is number == 0 ?
   /           \
 Yes            No
  |              |
digitCount=1     |
                 v
          Remove last digit
          (number /= 10)
                 |
          digitCount++
                 |
          Repeat until
          number == 0

*/
