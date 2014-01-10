/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaphone;

import static java.awt.Component.LEFT_ALIGNMENT;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Mitja
 */
public class UserListGUI extends javax.swing.JPanel {

    private MainWindowGUI main;
    private ArrayList list;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel pageTitle;
    private javax.swing.JTable table;
    private DefaultTableModel model;
    private boolean tableReady = false;

    /**
     * Creates new NewJPanel
     */
    public UserListGUI(MainWindowGUI main) {
        this.main = main;
        this.list = main.getController().getUserList();
        initComponents();
    }

    private void initComponents() {
        //Adds some padding to the panel.
        setBorder(new javax.swing.border.EmptyBorder(10, 10, 10, 10));

        //Creates a label for the page, adds it to the panel and aligns it left.
        pageTitle = new javax.swing.JLabel();
        pageTitle.setText("Handläggarlista");
        pageTitle.setAlignmentX(LEFT_ALIGNMENT);
        pageTitle.setBorder(new javax.swing.border.EmptyBorder(0, 0, 10, 0));
        add(pageTitle);

        //Creates a scroll pane, adds table to it and adds the pane to the panel.
        JScrollPane scrollPane = new JScrollPane(createTable());
        scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        scrollPane.setAlignmentX(LEFT_ALIGNMENT);
        add(scrollPane);

        //Creates a button, adds it to the panel and aligns it left.
        jButton1 = new javax.swing.JButton();
        jButton1.setText("Abonnemang");
        jButton1.setAlignmentX(LEFT_ALIGNMENT);
        add(jButton1);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private JTable createTable() {
        //Creates a table.
        String columnHeaders[] = {"Id", "Förnamn", "Efternamn", "Lösenord", "Antal reg. kunder", "Inkomster"};
        final String keys[] = {"userId", "userFirstName", "userLastName", "userPassword", "customerCount"};
        model = new DefaultTableModel(columnHeaders, list.size());
        table = new JTable(model) {
            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                switch (table.convertColumnIndexToModel(col)) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
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
                    System.out.println(list);
                    //Saves data and displays a message.

                    if (main.getController().getUserList().saveData()) {
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

        //Fills the table with data.
        for (int i = 0; i < list.size(); i++) {
            HashMap hashMap = (HashMap) list.get(i);
            for (int j = 0; j < keys.length; j++) {
                System.out.println(hashMap.get(keys[j]));
                table.setValueAt(hashMap.get(keys[j]), i, j);
            }
            table.setValueAt((int) hashMap.get(keys[keys.length - 1]) * 10 + " kr", i, keys.length);
        }
        tableReady = true;

        //Makes the table sortable.
        TableRowSorter<TableModel> sorter
                = new TableRowSorter<TableModel>(table.getModel());
        ArrayList sortKeys = new ArrayList();
        sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();
        table.setRowSorter(sorter);
        //Sets the default column to sort data by.
        table.getRowSorter().toggleSortOrder(4);

        //Filter
/*        ArrayList<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(2);
         filters.add(RowFilter.regexFilter("1", 0));
         filters.add(RowFilter.regexFilter("", 1));
         RowFilter rf = RowFilter.andFilter(filters);

         sorter.setRowFilter(rf);
         */
        return table;
    }
}
