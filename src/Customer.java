import java.util.*;
import java.util.HashMap;
import java.util.Random;
public class Customer {
    public String customerId;
    private static Map<String,String[]> customerDatabase;
    private static String tempList[];
    private StringBuffer customerName;

    static {
        customerDatabase= new HashMap<>();
    }

    public Customer() {
        this.customerId = "";
        this.customerName = new StringBuffer();
        tempList = new String[5];
    }
    public void createCustomerId(){
        this.customerId = finalCustomerId();
    }
    private static String finalCustomerId(){
        final int max = 999999;
        final int min = 100000;
        Random random = new Random();
        while (true){
            String proposedId = String.valueOf((Math.abs((int)(random.nextInt() * (max - min)) + min)));
            if (!customerDatabase.containsKey(proposedId)){
                storeCustomerId(proposedId);
                return proposedId;
            }
            else continue;
        }
    }

    public  static void storeCustomerId(String proposedId){
        System.out.println(proposedId);

        customerDatabase.put(proposedId,tempList);
    }

    public void getId(){
        System.out.println("New Customer created with id : " + this.customerId);

    }

    public void setName(String customer_name) {
        this.customerName.append(customer_name);
        tempList[0] = String.valueOf(this.customerName);
    }

    public static void getCustomerById(String customerid){
        System.out.println(Arrays.toString(customerDatabase.get(customerid)));
    }
}
