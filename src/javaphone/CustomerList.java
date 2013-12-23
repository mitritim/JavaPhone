/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaphone;

import java.util.ArrayList;

/**
 *
 * @author Mitja
 */
public class CustomerList {

    private ArrayList<Customer> customerList;
    private ArrayList<Customer> filteredCustomerList;

    public CustomerList() {
        //get customerList from file
    }

    public ArrayList<Customer> getCustomerList(User user, Service service) {
        return filteredCustomerList;
    }

    public boolean addCustomer(ArrayList customerData) {
        return true;
    }

    public ArrayList getCustomerData(Customer customer) {
        return null;
    }
    public boolean changeCustomerData(Customer customer, ArrayList customerData) {
        return true;
    }

    public int getCustomerNoByService(Service service) {
        return 0;
    }

    public boolean prepareReport() {
        ArrayList<ArrayList<Object>> reportData = new ArrayList<>();
        new StatisticsReport(reportData);
        return true;
    }

    public String getNextContract() {
        return null;
    }

}
