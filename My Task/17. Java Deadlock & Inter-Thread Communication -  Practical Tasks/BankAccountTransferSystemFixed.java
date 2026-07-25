/*
 * Task 03 - Bank Account Transfer System (FIXED VERSION)
 *
 * Deadlock fix strategy: CONSISTENT LOCK ORDERING BY ACCOUNT ID.
 * Both threads still call transfer(from, to, amount) in opposite
 * directions, but the transfer() method itself always locks the account
 * with the smaller id first. This means Thread1 and Thread2 both end up
 * locking the accounts in the SAME order, so a circular wait can never
 * form and the deadlock is prevented.
 */
public class BankAccountTransferSystemFixed {

    static class Account {
        private final int id; // used only to decide a consistent lock order
        private final String name;
        private double balance;

        Account(int id, String name, double balance) {
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

        double getBalance() {
            return balance;
        }
    }

    // Always locks the lower-id account first, no matter which is 'from' or 'to'
    private static void transfer(Account from, Account to, double amount) {
        Account first = (from.getId() < to.getId()) ? from : to;
        Account second = (from.getId() < to.getId()) ? to : from;

        synchronized (first) {
            synchronized (second) {
                from.balance -= amount;
                to.balance += amount;
                System.out.println(Thread.currentThread().getName() + ": transferred " + amount
                        + " from " + from.getName() + " to " + to.getName());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Account accountA = new Account(1, "Account A", 500);
        Account accountB = new Account(2, "Account B", 500);

        Thread thread1 = new Thread(() -> transfer(accountA, accountB, 100), "Thread1(A->B)");
        Thread thread2 = new Thread(() -> transfer(accountB, accountA, 100), "Thread2(B->A)");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final balance of Account A: " + accountA.getBalance());
        System.out.println("Final balance of Account B: " + accountB.getBalance());
    }
}
