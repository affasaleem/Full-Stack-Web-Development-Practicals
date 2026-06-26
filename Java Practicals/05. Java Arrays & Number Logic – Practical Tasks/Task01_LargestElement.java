import java.util.Scanner;

/**
 * Task 01: Find the largest element in an array.
 */
public class Task01_LargestElement {
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

        // Assume the first element is the largest, then compare with the rest
        int largest = numbers[0];
        for (int i = 1; i < size; i++) {
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }

        System.out.println("The largest element in the array is: " + largest);

        input.close();
    }
}
