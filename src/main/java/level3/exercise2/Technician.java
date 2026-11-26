package level3.exercise2;

import java.util.ArrayList;
import java.util.List;

public class Technician {
    private String name;
    private final String employeeId;
    private static double baseSalary = 1650.0;
    private final List<RepairOrder> assignedOrders;

    public Technician(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
        this.assignedOrders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public static double getBaseSalary() {
        return baseSalary;
    }

    public static void setBaseSalary(double baseSalary) {
        Technician.baseSalary = baseSalary;
    }

    public List<RepairOrder> getAssignedOrders() {
        return assignedOrders;
    }

    public void addRepairOrder(RepairOrder order) {
        if (order != null) {
            this.assignedOrders.add(order);
        }
    }

    public boolean removeRepairOrder(String ticketOrder) {
        if (ticketOrder == null) {
            return false;
        }
        return this.assignedOrders.removeIf(order -> ticketOrder.equalsIgnoreCase(order.getTicketCode()));
    }
}
