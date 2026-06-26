import java.util.Scanner;

/**
 * Task 04: Reverse an array.
 * The array itself is modified in-place by swapping elements
 * from both ends towards the middle (no built-in reverse methods).
 */
public class Task04_ReverseArray {
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

        System.out.print("Original array: ");
        printArray(numbers);

        // Swap elements from both ends towards the middle
        int start = 0;
        int end = size - 1;
        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }

        System.out.print("Array after reversing: ");
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
