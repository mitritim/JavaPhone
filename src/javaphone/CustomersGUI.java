package javaphone;

import static java.awt.Component.LEFT_ALIGNMENT;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel pageTitle;
    private javax.swing.JTable table;
    private DefaultTableModel model;
    private String keys[];
    private boolean tableReady = false;

    /**
     * Constructor for the class CustomersGUI
     * @param main  reference to the main window object
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
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        scrollPane.setAlignmentX(LEFT_ALIGNMENT);
        add(scrollPane);

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
                return getValueAt(0, column).getClass();
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
                    listRow.put(keys[modelColumn], table.getValueAt(row, column));

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
        TableRowSorter<TableModel> sorter
                = new TableRowSorter<TableModel>(table.getModel());
        ArrayList sortKeys = new ArrayList();
        sorter.setSortKeys(sortKeys);
        sorter.sort();
        table.setRowSorter(sorter);
        // Sets the default column to sort data by.
        //table.getRowSorter().toggleSortOrder(4);

        // Filter
/*        ArrayList<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(2);
         filters.add(RowFilter.regexFilter("1", 0));
         filters.add(RowFilter.regexFilter("", 1));
         RowFilter rf = RowFilter.andFilter(filters);

         sorter.setRowFilter(rf);
         */
        
        // Defines row editors.
/*        TableColumn serviceColumn = table.getColumnModel().getColumn(9);

        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Ingen abonnemang");
        comboBox.addItem("Telefoni");
        comboBox.addItem("Bredband");
        comboBox.addItem("Combo");

        serviceColumn.setCellEditor(new DefaultCellEditor(comboBox));
*/
        return table;
    }

    /**
     * Fills table with data or updates it.
     */
    public void fillTable() {
    
        tableReady = false;
        for (int i = 0; i < customerList.size(); i++) {
            HashMap hashMap = (HashMap) customerList.get(i);
            for (int j = 0; j < keys.length; j++) {
                table.setValueAt(hashMap.get(keys[j]), i, j);
            }
        }
        tableReady = true;
    }
}
