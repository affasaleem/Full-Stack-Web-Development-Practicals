/*
 * Task 02 - Bank Account Money Transfer (FIXED VERSION)
 *
 * Deadlock fix strategy: CONSISTENT LOCK ORDERING.
 * Every transfer locks accounts in a fixed order based on a unique account
 * id, regardless of which account is the source and which is the
 * destination. Since all threads always request locks in the same order,
 * a circular wait (and therefore a deadlock) is impossible.
 *
 * Inter-thread communication: if the source account does not have enough
 * balance, the transferring thread calls wait() and sleeps until another
 * thread deposits money into that account and calls notifyAll().
 */
public class BankTransferFixed {

    static class BankAccount {
        private final int id;          // used only to decide a consistent lock order
        private final String name;
        private double balance;

        BankAccount(int id, String name, double balance) {
            this.id = id;
            this.name = name;
            this.balance = balance;
        }

        int getId() {
            return id;
        }

        String getName() {
            return name;
        }

        synchronized double getBalance() {
            return balance;
        }

        // Waits until enough balance is available, then withdraws
        synchronized void withdraw(double amount) throws InterruptedException {
            while (balance < amount) {
                System.out.println(Thread.currentThread().getName()
                        + ": insufficient balance in " + name + " (has " + balance
                        + ", needs " + amount + "). Waiting for a deposit...");
                wait(); // release lock on 'this' and wait to be notified
            }
            balance -= amount;
        }

        synchronized void deposit(double amount) {
            balance += amount;
            System.out.println(Thread.currentThread().getName()
                    + ": deposited " + amount + " into " + name + " (new balance " + balance + ")");
            notifyAll(); // wake up any threads waiting for a deposit into this account
        }
    }

    // Always locks the account with the smaller id first to avoid circular waits
    private static void transfer(BankAccount from, BankAccount to, double amount) throws InterruptedException {
        BankAccount first = (from.getId() < to.getId()) ? from : to;
        BankAccount second = (from.getId() < to.getId()) ? to : from;

        synchronized (first) {
            synchronized (second) {
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println(Thread.currentThread().getName() + ": transferred " + amount
                        + " from " + from.getName() + " to " + to.getName());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BankAccount accountA = new BankAccount(1, "Account A", 1000);
        BankAccount accountB = new BankAccount(2, "Account B", 1000);

        // Thread 1: A -> B
        Thread t1 = new Thread(() -> {
            try {
                transfer(accountA, accountB, 100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Thread-1(A->B)");

        // Thread 2: B -> A (locking order is normalized inside transfer(), so no deadlock)
        Thread t2 = new Thread(() -> {
            try {
                transfer(accountB, accountA, 5000); // more than B has -> will wait
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Thread-2(B->A)");

        t1.start();
        t2.start();

        t1.join();

        // Deposit into B so Thread-2's transfer (which was waiting) can finally succeed
        Thread.sleep(300);
        accountB.deposit(5000);

        t2.join();

        System.out.println("Final balance of Account A: " + accountA.getBalance());
        System.out.println("Final balance of Account B: " + accountB.getBalance());
    }
}
