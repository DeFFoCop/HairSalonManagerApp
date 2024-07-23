//creating a stylist class 


public class Stylist {
    private String name;
    private int customerCount;

    public Stylist(String name) {
        this.name = name;
        this.customerCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public void incrementCustomerCount() {
        this.customerCount++;
    }

    public void decrementCustomerCount() {
        if (this.customerCount > 0) {
            this.customerCount--;
        }
    }

    @Override
    public String toString() {
        return String.format("%-15s %-10d", name, customerCount);
    }
}
