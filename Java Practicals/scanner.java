import java.util.Scanner;

public class scanner {
    public static void main (String[] args) {
        Scanner x = new Scanner(System.in);

        System.out.println("enter the number");
        int a = x.nextInt();

        switch(a) {
            case 1:
            System.out.println("monday");
            break;

            case 2:
            System.out.println("monday");
            break;

            default:
                System.out.println("invalid input");
        }
    }
}
