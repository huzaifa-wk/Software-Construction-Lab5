# Designing Specifications: Preconditions and Postconditions

## Software Construction Lab 5

**Student Name:** Huzaifa Waheed Khan
**Course:** Software Construction
**Lab:** Lab 5 – Designing Specifications: Preconditions and Postconditions
**Repository:** Software-Construction-Lab5
**Package:** SpecsAndContracts

---

## Objective

The objective of this lab is to apply concepts of method specifications, behavioral equivalence, preconditions, postconditions, mutation contracts, immutability, and declarative specifications using Java and JUnit testing.

The lab focuses on writing clear method contracts, validating input, controlling mutation, protecting internal state, and testing the expected behavior of methods.

---

# Lab Tasks

## Lab Task 1 – Behavioral Equivalence

### Objective

Understand how the client's perspective and the specification determine whether two implementations are behaviorally equivalent.

### Implementation

The `SearchStrategies` class contains two search methods:

* `findFirst(int[] arr, int val)` searches the array from index `0` to the end and returns the first matching index.
* `findLast(int[] arr, int val)` searches the array backwards and returns the last matching index.

If the value is not found:

* `findFirst()` returns `arr.length`.
* `findLast()` returns `-1`.

### Testing

JUnit tests demonstrate:

1. A case where the methods return different results when the array contains duplicate values.
2. A case where both methods return the same result when the value occurs exactly once.

### Main Concept

The task demonstrates that two methods can produce the same observable result for some inputs but different results for others.

---

## Lab Task 2 – Failing Fast on Precondition Violations

### Objective

Practice throwing unchecked exceptions when a client violates a method's precondition.

### Implementation

The `MathUtils` class contains:

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

If the altitude is negative, the method immediately throws:

```text
IllegalArgumentException
```

This demonstrates the **fail-fast** principle.

### Testing

A JUnit test uses:

```java
assertThrows(IllegalArgumentException.class, ...)
```

to verify that the method correctly rejects negative altitude.

### Main Concept

Invalid input is detected immediately instead of allowing the method to continue with invalid data.

---

## Lab Task 3 – Mutation Contracts

### Objective

Understand that mutation is disallowed unless it is explicitly stated in the method specification.

### Implementation

The `ListFormatter` class contains two methods:

### `sortInPlace()`

```text
sortInPlace(List<String> lst)
```

This method explicitly sorts and modifies the original list.

### `toLowerCase()`

```text
toLowerCase(List<String> lst)
```

This method creates and returns a new list containing lowercase strings. The original list remains unchanged.

### Testing

JUnit tests verify:

* `sortInPlace()` correctly modifies the original list.
* `toLowerCase()` does not modify the original list.
* `toLowerCase()` returns a separate list.

### Main Concept

A method should only modify its input when mutation is explicitly allowed by its specification.

---

## Lab Task 4 – Immutability for Safer Contracts

### Objective

Understand how returning mutable objects can expose internal state and how immutable return types provide safer contracts.

### Implementation

The `Authenticator` class contains two methods.

### `getMitId()`

```text
getMitId(String username)
```

This method returns a 9-digit MIT ID as a mutable `char[]`.

The test demonstrates that when the client modifies the returned array, the cached version is unintentionally corrupted.

### `getMitIdSecure()`

```text
getMitIdSecure(String username)
```

This method returns the ID as an immutable `String`.

Because `String` is immutable, the client cannot directly modify the returned value.

### Testing

JUnit tests demonstrate:

1. Modification of the returned `char[]` corrupts the cached value.
2. Returning a `String` provides safer protection against unintended modification.

### Main Concept

Immutable return values act as a safer firewall between internal data and the client.

---

## Lab Task 5 – Declarative vs. Operational Specifications

### Objective

Refactor an operational specification into a clear declarative specification.

### Implementation

The `StringJoinerUtil` class contains:

```text
joinStrings(List<String> words, String delimiter)
```

Two JavaDoc specifications are included in the source file.

### Operational JavaDoc

The bad operational JavaDoc describes **how** the method works internally, including:

* The `for` loop.
* `if` statements.
* String concatenation.
* The logic used to avoid a trailing delimiter.

### Declarative JavaDoc

The good declarative JavaDoc focuses only on the required behavior:

> Returns the concatenation of the elements in order, with the delimiter inserted between each adjacent pair.

It does not depend on the specific implementation.

### Testing

A JUnit test verifies that the strings are joined in the correct order with the delimiter placed between adjacent elements.

### Main Concept

A declarative specification describes **what the method guarantees**, while an operational specification describes **how the method performs its work**.

---

# Project Structure

```text
Software-Construction-Lab5/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── SpecsAndContracts/
│   │           ├── SearchStrategies.java
│   │           ├── MathUtils.java
│   │           ├── ListFormatter.java
│   │           ├── Authenticator.java
│   │           └── StringJoinerUtil.java
│   │
│   └── test/
│       └── java/
│           └── SpecsAndContracts/
│               ├── SearchStrategiesTest.java
│               ├── MathUtilsTest.java
│               ├── ListFormatterTest.java
│               ├── AuthenticatorTest.java
│               └── StringJoinerUtilTest.java
│
├── pom.xml
└── README.md
```

---

# Package Structure

All implementation and test classes use the same package:

```java
package SpecsAndContracts;
```

The five main implementation classes are:

* `SearchStrategies`
* `MathUtils`
* `ListFormatter`
* `Authenticator`
* `StringJoinerUtil`

The corresponding JUnit test classes are:

* `SearchStrategiesTest`
* `MathUtilsTest`
* `ListFormatterTest`
* `AuthenticatorTest`
* `StringJoinerUtilTest`

---

# Technologies Used

* Java
* Maven
* JUnit 5
* JavaDoc
* Git
* GitHub

---

# Requirements

The following software is required to run this project:

* Java JDK
* Apache Maven
* Git

Check the Java installation:

```bash
java -version
```

Check Maven:

```bash
mvn -version
```

---

# How to Run the Project

## 1. Clone the Repository

Clone the public GitHub repository:

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

Enter the project directory:

```bash
cd Software-Construction-Lab5
```

## 2. Compile the Project

Run:

```bash
mvn clean compile
```

## 3. Run All Tests

Run:

```bash
mvn clean test
```

A successful execution should display:

```text
BUILD SUCCESS
```

---

# Testing Summary

| Task      | Concept                    |  Tests |
| --------- | -------------------------- | -----: |
| Task 1    | Behavioral Equivalence     |      2 |
| Task 2    | Preconditions & Fail-Fast  |      2 |
| Task 3    | Mutation Contracts         |      2 |
| Task 4    | Immutability               |      2 |
| Task 5    | Declarative Specifications |      2 |
| **Total** | **All Lab Concepts**       | **10** |

---

# Key Concepts Learned

## Behavioral Equivalence

Behavioral equivalence is concerned with whether two implementations produce the same observable results from the client's perspective.

## Preconditions

A precondition specifies what must be true before a method executes.

Example:

```text
altitude >= 0
```

## Fail-Fast Validation

Fail-fast validation detects invalid input immediately and throws an appropriate unchecked exception.

## Mutation Contracts

Mutation should only occur when it is explicitly permitted by the method specification.

## Immutability

Immutable objects cannot be modified after creation. Returning immutable values can protect internal state from unintended changes.

## Declarative Specifications

Declarative specifications describe what a method guarantees rather than describing the internal steps used to implement it.

---

# Requirement Verification

| Lab Requirement                   | Implemented | Tested |
| --------------------------------- | :---------: | :----: |
| Behavioral equivalence            |      ✅      |    ✅   |
| First and last search strategies  |      ✅      |    ✅   |
| Preconditions                     |      ✅      |    ✅   |
| Fail-fast exception handling      |      ✅      |    ✅   |
| Mutation contracts                |      ✅      |    ✅   |
| Non-mutating method               |      ✅      |    ✅   |
| Mutable vs. immutable return type |      ✅      |    ✅   |
| Cache corruption demonstration    |      ✅      |    ✅   |
| Operational JavaDoc               |      ✅      |    —   |
| Declarative JavaDoc               |      ✅      |    —   |
| JUnit testing                     |      ✅      |    ✅   |

---

# Repository

**Repository Name:** `Software-Construction-Lab5`

**Package Name:** `SpecsAndContracts`

**Visibility:** Public

**GitHub Repository Link:**

(https://github.com/huzaifa-wk/Software-Construction-Lab5)

---

# Conclusion

This lab provided practical experience with designing and testing method specifications in Java. The five tasks demonstrated behavioral equivalence, preconditions, fail-fast validation, mutation contracts, immutability, and declarative specifications.

JUnit tests were used to verify the expected behavior of the implemented methods, including both valid and invalid cases. The lab also demonstrated how clear specifications and controlled access to data can make software safer, easier to test, maintain, and modify.
