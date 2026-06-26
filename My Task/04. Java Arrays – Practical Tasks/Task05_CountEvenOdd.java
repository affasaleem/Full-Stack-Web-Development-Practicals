import java.util.Scanner;

/**
 * Task 05: Count the number of even and odd elements in an array.
 */
public class Task05_CountEvenOdd {
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

        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < size; i++) {
            if (numbers[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Number of even elements: " + evenCount);
        System.out.println("Number of odd elements: " + oddCount);

        input.close();
    }
}
