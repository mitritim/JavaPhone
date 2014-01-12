package javaphone;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 * This class is responsible for providing a user interface for creating a new
 * customer. A scanned contract is shown to provide easier input.
 *
 * @author iGroup
 * @version 2014-01-12
 */
public class NewCustomerGUI extends javax.swing.JPanel {

    private MainWindowGUI main;

    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();

    private JLabel pageTitle = new JLabel("Ny kund");

    private JLabel labelId = new JLabel("Id:");
    private JLabel labelFirstName = new JLabel("Förnamn:");
    private JLabel labelLastName = new JLabel("Efternamn:");
    private JLabel labelPersonId = new JLabel("Personnummer:");
    private JLabel labelAddress = new JLabel("Adress:");
    private JLabel labelZipCode = new JLabel("Postnummer:");
    private JLabel labelLocation = new JLabel("Ort:");
    private JLabel labelEmail = new JLabel("E-mail:");
    private JLabel labelPhoneNumber = new JLabel("Telefonnummer:");
    private JLabel labelService = new JLabel("Abonnemang:");

    private JTextField fieldId = new JTextField(5);
    private JTextField fieldFirstName = new JTextField(20);
    private JTextField fieldLastName = new JTextField(20);
    private JTextField fieldPersonId = new JTextField(20);
    private JTextField fieldAddress = new JTextField(20);
    private JTextField fieldZipCode = new JTextField(20);
    private JTextField fieldLocation = new JTextField(20);
    private JTextField fieldEmail = new JTextField(20);
    private JTextField fieldPhoneNumber = new JTextField(20);
    private JComboBox fieldService;

    private JButton saveButton = new JButton("Spara kunden");

    private JLabel picLabel;

    /**
     * Constructor for the class NewCustomer
     *
     * @param main reference to the main window object
     */
    public NewCustomerGUI(MainWindowGUI main) {
        this.main = main;
        initComponents();
    }

    private void initComponents() {
        // Sets the layout of the panel.

        //setLayout(new GridLayout(1, 2));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        initLeftPanel();
        initRightPanel();

        add(leftPanel);
        add(rightPanel);
    }

    private void initLeftPanel() {
        // Adds some padding to the panel.
        leftPanel.setBorder(new javax.swing.border.EmptyBorder(10, 10, 10, 10));
        leftPanel.setAlignmentY(TOP_ALIGNMENT);

        javax.swing.UIManager.put("Label.font", new java.awt.Font("Arial", 0, 14));

        leftPanel.setLayout(new MigLayout());

        leftPanel.add(pageTitle, "wrap, gapbottom 15");

        leftPanel.add(labelId, "align label, gapbottom 15");
        leftPanel.add(fieldId, "wrap");
        fieldId.setEditable(false);
        fieldId.setText(Integer.toString(main.getController().getCustomerList().size() + 1));

        leftPanel.add(labelFirstName, "align label");
        leftPanel.add(fieldFirstName, "wrap");

        leftPanel.add(labelLastName, "align label");
        leftPanel.add(fieldLastName, "wrap");

        leftPanel.add(labelPersonId, "align label");
        leftPanel.add(fieldPersonId, "wrap, gapbottom 15");

        leftPanel.add(labelAddress, "align label");
        leftPanel.add(fieldAddress, "wrap");

        leftPanel.add(labelZipCode, "align label");
        leftPanel.add(fieldZipCode, "wrap");

        leftPanel.add(labelLocation, "align label");
        leftPanel.add(fieldLocation, "wrap, gapbottom 15");

        leftPanel.add(labelEmail, "align label");
        leftPanel.add(fieldEmail, "wrap");

        leftPanel.add(labelPhoneNumber, "align label");
        leftPanel.add(fieldPhoneNumber, "wrap, gapbottom 15");

        String fields[] = {"Inget abonnemang", "Telefoni", "Bredband", "Combo"};
        fieldService = new JComboBox(fields);
        leftPanel.add(labelService, "align label");
        leftPanel.add(fieldService, "wrap, gapbottom 15");

        leftPanel.add(saveButton, "tag ok");

        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                newCustomer();
            }
        });
    }

    private void initRightPanel() {

        // Adds some padding to the panel.
        rightPanel.setBorder(new javax.swing.border.EmptyBorder(10, 10, 10, 10));
        rightPanel.setAlignmentY(TOP_ALIGNMENT);
        initNextContract();
        rightPanel.add(picLabel);
    }

    private void newCustomer() {
        if (checkInput()) {
            HashMap customer = new HashMap();

            customer.put("customerId", fieldId.getText());
            customer.put("customerFirstName", fieldFirstName.getText());
            customer.put("customerLastName", fieldLastName.getText());
            customer.put("customerPersonId", fieldPersonId.getText());
            customer.put("customerAdress", fieldAddress.getText());
            customer.put("customerZipCode", fieldZipCode.getText());
            customer.put("customerLocation", fieldLocation.getText());
            customer.put("customerEmail", fieldEmail.getText());
            customer.put("customerPhoneNumber", fieldPhoneNumber.getText());
            customer.put("serviceId", fieldService.getSelectedIndex());
            customer.put("userId", main.getController().getActiveUser().get("userId"));

            if (main.getController().addCustomer(customer) && main.getController().saveCustomerList()) {
                JOptionPane.showMessageDialog(null,
                        "Den nya användaren skapades och sparades.",
                        "Anändaren skapades",
                        JOptionPane.DEFAULT_OPTION);
                
                // Updates all panes.
                main.updatePanes();

                // Moves and renames the contract file.
                if (main.getController().getScannedContracts().size() != 0) {
                    try {
                        Path sourcePath = Paths.get((String) main.getController().getScannedContracts().get(0));
                        String targetURI = "Registrerade avtal/" + fieldId.getText() + ".jpg";
                        Path targetPath = Paths.get(targetURI);
                        Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException ex) {
                        Logger.getLogger(NewCustomerGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                // The scanned image is first removed and a new one shown.
                rightPanel.remove(picLabel);
                initNextContract();
                rightPanel.add(picLabel);
                rightPanel.revalidate();
                rightPanel.repaint();

            } else {
                JOptionPane.showMessageDialog(null,
                        "Användaren kunde inte skapas.",
                        "Felmeddelande",
                        JOptionPane.ERROR_MESSAGE);
            }

            // Clears all fields.
            fieldId.setText(Integer.toString(
                    main.getController().getCustomerList().size() + 1));
            fieldFirstName.setText("");
            fieldLastName.setText("");
            fieldPersonId.setText("");
            fieldAddress.setText("");
            fieldZipCode.setText("");
            fieldLocation.setText("");
            fieldEmail.setText("");
            fieldPhoneNumber.setText("");
            fieldService.setSelectedIndex(0);
        }
    }

    private boolean checkInput() {
        if (!fieldId.getText().equals("")
                && !fieldFirstName.getText().equals("")
                && !fieldLastName.getText().equals("")
                && !fieldPersonId.getText().equals("")
                && !fieldAddress.getText().equals("")
                && !fieldZipCode.getText().equals("")
                && !fieldLocation.getText().equals("")
                && !fieldEmail.getText().equals("")
                && !fieldPhoneNumber.getText().equals("")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Alla fält måste vara ifyllda.",
                    "Felmeddelande",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void initNextContract() {
        ArrayList<String> scannedContracts = main.getController().getScannedContracts();

        if (scannedContracts.size() != 0) {
            ImageIcon image = new ImageIcon((String) scannedContracts.get(0));
            picLabel = new JLabel("", image, JLabel.CENTER);
        } else {
            picLabel = new JLabel("Det finns inga inscannade avtal att visa.");
        }
    }
}
