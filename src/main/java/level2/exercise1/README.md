---

## Level 2 - Exercise 1: Interfaces & Multiple Capabilities (`SmartPhone`)

This exercise combines **single class inheritance** (`extends`) with **multiple interface implementation** (`implements`), demonstrating how a class can inherit core attributes while fulfilling independent behavioral contracts.

### Architecture Overview
* **`Phone` (Base Class)**: Encapsulates core identity fields (`brand`, `model`) and provides base functionality via `call(String phoneNumber)`.
* **`Camera` & `Clock` (Interfaces)**: Define segregated, single-responsibility contracts (`takePhoto()` and `alarm()`), adhering to the **Interface Segregation Principle (ISP)**.
* **`SmartPhone` (Subclass)**: Extends `Phone` and implements both `Camera` and `Clock`, overriding each contract method with `@Override`.

### Why Use Interface-Typed Variables? (`Clock` vs `SmartPhone`)
In `Main.java`, objects are instantiated as `SmartPhone` in heap memory, but referenced through different types:
```java
Clock clock = new SmartPhone("Samsung", "Galaxy S21");
Camera camera = new SmartPhone("Google", "Pixel 6");