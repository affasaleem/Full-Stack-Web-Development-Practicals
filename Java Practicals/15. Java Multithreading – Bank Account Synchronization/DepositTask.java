/**
 * DepositTask.java
 *
 * A Runnable task that deposits a series of amounts into a shared
 * BankAccount. Each instance runs in its own thread, simulating
 * a real-world scenario where multiple deposit sources (salary
 * credits, transfers, etc.) may occur concurrently.
 */
public class DepositTask implements Runnable {

    private String depositorName;
    private BankAccount account;
    private double[] depositAmounts;

    /**
     * @param depositorName  name label for this thread's output
     * @param account        the shared BankAccount to deposit into
     * @param depositAmounts array of amounts this thread will deposit
     *                       one at a time, with a short pause between each
     */
    public DepositTask(String depositorName, BankAccount account, double[] depositAmounts) {
        this.depositorName = depositorName;
        this.account = account;
        this.depositAmounts = depositAmounts;
    }

    @Override
    public void run() {
        for (double amount : depositAmounts) {
            account.deposit(amount, depositorName);

            // Small pause between deposits to interleave thread activity
            // and make concurrent behavior visible in the output.
            try {
                Thread.sleep(50);
            } catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
