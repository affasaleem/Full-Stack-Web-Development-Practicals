/**
 * WithdrawTask.java
 *
 * A Runnable task that withdraws a series of amounts from a shared
 * BankAccount. If funds are insufficient for a particular withdrawal,
 * the thread will WAIT (not fail) until a deposit provides enough
 * balance, thanks to the wait()/notifyAll() coordination inside
 * BankAccount.withdraw(). This ensures the balance never goes negative.
 */
public class WithdrawTask implements Runnable {

    private String withdrawerName;
    private BankAccount account;
    private double[] withdrawAmounts;

    /**
     * @param withdrawerName  name label for this thread's output
     * @param account         the shared BankAccount to withdraw from
     * @param withdrawAmounts array of amounts this thread will withdraw
     */
    public WithdrawTask(String withdrawerName, BankAccount account, double[] withdrawAmounts) {
        this.withdrawerName = withdrawerName;
        this.account = account;
        this.withdrawAmounts = withdrawAmounts;
    }

    @Override
    public void run() {
        for (double amount : withdrawAmounts) {
            account.withdraw(amount, withdrawerName);

            // Small pause between withdrawals to interleave threads
            try {
                Thread.sleep(80);
            } catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
