import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * StudentSearch.java
 * Task 01 - Student Search
 *
 * Demonstrates the use of Optional<Student> to avoid null handling issues
 * when searching for a student by id.
 */
public class StudentSearch {

    private List<Student> students;

    public StudentSearch() {
        students = new ArrayList<>();
        // Sample data
        students.add(new Student(1, "Amara Perera"));
        students.add(new Student(2, "Kasun Fernando"));
        students.add(new Student(3, "Nadeesha Silva"));
    }

    /**
     * Searches for a student by id.
     * Returns an Optional<Student> instead of null so that callers
     * are forced to explicitly handle the "not found" case.
     */
    public Optional<Student> findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        StudentSearch studentSearch = new StudentSearch();
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Student Search (Optional Class Demo) =====");
        System.out.print("Enter Student ID to search: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        Optional<Student> result = studentSearch.findStudentById(id);

        // isPresent() - check whether a value was found before using it
        if (result.isPresent()) {
            Student student = result.get();
            System.out.println("Student Found: " + student.getName());
        } else {
            System.out.println("Student not found");
        }

        // ifPresent() - alternative functional-style handling
        result.ifPresent(student ->
                System.out.println("(ifPresent check) Student record: " + student));

        scanner.close();
    }
}
