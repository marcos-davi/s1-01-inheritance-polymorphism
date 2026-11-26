package level3.exercise2;

import java.util.ArrayList;
import java.util.List;

public class ServiceCenterManager {
    private final List<Technician> technicians = new ArrayList<>();


    public boolean addTechnician(String name, String employeeId) {
        if (name == null || name.trim().isEmpty() || employeeId == null || employeeId.trim().isEmpty()) {
            return false;
        }
        if (findTechnicianById(employeeId) != null) {
            return false;
        }
        Technician newTechnician = new Technician(name, employeeId);
        this.technicians.add(newTechnician);
        return true;
    }

    public boolean removeTechnician(String employeeId) {
        if (findTechnicianById(employeeId) == null) {
            return false;
        }
        return technicians.removeIf(technician -> technician.getEmployeeId().equalsIgnoreCase(employeeId));
    }

    public boolean assignOrderToTechnician(String employeeId, RepairOrder order) {
        if (order == null || order.getTicketCode() == null || ticketCodeExists(order.getTicketCode())) {
            return false;
        }
        Technician technician = findTechnicianById(employeeId);
        if(technician == null){
            return false;
        }
        technician.addRepairOrder(order);
        return true;

    }

    public boolean removeOrderFromTechnician(String employeeId, String ticketCode) {
        if (employeeId == null || ticketCode == null) {
            return false;
        }
        Technician technician = findTechnicianById(employeeId);
        if (technician == null) {
            return false;
        }
        return technician.removeRepairOrder(ticketCode);
    }

    public List<RepairOrder> getOrdersByTechnician(String employeeId) {
        Technician technician = findTechnicianById(employeeId);
        if (technician == null) {
            return null;
        }
        return technician.getAssignedOrders();
    }

    public double calculateOrderCost(String employeeId, String ticketCode){
        Technician technician = findTechnicianById(employeeId);
        RepairOrder order = findOrderByCode(technician, ticketCode);
        if(order == null){
            return -1.0;
        }
        return order.calculateTotalCost();
    }

    public int calculateOrderWarranty(String employeeId, String ticketCode){
        Technician technician = findTechnicianById(employeeId);
        RepairOrder order = findOrderByCode(technician, ticketCode);
        if(order == null){
            return -1;
        }
        return order.calculateWarrantyMonths();
    }


    private Technician findTechnicianById(String employeeId) {
        if (employeeId == null) {
            return null;
        }
        for (Technician technician : technicians) {
            if (technician.getEmployeeId().equalsIgnoreCase(employeeId)) {
                return technician;
            }
        }
        return null;
    }

    private RepairOrder findOrderByCode(Technician technician, String ticketCode) {
        if (technician == null || ticketCode == null) {
            return null;
        }
        for (RepairOrder order : technician.getAssignedOrders()) {
            if (ticketCode.equalsIgnoreCase(order.getTicketCode())) {
                return order;
            }
        }
        return null;

    }

    private boolean ticketCodeExists(String ticketCode) {
        if (ticketCode == null) {
            return false;
        }
        for (Technician technician : technicians) {
            if (findOrderByCode(technician, ticketCode) != null) {
                return true;
            }
        }
        return false;
    }

}
