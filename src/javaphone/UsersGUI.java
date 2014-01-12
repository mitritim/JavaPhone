package javaphone;

// <editor-fold defaultstate="collapsed" desc=" Imports ">
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.table.*;
import net.miginfocom.swing.MigLayout;
//</editor-fold>

/**
 * This class prepares a JPanel object to be shown in the tab that is
 * responsible for showing and editing program's users.
 *
 * @author iGroup
 * @version 2014-01-12
 */
public class UsersGUI extends javax.swing.JPanel {

    private MainWindowGUI main;
    private JFrame newUserFrame;
    private ArrayList userList;
    private javax.swing.JButton newUserButton;
    private javax.swing.JLabel pageTitle;
    private javax.swing.JTable table;
    private DefaultTableModel model;
    private String keys[];
    private boolean tableReady = false;

    private JLabel newUserTitle = new JLabel("Ny handläggare");

    private JLabel labelId = new JLabel("Id:");
    private JLabel labelFirstName = new JLabel("Förnamn:");
    private JLabel labelLastName = new JLabel("Efternamn:");
    private JLabel labelPassword = new JLabel("Lösenord:");

    private JTextField fieldId = new JTextField(5);
    private JTextField fieldFirstName = new JTextField(20);
    private JTextField fieldLastName = new JTextField(20);
    private JTextField fieldPassword = new JTextField(20);

    private JButton saveButton = new JButton("Spara handläggare");

    /**
     * Constructor for the classNewJPanel
     *
     * @param main reference to the main window object
     */
    public UsersGUI(MainWindowGUI main) {
        this.main = main;
        this.newUserFrame = createNewUserFrame();
        this.userList = main.getController().getUserList();
        initComponents();
    }

    private void initComponents() {
        // Adds some padding to the panel.
        setBorder(new javax.swing.border.EmptyBorder(10, 10, 10, 10));

        // Creates a label for the page, adds it to the panel and aligns it left.
        pageTitle = new javax.swing.JLabel();
        pageTitle.setText("Handläggare");
        pageTitle.setAlignmentX(LEFT_ALIGNMENT);
        pageTitle.setBorder(new javax.swing.border.EmptyBorder(0, 0, 10, 0));
        add(pageTitle);

        // Creates a scroll pane, adds table to it and adds the pane to the panel.
        JScrollPane scrollPane = new JScrollPane(createTable());
        scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        scrollPane.setAlignmentX(LEFT_ALIGNMENT);
        add(scrollPane);

        // Creates a button, adds it to the panel and aligns it left.
        newUserButton = new javax.swing.JButton();
        newUserButton.setText("Ny handläggare");
        newUserButton.setAlignmentX(LEFT_ALIGNMENT);
        add(newUserButton);
        newUserButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showNewUserFrame();
            }
        });

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private JTable createTable() {
        // Creates a table.
        String columnHeaders[] = {"Id", "Förnamn", "Efternamn", "Lösenord", "Antal reg. kunder", "Inkomster"};
        String mapKeys[] = {"userId", "userFirstName", "userLastName", "userPassword"};
        keys = mapKeys;
        model = new DefaultTableModel(columnHeaders, userList.size());
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
                    HashMap listRow = (HashMap) userList.get(modelRow);
                    listRow.put(keys[modelColumn], table.getValueAt(row, column));

                    // Saves data and displays a message.
                    if (main.getController().saveUserList()) {
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
        sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();
        table.setRowSorter(sorter);
        // Sets the default column to sort data by.
        table.getRowSorter().toggleSortOrder(4);

        return table;
    }

    /**
     * Fills table with data or updates it.
     */
    public void fillTable() {
        tableReady = false;
        for (int i = 0; i < userList.size(); i++) {
            HashMap hashMap = (HashMap) userList.get(i);
            for (int j = 0; j < keys.length; j++) {
                table.setValueAt(hashMap.get(keys[j]), i, j);
            }
            int customerCount = main.getController().getCustomerCountByUser(i + 1);
            table.setValueAt(customerCount, i, keys.length);
            table.setValueAt(customerCount * 10 + " kr", i, keys.length + 1);
        }
        tableReady = true;
    }

    private JFrame createNewUserFrame() {
        JFrame frame = new JFrame("Ny handläggare");

        //frame.setBorder(new javax.swing.border.EmptyBorder(10, 10, 10, 10));
        javax.swing.UIManager.put("Label.font", new java.awt.Font("Arial", 0, 14));

        frame.setLayout(new MigLayout());

        frame.add(newUserTitle, "wrap, gapbottom 15");
        newUserTitle.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));

        frame.add(labelId, "align label");
        frame.add(fieldId, "wrap");
        fieldId.setEditable(false);
        fieldId.setText(Integer.toString(main.getController().getUserList().size() + 1));

        frame.add(labelFirstName, "align label");
        frame.add(fieldFirstName, "wrap");

        frame.add(labelLastName, "align label");
        frame.add(fieldLastName, "wrap");

        frame.add(labelPassword, "align label");
        frame.add(fieldPassword, "wrap, gapbottom 15");

        frame.add(saveButton, "skip 1, tag ok");

        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                newUser();
            }
        });

        frame.pack();
        return frame;
    }

    private void showNewUserFrame() {
        newUserFrame.setVisible(true);
    }

    private void newUser() {
        if (checkInput()) {
            HashMap user = new HashMap();

            user.put("userId", fieldId.getText());
            user.put("userFirstName", fieldFirstName.getText());
            user.put("userLastName", fieldLastName.getText());
            user.put("userPassword", fieldPassword.getText());

            if (main.getController().addUser(user) && main.getController().saveUserList()) {
                JOptionPane.showMessageDialog(null,
                        "En ny handläggare skapades och sparades.",
                        "Handläggaren skapades",
                        JOptionPane.DEFAULT_OPTION);
                // Updates tables.
/*
                 main.updateCustomersGUI(); 
                 main.updateServicesGUI();
                 main.updateUsersGUI();
                 */
            } else {
                JOptionPane.showMessageDialog(null,
                        "Handläggaren kunde inte skapas.",
                        "Felmeddelande",
                        JOptionPane.ERROR_MESSAGE);
            }
            
            // Updates all panes.
            main.updatePanes();
            
            // Clears all fields.
            fieldId.setText(Integer.toString(
                    main.getController().getUserList().size() + 1));
            fieldFirstName.setText("");
            fieldLastName.setText("");
            fieldPassword.setText("");
            
            // Hides the frame.
            newUserFrame.setVisible(false);
        }
    }

    private boolean checkInput() {
        if (!fieldId.getText().equals("")
                && !fieldFirstName.getText().equals("")
                && !fieldLastName.getText().equals("")
                && !fieldPassword.getText().equals("")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Alla fält måste vara ifyllda.",
                    "Felmeddelande",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
