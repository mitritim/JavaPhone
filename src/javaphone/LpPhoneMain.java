package javaphone;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author iGroup
 */
public class LpPhoneMain {

    private int activeUser;
    private ServiceList serviceList;
    private UserList userList;
    private CustomerList customerList;

    public LpPhoneMain() {
        createServiceList();
        createUserList();
        createCustomerList();
    }

    public void runProgram() {
        PhoneMenu.printLogin(); //hur får jag tillbaka inloggningsuppgifter?
        //login();
    }

    private boolean setActiveUser(int userId) {
        activeUser = userId;
        return true;
    }

    public int getActiveUser() {
        return activeUser;
    }

    private boolean login(int userId, String password) {
        if (sendUserPassword(userId).equals(password)) {
            setActiveUser(userId);
            return true;
        } else {
            return false;
        }
    }

    private boolean createServiceList() {
        serviceList = new ServiceList();
        return true;
    }

    private boolean createUserList() {
        userList = new UserList();
        return true;
    }

    private boolean createCustomerList() {
        customerList = new CustomerList();
        return true;
    }

    public String getNextContract() {
        return customerList.getNextContract();
    }

    public boolean addCustomer(HashMap customerData) {
        return customerList.add(customerData);
    }

    public ArrayList getCustomerList(User user, Service service) {
        return customerList.filter(user, service);
    }

    public ArrayList getCustomerData(Customer customer) {
        return customerList.getCustomerData(customer);
    }

    public boolean changeCustomerData(Customer customer, HashMap customerData) {
        return customerList.changeCustomerData(customer, customerData);
    }

    public int getCustomerNoByService(Service service) {
        return customerList.getCustomerNoByService(service);
    }

    public ArrayList getUserList() {
        return userList;
    }

    public ArrayList getUserData(User user) {
        return userList.getUserData(user);
    }

    public boolean changeUserData(User user, HashMap userData) {
        return userList.changeUserData(user, userData);
    }

    public String sendUserPassword(int userId) {
        return userList.sendUserPassword(userId);
    }

    public ArrayList getServiceList() {
        return serviceList;
    }

    public double getServicePrice(Service service) {
        return serviceList.getServicePrice(service);
    }

    public boolean setServicePrice(Service service, double price) {
        return serviceList.setServicePrice(service, price);
    }
}
