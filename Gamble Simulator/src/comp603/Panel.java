package comp603;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends javax.swing.JPanel {

    User user;

    public Panel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        WelcomeText = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        UsernameText = new javax.swing.JTextArea();
        EnterButton = new javax.swing.JButton();
        UsernameBox = new javax.swing.JTextField();

        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        WelcomeText.setEditable(false);
        WelcomeText.setColumns(20);
        WelcomeText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        WelcomeText.setRows(5);
        WelcomeText.setText("Welcome to the Gambling Simulator!");
        WelcomeText.setMinimumSize(new java.awt.Dimension(600, 240));
        WelcomeText.setPreferredSize(new java.awt.Dimension(600, 240));
        jScrollPane1.setViewportView(WelcomeText);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        UsernameText.setEditable(false);
        UsernameText.setColumns(20);
        UsernameText.setRows(5);
        UsernameText.setText("Please enter your username below");
        UsernameText.setMaximumSize(new java.awt.Dimension(2480, 80));
        UsernameText.setMinimumSize(new java.awt.Dimension(260, 80));
        UsernameText.setPreferredSize(new java.awt.Dimension(260, 80));
        jScrollPane2.setViewportView(UsernameText);

        EnterButton.setText("ENTER");
        EnterButton.setMaximumSize(new java.awt.Dimension(100, 20));
        EnterButton.setMinimumSize(new java.awt.Dimension(100, 20));
        EnterButton.setPreferredSize(new java.awt.Dimension(100, 20));
        EnterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                EnterButtonActionPerformed(evt);
            }
        });

        UsernameBox.setBackground(new java.awt.Color(255, 255, 255));
        UsernameBox.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(EnterButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsernameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(200, 200, 200))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(UsernameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EnterButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
    }// </editor-fold>                         

    private void EnterButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String name = UsernameBox.getText();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!UserFileHandler.userExists(name)) {
            JOptionPane.showMessageDialog(this, "Username not found, creating new user...");
            User newUser = new User(name);
            UserFileHandler.updateUserData(newUser, 1000);
            user = newUser;
        } else {
            user = UserFileHandler.loadUsersData(name);
            JOptionPane.showMessageDialog(this, "Welcome " + user.getUsername() + ", Your current balance is : $" + user.getBalance());
        }
        
        GameSelection gameSelection = new GameSelection();
        gameSelection.updateUser(user);
        
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.getContentPane().removeAll();
        topFrame.getContentPane().add(gameSelection);
        topFrame.revalidate();
        topFrame.repaint();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton EnterButton;
    private javax.swing.JTextField UsernameBox;
    private javax.swing.JTextArea UsernameText;
    private javax.swing.JTextArea WelcomeText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration                   
}
