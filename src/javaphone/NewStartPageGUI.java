package javaphone;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

/**
 *
 * @author iGroup
 */
public class NewStartPageGUI extends javax.swing.JPanel {

    private MainWindowGUI main;
    private JLabel welcomeText;
    private JLabel text;
    private JLabel text2;

    /**
     * Constructor for class StartPageGUI.
     */
    public NewStartPageGUI(MainWindowGUI main) {
        this.main = main;
        initComponents();
    }

    /**
     * Initializes all components.
     */
    private void initComponents() {
        //Adds some padding to the panel.
        setBorder(new javax.swing.border.EmptyBorder(10, 10, 10, 10));
        
        //Changes the default font for all labels.
        //javax.swing.UIManager.put("Label.font", new java.awt.Font("Arial", 0, 12));
        
        welcomeText = new JLabel("Hej " 
                + main.getController().getActiveUser().get("userFirstName") 
                + ", välkommen till JavaPhone!");
        welcomeText.setFont(new java.awt.Font("Tahoma", 0, 14));
        welcomeText.setBorder(new javax.swing.border.EmptyBorder(0, 0, 10, 0));
        
        text = new JLabel("För att komma igång kan du behöva lite bla bla bla "
                + "imnfop som di lätt kan få genom att kanske fråga någon.");
        
        text2 = new JLabel("Genom att bara gå till någon sida eller något, "
                + "inta fan vet jag, sluta fråga så mycket fråfor ");

        add(welcomeText);
        add(text);
        add(text2);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }
}
