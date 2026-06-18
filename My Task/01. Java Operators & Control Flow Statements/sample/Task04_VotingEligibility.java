import java.util.Scanner;

/**
 * Task 04: Check whether a person is eligible for voting based on age.
 * The minimum voting age is assumed to be 18 years.
 */
public class Task04_VotingEligibility {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        final int MINIMUM_VOTING_AGE = 18;

        if (age >= MINIMUM_VOTING_AGE) {
            System.out.println("You are ELIGIBLE to vote.");
        } else {
            int yearsLeft = MINIMUM_VOTING_AGE - age;
            System.out.println("You are NOT eligible to vote.");
            System.out.println("You need to wait " + yearsLeft + " more year(s).");
        }

        input.close();
    }
}
