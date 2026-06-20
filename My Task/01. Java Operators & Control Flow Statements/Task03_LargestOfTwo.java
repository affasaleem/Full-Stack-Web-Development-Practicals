import java.util.Scanner;

public class Task03_LargestOfTwo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Number 1: ");
        int num1 = input.nextInt();

        System.out.print("Enter Number 2: ");
        int num2 = input.nextInt();

        int largest = (num1 > num2) ? num1 : num2 ; 

        if (num1 == num2){
            System.out.println("Both numbers are equal: " + num1);
        } else {
            System.out.println("The largest number is: " + largest);
        }

        input.close();
    }
}
