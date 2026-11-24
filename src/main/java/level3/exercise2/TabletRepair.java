package level3.exercise2;

public class TabletRepair extends RepairOrder {
    private static final double BASE_COST = 85.0;
    private static final double PREMIUM_BRAND_BONUS = 45.0;
    private static final double CRITICAL_COMPONENT_BONUS = 60.0;
    private static final int BASE_WARRANTY_MONTHS = 6;
    private static final int PREMIUM_BRAND_WARRANTY_BONUS = 6;

    private final String brand;
    private final String component;

    public TabletRepair(String ticketCode, String brand, String component) {
        super(ticketCode);
        this.brand = brand;
        this.component = component;
        setTotalCost(calculateTotalCost());
        setWarrantyMonths(calculateWarrantyMonths());
    }

    public String getBrand() {
        return brand;
    }

    public String getComponent() {
        return component;
    }

    @Override
    public double calculateTotalCost() {
        double totalCost = BASE_COST;
        if("iPad".equalsIgnoreCase(brand) || "Galaxy Tab".equalsIgnoreCase(brand)){
            totalCost += PREMIUM_BRAND_BONUS;
        }
        if("Screen".equalsIgnoreCase(component)){
            totalCost += CRITICAL_COMPONENT_BONUS;
        }
        return totalCost;
    }

    @Override
    public int calculateWarrantyMonths() {
        int totalWarranty = BASE_WARRANTY_MONTHS;
        if("iPad".equalsIgnoreCase(brand) || "Galaxy Tab".equalsIgnoreCase(brand)){
            totalWarranty += PREMIUM_BRAND_WARRANTY_BONUS;
        }
        return totalWarranty;
    }
}
