import java.util.Scanner;

/**
 * Task 08: Remove duplicate elements from an array.
 * This is done manually using nested loops (no Set/HashSet shortcuts),
 * by building a new array that only keeps the first occurrence of each value.
 */
public class Task08_RemoveDuplicates {
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
        printArray(numbers, size);

        // Temporary array to hold unique elements (worst case: no duplicates at all)
        int[] uniqueNumbers = new int[size];
        int uniqueCount = 0;

        for (int i = 0; i < size; i++) {
            boolean alreadyExists = false;

            // Check if numbers[i] has already been added to uniqueNumbers
            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueNumbers[j] == numbers[i]) {
                    alreadyExists = true;
                    break;
                }
            }

            if (!alreadyExists) {
                uniqueNumbers[uniqueCount] = numbers[i];
                uniqueCount++;
            }
        }

        System.out.print("Array after removing duplicates: ");
        printArray(uniqueNumbers, uniqueCount);

        input.close();
    }

    /**
     * Prints the first 'count' elements of the given array on a single line.
     */
    private static void printArray(int[] array, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(array[i]);
            if (i < count - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
