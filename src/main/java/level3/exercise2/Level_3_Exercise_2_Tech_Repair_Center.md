# Level 3 — Exercise 2: Tech Repair Center

**S1.01 · Inheritance & Polymorphism · Java OOP**

**Paquete:** `level3.exercise2` · Arquitectura en Capas, Herencia Abstracta y Polimorfismo

---

## 1. Contexto y Objetivo Arquitectónico

Un centro de servicio técnico especializado en reparación de dispositivos electrónicos necesita una aplicación de consola en Java para gestionar sus técnicos y las órdenes de reparación asignadas a cada uno.

El diseño debe seguir estrictamente una arquitectura en capas (*Separation of Concerns*), idéntica a la aplicada en el sistema de redacción deportiva:

- **Modelo de dominio:** `Technician`, `RepairOrder` (`abstract`) y 5 subclases concretas de reparación.
- **Capa de lógica de negocio:** `ServiceCenterManager` (gestiona las colecciones en memoria y delega los cálculos polimórficos; **prohibido** usar `Scanner` o `System.out.println` dentro de esta clase).
- **Capa de presentación (UI):** `Main` (gestiona exclusivamente el menú de consola, la lectura segura con `Scanner` y la impresión de resultados).

---

## 2. Especificaciones del Modelo de Dominio

### A. Clase `Technician`

**Atributos:**

- `name` (`String`, privado, con getter y setter).
- `employeeId` (`String`, privado, único por técnico, con getter — **sin setter** para proteger su identidad).
- `baseSalary` (`double`, atributo `static` compartido por todos los técnicos, inicializado en `1650.0 €`).
- `assignedOrders` (`List<RepairOrder>`, privado, inicializado como `new ArrayList<>()`).

**Métodos principales:**

- `addRepairOrder(RepairOrder order)`
- `removeRepairOrder(String ticketCode)` (ignora mayúsculas/minúsculas)
- `getAssignedOrders()`

### B. Clase Abstracta `RepairOrder`

**Atributos:**

- `ticketCode` (`String`, identificador único de la orden, p. ej., `"TK-101"`).
- `issueDescription` (`String`, inicializado como cadena vacía `""` por defecto).
- `warrantyMonths` (`int`, meses de garantía calculados).
- `totalCost` (`double`, coste final calculado en euros).

**Contratos polimórficos:**

```java
public abstract double calculateTotalCost();
public abstract int calculateWarrantyMonths();
```

---

## 3. Jerarquía de Subclases y Reglas de Negocio

Cada subclase debe invocar `setTotalCost(calculateTotalCost())` y `setWarrantyMonths(calculateWarrantyMonths())` **al final de su constructor**. Todas las comparaciones de texto deben ignorar mayúsculas/minúsculas mediante `.equalsIgnoreCase(...)`.

| Subclase | Atributos (`String`) | Coste Base | Modificadores de Coste | Garantía Base | Modificadores de Garantía |
|---|---|---|---|---|---|
| `SmartphoneRepair` | `brand`<br>`component` | 80.0 € | +50.0 € si `brand` es Apple o Samsung<br>+70.0 € si `component` es Screen o Motherboard | 6 meses | +6 meses si `brand` es Apple o Samsung<br>+3 meses si `component` es Battery |
| `LaptopRepair` | `brand`<br>`repairType` | 120.0 € | +80.0 € si `brand` es MacBook o ThinkPad<br>+90.0 € si `repairType` es Motherboard o GPU | 6 meses | +6 meses si `brand` es MacBook o ThinkPad<br>+6 meses si `repairType` es Motherboard |
| `ConsoleRepair` | `consoleModel`<br>`fault` | 90.0 € | +45.0 € si `consoleModel` es PS5 o Xbox Series X<br>+40.0 € si `fault` es HDMI | 3 meses | +3 meses si `consoleModel` es PS5 o Nintendo Switch<br>+3 meses si `fault` es HDMI |
| `SmartwatchRepair` | `brand` | 60.0 € | +35.0 € si `brand` es Apple Watch o Garmin | 3 meses | +3 meses si `brand` es Apple Watch o Garmin |
| `TabletRepair` | `brand`<br>`component` | 85.0 € | +45.0 € si `brand` es iPad o Galaxy Tab<br>+60.0 € si `component` es Screen | 6 meses | +6 meses si `brand` es iPad o Galaxy Tab |

---

## 4. Capa de Lógica: `ServiceCenterManager`

Gestiona internamente `List<Technician>` y expone **exactamente** los siguientes 7 métodos públicos (sin `Scanner` ni impresión por consola):

1. `boolean addTechnician(String name, String employeeId)` — Registra un técnico evitando IDs duplicados.
2. `boolean removeTechnician(String employeeId)` — Elimina el técnico indicado y devuelve `true` o `false`.
3. `boolean assignOrderToTechnician(String employeeId, RepairOrder order)` — Valida referencias nulas y asigna la orden.
4. `boolean removeOrderFromTechnician(String employeeId, String ticketCode)` — Elimina la orden por su código de ticket.
5. `List<RepairOrder> getOrdersByTechnician(String employeeId)` — Devuelve `null` si el técnico no existe, o su lista de órdenes.
6. `int calculateOrderWarranty(String employeeId, String ticketCode)` — Devuelve los meses de garantía polimórficos, o `-1` si no encuentra técnico o ticket.
7. `double calculateOrderCost(String employeeId, String ticketCode)` — Devuelve el coste polimórfico, o `-1.0` si no encuentra técnico o ticket.

---

## 5. Capa de Consola: `Main` y Orden de Implementación

Implementa un menú interactivo en bucle `do-while` con lectura segura (`readInt` con `try-catch` y validación `.trim().isEmpty()`) para las 7 operaciones:

1. Register technician
2. Remove technician
3. Assign repair order to a technician
4. Remove repair order
5. Show all repair orders by technician
6. Calculate repair warranty (months)
7. Calculate repair total cost (€)
0. Exit

### Orden recomendado de desarrollo

1. Crea el paquete `src/main/java/level3/exercise2` y construye las clases de dominio (`Technician`, `RepairOrder` y las 5 subclases).
2. Implementa `ServiceCenterManager` y sus métodos auxiliares privados de búsqueda.
3. Conecta la consola en `Main` y realiza *commits* atómicos por cada capa.
