package javaphone;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This controller class is responsible for communication between the GUI and
 * the model classes.
 *
 * @author iGroup
 */
public class Controller {

    private HashMap activeUser;
    private final ServiceList serviceList;
    private final UserList userList;
    private final CustomerList customerList;

    /**
     * Constructor for class Controller.
     */
    public Controller() {
        serviceList = new ServiceList();
        userList = new UserList();
        customerList = new CustomerList();
    }

    private boolean setActiveUser(int userId) {
        activeUser = userList.getUserById(userId);
        return true;
    }

    /**
     * Gets the user that is logged in.
     * @return HashMap user
     */
    public HashMap getActiveUser() {
        return activeUser;
    }

    /**
     * Checks if password is correct for the user-name.
     * @param   loginData HashMap with keys "userName" and "password"
     * @return  true if password matches <br />
     *          false if password doesn't match
     */
    public boolean login(HashMap loginData) {
        String userName = (String) loginData.get("userName");
        String password = (String) loginData.get("password");

        try {
            int userId = Integer.parseInt(userName);
            if (getUserById(userId).get("userPassword").equals(password)) {
                setActiveUser(userId);
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Adds customer to customerList.
     * @param customerData A Hashmap containing all customer data.
     * @return  true if successfully added <br />
     *          false if not added
     */
    public boolean addCustomer(HashMap customerData) {
        return customerList.add(customerData);
    }

    /**
     * Returns a list with all customers.
     * @return CustomerList customerList
     */
    public CustomerList getCustomerList() {
        return customerList;
    }

    /**
     * Gets a customer with the chosen id.
     * @param customerId 
     * @return HashMap with customer data
     */
    public HashMap getCustomerById(int customerId) {
        return customerList.getCustomerById(customerId);
    }

    /**
     * Gets the number of customers with the chosen service.
     * @param serviceId
     * @return int The number of customers with that service.
     */
    public int getCustomerCountByService(int serviceId) {
        return customerList.getCustomerCountByService(serviceId);
    }
    
    /**
     * Gets the number of customers registered by the chosen user.
     * @param userId
     * @return int The number of customers registered by that user.
     */
    public int getCustomerCountByUser(int userId) {
        return customerList.getCustomerCountByUser(userId);
    }

    /**
     * Saves all customer data to an xml-file.
     * @return  true if data was saved successfully <br />
     *          false if there were problems saving data
     */
    public boolean saveCustomerList() {
        return customerList.saveData();
    }

    /**
     * Gets a list with all users.
     * @return UserList A list containing all users
     */
    public UserList getUserList() {
        return userList;
    }

    /**
     * Adds a user to the list of users.
     * @param user
     * @return  true if user was added successfully <br />
     *          false if user was not added
     */
    public boolean addUser(HashMap user) {
        return userList.add(user);
    }

    /**
     * Gets a user with a specified id.
     * @param   userId the users id
     * @return  HashMap with the user's data
     */
    public HashMap getUserById(int userId) {
        return userList.getUserById(userId);
    }

    /**
     * Saves all user data to an xml-file.
     * @return  true if data was saved successfully <br />
     *          false if there were problems saving data
     */
    public boolean saveUserList() {
        return userList.saveData();
    }

    /**
     * Gets a list with all services.
     * @return ServiceList a list with all services
     */
    public ServiceList getServiceList() {
        return serviceList;
    }

    /**
     * Gets a service with the specified id.
     * @param serviceId
     * @return HashMap with the service data
     */
    public HashMap getServiceById(int serviceId) {
        return serviceList.getServiceById(serviceId);
    }

    /**
     * Saves all service data to an xml-file.
     * @return  true if data was saved successfully <br />
     *          false if there were problems saving data
     */
    public boolean saveServiceList() {
        return serviceList.saveData();
    }
    
    /**
     * Creates a statistics report in an xml-format.
     * @return  true if the report was created successfully <br />
     *          false if there were problems creating the report
     */
    public boolean createReport() {
        HashMap customerCountByService = new HashMap();
        for (HashMap service : serviceList) {
            int serviceId = (int) service.get("serviceId");
            customerCountByService
                    .put(serviceId, getCustomerCountByService(serviceId));
        }
        return serviceList.createReport(customerCountByService);
    }
    
    /**
     * Gets a list with available scanned contracts.
     * @return ArrayList holding paths to contract .jpg files
     */
    public ArrayList getScannedContracts() {
        return customerList.getFileList("Nya avtal", "jpg");
    }
}
