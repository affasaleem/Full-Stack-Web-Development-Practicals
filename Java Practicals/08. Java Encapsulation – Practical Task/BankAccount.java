/**
 * BankAccount.java
 *
 * Demonstrates Encapsulation in Java by keeping all attributes
 * private and exposing controlled access through public getter
 * and setter methods, plus dedicated deposit/withdraw methods
 * that enforce valid business logic (e.g. no overdrawing funds).
 */
public class BankAccount {

    // ---------- Private Attributes (hidden from outside access) ----------
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // ---------- Getter and Setter Methods ----------

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        // Prevent the account from being set up with a negative balance
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid balance amount. Balance cannot be negative.");
        }
    }

    /**
     * Adds the given amount to the current balance.
     * Only positive deposit amounts are accepted.
     *
     * @param amount the amount of money to deposit
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposited: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    /**
     * Subtracts the given amount from the current balance,
     * but only if there are sufficient funds available.
     *
     * @param amount the amount of money to withdraw
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal of " + amount + " denied.");
        } else {
            balance = balance - amount;
            System.out.println("Withdrew: " + amount + " | New Balance: " + balance);
        }
    }

    /**
     * Displays all account information in a clean, readable format.
     */
    public void displayAccountDetails() {
        System.out.println("Account Number      : " + accountNumber);
        System.out.println("Account Holder Name : " + accountHolderName);
        System.out.println("Current Balance     : " + balance);
    }
}
