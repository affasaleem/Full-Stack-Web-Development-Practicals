/**
 * Employee class representing a company employee record.
 * Used as the data model for Stream API and Predicate operations.
 */
public class Employee {

    private int id;
    private String name;
    private int age;
    private double salary;
    private String department;

    public Employee(int id, String name, int age, double salary, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age
                + ", Salary: Rs." + salary + ", Department: " + department;
    }
}
