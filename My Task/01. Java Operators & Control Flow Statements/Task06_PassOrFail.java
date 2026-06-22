import java.util.Scanner;

public class Task06_PassOrFail {
    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your mark: ");
        int marks = input.nextInt();

        // PASS MARK above 35
        // Validate the input range
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks.");
        } else if (marks <= 35) {
            System.out.println("Result: FAIL");
        } else {
            System.out.println("Result: PASS");
        }

        input.close();
    }
}
