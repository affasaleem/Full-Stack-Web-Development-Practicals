import java.util.Scanner;

public class Task04_VotingEligibility {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Your Age : ");
        int age = input.nextInt();

        if (age > 18) {
            System.out.print("You are ELIGIBLE to vote.");
        } else {
            System.out.print("You are NOT eligible to vote.");

        }

        input.close();
    }
}
