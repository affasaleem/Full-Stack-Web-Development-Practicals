import java.util.Scanner;

/**
 * Task 06: Find the second largest element in an array.
 * The array must contain at least two distinct values for a meaningful result.
 */
public class Task06_SecondLargestElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int size = input.nextInt();

        if (size < 2) {
            System.out.println("Please enter at least 2 elements to find a second largest value.");
            input.close();
            return;
        }

        int[] numbers = new int[size];

        System.out.println("Enter " + size + " element(s):");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            int current = numbers[i];

            if (current > largest) {
                // Current element becomes the new largest;
                // the previous largest becomes the second largest
                secondLargest = largest;
                largest = current;
            } else if (current > secondLargest && current != largest) {
                // Current element is smaller than the largest but bigger than
                // the current second largest, and it is not a duplicate of the largest
                secondLargest = current;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("There is no distinct second largest element "
                    + "(all elements may be equal).");
        } else {
            System.out.println("Largest element: " + largest);
            System.out.println("Second largest element: " + secondLargest);
        }

        input.close();
    }
}
