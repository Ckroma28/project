package comp603;

import comp603.BlackjackGUI;
import comp603.SlotGui;
import comp603.UserDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GameSelection extends javax.swing.JPanel {

    private User user;

    public GameSelection(User user) {
        this.user = user;
        initComponents();
        updateUser(user);
    }

    public void updateUser(User user) {
        this.user = user;
        CurrentUserText.setText("User: " + user.getUsername());
        CurrentBalanceText.setText("Balance: $" + user.getBalance());
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        SlotsButton = new javax.swing.JButton();
        CoinflipButton = new javax.swing.JButton();
        BlackjackButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ChooseGameText = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        CurrentBalanceText = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        CurrentUserText = new javax.swing.JTextArea();
        QuitButton = new javax.swing.JButton();

        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));

        SlotsButton.setText("SLOTS");
        SlotsButton.setMaximumSize(new java.awt.Dimension(200, 50));
        SlotsButton.setMinimumSize(new java.awt.Dimension(200, 50));
        SlotsButton.setPreferredSize(new java.awt.Dimension(200, 50));
        SlotsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SlotsButtonActionPerformed(evt);
            }
        });

        CoinflipButton.setText("COINFLIP");
        CoinflipButton.setMaximumSize(new java.awt.Dimension(200, 50));
        CoinflipButton.setMinimumSize(new java.awt.Dimension(200, 50));
        CoinflipButton.setPreferredSize(new java.awt.Dimension(200, 50));

        BlackjackButton.setText("BLACKJACK");
        BlackjackButton.setMaximumSize(new java.awt.Dimension(200, 50));
        BlackjackButton.setMinimumSize(new java.awt.Dimension(200, 50));
        BlackjackButton.setPreferredSize(new java.awt.Dimension(200, 50));
        BlackjackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BlackjackButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        ChooseGameText.setEditable(false);
        ChooseGameText.setColumns(20);
        ChooseGameText.setFont(new java.awt.Font("Segoe UI", 0, 36));
        ChooseGameText.setRows(1);
        ChooseGameText.setText("Please choose a game");
        ChooseGameText.setMinimumSize(new java.awt.Dimension(600, 60));
        ChooseGameText.setPreferredSize(new java.awt.Dimension(600, 60));
        jScrollPane2.setViewportView(ChooseGameText);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        CurrentBalanceText.setEditable(false);
        CurrentBalanceText.setColumns(20);
        CurrentBalanceText.setRows(1);
        CurrentBalanceText.setText("Balance: ");
        CurrentBalanceText.setMaximumSize(new java.awt.Dimension(260, 40));
        CurrentBalanceText.setMinimumSize(new java.awt.Dimension(260, 40));
        CurrentBalanceText.setPreferredSize(new java.awt.Dimension(260, 40));
        jScrollPane1.setViewportView(CurrentBalanceText);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        CurrentUserText.setEditable(false);
        CurrentUserText.setColumns(20);
        CurrentUserText.setRows(1);
        CurrentUserText.setText("User: ");
        CurrentUserText.setMaximumSize(new java.awt.Dimension(260, 40));
        CurrentUserText.setMinimumSize(new java.awt.Dimension(260, 40));
        CurrentUserText.setPreferredSize(new java.awt.Dimension(260, 40));
        jScrollPane3.setViewportView(CurrentUserText);

        QuitButton.setText("QUIT");
        QuitButton.setMaximumSize(new java.awt.Dimension(200, 50));
        QuitButton.setMinimumSize(new java.awt.Dimension(200, 50));
        QuitButton.setPreferredSize(new java.awt.Dimension(200, 50));
        QuitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                QuitButtonActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(SlotsButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(CoinflipButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(BlackjackButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(QuitButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(150, Short.MAX_VALUE))
                            );
                            jPanel1Layout.setVerticalGroup(
                            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(SlotsButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(CoinflipButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(BlackjackButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(QuitButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(150, Short.MAX_VALUE))
                            );
                            GroupLayout layout = new GroupLayout(this);
                            this.setLayout(layout);
                            layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())
                            );
                            layout.setVerticalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())
                            );
                            layout.setVerticalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            );
                        }

    private void QuitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Thanks for Playing!");
        System.exit(0);
    }

    private void BlackjackButtonActionPerformed(ActionEvent evt) {
        BlackjackGUI blackjackGUI = new BlackjackGUI(user);
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.getContentPane().removeAll();
        topFrame.add(blackjackGUI);
        topFrame.validate();
        topFrame.repaint();
    }

    private void SlotsButtonActionPerformed(ActionEvent evt) {
        if (user == null) {
            JOptionPane.showMessageDialog(this, "User not initialized!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        SlotGui slotGui = new SlotGui(user);
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.getContentPane().removeAll();
        topFrame.add(slotGui);
        topFrame.validate();
        topFrame.repaint();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton BlackjackButton;
    private javax.swing.JTextArea ChooseGameText;
    private javax.swing.JButton CoinflipButton;
    private javax.swing.JTextArea CurrentBalanceText;
    private javax.swing.JTextArea CurrentUserText;
    private javax.swing.JButton QuitButton;
    private javax.swing.JButton SlotsButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration
}