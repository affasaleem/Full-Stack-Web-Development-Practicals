import java.util.Scanner;

public class while_loop {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Enter your Password");
        int p = input.nextInt();

        while (p!=1234){
            System.out.println("Wrong Password");
            p = input.nextInt();
        }
        System.out.println("Succefully Login!");

    }
}
