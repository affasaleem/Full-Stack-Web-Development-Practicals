import java.util.Scanner;

public class Task07_BiggerNumberIfElse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your number 1: ");
        int num1 = input.nextInt();

        System.out.print("Enter your number 2: ");
        int num2 = input.nextInt();

        if (num1 < num2) {
            System.out.println(num2 + " is biggers than " + num1);
        } else if (num1 > num2) {
            System.out.println(num1 + " is biggers number " + num2);
        }else {
            System.out.println("Both numbers are equal: " + num1 +" & " + num2); // when 2 numbers are equal
        }

        input.close();
    }
}
