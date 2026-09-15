# Designing Specifications: Preconditions and Postconditions

## Software Construction Lab

**Student Name:** Huzaifa Waheed Khan
**Course:** Software Construction
**Lab:** Designing Specifications: Preconditions and Postconditions

---

## Objective

The objective of this lab is to apply software specification concepts through Java implementation and JUnit testing. The lab focuses on behavioral equivalence, preconditions, fail-fast validation, mutation contracts, immutability, and declarative specifications.

The tasks demonstrate how clear method specifications help developers create safer, more predictable, testable, and maintainable software.

---

## Lab Tasks

### Task 1 – Behavioral Equivalence

Implemented the `SearchStrategies` class with two search methods:

* `findFirst(int[] arr, int val)` searches from the beginning and returns the first matching index.
* `findLast(int[] arr, int val)` searches from the end and returns the last matching index.

JUnit tests were created to demonstrate:

* A case where the methods return different results when duplicate values exist.
* A case where both methods return the same result when the value occurs exactly once.

This task demonstrates that two implementations may behave differently for some inputs while producing the same result for others.

---

### Task 2 – Failing Fast on Precondition Violations

Implemented the `MathUtils` class with:

```text
calculateGravitationalPotentialEnergy(double mass, double altitude)
```

The method calculates gravitational potential energy using:

```text
E = m × g × h
```

The method has the following precondition:

```text
altitude >= 0
```

If a negative altitude is provided, the method immediately throws an `IllegalArgumentException`.

JUnit testing was performed using:

```text
assertThrows(IllegalArgumentException.class, ...)
```

This demonstrates the fail-fast principle by rejecting invalid input before performing the calculation.

---

### Task 3 – Mutation Contracts

Implemented the `ListFormatter` class with two methods:

* `sortInPlace(List<String> lst)` explicitly modifies and sorts the original list.
* `toLowerCase(List<String> lst)` creates and returns a new list containing lowercase strings without modifying the original list.

JUnit tests verify that:

* `sortInPlace()` correctly modifies the original list.
* `toLowerCase()` leaves the original list unchanged.
* `toLowerCase()` returns a separate list.

This task demonstrates that mutation should only occur when it is explicitly allowed by the method specification.

---

### Task 4 – Immutability for Safer Contracts

Implemented the `Authenticator` class with two methods:

* `getMitId(String username)` returns a mutable `char[]`.
* `getMitIdSecure(String username)` returns the ID as an immutable `String`.

The first method demonstrates how returning a mutable array can expose internal state. A client can modify the returned character array, which can unintentionally corrupt the cached value.

The secure method returns a `String`, which is immutable. This prevents the client from directly modifying the returned value and provides a safer boundary between internal state and external clients.

JUnit tests were used to demonstrate both behaviors.

---

### Task 5 – Declarative vs. Operational Specifications

Implemented the `StringJoinerUtil` class with:

```text
joinStrings(List<String> words, String delimiter)
```

The source code contains two JavaDoc specifications:

#### Operational Specification

The operational JavaDoc describes how the method works internally, including:

* The `for` loop.
* `if` statements.
* String concatenation.
* The logic used to prevent a trailing delimiter.

#### Declarative Specification

The declarative JavaDoc focuses only on the required behavior:

> Returns the concatenation of the elements in order, with the delimiter inserted between each adjacent pair.

This demonstrates why declarative specifications are preferable because they describe what the method guarantees instead of how the implementation achieves it.

---

## Project Structure

```text
Designing-Specifications-Lab/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── labtask1/
│   │       │   └── SearchStrategies.java
│   │       │
│   │       ├── labtask2/
│   │       │   └── MathUtils.java
│   │       │
│   │       ├── labtask3/
│   │       │   └── ListFormatter.java
│   │       │
│   │       ├── labtask4/
│   │       │   └── Authenticator.java
│   │       │
│   │       └── labtask5/
│   │           └── StringJoinerUtil.java
│   │
│   └── test/
│       └── java/
│           ├── labtask1/
│           │   └── SearchStrategiesTest.java
│           │
│           ├── labtask2/
│           │   └── MathUtilsTest.java
│           │
│           ├── labtask3/
│           │   └── ListFormatterTest.java
│           │
│           ├── labtask4/
│           │   └── AuthenticatorTest.java
│           │
│           └── labtask5/
│               └── StringJoinerUtilTest.java
│
├── pom.xml
└── README.md
```

---

## Technologies Used

* **Java**
* **Maven**
* **JUnit 5**
* **JavaDoc**
* **Git & GitHub**

---

## Requirements

Before running the project, make sure the following are installed:

* Java JDK
* Apache Maven
* Git

You can verify Java using:

```bash
java -version
```

Verify Maven using:

```bash
mvn -version
```

---

## How to Run the Project

### 1. Clone the Repository

Clone the public GitHub repository:

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

Move into the project directory:

```bash
cd Designing-Specifications-Lab
```

### 2. Compile the Project

Run:

```bash
mvn clean compile
```

### 3. Run All JUnit Tests

Run:

```bash
mvn clean test
```

A successful test execution should display:

```text
BUILD SUCCESS
```

The project contains tests for all five lab tasks.

---

## Testing Summary

| Lab Task  | Main Concept               | Test Coverage |
| --------- | -------------------------- | ------------: |
| Task 1    | Behavioral Equivalence     |       2 tests |
| Task 2    | Preconditions & Fail-Fast  |       2 tests |
| Task 3    | Mutation Contracts         |       2 tests |
| Task 4    | Immutability               |       2 tests |
| Task 5    | Declarative Specifications |       2 tests |
| **Total** | **All Lab Concepts**       |  **10 tests** |

---

## Key Concepts Learned

Through this lab, the following concepts were practiced:

### Behavioral Equivalence

Two implementations are behaviorally equivalent when they produce the same observable behavior for the cases defined by their specification.

### Preconditions

A precondition defines what must be true before a method is executed.

Example:

```text
altitude >= 0
```

### Fail-Fast Validation

Invalid input should be detected as early as possible. In this lab, `IllegalArgumentException` is used when the altitude violates the precondition.

### Mutation Contracts

A method should not modify its input unless the specification explicitly allows mutation.

### Immutability

Immutable objects cannot be changed after creation. Returning immutable objects such as `String` can protect internal state from unintended modifications.

### Declarative Specifications

A declarative specification describes **what** a method guarantees rather than **how** it performs its work. This makes specifications clearer and allows the implementation to change without changing the required behavior.

---

## Repository Link

**GitHub Repository:**
`YOUR_GITHUB_REPOSITORY_URL`

The repository is configured as **Public** as required for submission.

---

## Conclusion

This lab provided practical experience with designing and testing method specifications in Java. The five tasks demonstrated how behavioral equivalence, preconditions, mutation control, immutability, and declarative specifications can improve software reliability and maintainability.

JUnit testing was used throughout the lab to verify that the implementations satisfy their specified behavior and correctly handle both valid and invalid situations.
