package comp603;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GameSelection extends javax.swing.JPanel {

    User user;
    CoinflipGUI coinflipGUI;

    public GameSelection() {
        initComponents();
        coinflipGUI = new CoinflipGUI(this); 
    }

    public void updateUser(User user) {
        this.user = user;
        CurrentUserText.setText("User: " + user.getUsername());
        CurrentBalanceText.setText("Balance: $" + user.getBalance());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
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
        CoinflipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CoinflipButtonActionPerformed(evt);
            }
        });

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
        ChooseGameText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
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
        
        QuitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SlotsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CoinflipButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BlackjackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(QuitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE) 
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SlotsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CoinflipButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BlackjackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>

    private void QuitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Thanks for Playing!");
        System.exit(0);
    }

    private void BlackjackButtonActionPerformed(ActionEvent evt) {
        BlackjackGUI blackjackGUI = new BlackjackGUI();

        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.getContentPane().removeAll();
        topFrame.add(blackjackGUI);
        topFrame.validate();
        topFrame.repaint();
    }

    private void CoinflipButtonActionPerformed(ActionEvent evt) {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.getContentPane().removeAll();
        topFrame.add(coinflipGUI);
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
    javax.swing.JButton BlackjackButton;
    javax.swing.JTextArea ChooseGameText;
    javax.swing.JButton CoinflipButton;
    javax.swing.JTextArea CurrentBalanceText;
    javax.swing.JTextArea CurrentUserText;
    javax.swing.JButton QuitButton;
    javax.swing.JButton SlotsButton;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration
}
