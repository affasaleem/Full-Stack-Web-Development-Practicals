# Java Optional Class – Practical Tasks

Three small standalone Java programs demonstrating how to use `java.util.Optional`
to avoid null-handling issues, as required by the practical task sheet.

## Structure

```
Task01_StudentSearch/
    Student.java        - entity class
    StudentSearch.java  - main class, findStudentById(int id) -> Optional<Student>

Task02_EmployeeLookup/
    Employee.java        - entity class (id, name, salary)
    EmployeeLookup.java   - main class, findEmployee(int id) -> Optional<Employee>

Task03_BookLibrary/
    Book.java         - entity class (id, title, author)
    BookLibrary.java  - main class, findBookByTitle(String title) -> Optional<Book>
```

## Task 01 – Student Search
- `findStudentById(int id)` returns `Optional<Student>` instead of `null`.
- Uses `isPresent()` to check for a match and print the student's name,
  otherwise prints `Student not found`.
- Also demonstrates `ifPresent()` as an additional functional-style check.

## Task 02 – Employee Lookup
- `findEmployee(int id)` returns `Optional<Employee>`.
- Uses `isPresent()` to report whether a match was found.
- Uses `orElse()` to fall back to a **default Employee object**
  (`id=0, name="Unknown Employee", salary=0.0`) when no employee matches the id.

## Task 03 – Book Library
- `findBookByTitle(String title)` searches books by title (case-insensitive)
  and returns `Optional<Book>`.
- Uses `ifPresent()` to print the book's details only when found.
- Also uses `isPresent()` to report a "not found" message when there is no match.

## How to Compile and Run

Each task is self-contained. From inside a task folder:

```bash
javac *.java
java StudentSearch      # or EmployeeLookup / BookLibrary
```

Each program will prompt for a search value (student id, employee id, or book
title) via the console and print the result.

## Notes

- All three tasks avoid returning `null` directly, per the assignment's
  "Important Requirement" section.
- Together, the three tasks demonstrate all three requested Optional methods:
  `isPresent()`, `orElse()`, and `ifPresent()`.
- Sample in-memory data is preloaded in each class's constructor so the
  programs can be run and tested immediately.
