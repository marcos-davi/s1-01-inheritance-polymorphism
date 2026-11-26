# Java OOP Core Concepts — Technical Reference

Consolidated study guide aligned with Oracle Java Documentation for the project `s1-01-inheritance-polymorphism`.

---

## 1. Encapsulation & Access Control
According to Oracle's official guidelines (*Controlling Access to Members of a Class*), encapsulation hides an object's internal state and forces all external interactions through controlled public methods. This prevents invalid state mutations and isolates internal implementation details.

* **`private`**: Accessible only inside the declaring class. Standard visibility for instance attributes.
* **`protected`**: Accessible within the same package and by any subclass, even in different packages.
* **`public`**: Accessible from any class across the application.

```java
public class Phone {
    private final String brand; // Protected internal state

    public Phone(String brand) {
        this.brand = brand;
    }

    public String getBrand() { // Controlled read-only access
        return this.brand;
    }
}
```

---

## 2. Single Inheritance & The `super` Keyword
Inheritance establishes an **IS-A** relationship (e.g., a `WindInstrument` *is an* `Instrument`). Java supports **single class inheritance**: a class can extend only one direct superclass via `extends`, and every class implicitly inherits from `java.lang.Object`.

When instantiating a subclass, the JVM initializes the superclass portion before the subclass body executes. Consequently, `super(...)` must always be the **first statement** inside a subclass constructor.

```java
public class WindInstrument extends Instrument {
    public WindInstrument(String name, double price) {
        super(name, price); // Invokes Instrument constructor first
    }
}
```

---

## 3. Abstract Classes & Method Overriding
An `abstract` class serves as an incomplete blueprint that cannot be instantiated directly with `new`. It combines shared state and concrete helper methods with `abstract` method contracts that every concrete subclass must implement using `@Override`.

```java
public abstract class Instrument {
    public abstract void play(); // Contract without implementation body
}

public class Drum extends Instrument {
    @Override
    public void play() { // Compile-time verified override
        System.out.println("Playing percussion instrument");
    }
}
```

---

## 4. Memory Scope & Mutability: `static` vs. `final`
The `static` and `final` modifiers control memory ownership in the Java Virtual Machine (JVM) and variable reassignment rules:

| Modifier Combination | JVM Memory Scope | Reassignable? | Initialization Timing |
| :--- | :--- | :--- | :--- |
| **Instance (default)** | Per object instance (Heap) | Yes | At declaration or inside each constructor call. |
| **`static`** | Class-level (single shared copy) | Yes | Once when the JVM loads the class into memory. |
| **`final`** | Per object instance (constant) | No | At declaration or **inside the constructor**. |
| **`static final`** | Class-level global constant | No | At declaration (`UPPER_SNAKE_CASE`) or in a `static` block. |

**Class Loading Lifecycle:** The JVM loads a class into memory **only once** during program execution, triggered the first time either:
1. An instance is created with `new`.
2. A `static` field or method is accessed.

A `static { ... }` block runs once upon class loading, whereas an instance initialization block `{ ... }` runs before every constructor call.

---

## 5. Runtime Polymorphism (Dynamic Method Dispatch)
Under the *Java Language Specification*, invoking an instance method on an object reference separates compile-time type checking from runtime execution:

1. **Compile Time (Reference Type Filter):** Given `Instrument item = new WindInstrument("Trumpet", 200.0);`, the compiler inspects only the declared variable type on the left (`Instrument`). It allows calls declared in `Instrument` and rejects subclass-specific methods not present in the base contract.
2. **Runtime (Actual Heap Object Execution):** When the JVM executes `item.play()`, it inspects the concrete object in Heap memory (`WindInstrument`) via dynamic dispatch and runs its overridden method.

> **Core Rule:** The **reference type** (left side) determines *which methods can be called* at compile time; the **actual object in memory** (right side) determines *which implementation executes* at runtime.

To safely access subclass-specific members from a polymorphic reference, modern Java provides **Pattern Matching for `instanceof`**:

```java
if (article instanceof FootballArticle football) {
    System.out.println("Competition: " + football.getCompetition());
}
```

---

## 6. Abstract Class vs. Interface
Both abstractions prevent direct instantiation, yet they solve distinct architectural responsibilities:

| Design Dimension | Abstract Class (`abstract class`) | Interface (`interface`) |
| :--- | :--- | :--- |
| **Conceptual Relation** | Identity (**IS-A**): `SmartPhone` *is a* `Phone`. | Capability (**CAN-DO**): `SmartPhone` *can act as* `Camera` & `Clock`. |
| **Multiple Inheritance** | Single inheritance only (`extends` one class). | Multiple implementation (`implements A, B, C`). |
| **Instance State** | Supports instance fields (`private`, `protected`) and constructors. | No instance fields or constructors; constants are implicitly `public static final`. |
| **Method Types** | Any combination of concrete and `abstract` methods. | Implicitly `public abstract`, plus optional `default` and `static` methods. |
| **Primary Use Case** | Sharing common state and base logic across closely related classes. | Decoupling behavior contracts across unrelated classes (loose coupling & ISP). |

---

## 7. Complete Polymorphism & Abstraction Example

```java
interface Publishable {
    void publish();
    default String getPlatform() { return "Digital Sports Portal"; }
}

abstract class BaseArticle implements Publishable {
    private final String headline;

    public BaseArticle(String headline) { this.headline = headline; }
    public String getHeadline() { return headline; }
    public abstract double calculatePrice();
}

class FootballArticle extends BaseArticle {
    private final String competition;

    public FootballArticle(String headline, String competition) {
        super(headline);
        this.competition = competition;
    }

    public String getCompetition() { return competition; }

    @Override
    public double calculatePrice() {
        return competition.equalsIgnoreCase("Champions League") ? 400.0 : 300.0;
    }

    @Override
    public void publish() {
        System.out.println("[" + getPlatform() + "] Football: " + getHeadline());
    }
}
```