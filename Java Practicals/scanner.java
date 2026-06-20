import java.util.Scanner;

public class scanner {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("enter the number");
        int a = input.nextInt();

        switch(a) {
            case 1:
            System.out.println("monday");
            break;

            case 2:
            System.out.println("tuesday");
            break;

            case 5:
            System.out.println("friday");
            break;

            default:
                System.out.println("invalid input");
        }
    }
}
