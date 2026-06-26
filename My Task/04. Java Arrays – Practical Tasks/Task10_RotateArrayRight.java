import java.util.Scanner;

/**
 * Task 10: Rotate an array to the right by one position.
 * Example: [1, 2, 3, 4, 5] -> [5, 1, 2, 3, 4]
 * The last element wraps around to become the first element.
 */
public class Task10_RotateArrayRight {
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

        // Display the original array
        System.out.print("Original array: ");
        printArray(numbers);

        if (size > 0) {
            // Save the last element; it will move to the front
            int lastElement = numbers[size - 1];

            // Shift every element one position to the right
            for (int i = size - 1; i > 0; i--) {
                numbers[i] = numbers[i - 1];
            }

            // Place the saved last element at the beginning
            numbers[0] = lastElement;
        }

        // Display the rotated array
        System.out.print("Array after rotating right by one position: ");
        printArray(numbers);

        input.close();
    }

    /**
     * Prints all elements of the given array on a single line.
     */
    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
