import java.util.Scanner;

public class Task04_MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = input.nextInt();

        final int TABLE_LIMIT = 12;
        int multiplier = 1;
        int r;

        System.out.println("Multiplication table of " + num + ":");

        while (multiplier <= TABLE_LIMIT) {
            r = num * multiplier;
            System.out.println(num + " x " + multiplier + " = " + r);
            multiplier++;
        }

        input.close();
    }
}
