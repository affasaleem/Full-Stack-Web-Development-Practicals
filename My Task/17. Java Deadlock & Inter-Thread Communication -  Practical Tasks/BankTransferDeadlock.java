/*
 * Task 02 - Bank Account Money Transfer (DEADLOCK VERSION)
 *
 * Two accounts, two threads transferring money in opposite directions at
 * the same time:
 *   Thread 1: Account A -> Account B  (locks A first, then B)
 *   Thread 2: Account B -> Account A  (locks B first, then A)
 *
 * Locking the accounts in different orders creates a circular wait,
 * so the program will hang here (DEADLOCK).
 */
public class BankTransferDeadlock {

    static class BankAccount {
        private final String name;
        private double balance;

        BankAccount(String name, double balance) {
            this.name = name;
            this.balance = balance;
        }

        String getName() {
            return name;
        }

        double getBalance() {
            return balance;
        }

        void withdraw(double amount) {
            balance -= amount;
        }

        void deposit(double amount) {
            balance += amount;
        }
    }

    // Transfers money from 'from' to 'to', locking 'from' first then 'to'
    private static void transfer(BankAccount from, BankAccount to, double amount) {
        synchronized (from) {
            System.out.println(Thread.currentThread().getName() + ": locked " + from.getName());
            sleep(100); // give the other thread a chance to lock its first account

            System.out.println(Thread.currentThread().getName() + ": waiting to lock " + to.getName());
            synchronized (to) {
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println(Thread.currentThread().getName() + ": transferred " + amount
                        + " from " + from.getName() + " to " + to.getName());
            }
        }
    }

    public static void main(String[] args) {
        BankAccount accountA = new BankAccount("Account A", 1000);
        BankAccount accountB = new BankAccount("Account B", 1000);

        // Thread 1: A -> B (locks A then B)
        Thread t1 = new Thread(() -> transfer(accountA, accountB, 100), "Thread-1(A->B)");

        // Thread 2: B -> A (locks B then A) -- OPPOSITE ORDER -> deadlock
        Thread t2 = new Thread(() -> transfer(accountB, accountA, 50), "Thread-2(B->A)");

        t1.start();
        t2.start();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
