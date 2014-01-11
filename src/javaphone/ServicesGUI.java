package javaphone;

import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class ServicesGUI extends javax.swing.JPanel {

    private MainWindowGUI main;
    private ArrayList list;
    private javax.swing.JButton reportButton;
    private javax.swing.JLabel pageTitle;
    private javax.swing.JTable table;
    private DefaultTableModel model;
    private String keys[];
    private boolean tableReady = false;

    /**
     * Creates new NewJPanel
     */
    public ServicesGUI(MainWindowGUI main) {
        this.main = main;
        this.list = main.getController().getServiceList();
        initComponents();
    }

    private void initComponents() {
        // Adds some padding to the panel.
        setBorder(new javax.swing.border.EmptyBorder(10, 10, 10, 10));

        // Creates a label for the page, adds it to the panel and aligns it left.
        pageTitle = new javax.swing.JLabel();
        pageTitle.setText("Abonnemang");
        pageTitle.setAlignmentX(LEFT_ALIGNMENT);
        pageTitle.setBorder(new javax.swing.border.EmptyBorder(0, 0, 10, 0));
        add(pageTitle);

        // Creates a scroll pane, adds table to it and adds the pane to the panel.
        JScrollPane scrollPane = new JScrollPane(createTable());
        scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        scrollPane.setAlignmentX(LEFT_ALIGNMENT);
        add(scrollPane);

        // Creates a button, adds it to the panel and aligns it left.
        reportButton = new javax.swing.JButton();
        reportButton.setText("Skapa rapport för statistikbyrån");
        reportButton.setAlignmentX(LEFT_ALIGNMENT);
        add(reportButton);
        
        reportButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (main.getController().createReport()) {
                        JOptionPane.showMessageDialog(null,
                                "Rapporten skapades och sparades.",
                                "Rapport skapat",
                                JOptionPane.DEFAULT_OPTION);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Rapporten kunde inte skapas.",
                                "Felmeddelande",
                                JOptionPane.ERROR_MESSAGE);
                    }
            }
        });
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private JTable createTable() {
        // Creates a table.
        String columnHeaders[] = {"Abonnemang", "Pris", "Antal kunder", "Intäkter"};
        String mapKeys[] = {"serviceName", "servicePrice"};
        keys = mapKeys;
        model = new DefaultTableModel(columnHeaders, list.size());
        table = new JTable(model) {
            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                switch (table.convertColumnIndexToModel(col)) {
                    case 1:
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void setValueAt(Object cell, int row, int column) {
                super.setValueAt(cell, row, column);
                if (tableReady) {
                    int modelRow = table.convertRowIndexToModel(row);
                    int modelColumn = table.convertColumnIndexToModel(column);
                    HashMap listRow = (HashMap) list.get(modelRow);
                    listRow.put(keys[modelColumn], table.getValueAt(row, column));

                    // Saves data and displays a message.
                    if (main.getController().saveServiceList()) {
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

        return table;
    }

    /**
     * Fills table with data or updates it.
     */
    public void fillTable() {
        tableReady = false;
        for (int i = 0; i < list.size(); i++) {
            HashMap hashMap = (HashMap) list.get(i);
            for (int j = 0; j < keys.length; j++) {
                table.setValueAt(hashMap.get(keys[j]), i, j);
            }
            int customerCount = main.getController()
                    .getCustomerCountByService((int) hashMap.get("serviceId"));
            int income = customerCount * (int) hashMap.get("servicePrice");
            table.setValueAt(customerCount, i, keys.length);
            table.setValueAt(income, i, keys.length + 1);
        }
        tableReady = true;
    }
}
