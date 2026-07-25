import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * EmployeeLookup.java
 * Task 02 - Employee Lookup
 *
 * Demonstrates the use of Optional<Employee> together with orElse()
 * to supply a default employee object when no match is found,
 * instead of returning or checking for null.
 */
public class EmployeeLookup {

    private List<Employee> employees;

    // Default employee returned by orElse() when no match is found.
    private static final Employee DEFAULT_EMPLOYEE = new Employee(0, "Unknown Employee", 0.0);

    public EmployeeLookup() {
        employees = new ArrayList<>();
        // Sample data
        employees.add(new Employee(101, "Ruwan Jayasinghe", 75000.0));
        employees.add(new Employee(102, "Dilani Wickramasinghe", 82000.0));
        employees.add(new Employee(103, "Chamara Rathnayake", 68000.0));
    }

    /**
     * Searches for an employee by id.
     * Returns an Optional<Employee> so the caller must explicitly
     * decide how to handle a missing result.
     */
    public Optional<Employee> findEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return Optional.of(employee);
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        EmployeeLookup employeeLookup = new EmployeeLookup();
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Employee Lookup (Optional Class Demo) =====");
        System.out.print("Enter Employee ID to search: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        Optional<Employee> result = employeeLookup.findEmployee(id);

        // isPresent() - explicitly check before accessing the value
        if (result.isPresent()) {
            System.out.println("Employee Found: " + result.get());
        } else {
            System.out.println("Employee not found. A default record will be used.");
        }

        // orElse() - returns the found employee, or the default employee
        // object if the Optional is empty. This avoids null checks entirely.
        Employee employee = result.orElse(DEFAULT_EMPLOYEE);
        System.out.println("Resulting Employee Record: " + employee);

        scanner.close();
    }
}
