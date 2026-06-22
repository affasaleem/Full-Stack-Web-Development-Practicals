public class Task01_PrintNumbersWhileLoop {
    public static void main(String[] args) {
        int num = 1;
        final int limit = 100;

        System.out.println("Numbers from 1 to 100:");

        while (num <= limit) {
            System.out.print(num + " ");
            num++;
        }

        System.out.println(); // move to a new line after the loop
    }
}
