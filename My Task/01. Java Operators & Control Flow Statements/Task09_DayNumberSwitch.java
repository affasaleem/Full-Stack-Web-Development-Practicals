import java.util.Scanner;

public class Task09_DayNumberSwitch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a day number (1-7): ");
        int dayNumber = input.nextInt();

        switch (dayNumber) {
            case 1:
            System.out.println("Monday");
            break;

            case 2:
            System.out.println("Tuesday");
            break;

            case 3:
            System.out.println("Wednesday");
            break;

            case 4:
            System.out.println("Thursday");
            break;

            case 5:
            System.out.println("Friday");
            break;

            case 6:
            System.out.println("Satday");
            break;

            case 7:
            System.out.println("Sunday");
            break;

            default:
                System.out.println("invalid input");

        }

        input.close();
        
    }
}
