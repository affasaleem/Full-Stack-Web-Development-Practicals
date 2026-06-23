import java.util.Scanner;

/*
Find the factorial of a number.
Ex: 5! = 5 x 4 x 3 x 2 x 1 = 120
*/

public class Task07_Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a non-negative integer number: ");
        int num = input.nextInt();

        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long factorial = 1; // use long to support reasonably large results
            int counter = num;

            while (counter > 1) {
                factorial *= counter;
                counter--;
            }

            System.out.println("Factorial of " + num + " is: " + factorial);
        }

        input.close();
    }
}


/* WHY USE long?
'long' can store much larger numbers than 'int' ,
 so it prevents overflow for reasonably large inputs.
*/