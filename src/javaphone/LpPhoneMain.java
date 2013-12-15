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

    public LpPhoneMain() {
    }

    private boolean setActiveUser(int userId) {
        return false;
    }

    public int getActiveUser() {
        return 0;
    }

    private int login() {
        return 0;
    }

    private void runProgram() {
    }

    private boolean createServiceList() {
        new ServiceList();
        return false;
    }

    private boolean createUserList(int activeUser) {
        new UserList();
        return false;
    }

    private boolean createCustomerList() {
        new CustomerList();
        return false;
    }

    public String getNextContract() {
        return null;
    }

    public boolean addCustomer(ArrayList customerData) {
        return false;
    }

    public ArrayList getCustomerList(User user, Service service) {
        return null;
    }

    public ArrayList getCustomerData(Customer customer) {
        return null;
    }

    public boolean setCustomerData(Customer custoer, ArrayList customerData) {
        return false;
    }

    public ArrayList getUserList() {
        return null;
    }

    public ArrayList getUserData(User user) {
        return null;
    }

    public boolean setUserData(User user, ArrayList userData) {
        return false;
    }

    public String sendUserPassword(int userId) {
        return null;
    }

    public ArrayList getServiceList() {
        return null;
    }

    public double getServicePrice(Service service) {
        return 0;
    }

    public boolean setServicePrice(Service service, double price) {
        return false;
    }

    public int getCustomerNoByService(Service service) {
        return 0;
    }

}
