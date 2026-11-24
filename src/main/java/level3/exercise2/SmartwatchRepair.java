package level3.exercise2;

public class SmartwatchRepair extends RepairOrder{
    private static final double BASE_COST = 60.0;
    private static final double PREMIUM_BRAND_BONUS = 35.0;
    private static final int BASE_WARRANTY_MONTHS = 3;
    private static final int PREMIUM_BRAND_WARRANTY_BONUS = 3;
    private final String brand;

    public SmartwatchRepair(String ticketCode, String brand) {
        super(ticketCode);
        this.brand = brand;
        setTotalCost(calculateTotalCost());
        setWarrantyMonths(calculateWarrantyMonths());
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public double calculateTotalCost() {
        double totalCost = BASE_COST;
        if("Apple Watch".equalsIgnoreCase(brand) || "Garmin".equalsIgnoreCase(brand)){
            totalCost += PREMIUM_BRAND_BONUS;
        }
        return totalCost;
    }

    @Override
    public int calculateWarrantyMonths() {
        int totalWarranty = BASE_WARRANTY_MONTHS;
        if("Apple Watch".equalsIgnoreCase(brand) || "Garmin".equalsIgnoreCase(brand)){
            totalWarranty += PREMIUM_BRAND_WARRANTY_BONUS;
        }
        return totalWarranty;
    }
}
