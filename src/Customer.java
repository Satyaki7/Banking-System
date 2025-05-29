import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Customer {
    public final String customerId;
    private static Set<String> customerDatabase;
    private StringBuffer customerName;

    static {
        customerDatabase= new HashSet<String>();
    }

    public Customer() {
        this.customerId = finalCustomerId();
    }

    private static String finalCustomerId(){
        final int max = 999999;
        final int min = 100000;
        Random random = new Random();
        while (true){
            String proposedId = String.valueOf((Math.abs((int)(random.nextInt() * (max - min)) + min)));
            if (!customerDatabase.contains(proposedId)){
                storeCustomerId(proposedId);
                return proposedId;
            }
            else continue;
        }
    }

    public  static void storeCustomerId(String proposedId){
        System.out.println(proposedId);
        customerDatabase.add(proposedId);
    }

    public String getId(){
        return this.customerId;
    }

    public void setName(String customerName) {
        this.customerName = new StringBuffer(customerName);
    }
}
