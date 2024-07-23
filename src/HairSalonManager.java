import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

//Creating a SalonManager Class to store customer objects and receive user inputs



public class HairSalonManager {
	//class attributes
	private CustomerList customerList=new CustomerList();
    private Scanner scanner;
    private ArrayList<Service> services;
    private ArrayList<Stylist> stylists;
	
	


    public HairSalonManager() {
    	services = new ArrayList<>();
        scanner = new Scanner(System.in);
        stylists = new ArrayList<>();
        stylists.add(new Stylist("Georgia"));
        stylists.add(new Stylist("Bill"));
        stylists.add(new Stylist("Richard"));
    } 
    
    public void addCustomer(){
    	
        // Input validation and error handling for first name
        String firstName;
        do {
            System.out.print("Enter customer First Name: ");
            firstName = scanner.nextLine().trim();
            if (firstName.isEmpty()) {
                System.out.println("First Name cannot be empty. Please try again.");
            }
        } while (firstName.isEmpty());
        
        // Input validation and error handling for last name
        String lastName;
        do {
            System.out.print("Enter customer Last Name: ");
            lastName = scanner.nextLine().trim();
            if (lastName.isEmpty()) {
                System.out.println("Last Name cannot be empty. Please try again.");
            }
        } while (lastName.isEmpty());

        // Input validation and error handling for phone number
        String phone;
        do {
            System.out.print("Enter customer phone: ");
            phone = scanner.nextLine().trim();
            if (!isValidPhoneNumber(phone)) {
                System.out.println("Invalid phone number format. Please enter a valid phone number.");
                phone = ""; // Reset phone number to force re-entry
            }
        } while (phone.isEmpty());
              
        Customer customer = new Customer(firstName, lastName, phone, stylists);
        
        System.out.println(customer.getStylist().getName() + " will take care of you today!");
        
        // Input validation and error handling for services
        ArrayList<String> services = new ArrayList<>();
        do {
            System.out.println("Available services: haircut, haircolouring, styling, perming, treatment");
            System.out.print("Enter services (comma-separated with no whitespaces, e.g., haircut,styling,haircolouring): ");
            String userInput = scanner.nextLine().trim();
            services = new ArrayList<>(Arrays.asList(userInput.split(",")));
            if (!areValidServices(services)) {
                System.out.println("Invalid service input. Please enter valid services.");
                services.clear(); // Clear services list to force re-entry
            }
        } while (services.isEmpty());
        
        //creating a for loop to add each service input to the customer object
        for (String serviceName : services) {
        	
        	Service service = new Service(serviceName);
        	
        	customer.addService(service);
        }
        
        customer.recalculateTotalCost();
        
        //System.out.println(customer.toString());
        //adding customer to the customer list       
        customerList.addCustomer(customer);
        
        //adding customers to the customersWithService to perform calculations
        
        
        System.out.println("Customer added successfully!");
    }
    
    //method to display stylist customer count 
    public void displayStylists() {
        System.out.println(String.format("%-15s %-10s", "Stylist Name", "Customer Count"));
        System.out.println("---------------------------------");
        for (Stylist stylist : stylists) {
            System.out.println(stylist);
        }
    }
    
    //creating a method to display service types and their current generated revenues
    public void calculateAndDisplayServiceRevenue() {
        Map<String, Integer> serviceCustomerCount = new HashMap<>();
        Map<String, Double> serviceRevenue = new HashMap<>();
        
        for (Customer customer : this.customerList.customers) {
            for (Service service : customer.getServices()) {
                serviceCustomerCount.put(service.getName(), serviceCustomerCount.getOrDefault(service.getName(), 0) + 1);
                serviceRevenue.put(service.getName(), serviceRevenue.getOrDefault(service.getName(), 0.0) + service.getCost());
            }
        }

        System.out.println(String.format("%-20s %-20s %-20s", "Service", "Total Customers", "Total Revenue"));
        System.out.println("-------------------------------------------------------------");
        for (String service : serviceCustomerCount.keySet()) {
            System.out.println(String.format("%-20s %-20d %-20.2f", service, serviceCustomerCount.get(service), serviceRevenue.get(service)));
        }
    }
    
    // Utility method to check if phone number is valid
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Implement your validation logic here
        // Example: simple length check
        return phoneNumber.matches("\\d{10}"); // Assuming phone number is 10 digits
    }
    
    // Utility method to check if services are valid
    private boolean areValidServices(List<String> services) {
        // Implement your validation logic here
        // Example: checking against a predefined list of valid services
        List<String> validServices = Arrays.asList("haircut", "haircolouring", "styling", "perming", "treatment");
        for (String service : services) {
            if (!validServices.contains(service)) {
                return false;
            }
        }
        return true;
    }
    
    
    
    

    public void showMenu() {
        int choice = -1;
        do {
            System.out.println("\nSalon Management System");
            System.out.println("1. Add Customer");
            System.out.println("2. Display Customers");
            System.out.println("3. Sort customers by service cost");
            System.out.println("4. Sort customers by last name");
            System.out.println("5. Find the current revenue generated by each service");
            System.out.println("6. Find customer with highest service cost");
            System.out.println("7. Find customer with lowest service cost");
            System.out.println("8. Find customers allocated to a specific stylist");
            System.out.println("9. Exit");

            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter your choice: ");
                String input = scanner.nextLine();
                try {
                    choice = Integer.parseInt(input);
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter an integer.");
                }
            }

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    customerList.displayCustomers();
                    break;
                case 3:
                    customerList.sortByTotalServiceCost();
                    customerList.displayCustomers();
                    break;
                case 4:
                    customerList.sortByLastName();
                    customerList.displayCustomers();
                    break;
                    
                case 5:
                	calculateAndDisplayServiceRevenue();
                	break;
                	
                case 6:
                	customerList.displayCustomerWithHighestServiceCost();
                	break;
                
                case 7:
                	customerList.displayCustomerWithLowestServiceCost();
                	break;
                    
                case 8:
                	displayStylists();
                	break;

                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 9);
    }

	    public static void main(String[] args) {
	        HairSalonManager manager = new HairSalonManager();
	        manager.showMenu();
	    }
	}


