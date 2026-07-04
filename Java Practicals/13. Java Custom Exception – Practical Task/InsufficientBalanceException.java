/**
 * InsufficientBalanceException.java
 *
 * A user-defined (custom) exception class that represents the
 * specific error condition of attempting to withdraw more money
 * than is available in a bank account.
 *
 * How custom exceptions work:
 *  - By extending the Exception class (which is a checked exception),
 *    we create our own exception type with a meaningful name that
 *    clearly describes the exact problem that occurred.
 *  - Using a custom exception instead of a generic RuntimeException
 *    makes the code more readable and forces the calling code to
 *    consciously handle this specific failure case.
 *  - We store the withdrawal amount and available balance so the
 *    catch block can display precise, informative error details.
 */
public class InsufficientBalanceException extends Exception {

    // Store the amounts involved for detailed error reporting
    private double withdrawalAmount;
    private double availableBalance;

    /**
     * Constructs an InsufficientBalanceException with a message
     * and the two amounts that caused the error.
     *
     * @param message           a description of the error
     * @param withdrawalAmount  the amount the user tried to withdraw
     * @param availableBalance  the actual balance available in the account
     */
    public InsufficientBalanceException(String message, double withdrawalAmount, double availableBalance) {
        // Pass the message up to the parent Exception class
        super(message);
        this.withdrawalAmount = withdrawalAmount;
        this.availableBalance = availableBalance;
    }

    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }
}
