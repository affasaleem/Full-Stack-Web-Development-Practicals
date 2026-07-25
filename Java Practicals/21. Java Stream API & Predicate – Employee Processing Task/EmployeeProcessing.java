import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Java Stream API & Predicate - Employee Processing Task
 * Demonstrates filtering, mapping, sorting, grouping, and aggregation
 * on a list of Employee objects using the Stream API and Predicate.
 */
public class EmployeeProcessing {

    public static void main(String[] args) {

        // Sample employee data
        List<Employee> employees = List.of(
                new Employee(1, "Amal Perera", 28, 55000, "IT"),
                new Employee(2, "Nadia Silva", 34, 72000, "IT"),
                new Employee(3, "Kasun Fernando", 41, 95000, "Finance"),
                new Employee(4, "Ishara Jayasuriya", 25, 48000, "HR"),
                new Employee(5, "Tharindu Bandara", 37, 88000, "IT"),
                new Employee(6, "Dilani Rathnayake", 30, 61000, "Finance"),
                new Employee(7, "Sanduni Wickrama", 45, 105000, "Management"),
                new Employee(8, "Chamara De Silva", 29, 58000, "HR")
        );

        // ---------- Task 01: Employees with salary greater than Rs.60,000 using Predicate ----------
        System.out.println("Task 01: Employees with salary greater than Rs.60,000");
        Predicate<Employee> highSalaryPredicate = employee -> employee.getSalary() > 60000;
        employees.stream()
                .filter(highSalaryPredicate)
                .forEach(System.out::println);

        // ---------- Task 02: Employees in IT department and older than 30 ----------
        System.out.println("\nTask 02: IT department employees older than 30");
        Predicate<Employee> isITDepartment = employee -> employee.getDepartment().equalsIgnoreCase("IT");
        Predicate<Employee> isOlderThan30 = employee -> employee.getAge() > 30;
        employees.stream()
                .filter(isITDepartment.and(isOlderThan30))
                .forEach(System.out::println);

        // ---------- Task 03: Count employees whose age is greater than 30 ----------
        long countOlderThan30 = employees.stream()
                .filter(isOlderThan30)
                .count();
        System.out.println("\nTask 03: Number of employees older than 30: " + countOlderThan30);

        // ---------- Task 04: Find the highest-paid employee ----------
        Optional<Employee> highestPaidEmployee = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("\nTask 04: Highest-paid employee");
        highestPaidEmployee.ifPresent(System.out::println);

        // ---------- Task 05: Print employee names in uppercase ----------
        System.out.println("\nTask 05: Employee names in uppercase");
        employees.stream()
                .map(Employee::getName)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // ---------- Task 06: Calculate the average salary ----------
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.println("\nTask 06: Average salary of all employees: Rs." + averageSalary);

        // ---------- Task 07: Group employees by department ----------
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("\nTask 07: Employees grouped by department");
        employeesByDepartment.forEach((department, employeeList) -> {
            System.out.println(department + ":");
            employeeList.forEach(employee -> System.out.println("  " + employee));
        });

        // ---------- Task 08: Sort employees by salary in descending order ----------
        System.out.println("\nTask 08: Employees sorted by salary (descending)");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);

        // ---------- Task 09: First employee whose salary is greater than Rs.80,000 ----------
        Optional<Employee> firstAbove80k = employees.stream()
                .filter(employee -> employee.getSalary() > 80000)
                .findFirst();
        System.out.println("\nTask 09: First employee with salary greater than Rs.80,000");
        firstAbove80k.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("No employee found with salary greater than Rs.80,000.")
        );

        // ---------- Task 10: Find the second-highest salary ----------
        List<Double> distinctSalariesDescending = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("\nTask 10: Second-highest salary");
        if (distinctSalariesDescending.size() >= 2) {
            System.out.println("Rs." + distinctSalariesDescending.get(1));
        } else {
            System.out.println("Not enough distinct salary values to determine a second-highest salary.");
        }
    }
}
