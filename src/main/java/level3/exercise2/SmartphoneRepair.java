package level3.exercise2;

public class SmartphoneRepair extends RepairOrder{
    private final String brand;
    private final String component;
    private static final double BASE_COST = 80.0;
    private static final double PREMIUM_BRAND_BONUS = 50.0;
    private static final double CRITICAL_COMPONENT_BONUS = 70.0;
    private static final int BASE_WARRANTY_MONTHS = 6;
    private static final int PREMIUM_BRAND_WARRANTY_BONUS = 6;
    private static final int BATTERY_WARRANTY_BONUS = 3;
    public SmartphoneRepair(String ticketCode, String brand, String component) {
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
        if("Apple".equalsIgnoreCase(this.brand) || "Samsung".equalsIgnoreCase(this.brand)){
            totalCost += PREMIUM_BRAND_BONUS;
        }
        if("Screen".equalsIgnoreCase(this.component) || "Motherboard".equalsIgnoreCase(this.component)){
            totalCost += CRITICAL_COMPONENT_BONUS;
        }
        return totalCost;
    }

    @Override
    public int calculateWarrantyMonths() {
        int totalWarranty = BASE_WARRANTY_MONTHS;
        if("Apple".equalsIgnoreCase(this.brand) || "Samsung".equalsIgnoreCase(this.brand)){
            totalWarranty += PREMIUM_BRAND_WARRANTY_BONUS;
        }

        if("Battery".equalsIgnoreCase(this.component)){
            totalWarranty += BATTERY_WARRANTY_BONUS;
        }
        return totalWarranty;
    }
}
