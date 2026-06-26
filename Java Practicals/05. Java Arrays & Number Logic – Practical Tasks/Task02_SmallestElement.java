import java.util.Scanner;

/**
 * Task 02: Find the smallest element in an array.
 */
public class Task02_SmallestElement {
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

        // Assume the first element is the smallest, then compare with the rest
        int smallest = numbers[0];
        for (int i = 1; i < size; i++) {
            if (numbers[i] < smallest) {
                smallest = numbers[i];
            }
        }

        System.out.println("The smallest element in the array is: " + smallest);

        input.close();
    }
}
