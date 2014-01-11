package javaphone;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class holds a list of all customers and provides methods to access it.
 *
 * @author iGroup
 */
public class CustomerList extends ArrayList<HashMap> {

    private final DataFileIO customerDataFile;

    /**
     * Constructor for the class CustomerList. <br />
     * First creates an instance of DataFileIO <br />
     * and adds reference to HashMap objects it gets from an xml-file.
     */
    public CustomerList() {
        customerDataFile = new DataFileIO("customers.xml", "customers", "customer");
        this.addAll(customerDataFile.read());
    }

    /**
     * Searches for customer with specific customerId
     *
     * @param customerId
     * @return customer data as HashMap if customer found null if customer not
     * found
     */
    public HashMap getCustomerById(int customerId) {
        for (HashMap customer : this) {
            if (customerId == (int) customer.get("customerId")) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Gets the number of customers by service.
     *
     * @param   serviceId
     * @return  The number of customers with the specified service.
     */
    public int getCustomerCountByService(int serviceId) {
        int customerCount = 0;
        for (HashMap hashMap : this) {
            if ((int) hashMap.get("serviceId") == serviceId) {
                customerCount++;
            }
        }
        return customerCount;
    }

    /**
     * Gets the number of customers registered by a user.
     *
     * @param   userId
     * @return  The number of customers registered by a user.
     */
    public int getCustomerCountByUser(int userId) {
        int customerCount = 0;
        for (HashMap hashMap : this) {
            if ((int) hashMap.get("userId") == userId) {
                customerCount++;
            }
        }
        return customerCount;
    }

    /**
     * Gets a list of files in a folder with a specific extension.
     *
     * @param folderName Folder to search for files. Use "." for root.
     * @param validExtension Valid file extension.
     * @return ArayList with relative file-paths as Strings.
     */
    public ArrayList getFileList(String folderName, String validExtension) {
        ArrayList files = new ArrayList();
        File folder = new File(folderName); // the folder to check for files
        File[] folderContent = folder.listFiles(); //a list of all files and folders within the chosen folder

        for (File file : folderContent) {
            String fileName = file.toString();
            String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);
            if (file.isFile() & fileExtension.equalsIgnoreCase(validExtension)) {
                // Checks that it is not a folder or a file of another type.
                files.add(fileName);
            }
        }
        return files;
    }

    /**
     * Saves data to xml file.
     *
     * @return true if data was saved false if data was not saved
     */
    public boolean saveData() {
        return customerDataFile.write(this);
    }
}
