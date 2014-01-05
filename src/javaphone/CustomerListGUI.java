/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaphone;

/**
 *
 * @author LimeDV
 */
public class CustomerListGUI extends javax.swing.JFrame {

    /**
     * Creates new form StartPageGUI
     */
    public CustomerListGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        menu = new javax.swing.JPanel();
        main = new javax.swing.JPanel();
        customerList = new javax.swing.JLabel();
        viewPhone = new javax.swing.JCheckBox();
        viewBradband = new javax.swing.JCheckBox();
        filterWorker = new javax.swing.JLabel();
        workerDropdown = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonStartpage = new javax.swing.JButton();
        buttonAddNewCustomer = new javax.swing.JButton();
        buttonCustomer = new javax.swing.JButton();
        buttonWorker = new javax.swing.JButton();
        buttonServices = new javax.swing.JButton();
        buttonLoggOut = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kunder | lpPhone");
        setPreferredSize(new java.awt.Dimension(1080, 720));

        menu.setAlignmentX(0.0F);
        menu.setAlignmentY(0.0F);

        main.setAlignmentY(0.0F);

        customerList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        customerList.setText("Kundlista");

        viewPhone.setText("Telefoni");

        viewBradband.setText("Bredband");

        filterWorker.setText("Filtrera för handläggare:");

        workerDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        workerDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workerDropdownActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(240, 240, 240));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kund ID", "Namn", "Telefon", "Bredband"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(240, 240, 240));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(customerList)
                        .addGap(57, 57, 57)
                        .addComponent(viewPhone)
                        .addGap(61, 61, 61)
                        .addComponent(viewBradband)
                        .addGap(65, 65, 65)
                        .addComponent(filterWorker)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(workerDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewPhone)
                    .addComponent(viewBradband)
                    .addComponent(filterWorker)
                    .addComponent(workerDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerList))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );

        buttonStartpage.setText("Startsida");
        buttonStartpage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartpageActionPerformed(evt);
            }
        });

        buttonAddNewCustomer.setText("Lägg till ny kund");
        buttonAddNewCustomer.setMaximumSize(new java.awt.Dimension(83, 25));
        buttonAddNewCustomer.setMinimumSize(new java.awt.Dimension(83, 25));
        buttonAddNewCustomer.setPreferredSize(new java.awt.Dimension(83, 25));
        buttonAddNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddNewCustomerActionPerformed(evt);
            }
        });

        buttonCustomer.setText("Kunder");
        buttonCustomer.setMaximumSize(new java.awt.Dimension(83, 25));
        buttonCustomer.setMinimumSize(new java.awt.Dimension(83, 25));
        buttonCustomer.setPreferredSize(new java.awt.Dimension(83, 25));

        buttonWorker.setText("Handläggare");
        buttonWorker.setMaximumSize(new java.awt.Dimension(83, 25));
        buttonWorker.setMinimumSize(new java.awt.Dimension(83, 25));
        buttonWorker.setPreferredSize(new java.awt.Dimension(83, 25));
        buttonWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWorkerActionPerformed(evt);
            }
        });

        buttonServices.setText("Abonemang");
        buttonServices.setMaximumSize(new java.awt.Dimension(83, 25));
        buttonServices.setMinimumSize(new java.awt.Dimension(83, 25));
        buttonServices.setPreferredSize(new java.awt.Dimension(83, 25));
        buttonServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonServicesActionPerformed(evt);
            }
        });

        buttonLoggOut.setText("Logga ut");
        buttonLoggOut.setMaximumSize(new java.awt.Dimension(83, 25));
        buttonLoggOut.setMinimumSize(new java.awt.Dimension(83, 25));
        buttonLoggOut.setPreferredSize(new java.awt.Dimension(83, 25));
        buttonLoggOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoggOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addComponent(buttonStartpage, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(menuLayout.createSequentialGroup()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonServices, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLoggOut, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAddNewCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(892, 899, Short.MAX_VALUE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addComponent(buttonStartpage, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(buttonAddNewCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(buttonCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(buttonWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(buttonServices, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(buttonLoggOut, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        jMenu1.setText("Edit");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Hjälp");

        jMenuItem1.setText("jMenuItem1");
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1102, 765));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void buttonLoggOutActionPerformed(java.awt.event.ActionEvent evt) {                                              
    System.exit(0);  
    }                                             

    private void buttonAddNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {                                                     
           dispose();
        NewCustomerGUI a = new NewCustomerGUI();
       a.setVisible(true);
    }                                                    

    private void workerDropdownActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void buttonStartpageActionPerformed(java.awt.event.ActionEvent evt) {                                                
             dispose();
        StartPageGUI s = new StartPageGUI();
       s.setVisible(true);
    }                                               

    private void buttonWorkerActionPerformed(java.awt.event.ActionEvent evt) {                                             
        dispose();
        WorkerListGUI wl = new WorkerListGUI();
       wl.setVisible(true);
    }                                            

    private void buttonServicesActionPerformed(java.awt.event.ActionEvent evt) {                                               
        dispose();
        ServicesGUI se = new ServicesGUI();
       se.setVisible(true);
    }                                              

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartPageGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton buttonAddNewCustomer;
    private javax.swing.JButton buttonCustomer;
    private javax.swing.JButton buttonLoggOut;
    private javax.swing.JButton buttonServices;
    private javax.swing.JButton buttonStartpage;
    private javax.swing.JButton buttonWorker;
    private javax.swing.JLabel customerList;
    private javax.swing.JLabel filterWorker;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel main;
    private javax.swing.JPanel menu;
    private javax.swing.JCheckBox viewBradband;
    private javax.swing.JCheckBox viewPhone;
    private javax.swing.JComboBox workerDropdown;
    // End of variables declaration                   
}
