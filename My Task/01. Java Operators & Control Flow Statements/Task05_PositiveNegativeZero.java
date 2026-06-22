import java.util.Scanner;

public class Task05_PositiveNegativeZero {
    public static void main (String[]args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Your Number: ");
        int num = input.nextInt();

        if (num < 0) {
            System.out.println(num + " is a NEGATIVE number.");
        } else if (num > 0) {
            System.out.println(num + " is a POSITIVE number.");
        } else {
            System.out.println("The number is ZERO.");
        }

        input.close();
    }
}
