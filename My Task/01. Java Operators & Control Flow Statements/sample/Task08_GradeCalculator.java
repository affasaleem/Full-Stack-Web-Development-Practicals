import java.util.Scanner;

/**
 * Task 08: Grade calculator using else-if conditions.
 * Grading scale:
 *   90 - 100 : A
 *   80 - 89  : B
 *   70 - 79  : C
 *   60 - 69  : D
 *   Below 60 : F
 */
public class Task08_GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the student's score (0-100): ");
        int score = input.nextInt();

        char grade;

        if (score < 0 || score > 100) {
            System.out.println("Invalid score. Please enter a value between 0 and 100.");
        } else {
            if (score >= 90) {
                grade = 'A';
            } else if (score >= 80) {
                grade = 'B';
            } else if (score >= 70) {
                grade = 'C';
            } else if (score >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.println("Score: " + score);
            System.out.println("Grade: " + grade);
        }

        input.close();
    }
}
