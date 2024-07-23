import java.util.Random;
import java.util.ArrayList;



public class Customer {
	


	//defining the class attributes
	private String firstName;
	private String lastName;
	private String phone;
	private ArrayList<Service> services;
	private int id;
	private Stylist stylist;
	private double totalServiceCost;
	 
	 
    public Customer(String firstNameIn, String lastNameIn, String phoneIn, ArrayList<Stylist> stylistIn) {
        this.firstName = firstNameIn;
        this.lastName = lastNameIn;
        this.phone = phoneIn;
        this.services = new ArrayList();
        this.stylist = assignStylist(stylistIn);
        this.stylist.incrementCustomerCount();
        this.id = generateRandomId();
        this.totalServiceCost = 0.0;
    }
    
    private int generateRandomId() {
        Random rand = new Random();
        return rand.nextInt(100); // Generate a random integer between 0 and 99
    }
    
    //creating a method to assign a stylist to a customer object
    private Stylist assignStylist(ArrayList<Stylist> stylists) {
        Stylist selectedStylist = stylists.get(0);
        boolean equalCounts = true;
        for (Stylist stylist : stylists) {
            if (stylist.getCustomerCount() < selectedStylist.getCustomerCount()) {
                selectedStylist = stylist;
                equalCounts = false;
            } else if (stylist.getCustomerCount() != selectedStylist.getCustomerCount()) {
                equalCounts = false;
            }
        }
        if (equalCounts) {
            Random rand = new Random();
            selectedStylist = stylists.get(rand.nextInt(stylists.size()));
        }
        return selectedStylist;
    }
    
    //creating a method to add services to an arraylist of services in the customer object
    public void addService(Service serviceIn) {
    	
    	this.services.add(serviceIn);
    	
    }
    
    //creating a method to calculate the services based on the input array of strings 
    public double calculateTotalCost() {
        double cost = 0;
        for (Service service : services) {
        	
        	cost += service.getCost();
          
        }
        return cost;
    }
    
    // creating a method to extract the service name from the input services
    public String getServicesNames() {
        ArrayList<String> serviceNames = new ArrayList<>();
        for (Service service : services) {
            serviceNames.add(service.getName());
        }
        return String.join(", ", serviceNames);
    }
    
    public void recalculateTotalCost() {
    	this.totalServiceCost = calculateTotalCost();
    }
    
    public Stylist getStylist() {
    	return stylist;
    }
    
    public ArrayList<Service> getServices() {
		return services;
	}
    
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public int getId() {
		return id;
	}
	
	public double getTotalCost() {
		return totalServiceCost;
	}
	
	@Override
	public String toString() {
		return String.format("%-15s %-15s %-15s %-50s %-15.2f %-10d %-15s", firstName, lastName, phone, getServicesNames(), totalServiceCost, id, stylist.getName());
	}

}
