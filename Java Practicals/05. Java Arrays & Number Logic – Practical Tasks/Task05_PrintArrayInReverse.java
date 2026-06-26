import java.util.Scanner;

/**
 * Task 05: Print array elements in reverse order.
 * Unlike Task 04, the original array is NOT modified.
 * The elements are simply displayed starting from the last index
 * down to the first, by looping backwards.
 */
public class Task05_PrintArrayInReverse {
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

        System.out.print("Array elements in original order: ");
        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        System.out.print("Array elements in reverse order: ");
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        input.close();
    }
}
