# S1.01 — Java Inheritance & Polymorphism (`s1-01-inheritance-polymorphism`)

A progressive Java Object-Oriented Programming (OOP) project structured across three difficulty levels. It demonstrates core architectural principles—encapsulation, inheritance, abstraction, JVM memory modifiers (`static` / `final`), interface segregation, runtime polymorphism, and separation of concerns—culminating in a console-based **Sports Newsroom Management System**.

---

## Project Structure

```text
s1-01-inheritance-polymorphism/
├── README.md
└── src/
    └── main/
        └── java/
            ├── level1/
            │   ├── exercise1/        # Abstract classes, single inheritance & method overriding (Instruments)
            │   └── exercise2/        # JVM class loading lifecycle: static vs. final (Car)
            ├── level2/
            │   └── exercise1/        # Multiple interface implementation & IS-A vs. CAN-DO (SmartPhone)
            └── level3/
                └── exercise1/        # Polymorphic domain model & layered architecture (Sports Newsroom)
                    ├── Editor.java
                    ├── News.java
                    ├── FootballNews.java
                    ├── BasketballNews.java
                    ├── TennisNews.java
                    ├── F1News.java
                    ├── MotorcyclingNews.java
                    ├── NewsroomManager.java
                    └── Main.java
```

---

## Exercises Breakdown & OOP Concepts Applied

### Level 1 — Fundamentals of Inheritance & JVM Memory Scope

* **Exercise 1 (`level1.exercise1` — Musical Instruments):**
    * **Concepts:** `abstract` base class (`Instrument`), single inheritance (`WindInstrument`, `StringInstrument`, `PercussionInstrument`), constructor chaining via `super(...)`, and `@Override` of abstract methods (`play()`).
    * **JVM Class Loading:** Demonstrates that the JVM loads a class into memory **only once**—triggered either on the first instantiation (`new`) or the first access to a `static` member—executing `static { ... }` initialization blocks once upon loading and instance `{ ... }` blocks before every constructor call.

* **Exercise 2 (`level1.exercise2` — Car Model & Modifiers):**
    * **Concepts:** Differences in memory scope, mutability, and initialization timing across `static final` (class-level constant initialized at declaration), `static` (shared class-level mutable state), and `final` (instance-level constant initialized inside the constructor).
    * **Method Invocation:** Contrasts calling `static` methods via class reference (`Car.brake()`) against instance methods via object reference (`car.accelerate()`).

---

### Level 2 — Inheritance vs. Interfaces

* **Exercise 1 (`level2.exercise1` — Phone & SmartPhone):**
    * **Concepts:** Combines single class inheritance (`SmartPhone extends Phone`) with multiple interface implementation (`implements Camera, Clock`).
    * **Architectural Distinction:** Models identity (**IS-A**: a `SmartPhone` *is a* `Phone`) through a superclass while decoupling independent capabilities (**CAN-DO**: *can take photos* and *can set an alarm*) through focused interfaces.

---

### Level 3 — Sports Newsroom Management System (`level3.exercise1`)

A complete console application designed with a **layered architecture** that isolates domain entities, business logic, and console I/O:

```text
+------------------+       delegates       +--------------------+       manages       +----------------+
|    Main (UI)     | --------------------> |  NewsroomManager   | --------------------> |     Editor     |
| (Scanner / Menu) | <-------------------- |  (Business Logic)  | <-------------------- |  (List<News>)  |
+------------------+   boolean / values    +--------------------+                       +----------------+
                                                                                                 |
                                                                                          polymorphism
                                                                                                 v
                                                                                    +------------------------+
                                                                                    |     News (abstract)    |
                                                                                    +------------------------+
                                                                                      ^   ^    ^    ^     ^
                                                                                      |   |    |    |     |
                                                                              Football  Bask. Ten.  F1  MotoGP
```

#### 1. Domain Model (`Editor` & `News` Hierarchy)
* **`Editor`:** Encapsulates editor identity (`name`, `dni`, shared `static` base `salary = 1500.0`) and manages an internal `List<News>` with controlled operations (`addNews`, `removeNews` by headline).
* **`News` (Abstract Base Class):** Defines shared state (`headline`, `text`, `score`, `price`) and enforces polymorphic pricing and scoring contracts (`abstract double calculatePrice()`, `abstract int calculateScore()`).
* **Concrete Subclasses:**
    * `FootballNews` (attributes: `competition`, `club`, `player`)
    * `BasketballNews` (attributes: `competition`, `club`)
    * `TennisNews` (attributes: `competition`, `player`)
    * `F1News` (attribute: `team`)
    * `MotorcyclingNews` (attribute: `team`)

Each subclass invokes `setPrice(calculatePrice())` and `setScore(calculateScore())` inside its constructor so every news item initializes with accurate domain rules immediately upon instantiation.

#### 2. Business Logic Layer (`NewsroomManager`)
* Completely decoupled from `System.in` and `System.out` (no `Scanner` or console printing inside business logic).
* Prevents duplicate editor registrations by DNI (`equalsIgnoreCase`), safely guards against `null` references, and delegates polymorphic score/price calculations through `News` base references.

#### 3. Console Presentation Layer (`Main`)
* Provides an interactive menu with safe `Scanner` input parsing (`Integer.parseInt(scanner.nextLine().trim())` inside a `try-catch` helper to prevent buffer newline bugs and `NumberFormatException`).
* Supports 7 core operations:
    1. Introduce editor
    2. Remove editor
    3. Assign news to an editor (polymorphic instantiation across all 5 sports)
    4. Remove news by editor DNI and headline
    5. Show all news assigned to an editor
    6. Calculate news score
    7. Calculate news price

---

## Pricing & Scoring Rules Summary (`level3.exercise1`)

| Sport Subclass | Base Price | Price Modifiers | Base Score | Score Modifiers |
| :--- | :--- | :--- | :--- | :--- |
| **Football** | `300 €` | `+100 €` Champions League<br>`+100 €` Barça or Madrid<br>`+50 €` Ferran Torres or Benzema | `5 pts` | `+3 pts` Champions League<br>`+2 pts` Liga<br>`+1 pt` Barça or Madrid<br>`+1 pt` Ferran Torres or Benzema |
| **Basketball** | `250 €` | `+75 €` Euroleague<br>`+75 €` Barça or Madrid | `4 pts` | `+3 pts` Euroleague<br>`+2 pts` Liga ACB<br>`+1 pt` Barça or Madrid |
| **Tennis** | `150 €` | `+100 €` Federer, Nadal or Djokovic | `4 pts` | `+3 pts` Federer, Nadal or Djokovic |
| **F1** | `100 €` | `+50 €` Ferrari or Mercedes | `4 pts` | `+2 pts` Ferrari or Mercedes |
| **Motorcycling** | `100 €` | `+50 €` Honda or Yamaha | `3 pts` | `+3 pts` Honda or Yamaha |

---

## Prerequisites & Execution

* **Java Development Kit (JDK):** Java 17 or higher (uses enhanced `switch` expressions `case 1 -> ...`).
* **IDE:** IntelliJ IDEA (or any standard Java IDE / CLI).

### Running via Command Line
From the project root directory:

```bash
# Compile all source files
javac -d out src/main/java/level3/exercise1/*.java

# Run the Sports Newsroom application
java -cp out level3.exercise1.Main
```

---

## Engineering Conventions Used

* **Language:** Codebase, identifiers, Git commits, and UI messages written in English.
* **Separation of Concerns (SRP):** Strict boundary between domain entities (`Editor`, `News`), state management (`NewsroomManager`), and user I/O (`Main`).
* **Defensive Input Handling:** Trimmed string inputs, early guard clauses (`if (value.isEmpty()) return;`), and centralized integer parsing (`readInt`).