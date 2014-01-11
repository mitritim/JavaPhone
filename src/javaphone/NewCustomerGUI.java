/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaphone;

import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author iGroup
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

    private JTextField fieldId = new JTextField(20);
    private JTextField fieldFirstName = new JTextField(20);
    private JTextField fieldLastName = new JTextField(20);
    private JTextField fieldPersonId = new JTextField(20);
    private JTextField fieldAddress = new JTextField(20);
    private JTextField fieldZipCode = new JTextField(20);
    private JTextField fieldLocation = new JTextField(20);
    private JTextField fieldEmail = new JTextField(20);
    private JTextField fieldPhoneNumber = new JTextField(20);
    private JTextField fieldService = new JTextField(20);

    private JButton saveButton = new JButton("Spara kunden");

    /**
     * Creates new NewNewCustomer
     */
    public NewCustomerGUI(MainWindowGUI main) {
        this.main = main;
        initComponents();
    }

    private void initComponents() {
        // Sets the layout of the panel.

        setLayout(new GridLayout(1, 2));

        initLeftPanel();
        try {
            initRightPanel();
        } catch (IOException ex) {}

        add(leftPanel);
        add(rightPanel);
    }

    private void initLeftPanel() {
        // Adds some padding to the panel.
        leftPanel.setBorder(new javax.swing.border.EmptyBorder(10, 10, 10, 10));
        javax.swing.UIManager.put("Label.font", new java.awt.Font("Arial", 0, 14));

        leftPanel.setLayout(new MigLayout());

        leftPanel.add(pageTitle, "wrap, gapbottom 15");

        leftPanel.add(labelId, "align label, gapbottom 15");
        leftPanel.add(fieldId, "wrap");

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

        leftPanel.add(labelService, "align label");
        leftPanel.add(fieldService, "wrap, gapbottom 15");

        leftPanel.add(saveButton, "tag ok");
    }

    private void initRightPanel() throws IOException {

        // Adds some padding to the panel.
        rightPanel.setBorder(new javax.swing.border.EmptyBorder(10, 10, 10, 10));
        
        BufferedImage myPicture = ImageIO.read(new File((String) main
                .getController().getScannedContracts().get(0)));
         JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        rightPanel.add(picLabel);
    }
}
