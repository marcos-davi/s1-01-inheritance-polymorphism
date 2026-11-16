# S1.01 - Inheritance and Polymorphism in Java

**Description**: Practical exercises focused on Object-Oriented Programming (OOP) principles in Java, including inheritance, abstract classes, polymorphism (`@Override`), class loading lifecycle, static/instance initialization blocks, and the `static` and `final` modifiers.

## Technologies
* **Language**: Java (JDK 21+)
* **Build Tool**: Apache Maven
* **IDE**: IntelliJ IDEA
* **Version Control**: Git & GitHub (Conventional Commits)

## Technical Documentation & Theoretical Notes

### Level 1 - Exercise 1: Class Loading & Initialization Blocks
During execution, the Java Virtual Machine (JVM) loads each class into memory **only once**. This loading process is triggered the first time either of these two events occurs:
1. The first instance of the class is created (`new WindInstrument(...)`).
2. A `static` member (field or method) of the class is accessed (`Instrument.playing(...)`).

#### Differences between `static` Block and Instance Initialization Block
| Feature | Static Block (`static { ... }`) | Instance Initialization Block (`{ ... }`) |
| :--- | :--- | :--- |
| **When it executes** | **Once**, when the class is first loaded into memory by the JVM. | **Every time** a new object instance is created with `new`, right before the constructor body runs. |
| **Access to members** | Can only access `static` fields and methods. | Can access both instance (`this`) and `static` members. |
| **Primary use case** | Initializing static constants or running one-time class setup logic. | Sharing common initialization code across multiple overloaded constructors. |

## Project Structure
```text
s1-01-inheritance-polymorphism/
├── src/
│   └── main/
│       └── java/
│           └── level1/
│               ├── exercise1/    # Musical Instruments (Inheritance & Class Loading)
│               └── exercise2/    # Car Class (static & final modifiers)
├── .gitignore
├── pom.xml
└── README.md
