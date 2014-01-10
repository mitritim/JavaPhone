package javaphone;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;

public class MainWindowGUI extends JPanel {

    private LpPhoneMain controller;

    public MainWindowGUI() {
        super(new GridLayout());

        controller = new LpPhoneMain();
        while(!controller.login(login()));

        //Creates and adds the tabbed pane to this panel.
        add(createTabbedPane());
    }

    private JTabbedPane createTabbedPane() {
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT) {
            @Override //Modified so that choosing the last tab exits the program.
            public void setSelectedIndex(int index) {
                if (index != 0 && index == this.getTabCount() - 1) {
                    System.exit(0);
                }
                super.setSelectedIndex(index);
            }
        };
        tabbedPane.setPreferredSize(new Dimension(800, 600));

        //Sets all tabs.
        tabbedPane.addTab("Startsida", new NewStartPageGUI(this));
        tabbedPane.addTab("Lägg till ny kund", new NewNewCustomer());
        tabbedPane.addTab("Kunder", makeTextPanel("Kundlista"));
        tabbedPane.addTab("Handläggare", new UserListGUI(this));
        tabbedPane.addTab("Abonnemang", makeTextPanel("Abonnemang"));
        tabbedPane.addTab("Logga ut", null);

        tabbedPane.setUI(new javax.swing.plaf.metal.MetalTabbedPaneUI() {
            @Override //Overrides calculateTabHeight to modify tab height.
            protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
                return super.calculateTabHeight(tabPlacement, tabIndex, fontHeight) + 30;
            }
        });

        //Enables the use of scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        return tabbedPane;
    }

    private JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        //panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    /**
     * Creates the main program window and shows it.
     */
    public static void createMainWindow() {
        //Creates and sets up the window.
        JFrame frame = new JFrame("JavaPhone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Maximizes the window.
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Adds content to the window.
        frame.add(new MainWindowGUI());

        //Displays the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createMainWindow();
    }

    /**
     * @return the controller
     */
    public LpPhoneMain getController() {
        return controller;
    }

    /**
     * @param controller the controller to set
     */
    public void setController(LpPhoneMain controller) {
        this.controller = controller;
    }
    
    public HashMap login() {
        final JTextField username = new JTextField();
        final JTextField password = new JPasswordField();
        Object[] message = {"Användarnamn:", username, "Lösenord:", password};
        HashMap loginData = new HashMap();

        UIManager.put("OptionPane.okButtonText", "Logga in");
        UIManager.put("OptionPane.cancelButtonText", "Avbryt");
        final JOptionPane optionPane = new JOptionPane();
        int option = optionPane.showConfirmDialog(null, message, "Logga in", JOptionPane.CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            loginData.put("userName", username.getText());
            loginData.put("password", password.getText());
            return loginData;
        }
        return null;
    }
}
