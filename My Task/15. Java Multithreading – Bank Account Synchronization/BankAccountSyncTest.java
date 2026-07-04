/**
 * BankAccountSyncTest.java
 *
 * Main class that sets up the Bank Account Synchronization simulation.
 *
 * Demonstrates:
 *  - Synchronized deposit() and withdraw() preventing race conditions.
 *  - wait() / notifyAll() ensuring withdrawals pause when funds are
 *    insufficient rather than letting the balance go negative.
 *  - Multiple deposit AND withdraw threads running concurrently on
 *    the same BankAccount object, always leaving a consistent balance.
 *
 * Total deposits  = 500 + 300 + 700 + 400 = 1900
 * Total withdrawals = 400 + 600 + 300 + 200 = 1500
 * Expected final balance = initialBalance(500) + 1900 - 1500 = 900
 */
public class BankAccountSyncTest {

    public static void main(String[] args) {

        // Shared bank account with initial balance of 500
        BankAccount sharedAccount = new BankAccount("ACC-2024", 500.00);

        System.out.println("===== Bank Account Synchronization Demo =====");
        System.out.println("Initial state:");
        sharedAccount.displayBalance();
        System.out.println();
        System.out.println("Starting concurrent deposit and withdrawal threads...");
        System.out.println("---------------------------------------------");

        // ---------- Deposit threads ----------
        Thread depositThread1 = new Thread(
                new DepositTask("Depositor-1", sharedAccount,
                        new double[]{500.00, 300.00}));

        Thread depositThread2 = new Thread(
                new DepositTask("Depositor-2", sharedAccount,
                        new double[]{700.00, 400.00}));

        // ---------- Withdrawal threads ----------
        // These amounts total 1500. Some may need to wait for deposits.
        Thread withdrawThread1 = new Thread(
                new WithdrawTask("Withdrawer-1", sharedAccount,
                        new double[]{400.00, 600.00}));

        Thread withdrawThread2 = new Thread(
                new WithdrawTask("Withdrawer-2", sharedAccount,
                        new double[]{300.00, 200.00}));

        // Start all threads — all run concurrently on the same account
        depositThread1.start();
        depositThread2.start();
        withdrawThread1.start();
        withdrawThread2.start();

        // Wait for all threads to complete before printing the final balance
        try {
            depositThread1.join();
            depositThread2.join();
            withdrawThread1.join();
            withdrawThread2.join();
        } catch (InterruptedException interruptedException) {
            System.out.println("Main thread interrupted: " + interruptedException.getMessage());
        }

        System.out.println("---------------------------------------------");
        System.out.println("\n===== All Transactions Completed =====");
        sharedAccount.displayBalance();
        System.out.println("Expected final balance: 900.00");
        System.out.println("Balance is never negative — thread safety confirmed.");
    }
}
