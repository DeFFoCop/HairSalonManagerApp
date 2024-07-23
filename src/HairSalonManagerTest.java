public class HairSalonManagerTest {

    public static void main(String[] args) {
        HairSalonManager manager = new HairSalonManager();
        testAddCustomer(manager);
        testDisplayCustomers(manager);
        testSortByServiceCost(manager);
        testSortByLastName(manager);
        testCalculateServiceRevenue(manager);
        testFindCustomerWithHighestServiceCost(manager);
        testFindCustomerWithLowestServiceCost(manager);
        testFindCustomersByStylist(manager);
        System.out.println("Testing is completed");
    }

    private static void testAddCustomer(HairSalonManager manager) {
        System.out.println("\nTesting adding one or more customer. Keep selecting option 1 , press 9 when you are done");
        manager.addCustomer();
        System.out.println();
        manager.showMenu();
    }

    private static void testDisplayCustomers(HairSalonManager manager) {
        System.out.println("\nTesting displaying customers. Keep selecting option 2 , press 9 when you are done");
        manager.showMenu();
    }

    private static void testSortByServiceCost(HairSalonManager manager) {
        System.out.println("\nTesting sorting customers by service cost. Keep selecting option 3 , press 9 when you are done");
        manager.showMenu();
    }

    private static void testSortByLastName(HairSalonManager manager) {
        System.out.println("\nTesting sorting customers by last name. Keep selecting option 4 , press 9 when you are done");
        manager.showMenu();
    }

    private static void testCalculateServiceRevenue(HairSalonManager manager) {
        System.out.println("\nTesting calculating and displaying service revenue. Keep selecting option 5 , press 9 when you are done");
        manager.showMenu();
    }

    private static void testFindCustomerWithHighestServiceCost(HairSalonManager manager) {
        System.out.println("\nTesting finding customer with highest service cost. Keep selecting option 6 , press 9 when you are done");
        manager.showMenu();
    }

    private static void testFindCustomerWithLowestServiceCost(HairSalonManager manager) {
        System.out.println("\nTesting finding customer with lowest service cost. Keep selecting option 7 , press 9 when you are done");
        manager.showMenu();
    }

    private static void testFindCustomersByStylist(HairSalonManager manager) {
        System.out.println("\nTesting finding customers allocated to a specific stylist. Keep selecting option 8 , press 9 when you are done");
        manager.showMenu();
    }
}
