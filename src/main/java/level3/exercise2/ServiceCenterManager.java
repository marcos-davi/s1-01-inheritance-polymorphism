package level3.exercise2;

import java.util.ArrayList;
import java.util.List;

public class ServiceCenterManager {
    private final List<Technician> technicians = new ArrayList<>();

    public boolean addTechnician(String name, String employeeId) {
        if (isBlank(name) || isBlank(employeeId)) {
            return false;
        }
        if (findTechnicianById(employeeId) != null) {
            return false;
        }
        technicians.add(new Technician(name.trim(), employeeId.trim()));
        return true;
    }

    public boolean removeTechnician(String employeeId) {
        Technician technician = findTechnicianById(employeeId);
        if (technician == null) {
            return false;
        }
        return technicians.remove(technician);
    }

    public boolean assignOrderToTechnician(String employeeId, RepairOrder order) {
        if (order == null || isBlank(order.getTicketCode())) {
            return false;
        }
        Technician technician = findTechnicianById(employeeId);
        if (technician == null) {
            return false;
        }
        if (ticketCodeExists(order.getTicketCode())) {
            return false;
        }
        technician.addRepairOrder(order);
        return true;
    }

    public boolean removeOrderFromTechnician(String employeeId, String ticketCode) {
        Technician technician = findTechnicianById(employeeId);
        RepairOrder order = findOrderByCode(technician, ticketCode);
        if (order == null) {
            return false;
        }
        return technician.getAssignedOrders().remove(order);
    }
    
    public List<RepairOrder> getOrdersByTechnician(String employeeId) {
        Technician technician = findTechnicianById(employeeId);
        if (technician == null) {
            return null;
        }
        return technician.getAssignedOrders();
    }

    public double calculateOrderCost(String employeeId, String ticketCode) {
        RepairOrder order = findOrderByCode(findTechnicianById(employeeId), ticketCode);
        if (order == null) {
            return -1.0;
        }
        return order.calculateTotalCost();
    }

    public int calculateOrderWarranty(String employeeId, String ticketCode) {
        RepairOrder order = findOrderByCode(findTechnicianById(employeeId), ticketCode);
        if (order == null) {
            return -1;
        }
        return order.calculateWarrantyMonths();
    }

    private Technician findTechnicianById(String employeeId) {
        if (isBlank(employeeId)) {
            return null;
        }
        String id = employeeId.trim();
        for (Technician technician : technicians) {
            if (technician.getEmployeeId().equalsIgnoreCase(id)) {
                return technician;
            }
        }
        return null;
    }

    private RepairOrder findOrderByCode(Technician technician, String ticketCode) {
        if (technician == null || isBlank(ticketCode)) {
            return null;
        }
        String code = ticketCode.trim();
        for (RepairOrder order : technician.getAssignedOrders()) {
            String storedCode = order.getTicketCode();
            if (storedCode != null && code.equalsIgnoreCase(storedCode.trim())) {
                return order;
            }
        }
        return null;
    }

    private boolean ticketCodeExists(String ticketCode) {
        for (Technician technician : technicians) {
            if (findOrderByCode(technician, ticketCode) != null) {
                return true;
            }
        }
        return false;
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}