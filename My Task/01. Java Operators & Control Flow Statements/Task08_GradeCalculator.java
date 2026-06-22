import java.util.Scanner;

/*  Grading scale:
 *   75 - 100 : A
 *   65 - 74  : B
 *   55 - 64  : C
 *   40 - 54  : D
 *   Below 39 : F */


public class Task08_GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your marks (0-100): ");
        int marks = input.nextInt();

        char grade;

        if (marks < 0 || marks >100) {
            System.out.println("Please enter correct value!");
        } else {
            if (marks >= 75) {
                grade = 'A';
            } else if (marks >= 65) {
                grade = 'B';
            } else if (marks >= 55) {
                grade = 'C';
            } else if (marks >= 40) {
                grade = 'D';
            } else {
                grade = 'F';
            }
            System.out.println("Grade: " + grade);
        }

        input.close();
    }
}
