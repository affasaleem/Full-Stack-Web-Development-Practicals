import java.util.Scanner;

public class Task02_EvenOrOdd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Your Number: ");
        int num = input.nextInt();

        if ((num % 2) != 0){
            System.out.print(num + " is an ODD number.");
        } else {
            System.out.print(num +" is an EVEN number.");
        }
    }
}
