import java.util.Scanner;

/**
 * Task 07: Reverse an array without using built-in methods.
 * The reversal is done in-place by swapping elements from both ends
 * towards the middle.
 */
public class Task07_ReverseArray {
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

        // Reverse the array by swapping elements from both ends
        int start = 0;
        int end = size - 1;
        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }

        // Display the reversed array
        System.out.print("Reversed array: ");
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
