import java.util.Scanner;

public class Task12_DivisibleBy3And5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = input.nextInt();

        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println(num + " is divisible by both 3 and 5.");
        } else {
            System.out.println(num + " is NOT divisible by both 3 and 5.");
        }

        input.close();
    }
}
