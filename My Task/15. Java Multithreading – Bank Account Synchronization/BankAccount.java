/**
 * BankAccount.java
 *
 * A thread-safe bank account that is shared among multiple threads.
 * This is the critical shared resource in the simulation.
 *
 * ---------------- WHY SYNCHRONIZATION IS NEEDED ----------------
 * Without synchronized, a race condition can corrupt the balance:
 *
 *   Thread A (withdraw 500) reads balance = 1000
 *   Thread B (withdraw 800) reads balance = 1000  ← same snapshot
 *   Thread A sets balance = 1000 - 500 = 500
 *   Thread B sets balance = 1000 - 800 = 200      ← overwrites A's write!
 *   Net result: balance = 200, but 1300 was withdrawn from 1000.
 *
 * Declaring deposit() and withdraw() as synchronized means only one
 * thread can execute either method at a time (they share the same
 * object-level lock), so the read-and-modify of balance is always atomic.
 *
 * ---------------- WHY wait() / notifyAll() ----------------
 * If a withdraw thread arrives when funds are insufficient, it should
 * PAUSE and give other threads (deposits) a chance to run. Simply
 * rejecting the withdrawal would mean the task might never complete.
 * wait() releases the lock and suspends the thread; notifyAll() wakes
 * all waiting threads after every deposit so they re-check the balance.
 */
public class BankAccount {

    // ---------- Attributes ----------
    private String accountId;
    private double balance;

    /**
     * Constructor to create a bank account with an initial balance.
     *
     * @param accountId      unique identifier for the account
     * @param initialBalance starting balance (must be non-negative)
     */
    public BankAccount(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    public String getAccountId() {
        return accountId;
    }

    /**
     * Returns the current balance.
     * Declared synchronized so a thread reading the balance always
     * sees the most recently committed value written by another thread.
     *
     * @return current balance
     */
    public synchronized double getBalance() {
        return balance;
    }

    /**
     * Deposits the given amount into the account.
     *
     * SYNCHRONIZED: Acquires the object lock before modifying balance,
     * so no other thread can read or write balance at the same time.
     * After updating the balance, notifyAll() wakes any withdraw
     * threads that are waiting due to insufficient funds, giving them
     * a chance to re-check whether they can now proceed.
     *
     * @param amount        the amount to deposit (must be positive)
     * @param depositorName the name of the depositing thread
     */
    public synchronized void deposit(double amount, String depositorName) {
        if (amount <= 0) {
            System.out.println("[" + depositorName + "] Invalid deposit amount: " + amount);
            return;
        }

        balance += amount;
        System.out.printf("[%-14s] Deposited: %8.2f  |  New Balance: %8.2f%n",
                depositorName, amount, balance);

        // Wake all waiting withdraw threads — a deposit may have provided
        // the funds they were waiting for.
        notifyAll();
    }

    /**
     * Withdraws the given amount from the account.
     *
     * SYNCHRONIZED: Acquires the object lock before touching balance.
     * If insufficient funds are available, the thread calls wait(),
     * which atomically releases the lock and suspends this thread.
     * When a deposit calls notifyAll(), all suspended withdraw threads
     * are woken, re-acquire the lock one at a time, and re-check the
     * condition inside the while loop (using while, not if, to guard
     * against spurious wakeups and multiple threads waking at once).
     *
     * The balance can NEVER go negative because the while loop ensures
     * the check and the deduction happen atomically under the same lock.
     *
     * @param amount         the amount to withdraw (must be positive)
     * @param withdrawerName the name of the withdrawing thread
     */
    public synchronized void withdraw(double amount, String withdrawerName) {
        if (amount <= 0) {
            System.out.println("[" + withdrawerName + "] Invalid withdrawal amount: " + amount);
            return;
        }

        // WHILE (not if): re-check after every wakeup because another
        // thread may have consumed the funds between the notify and
        // this thread re-acquiring the lock.
        while (balance < amount) {
            System.out.printf("[%-14s] Insufficient funds (need: %6.2f | have: %6.2f). Waiting...%n",
                    withdrawerName, amount, balance);
            try {
                wait();  // Release the lock and suspend until notifyAll() is called
            } catch (InterruptedException interruptedException) {
                System.out.println("[" + withdrawerName + "] Thread was interrupted while waiting.");
                Thread.currentThread().interrupt();
                return;
            }
        }

        balance -= amount;
        System.out.printf("[%-14s] Withdrawn : %8.2f  |  New Balance: %8.2f%n",
                withdrawerName, amount, balance);
    }

    /**
     * Displays the current account balance (thread-safe read).
     */
    public synchronized void displayBalance() {
        System.out.printf("Account [%s] Current Balance: %.2f%n", accountId, balance);
    }
}
