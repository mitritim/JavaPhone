/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaphone;

import static java.awt.Component.LEFT_ALIGNMENT;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author iGroup
 */
public class NewNewCustomer extends javax.swing.JPanel {

    private JLabel pageTitle;

    private JLabel labelId;
    private JLabel labelFirstName;
    private JLabel labelLastName;
    private JLabel labelPersonId;
    private JLabel labelAddress;
    private JLabel labelZipCode;
    private JLabel labelLocation;
    private JLabel labelEmail;
    private JLabel labelPhoneNumber;
    private JLabel labelService;
    private JLabel labelRegisteredByUser;

    private JTextField fieldId;
    private JTextField fieldFirstName;
    private JTextField fieldLastName;
    private JTextField fieldPersonId;
    private JTextField fieldAddress;
    private JTextField fieldZipCode;
    private JTextField fieldLocation;
    private JTextField fieldEmail;
    private JTextField fieldPhoneNumber;
    private JTextField fieldService;
    private JTextField fieldRegisteredByUser;

    private JButton saveButton;

    /**
     * Creates new NewNewCustomer
     */
    public NewNewCustomer() {
        initComponents();
    }

    private void initComponents() {
        //Adds some padding to the panel.
        setBorder(new javax.swing.border.EmptyBorder(10, 10, 10, 10));

        //Creates a label for the page, adds it to the panel and aligns it left.
        pageTitle = new JLabel();
        pageTitle.setText("Ny kund");
        pageTitle.setAlignmentX(LEFT_ALIGNMENT);
        pageTitle.setBorder(new javax.swing.border.EmptyBorder(0, 0, 10, 0));
        add(pageTitle);

        //Creates a button, adds it to the panel and aligns it left.
        saveButton = new javax.swing.JButton();
        saveButton.setText("Spara");
        saveButton.setAlignmentX(LEFT_ALIGNMENT);
        add(saveButton);

        fieldId = new JTextField();
        fieldId.setText("bla");
        

        fieldFirstName = new JTextField();
        fieldFirstName.setText("kklkdlskd");

        labelId = new JLabel();
        labelId.setText("Id:");

        labelFirstName = new JLabel();
        labelFirstName.setText("Förnamn:");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void setLayout() {

    }
}
