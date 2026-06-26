/**
 * BankAccountTest.java
 *
 * Main class used to test the BankAccount class.
 * Creates a BankAccount object, sets its details using setters,
 * performs a deposit and a withdrawal, and displays the final
 * account details.
 */
public class BankAccountTest {

    public static void main(String[] args) {

        // Create a BankAccount object
        BankAccount account = new BankAccount();

        // Set account details using setter methods
        account.setAccountNumber("ACC10023");
        account.setAccountHolderName("Nimal Perera");
        account.setBalance(0);

        System.out.println("===== Initial Account Details =====");
        account.displayAccountDetails();

        // Deposit ₹5000 into the account
        System.out.println("\n===== Performing Deposit =====");
        account.deposit(5000);

        // Withdraw ₹2000 from the account
        System.out.println("\n===== Performing Withdrawal =====");
        account.withdraw(2000);

        // Display the updated account details
        System.out.println("\n===== Updated Account Details =====");
        account.displayAccountDetails();
    }
}
