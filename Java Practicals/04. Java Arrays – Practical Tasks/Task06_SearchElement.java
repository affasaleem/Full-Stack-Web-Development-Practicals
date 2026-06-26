import java.util.Scanner;

/**
 * Task 06: Search for a specific element in an array using linear search.
 */
public class Task06_SearchElement {
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

        System.out.print("Enter the element to search for: ");
        int target = input.nextInt();

        int foundIndex = -1; // -1 means the element was not found

        for (int i = 0; i < size; i++) {
            if (numbers[i] == target) {
                foundIndex = i;
                break; // stop as soon as the element is found
            }
        }

        if (foundIndex != -1) {
            System.out.println("Element " + target + " found at index " + foundIndex
                    + " (position " + (foundIndex + 1) + ").");
        } else {
            System.out.println("Element " + target + " was not found in the array.");
        }

        input.close();
    }
}
