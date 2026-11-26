package level3.exercise2;

import java.util.ArrayList;
import java.util.List;

public class ServiceCenterManager {
    private final List<Technician> technicians = new ArrayList<>();


   public boolean addTechnician (String name, String employeeId){
       if(findTechnicianById(employeeId) != null) {
           return false;
       }
       Technician newTechnician = new Technician(name, employeeId);
       if(!technicians.contains(newTechnician)) {
           this.technicians.add(newTechnician);
       }
       return true;
   }

    public boolean removeTechnician(String employeeId){
        if(findTechnicianById(employeeId) == null){
            return false;
        }
        technicians.removeIf(technician -> technician.getEmployeeId().equalsIgnoreCase(employeeId));
        return true;
    }

    public boolean assignOrderToTechnician(String employeeId, RepairOrder order){
       Technician technician = findTechnicianById(employeeId);
       if(technician.getAssignedOrders().contains(order)){
           return false;
       }
       technician.addRepairOrder(order);
       return true;

    }



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
