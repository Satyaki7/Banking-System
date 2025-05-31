import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        boolean running = true;
        while (running) {
            System.out.println("Enter 1 to create customer: ");
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    createCustomer();
                    break;
                case 2:
                    getDetails();
                    break;
                case 3:
                    running = false;
                default:
                    continue;
            }
        }
    }

    public static void createCustomer() {
        Scanner sc = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.print("Enter the name of the customer: ");
        customer.setName(sc.nextLine());
        customer.createCustomerId();
        customer.getId();
    }
    public static void getDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer Id to see details: ");
        String customerid = sc.nextLine();
        Customer.getCustomerById(customerid);
    }

}
