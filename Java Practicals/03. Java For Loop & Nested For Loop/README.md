# Java Pattern Printing Practical Tasks

This repository contains 5 Java programs that print patterns using `for` loops and nested `for` loops. No user input is required — each pattern uses a fixed number of rows as shown in the task specification.

## How to Compile and Run

Each task is a standalone `.java` file with a `main` method. To compile and run any task:

```bash
javac TaskXX_Name.java
java TaskXX_Name
```

For example:

```bash
javac Task01_StarPattern.java
java Task01_StarPattern
```

## Task List

| Task | File | Pattern |
|------|------|---------|
| 01 | `Task01_StarPattern.java` | Increasing star pattern (1 to 5 stars per row) |
| 02 | `Task02_ReverseStarPattern.java` | Decreasing star pattern (5 to 1 stars per row) |
| 03 | `Task03_NumberPattern.java` | Increasing number sequence pattern (1, 12, 123, 1234, 12345) |
| 04 | `Task04_RightTrianglePattern.java` | Centered triangle of stars (1, 3, 5, 7, 9 stars per row) |
| 05 | `Task05_DiamondPattern.java` | Centered diamond of stars (upper + lower triangle) |

## Expected Output

**Task 01**
```
*
**
***
****
*****
```

**Task 02**
```
*****
****
***
**
*
```

**Task 03**
```
1
12
123
1234
12345
```

**Task 04**
```
    *
   ***
  *****
 *******
*********
```

**Task 05**
```
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
```

## Notes

- Tasks 04 and 05 use a leading-space calculation (`NUMBER_OF_ROWS - row`) so the stars form a properly centered triangle/diamond shape, rather than a plain left-aligned staircase.
- Each program uses nested `for` loops: the outer loop controls the rows, and the inner loop(s) control spacing and character printing within each row.
- Code follows standard Java naming conventions and includes comments explaining the loop logic.

## Pushing to GitHub

```bash
git init
git add .
git commit -m "Add Java pattern printing practical tasks"
git branch -M main
git remote add origin https://github.com/<your-username>/<your-repo-name>.git
git push -u origin main
```
