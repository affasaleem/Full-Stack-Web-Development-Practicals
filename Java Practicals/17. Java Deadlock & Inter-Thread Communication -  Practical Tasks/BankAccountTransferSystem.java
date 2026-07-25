/*
 * Task 03 - Bank Account Transfer System (DEADLOCK VERSION)
 *
 * Two accounts, two threads:
 *   Thread 1: Account A -> Account B
 *   Thread 2: Account B -> Account A
 *
 * Each account is locked using the synchronized keyword. Thread 1 locks A
 * then B, while Thread 2 locks B then A. This opposite locking order
 * causes a DEADLOCK - both threads end up waiting on each other forever.
 */
public class BankAccountTransferSystem {

    static class Account {
        private final String name;
        private double balance;

        Account(String name, double balance) {
            this.name = name;
            this.balance = balance;
        }

        String getName() {
            return name;
        }
    }

    // Locks 'from' first, then 'to' - no ordering rule, just call order
    private static void transfer(Account from, Account to, double amount) {
        synchronized (from) {
            System.out.println(Thread.currentThread().getName() + ": locked " + from.getName());
            sleep(100);

            System.out.println(Thread.currentThread().getName() + ": trying to lock " + to.getName());
            synchronized (to) {
                from.balance -= amount;
                to.balance += amount;
                System.out.println(Thread.currentThread().getName() + ": transferred " + amount
                        + " from " + from.getName() + " to " + to.getName());
            }
        }
    }

    public static void main(String[] args) {
        Account accountA = new Account("Account A", 500);
        Account accountB = new Account("Account B", 500);

        Thread thread1 = new Thread(() -> transfer(accountA, accountB, 100), "Thread1(A->B)");
        Thread thread2 = new Thread(() -> transfer(accountB, accountA, 100), "Thread2(B->A)");

        thread1.start();
        thread2.start();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
