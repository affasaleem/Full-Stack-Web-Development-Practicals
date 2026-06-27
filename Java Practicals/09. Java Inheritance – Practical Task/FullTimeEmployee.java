/**
 * FullTimeEmployee.java
 *
 * Child class that extends Employee. A full-time employee is paid
 * a fixed monthly salary, so calculateSalary() simply returns that
 * stored value rather than computing it from other inputs.
 */
public class FullTimeEmployee extends Employee {

    // ---------- Field specific to FullTimeEmployee ----------
    private double monthlySalary;

    /**
     * Constructor that initializes the inherited fields (name, id)
     * via super(), plus the monthlySalary field unique to this class.
     *
     * @param name          the employee's name
     * @param id            the employee's unique ID
     * @param monthlySalary the fixed monthly salary for this employee
     */
    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    /**
     * Returns the full-time employee's salary.
     * For a full-time employee this is simply the fixed monthly salary.
     *
     * @return the monthly salary
     */
    public double calculateSalary() {
        return monthlySalary;
    }

    /**
     * Overrides displayInfo() to show the basic employee details
     * (inherited from Employee) plus the calculated salary specific
     * to a full-time employee.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Employee Type : Full-Time");
        System.out.println("Monthly Salary: " + calculateSalary());
    }
}
