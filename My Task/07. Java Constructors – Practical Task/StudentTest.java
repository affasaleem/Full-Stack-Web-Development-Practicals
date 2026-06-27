/**
 * StudentTest.java
 *
 * Main class used to demonstrate and test the three constructors
 * defined in the Student class: default, parameterized, and copy.
 */
public class StudentTest {

    public static void main(String[] args) {

        // 1. Create a student using the DEFAULT constructor
        Student defaultStudent = new Student();

        // 2. Create a student using the PARAMETERIZED constructor
        Student parameterizedStudent = new Student(101, "Nimal Perera", "Software Engineering");

        // 3. Create a third student using the COPY constructor
        //    (copies all attribute values from parameterizedStudent)
        Student copiedStudent = new Student(parameterizedStudent);

        // ---------- Display details of all three students ----------
        System.out.println("===== Student Created Using Default Constructor =====");
        defaultStudent.displayDetails();

        System.out.println("\n===== Student Created Using Parameterized Constructor =====");
        parameterizedStudent.displayDetails();

        System.out.println("\n===== Student Created Using Copy Constructor =====");
        copiedStudent.displayDetails();
    }
}
