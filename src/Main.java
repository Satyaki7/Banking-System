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
                    running = false;
                default:
                    continue;
            }
        }
    }

    public static void createCustomer() {
        Scanner sc = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.println("Enter the name of the customer: ");
        customer.setName(sc.nextLine());
        System.out.println("New Customer created with id : " + customer.getId());
    }

}
