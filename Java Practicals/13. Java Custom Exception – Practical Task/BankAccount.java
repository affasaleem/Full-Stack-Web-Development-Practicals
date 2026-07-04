/**
 * BankAccount.java
 *
 * Represents a bank account with encapsulated attributes and a
 * withdraw() method that enforces a balance check by throwing a
 * custom InsufficientBalanceException when the requested amount
 * exceeds the available balance.
 */
public class BankAccount {

    // ---------- Private Attributes (Encapsulation) ----------
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    /**
     * Parameterized constructor to set up a bank account with
     * an account number, holder name, and initial balance.
     *
     * @param accountNumber     the unique account number
     * @param accountHolderName the name of the account holder
     * @param balance           the initial deposit balance
     */
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // ---------- Getters ----------

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Displays the current account details in a formatted layout.
     */
    public void displayAccountDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance        : " + balance);
    }

    /**
     * Attempts to withdraw the specified amount from the account.
     *
     * If the withdrawal amount exceeds the current balance, this
     * method throws an InsufficientBalanceException instead of
     * silently failing or corrupting the balance. This keeps all
     * the error-signaling logic here in the model class and lets
     * the calling code decide how to display or react to it.
     *
     * The 'throws' keyword in the signature tells the compiler and
     * any developer reading this code that InsufficientBalanceException
     * is a possible outcome that must be handled by the caller.
     *
     * @param withdrawalAmount the amount to withdraw
     * @throws InsufficientBalanceException if the amount exceeds the balance
     */
    public void withdraw(double withdrawalAmount) throws InsufficientBalanceException {

        if (withdrawalAmount <= 0) {
            System.out.println("Error: Withdrawal amount must be greater than zero.");
            return;
        }

        if (withdrawalAmount > balance) {
            // Throw the custom exception with a descriptive message
            // and the two amounts for detailed error reporting
            throw new InsufficientBalanceException(
                "Withdrawal of " + withdrawalAmount + " failed: insufficient funds.",
                withdrawalAmount,
                balance
            );
        }

        // Sufficient balance available — process the withdrawal
        balance = balance - withdrawalAmount;
        System.out.println("Withdrawal successful!");
        System.out.println("Amount withdrawn  : " + withdrawalAmount);
        System.out.println("Remaining balance : " + balance);
    }
}
