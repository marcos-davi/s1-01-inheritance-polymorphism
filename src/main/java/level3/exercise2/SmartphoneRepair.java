package level3.exercise2;

public class SmartphoneRepair extends RepairOrder{
    private String brand;
    private String component;
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
        double totalCost = 80.0;
        if("Apple".equalsIgnoreCase(this.brand) || "Samsung".equalsIgnoreCase(this.brand)){
            totalCost += 50;
        }
        if("Screen".equalsIgnoreCase(this.component) || "Motherboard".equalsIgnoreCase(this.component)){
            totalCost += 70.0;
        }
        return totalCost;
    }

    @Override
    public int calculateWarrantyMonths() {
        int totalWarranty = 6;
        if("Apple".equalsIgnoreCase(this.brand) || "Samsung".equalsIgnoreCase(this.brand)){
            totalWarranty += 6;
        }

        if("Battery".equalsIgnoreCase(this.component)){
            totalWarranty += 3;
        }
        return totalWarranty;
    }
}
