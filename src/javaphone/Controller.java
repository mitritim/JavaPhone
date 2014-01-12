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
     * Constructor for class LpPhoneMain.
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

    public boolean addCustomer(HashMap customerData) {
        return customerList.add(customerData);
    }

    public CustomerList getCustomerList() {
        return customerList;
    }

    public HashMap getCustomerById(int customerId) {
        return customerList.getCustomerById(customerId);
    }

    public int getCustomerCountByService(int serviceId) {
        return customerList.getCustomerCountByService(serviceId);
    }
    
    public int getCustomerCountByUser(int userId) {
        return customerList.getCustomerCountByUser(userId);
    }

    public boolean saveCustomerList() {
        return customerList.saveData();
    }

    public UserList getUserList() {
        return userList;
    }

    public boolean addUser(HashMap user) {
        return userList.add(user);
    }
    public HashMap getUserById(int userId) {
        return userList.getUserById(userId);
    }

    public boolean saveUserList() {
        return userList.saveData();
    }

    public ServiceList getServiceList() {
        return serviceList;
    }

    public HashMap getServiceById(int serviceId) {
        return serviceList.getServiceById(serviceId);
    }

    public boolean saveServiceList() {
        return serviceList.saveData();
    }
    
    public boolean createReport() {
        HashMap customerCountByService = new HashMap();
        for (HashMap service : serviceList) {
            int serviceId = (int) service.get("serviceId");
            customerCountByService
                    .put(serviceId, getCustomerCountByService(serviceId));
        }
        return serviceList.createReport(customerCountByService);
    }
    
    public ArrayList getScannedContracts() {
        return customerList.getFileList("Nya avtal", "jpg");
    }
}
