package level3.exercise2;

public class ConsoleRepair extends RepairOrder{
    private static final double BASE_COST = 90.0;
    private static final double PREMIUM_MODEL_BONUS = 45.0;
    private static final double CRITICAL_FAULT_BONUS = 40.0;
    private static final int BASE_WARRANTY_MONTHS = 3;
    private static final int PREMIUM_MODEL_WARRANTY_BONUS = 3;
    private static final int COMPONENT_WARRANTY_BONUS = 3;

    private final String consoleModel;
    private final String fault;

    public ConsoleRepair(String ticketCode, String consoleModel, String fault) {
        super(ticketCode);
        this.consoleModel = consoleModel;
        this.fault = fault;
        setTotalCost(calculateTotalCost());
        setWarrantyMonths(calculateWarrantyMonths());
    }

    public String getConsoleModel() {
        return consoleModel;
    }

    public String getFault() {
        return fault;
    }

    @Override
    public double calculateTotalCost() {
        double totalCost = BASE_COST;
        if("PS5".equalsIgnoreCase(consoleModel) || "Xbox Series X".equalsIgnoreCase(consoleModel)){
            totalCost += PREMIUM_MODEL_BONUS;
        }
        if("HDMI".equalsIgnoreCase(fault)){
            totalCost += CRITICAL_FAULT_BONUS;
        }
        return totalCost;
    }

    @Override
    public int calculateWarrantyMonths() {
        int totalWarranty = BASE_WARRANTY_MONTHS;
        if("PS5".equalsIgnoreCase(consoleModel) || ("Nintendo Switch".equalsIgnoreCase(consoleModel))) {
            totalWarranty += PREMIUM_MODEL_WARRANTY_BONUS;
        }
        if ("HDMI".equalsIgnoreCase(fault)) {
            totalWarranty += COMPONENT_WARRANTY_BONUS;
        }
        return totalWarranty;

    }
}
