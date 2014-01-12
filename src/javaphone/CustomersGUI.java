package javaphone;

import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

/**
 * This class prepares a JPanel object to be shown in the tab that is
 * responsible for showing and editing program's users.
 *
 * @author iGroup
 */
public class CustomersGUI extends javax.swing.JPanel {

    private MainWindowGUI main;
    private ArrayList customerList;
    private JButton jButton1;
    private JLabel pageTitle;
    private JTable table;
    private JScrollPane scrollPane;

    private JPanel filterPanel = new JPanel();
    private JComboBox serviceBox;
    private JComboBox userBox;

    private DefaultTableModel model;
    private String keys[];
    private boolean tableReady = false;
    private TableRowSorter<TableModel> sorter;

    /**
     * Constructor for the class CustomersGUI
     *
     * @param main reference to the main window object
     */
    public CustomersGUI(MainWindowGUI main) {
        this.main = main;
        this.customerList = main.getController().getCustomerList();
        initComponents();
    }

    private void initComponents() {
        // Adds some padding to the panel.
        setBorder(new javax.swing.border.EmptyBorder(10, 10, 10, 10));

        // Creates a label for the page, adds it to the panel and aligns it left.
        pageTitle = new javax.swing.JLabel();
        pageTitle.setText("Kunder");
        pageTitle.setAlignmentX(LEFT_ALIGNMENT);
        pageTitle.setBorder(new javax.swing.border.EmptyBorder(0, 0, 10, 0));
        add(pageTitle);

        // Creates a scroll pane, adds table to it and adds the pane to the panel.
        createTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        scrollPane.setAlignmentX(LEFT_ALIGNMENT);
        add(scrollPane);

        // Creates the panel with the filters.
        initFilterPanel();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public JTable createTable() {
        // Creates a table.
        String columnHeaders[] = {"Id", "Förnamn", "Efternamn", "Personnummer",
            "Address", "Postnummer", "Ort", "E-mail", "Telefonnummer",
            "Abonnemang", "Registrerad av"};
        String mapKeys[] = {"customerId", "customerFirstName", "customerLastName",
            "customerPersonId", "customerAdress", "customerZipCode", "customerLocation",
            "customerEmail", "customerPhoneNumber", "serviceId", "userId"};
        keys = mapKeys;
        model = new DefaultTableModel(columnHeaders, customerList.size());
        table = new JTable(model) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    default:
                        return String.class;
                }
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                switch (table.convertColumnIndexToModel(col)) {
                    case 0:
                    case 10:
                        return false;
                    default:
                        return true;
                }
            }

            @Override
            public void setValueAt(Object cell, int row, int column) {
                super.setValueAt(cell, row, column);
                if (tableReady) {
                    int modelRow = table.convertRowIndexToModel(row);
                    int modelColumn = table.convertColumnIndexToModel(column);
                    HashMap listRow = (HashMap) customerList.get(modelRow);
                    if (modelColumn == 9) {
                        listRow.put(keys[modelColumn], (int) getServiceIdByName((String) table.getValueAt(row, column)));
                    } else {
                        listRow.put(keys[modelColumn], table.getValueAt(row, column));
                    }

                    // Saves data and displays a message.
                    if (main.getController().saveCustomerList()) {
                        JOptionPane.showMessageDialog(this,
                                "Ändringen sparades",
                                "Ändringen sparades",
                                JOptionPane.DEFAULT_OPTION);
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Ändringen kunde inte sparas",
                                "Felmeddelande",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    main.updateServicesGUI();
                    main.updateUsersGUI();
                }
            }
        };

        // Fills the table with data.
        fillTable();

        // Makes the table sortable.
        sorter = new TableRowSorter<TableModel>(table.getModel());
        ArrayList sortKeys = new ArrayList();
        sorter.setSortKeys(sortKeys);
        sorter.sort();
        table.setRowSorter(sorter);

        // Defines row editors.
        TableColumn serviceColumn = table.getColumnModel().getColumn(9);
        JComboBox comboBox = new JComboBox(getServiceNames());
        serviceColumn.setCellEditor(new DefaultCellEditor(comboBox));

        return table;
    }

    /**
     * Fills table with data or updates it.
     */
    public void fillTable() {
        tableReady = false;
        for (int i = 0; i < customerList.size(); i++) {
            HashMap hashMap = (HashMap) customerList.get(i);
            for (int j = 0; j < keys.length - 2; j++) {
                table.setValueAt(hashMap.get(keys[j]), i, j);
            }
            table.setValueAt(getServiceNames()[(int) hashMap.get("serviceId")], i, keys.length - 2);
            table.setValueAt(getUserNames()[(int) hashMap.get("userId")], i, keys.length - 1);
        }
        tableReady = true;
    }

    private String[] getServiceNames() {
        String[] serviceNames = new String[main.getController().getServiceList().size() + 1];
        ArrayList<String> names = new ArrayList();
        names.add("Inget abonnemang");
        for (HashMap service : main.getController().getServiceList()) {
            names.add((String) service.get("serviceName"));
        }
        names.toArray(serviceNames);
        return serviceNames;
    }

    private int getServiceIdByName(String serviceName) {
        for (HashMap service : main.getController().getServiceList()) {
            if (serviceName.equals(service.get("serviceName"))) {
                return (int) service.get("serviceId");
            }
        }
        return 0;
    }

    private String[] getUserNames() {
        String[] serviceNames = new String[main.getController().getUserList().size() + 1];
        ArrayList<String> names = new ArrayList();
        names.add("Ingen handläggare");
        for (HashMap user : main.getController().getUserList()) {
            String userFirstName = (String) user.get("userFirstName");
            String userLastName = (String) user.get("userLastName");
            names.add(userLastName + ", " + userFirstName);
        }
        names.toArray(serviceNames);
        return serviceNames;
    }

    private void filter(String serviceName, String userName) {

        ArrayList<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(2);

        if (serviceName.equals("Alla abonnemang")) {
            serviceName = "";
        }

        if (userName.equals("Alla handläggare")) {
            userName = "";
        }

        filters.add(RowFilter.regexFilter(serviceName, 9));
        filters.add(RowFilter.regexFilter(userName, 10));
        RowFilter rf = RowFilter.andFilter(filters);

        sorter.setRowFilter(rf);
    }

    private void initFilterPanel() {
        filterPanel.setAlignmentX(LEFT_ALIGNMENT);

        ActionListener comboBoxChange = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filter((String) serviceBox.getSelectedItem(),
                        (String) userBox.getSelectedItem());
            }
        };

        JLabel labelFilterService = new JLabel("Visa kunder med abonnemang:");

        String serviceNames[] = getServiceNames();
        serviceNames[0] = "Alla abonnemang";
        serviceBox = new JComboBox(serviceNames);
        serviceBox.addActionListener(comboBoxChange);

        JLabel labelFilterUser = new JLabel("Visa kunder som registrerades av:");
        labelFilterUser.setBorder(new EmptyBorder(0, 50, 0, 0));

        String userNames[] = getUserNames();
        userNames[0] = "Alla handläggare";
        userBox = new JComboBox(userNames);
        userBox.addActionListener(comboBoxChange);

        filterPanel.add(labelFilterService);
        filterPanel.add(serviceBox);
        filterPanel.add(labelFilterUser);
        filterPanel.add(userBox);

        add(filterPanel);
    }

    public void updateTable() {
        remove(scrollPane);
        createTable();
        add(scrollPane);
        revalidate();
        repaint();
    }
}
