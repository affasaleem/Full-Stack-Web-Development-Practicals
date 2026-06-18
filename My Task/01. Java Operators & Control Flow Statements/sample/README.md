# Java Operators and Control Flow Statements – Practical Tasks

This repository contains 14 Java programs demonstrating the use of **operators** and **control flow statements** (if-else, switch). Every program uses the `Scanner` class to read user input from the console.

## How to Compile and Run

Each task is a standalone `.java` file with a `main` method. To compile and run any task:

```bash
javac TaskXX_Name.java
java TaskXX_Name
```

For example:

```bash
javac Task01_ArithmeticOperations.java
java Task01_ArithmeticOperations
```

## Task List

| Task | File | Description |
|------|------|-------------|
| 01 | `Task01_ArithmeticOperations.java` | Addition, subtraction, multiplication, division of two numbers |
| 02 | `Task02_EvenOrOdd.java` | Check whether a number is even or odd |
| 03 | `Task03_LargestOfTwo.java` | Find the largest of two numbers |
| 04 | `Task04_VotingEligibility.java` | Check voting eligibility based on age |
| 05 | `Task05_PositiveNegativeZero.java` | Check if a number is positive, negative, or zero |
| 06 | `Task06_PassOrFail.java` | Check pass/fail status based on marks |
| 07 | `Task07_BiggerNumberIfElse.java` | Find the bigger number using if-else |
| 08 | `Task08_GradeCalculator.java` | Grade calculator using else-if conditions |
| 09 | `Task09_DayNameSwitch.java` | Display day name based on day number (switch) |
| 10 | `Task10_SimpleCalculatorSwitch.java` | Simple calculator using switch statement |
| 11 | `Task11_VowelOrConsonant.java` | Check whether a character is a vowel or consonant |
| 12 | `Task12_DivisibleBy3And5.java` | Check divisibility by both 3 and 5 |
| 13 | `Task13_SmallestOfThree.java` | Find the smallest among three numbers |
| 14 | `Task14_MonthNameSwitch.java` | Display month name using switch statement |

## Notes

- All programs use `Scanner` for user input as required.
- Each program includes input validation where applicable (e.g., division by zero, out-of-range values).
- Code follows standard Java naming conventions and includes comments for clarity.

## How to Push This to GitHub

```bash
git init
git add .
git commit -m "Add Java operators and control flow practical tasks"
git branch -M main
git remote add origin https://github.com/<your-username>/<your-repo-name>.git
git push -u origin main
```

Replace `<your-username>` and `<your-repo-name>` with your actual GitHub username and repository name, then submit that URL.
