import java.util.Scanner;

/**
 * BankAccountTest.java
 *
 * Main class that demonstrates the full custom exception workflow:
 *  1. Creates a BankAccount object with an initial balance.
 *  2. Accepts a withdrawal amount from the user via Scanner.
 *  3. Calls withdraw(), which throws InsufficientBalanceException
 *     if the amount exceeds the balance.
 *  4. Handles the custom exception in a try-catch block, printing
 *     a clear, user-friendly error message without crashing.
 */
public class BankAccountTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create and display the initial account
        BankAccount account = new BankAccount("ACC20045", "Nimal Perera", 15000.00);

        System.out.println("===== Account Details =====");
        account.displayAccountDetails();

        System.out.print("\nEnter the amount to withdraw: ");
        double withdrawalAmount = scanner.nextDouble();

        System.out.println("\n===== Withdrawal Result =====");

        try {
            // withdraw() will throw InsufficientBalanceException
            // if there are not enough funds — we catch it below
            account.withdraw(withdrawalAmount);

        } catch (InsufficientBalanceException exception) {
            // Catching the specific custom exception gives us access
            // to the extra fields we stored (attempted amount,
            // available balance), letting us produce a precise message.
            System.out.println("Error: " + exception.getMessage());
            System.out.println("Attempted to withdraw : " + exception.getWithdrawalAmount());
            System.out.println("Available balance     : " + exception.getAvailableBalance());
            System.out.println("Please try a smaller withdrawal amount.");
        }

        // The program continues normally after the exception is caught
        System.out.println("\n===== Final Account Status =====");
        account.displayAccountDetails();

        scanner.close();
    }
}
