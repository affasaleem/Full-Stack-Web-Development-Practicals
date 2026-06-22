import java.util.Scanner;

public class Task13_SmallestOfThree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        double num1 = input.nextDouble();

        System.out.print("Enter number 2: ");
        double num2 = input.nextDouble();

        System.out.print("Enter number 3: ");
        double num3 = input.nextDouble();

        double smallest = num1;

        if (num2 < smallest) {
            smallest = num2;
        }
        if (num3 < smallest) {
            smallest = num3;
        }

        System.out.println("The smallest number is: " + smallest);

        input.close();
    }
}
