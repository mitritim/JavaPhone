package javaphone;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This controller class is responsible for communication between the GUI and
 * the model classes.
 *
 * @author iGroup
 */
public class LpPhoneMain {

    private HashMap activeUser;
    private final ServiceList serviceList;
    private final UserList userList;
    private final CustomerList customerList;

    /**
     * Constructor for class LpPhoneMain.
     */
    public LpPhoneMain() {
        serviceList = new ServiceList();
        userList = new UserList();
        customerList = new CustomerList();
    }

    public void runProgram() {
        //login();
    }

    private boolean setActiveUser(int userId) {
        activeUser = userList.getUserById(userId);
        return true;
    }

    public HashMap getActiveUser() {
        return activeUser;
    }

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

    public String getNextContract() {
        return customerList.getNextContract();
    }

    public boolean addCustomer(HashMap customerData) {
        return customerList.add(customerData);
    }

    public CustomerList getCustomerList() {
        return customerList;
    }

    public ArrayList getCustomerList(int userId, int serviceId) {
        return customerList.filter(userId, serviceId);
    }

    public HashMap getCustomerById(int customerId) {
        return customerList.getCustomerById(customerId);
    }

    /*    public boolean changeCustomerData(Customer customer, HashMap customerData) {
     return customerList.changeCustomerData(customer, customerData);
     }
     */
    public int getCustomerNoByService(int serviceId) {
        return customerList.getCustomerNoByService(serviceId);
    }

    public UserList getUserList() {
        return userList;
    }

    public HashMap getUserById(int userId) {
        return userList.getUserById(userId);
    }
    /*
     public boolean changeUserData(User user, HashMap userData) {
     return userList.changeUserData(user, userData);
     }
     */

    public ServiceList getServiceList() {
        return serviceList;
    }

    public ArrayList getServiceById(int serviceId) {
        return serviceList.getServiceById(serviceId);
    }

    public double getServicePrice(int serviceId) {
        return serviceList.getServicePrice(serviceId);
    }

    public boolean setServicePrice(int serviceId, double price) {
        return serviceList.setServicePrice(serviceId, price);
    }
}
