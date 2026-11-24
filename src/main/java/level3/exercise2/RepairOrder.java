package level3.exercise2;

public abstract class RepairOrder {
    private final String ticketCode;
    private String issueDescription;
    private int warrantyMonths;
    private double totalCost;

    public RepairOrder(String ticketCode) {
        this.ticketCode = ticketCode;
        this.issueDescription = "";
    }

    public abstract double calculateTotalCost();
    public abstract int calculateWarrantyMonths();

    public String getTicketCode() {
        return ticketCode;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    protected void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    public double getTotalCost() {
        return totalCost;
    }

    protected void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
