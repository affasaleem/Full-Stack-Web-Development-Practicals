import java.util.Scanner;

/**
 * Task 04: Calculate the average of array elements.
 */
public class Task04_AverageOfElements {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int size = input.nextInt();

        int[] numbers = new int[size];

        System.out.println("Enter " + size + " element(s):");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += numbers[i];
        }

        double average = (double) sum / size;

        System.out.println("Sum of elements: " + sum);
        System.out.println("Average of elements: " + average);

        input.close();
    }
}
