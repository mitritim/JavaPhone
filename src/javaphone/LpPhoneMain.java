/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaphone;

import java.util.ArrayList;

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
    }

    public void runProgram() {
        createServiceList();
        createUserList();
    }

    private boolean setActiveUser(int userId) {
        activeUser = userId;
        return true;
    }

    public int getActiveUser() {
        return activeUser;
    }

    private int login() {
        return 0;
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

    public boolean addCustomer(ArrayList customerData) {
        return customerList.addCustomer(customerData);
    }

    public ArrayList getCustomerList(User user, Service service) {
        return customerList.getCustomerList(user, service);
    }

    public ArrayList getCustomerData(Customer customer) {
        return customerList.getCustomerData(customer);
    }

    public boolean changeCustomerData(Customer customer, ArrayList customerData) {
        return customerList.changeCustomerData(customer, customerData);
    }

    public int getCustomerNoByService(Service service) {
        return customerList.getCustomerNoByService(service);
    }

    public ArrayList getUserList() {
        return userList.getUserList();
    }

    public ArrayList getUserData(User user) {
        return userList.getUserData(user);
    }

    public boolean changeUserData(User user, ArrayList userData) {
        return userList.changeUserData(user, userData);
    }

    public String sendUserPassword(int userId) {
        return userList.sendUserPassword(userId);
    }

    public ArrayList getServiceList() {
        return serviceList.getServiceList();
    }

    public double getServicePrice(Service service) {
        return serviceList.getServicePrice(service);
    }

    public boolean setServicePrice(Service service, double price) {
        return serviceList.setServicePrice(service, price);
    }
}
