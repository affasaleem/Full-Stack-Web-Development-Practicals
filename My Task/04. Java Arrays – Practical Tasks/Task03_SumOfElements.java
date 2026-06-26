import java.util.Scanner;

/**
 * Task 03: Calculate the sum of all elements in an array.
 */
public class Task03_SumOfElements {
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

        System.out.println("The sum of all elements in the array is: " + sum);

        input.close();
    }
}
