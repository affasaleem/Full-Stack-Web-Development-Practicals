import java.util.Scanner;

public class Task03_SumOfEvenNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number limit: ");
        int n = input.nextInt();

        int num = 1;
        int sum = 0;
        while (num <= n) {
            if (num % 2 == 0) {
                sum += num;  //sum = sum + num;
            }
            num++;
        }

        System.out.print(" sum of all even from 1 to " + n + " is: " + sum);

        input.close();
    }
}
