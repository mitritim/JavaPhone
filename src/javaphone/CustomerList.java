package javaphone;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author iGroup
 */
public class CustomerList extends ArrayList<HashMap> {

    private final DataFileIO customerDataFile;

    public CustomerList() {
        customerDataFile = new DataFileIO("customers.xml", "customers", "customer");
        this.addAll(customerDataFile.read());
    }

    public ArrayList filter(User user, Service service) {
        return null;
    }

    public ArrayList getCustomerData(Customer customer) {
        return null;
    }

    public boolean changeCustomerData(Customer customer, HashMap customerData) {
        return true;
    }

    public int getCustomerNoByService(Service service) {
        return 0;
    }

    public void prepareReport() {
    }

    public String getNextContract() {
        return null;
    }

}
