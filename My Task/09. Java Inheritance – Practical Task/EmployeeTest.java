/**
 * EmployeeTest.java
 *
 * Main class used to demonstrate the Employee inheritance hierarchy.
 * Creates one FullTimeEmployee and one PartTimeEmployee, then
 * displays the information for each using polymorphic Employee
 * references, showing that each subclass implements its own
 * salary calculation logic.
 */
public class EmployeeTest {

    public static void main(String[] args) {

        // Create a FullTimeEmployee (paid a fixed monthly salary)
        Employee fullTimeEmployee = new FullTimeEmployee("Kasun Silva", 201, 75000);

        // Create a PartTimeEmployee (paid based on hours worked x hourly rate)
        Employee partTimeEmployee = new PartTimeEmployee("Amara Fernando", 202, 80, 750);

        System.out.println("===== Full-Time Employee Details =====");
        fullTimeEmployee.displayInfo();

        System.out.println("\n===== Part-Time Employee Details =====");
        partTimeEmployee.displayInfo();
    }
}
