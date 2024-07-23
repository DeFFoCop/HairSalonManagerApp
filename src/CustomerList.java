import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;




public class CustomerList {
	
	public ArrayList<Customer> customers;
	
	public CustomerList() {
		customers = new ArrayList<>();
	}
	
    public void addCustomer(Customer newCustomer) {
    	
    	customers.add(newCustomer);
        
    }
    
    public void sortByTotalServiceCost() {
        Collections.sort(customers, Comparator.comparingDouble(Customer::calculateTotalCost).reversed());
    }
    
    public void sortByLastName() {
    	Collections.sort(customers, Comparator.comparing(Customer::getLastName, String.CASE_INSENSITIVE_ORDER));
    }
    
    //identify the customer who has paid the highest service cost
    public void displayCustomerWithHighestServiceCost() {
        // Check if customers list is not empty
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        // Find customer with highest service cost
        Customer highestPayingCustomer = Collections.max(customers, Comparator.comparingDouble(Customer::calculateTotalCost));

        // Print header
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-15s %-15s %-50s %-18s %-12s %-15s%n",
                "First Name", "Last Name", "Phone", "Services", "ServiceTotalCost", "CustomerId", "Stylist");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");

        // Print customer details
        System.out.println(highestPayingCustomer);
    }
    
    //identify the customer who has paid the lowest service cost
    public void displayCustomerWithLowestServiceCost() {
        // Check if customers list is not empty
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        // Find customer with highest service cost
        Customer lowestPayingCustomer = Collections.min(customers, Comparator.comparingDouble(Customer::calculateTotalCost));

        // Print header
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-15s %-15s %-50s %-18s %-12s %-15s%n",
                "First Name", "Last Name", "Phone", "Services", "ServiceTotalCost", "CustomerId", "Stylist");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");

        // Print customer details
        System.out.println(lowestPayingCustomer);
    }

    public void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers to display.");
        } else {
            System.out.println(String.format("%-15s %-15s %-15s %-50s %-15s %-10s %-15s", "First Name", "Last Name", "Phone", "Services", "ServiceTotalCost","CustomerId", "Stylist" ));
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        
    }

    }
    
    
}
