# Java Loops Practical Tasks

This repository contains 10 Java programs demonstrating the use of **loops** (`while`, with `switch` in Task 10). Programs that require dynamic input use the `Scanner` class; Tasks 01 and 02 use fixed ranges as specified and need no input.

## How to Compile and Run

Each task is a standalone `.java` file with a `main` method. To compile and run any task:

```bash
javac TaskXX_Name.java
java TaskXX_Name
```

For example:

```bash
javac Task01_PrintNumbersWhileLoop.java
java Task01_PrintNumbersWhileLoop
```

## Task List

| Task | File | Description |
|------|------|-------------|
| 01 | `Task01_PrintNumbersWhileLoop.java` | Print numbers from 1 to 100 using a while loop |
| 02 | `Task02_OddNumbers1To50.java` | Print all odd numbers between 1 and 50 |
| 03 | `Task03_SumOfEvenNumbers.java` | Find the sum of all even numbers from 1 to n |
| 04 | `Task04_MultiplicationTable.java` | Print the multiplication table of a given number using a while loop |
| 05 | `Task05_ReverseNumber.java` | Reverse a given number |
| 06 | `Task06_CountDigits.java` | Count the digits in a number |
| 07 | `Task07_Factorial.java` | Find the factorial of a number |
| 08 | `Task08_PalindromeNumber.java` | Check whether a number is a palindrome or not |
| 09 | `Task09_FibonacciSeries.java` | Generate the Fibonacci series up to n terms |
| 10 | `Task10_MenuDrivenCalculator.java` | Menu-driven calculator using a while loop, exits on user choice |

## Notes

- All programs that need input use `Scanner`.
- Edge cases are handled: negative numbers (Tasks 05, 06, 08), negative factorial input (Task 07), non-positive term counts (Task 09), division by zero and invalid menu choices (Task 10).
- Code follows standard Java naming conventions and includes comments for clarity.

## Pushing to GitHub

```bash
git init
git add .
git commit -m "Add Java loops practical tasks"
git branch -M main
git remote add origin https://github.com/<your-username>/<your-repo-name>.git
git push -u origin main
```
