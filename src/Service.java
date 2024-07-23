import java.util.Random;

public class Service {
	String name;
	double cost;
	int    id;
	
	// Define service costs
    private static final double HAIRCUT_COST = 20.0;
	private static final double HAIR_COLOURING_COST = 30.0;
	private static final double STYLING_COST = 35.0;
	private static final double PERMING_COST = 50.0;
	private static final double TREATMENT_COST = 45.0;


	public Service(String name) {
        this.name = name;
        this.cost = getServiceCostByInput(name);
        this.id = generateRandomId();
    }
	
	public double getServiceCostByInput(String serviceName) {
		
		switch (serviceName.toLowerCase()) {
                case "haircut":
                    return HAIRCUT_COST;
                    
                case "haircolouring":
                    return HAIR_COLOURING_COST;
                    
                case "styling":
                    return STYLING_COST;
                    
                case "perming":
                    return PERMING_COST;
                    
                case "treatment":
                    return TREATMENT_COST;                    
                default:
                    System.out.println("Unknown service: " + serviceName);
                    return 0.0;
            
        }
		
	
	}
	
    private int generateRandomId() {
        Random rand = new Random();
        return rand.nextInt(100); // Generate a random integer between 0 and 99
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}