package level3.exercise2;

import java.util.ArrayList;
import java.util.List;

public class ServiceCenterManager {
    private final List<Technician> technicians = new ArrayList<>();

    private Technician findTechnicianById(String employeeId) {
        if(employeeId == null){
            return null;
        }
        for (Technician technician : technicians) {
            if (technician.getEmployeeId().equalsIgnoreCase(employeeId)) {
                return technician;
            }
        }
        return null;
    }

    private RepairOrder findOrderByCode(Technician technician, String ticketCode){
        if(technician== null || ticketCode == null){
            return null;
        }
        for(RepairOrder order : technician.getAssignedOrders()){
            if(ticketCode.equalsIgnoreCase(order.getTicketCode())) {
                return order;
            }
        }
        return null;

    }
    private boolean ticketCodeExists(String ticketCode){
        if(ticketCode == null){
            return false;
        }
        for (Technician technician : technicians) {
            if(findOrderByCode(technician, ticketCode) != null){
                return true;
            }
        }
        return false;
    }

}
