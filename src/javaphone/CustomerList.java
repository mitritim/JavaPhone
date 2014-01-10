package javaphone;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class handles the customers information when 
 * searching for the customer id number.
 * 
 * @author iGroup
 */
public class CustomerList extends ArrayList<HashMap> {

    private final DataFileIO customerDataFile;
    
    /**
     * Adds customer to the datafile.
     */
    public CustomerList() {
        customerDataFile = new DataFileIO("customers.xml", "customers", "customer");
        this.addAll(customerDataFile.read());
    }

    /**
     * Searches for customer with specific customerId
     * @param customerId
     * @return customer data as HashMap if customer found 
     *         null if customer not found
     */     
    public HashMap getServiceById(int customerId) {
        for (HashMap customer : this) {
            if (customerId == (int) customer.get("customerId")) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Gets the number of customers by service.
     * @param serviceId
     * @return customer number
     */
    public int getCustomerCountByService(int serviceId) {
        return 0;
    }
    
    /**
     * Prepares the report
     */
    public void prepareReport() {
    }
    
    /**
     * Gets the next contract
     * @return null
     */
    public String getNextContract() {
        return null;
    }

}
