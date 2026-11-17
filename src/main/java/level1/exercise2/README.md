### Level 1 - Exercise 2: `static` vs `final` Modifiers (`Car` Class)

This exercise demonstrates how Java manages class-level memory versus instance-level memory and immutability through the `static` and `final` modifiers.

#### Modifiers Comparison Table
| Attribute | Modifiers | Memory Scope | Mutable? | Where is it initialized? |
| :--- | :--- | :--- | :--- | :--- |
| `BRAND` | `static final` | Class-level (single shared constant) | No (constant) | At declaration (`"Toyota"`) or inside a `static` block. |
| `model` | `static` | Class-level (shared across all instances) | Yes | At declaration, in a `static` block, or via `Car.setModel(...)`. |
| `power` | `final` | Instance-level (unique per object) | No (once assigned) | At declaration or inside the class constructor (`Car(int power)`). |

#### Key Takeaways & Answers
* **Which attribute can be initialized in the constructor?**  
  Only `power` (`final` without `static`). Because it belongs to each individual instance, every `Car` object can receive its own value at creation time via `new Car(150)` or `new Car(200)`, after which it becomes immutable.
* **Which attribute can never be modified?**  
  `BRAND` (`static final`). It acts as a global constant for the entire `Car` class and cannot be reassigned anywhere in the program.
* **Which attribute affects all instances when modified?**  
  `model` (`static`). Because there is only one copy in class memory, calling `Car.setModel("Camry")` immediately updates the model seen across all existing and future `Car` instances (`car1` and `car2`).
* **`static` vs Instance Methods:**  
  `Car.brake()` is `static` and can be invoked directly on the class without creating any object, whereas `accelerate()` is an instance method and requires an instantiated `Car` object (`car1.accelerate()`).