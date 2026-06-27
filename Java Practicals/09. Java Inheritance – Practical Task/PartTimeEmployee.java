/**
 * PartTimeEmployee.java
 *
 * Child class that extends Employee. A part-time employee is paid
 * based on the number of hours worked multiplied by an hourly rate,
 * so calculateSalary() performs that calculation directly.
 */
public class PartTimeEmployee extends Employee {

    // ---------- Fields specific to PartTimeEmployee ----------
    private double hoursWorked;
    private double hourlyRate;

    /**
     * Constructor that initializes the inherited fields (name, id)
     * via super(), plus hoursWorked and hourlyRate unique to this class.
     *
     * @param name        the employee's name
     * @param id          the employee's unique ID
     * @param hoursWorked total number of hours worked
     * @param hourlyRate  pay rate per hour
     */
    public PartTimeEmployee(String name, int id, double hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    /**
     * Calculates the part-time employee's salary as
     * hours worked multiplied by the hourly rate.
     *
     * @return the calculated salary
     */
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    /**
     * Overrides displayInfo() to show the basic employee details
     * (inherited from Employee) plus the calculated salary specific
     * to a part-time employee.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Employee Type : Part-Time");
        System.out.println("Hours Worked  : " + hoursWorked);
        System.out.println("Hourly Rate   : " + hourlyRate);
        System.out.println("Total Salary  : " + calculateSalary());
    }
}
