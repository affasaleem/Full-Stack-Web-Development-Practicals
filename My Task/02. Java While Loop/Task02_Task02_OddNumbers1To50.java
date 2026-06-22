public class Task02_Task02_OddNumbers1To50 {
    public static void main(String[] args) {
        int num = 1;
        final int limit = 50;

        System.out.println("Odd numbers between 1 and 50:");

        while (num <= limit) {
            if ((num % 2) != 0) {
                System.out.print(num + " ");
            }
            num++;
        }

        System.out.println(); // move to a new line after the loop
    }
}