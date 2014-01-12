package javaphone;

import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

/**
 *
 * @author iGroup
 */
public class StartPageGUI extends javax.swing.JPanel {

    private MainWindowGUI main;
    private JLabel welcomeText;
    private JLabel text;
    private JLabel text2;

    /**
     * Constructor for class StartPageGUI.
     */
    public StartPageGUI(MainWindowGUI main) {
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
        welcomeText.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        welcomeText.setBorder(new javax.swing.border.EmptyBorder(0, 0, 10, 0));
        
        text = new JLabel("Lpphone är ett fiktivt program för hantering "
                + "av kunder och data riktat till ett telefonbolag.");
        
        text2 = new JLabel("Copyright, iGroup 2014");

        add(welcomeText);
        add(text);
        add(text2);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }
}
