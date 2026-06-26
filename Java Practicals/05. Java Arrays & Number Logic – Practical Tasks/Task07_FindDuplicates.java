import java.util.Scanner;

/**
 * Task 07: Find duplicate elements in an array.
 * Identifies which values appear more than once, printing each
 * duplicate value only once even if it repeats more than twice.
 */
public class Task07_FindDuplicates {
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

        // Array to keep track of values that have already been reported as duplicates,
        // so each duplicate value is printed only once.
        int[] reportedDuplicates = new int[size];
        int reportedCount = 0;
        boolean foundAnyDuplicate = false;

        System.out.println("Duplicate element(s) found:");

        for (int i = 0; i < size; i++) {
            int countOccurrences = 0;

            // Count how many times numbers[i] appears in the whole array
            for (int j = 0; j < size; j++) {
                if (numbers[j] == numbers[i]) {
                    countOccurrences++;
                }
            }

            if (countOccurrences > 1) {
                // Check whether this value has already been reported
                boolean alreadyReported = false;
                for (int k = 0; k < reportedCount; k++) {
                    if (reportedDuplicates[k] == numbers[i]) {
                        alreadyReported = true;
                        break;
                    }
                }

                if (!alreadyReported) {
                    System.out.println(numbers[i] + " (appears " + countOccurrences + " times)");
                    reportedDuplicates[reportedCount] = numbers[i];
                    reportedCount++;
                    foundAnyDuplicate = true;
                }
            }
        }

        if (!foundAnyDuplicate) {
            System.out.println("No duplicate elements were found in the array.");
        }

        input.close();
    }
}
