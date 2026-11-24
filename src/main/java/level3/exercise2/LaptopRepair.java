package level3.exercise2;

public class LaptopRepair extends RepairOrder {
    private static final double BASE_COST = 120.0;
    private static final double PREMIUM_BRAND_BONUS = 80.0;
    private static final double CRITICAL_COMPONENT_BONUS = 90.0;
    private static final int BASE_WARRANTY_MONTHS = 6;
    private static final int PREMIUM_BRAND_WARRANTY_BONUS = 6;
    private static final int COMPONENT_WARRANTY_BONUS = 6;

    private final String brand;
    private final String repairType;

    public LaptopRepair(String ticketCode, String brand, String repairType) {
        super(ticketCode);
        this.brand = brand;
        this.repairType = repairType;
        setTotalCost(calculateTotalCost());
        setWarrantyMonths(calculateWarrantyMonths());
    }

    public String getBrand() {
        return brand;
    }

    public String getRepairType() {
        return repairType;
    }

    @Override
    public double calculateTotalCost() {
        double totalPrice = BASE_COST;
        if("MacBook".equalsIgnoreCase(brand) || "ThinkPad".equalsIgnoreCase(brand)) {
            totalPrice += PREMIUM_BRAND_BONUS;
        }
        if("Motherboard".equalsIgnoreCase(repairType) || "GPU".equalsIgnoreCase(repairType)) {
            totalPrice += CRITICAL_COMPONENT_BONUS;
        }
        return totalPrice;
    }

    @Override
    public int calculateWarrantyMonths() {
        int totalWarranty = BASE_WARRANTY_MONTHS;
        if("MacBook".equalsIgnoreCase(brand) || ("ThinkPad".equalsIgnoreCase(brand))) {
            totalWarranty += PREMIUM_BRAND_WARRANTY_BONUS;
        }
        if ("Motherboard".equalsIgnoreCase(repairType)) {
            totalWarranty += COMPONENT_WARRANTY_BONUS;
        }
        return totalWarranty;
    }
}
