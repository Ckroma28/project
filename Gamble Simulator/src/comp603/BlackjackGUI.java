package comp603;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.*;

public class BlackjackGUI extends JPanel {

    private JPanel gamePanel;
    GameSelection parentPanel;

    public BlackjackGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        WelcomeText = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        ExplainText = new javax.swing.JTextArea();
        YesButton = new javax.swing.JButton();
        NoButton = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setMinimumSize(new java.awt.Dimension(1000, 500));
        setPreferredSize(new java.awt.Dimension(1000, 500));

        MainPanel.setMaximumSize(new java.awt.Dimension(1000, 500));
        MainPanel.setMinimumSize(new java.awt.Dimension(1000, 500));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        WelcomeText.setEditable(false);
        WelcomeText.setColumns(20);
        WelcomeText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        WelcomeText.setRows(5);
        WelcomeText.setText("Welcome to Blackjack!");
        WelcomeText.setBorder(null);
        jScrollPane1.setViewportView(WelcomeText);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        ExplainText.setEditable(false);
        ExplainText.setColumns(20);
        ExplainText.setRows(5);
        ExplainText.setText("Would you like an explanation of how to play the game?");
        ExplainText.setBorder(null);
        jScrollPane2.setViewportView(ExplainText);

        YesButton.setText("Yes");
        YesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YesButtonActionPerformed(evt);
            }
        });

        NoButton.setText("No");
        NoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                .addContainerGap(315, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(315, 315, 315))
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(345, 345, 345)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(85, 85, 85)
                                                .addComponent(YesButton)
                                                .addGap(39, 39, 39)
                                                .addComponent(NoButton))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(YesButton)
                                        .addComponent(NoButton))
                                .addContainerGap(139, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

    }// </editor-fold>

    private void YesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String explanation = "<html><body style='width: 300px; padding: 10px;'>"
                + "<h2>How to Play Blackjack</h2>"
                + "<p>The goal of blackjack is to get your count closest to 21.</p>"
                + "<p>The user and dealer both get 2 cards each.</p>"
                + "<p>The user must get a higher count than the dealer to win.</p>"
                + "<p>If the user has a smaller count value than the dealer they lose.</p>"
                + "<p>Each card is worth what the rank is (e.g., 9 is worth 9 counts).</p>"
                + "<p>Cards such as Jack, Queen or King have a count value of 10.</p>"
                + "<p>Ace cards work differently.</p>"
                + "<p>If a hand with 2 cards and one of those cards is an Ace,</p>"
                + "<p>The Ace is worth 11 counts. If a hand has more than 2 cards,</p>"
                + "<p>The Ace is worth 1 count.</p>"
                + "</body></html>";

        JOptionPane.showMessageDialog(this, explanation, "Blackjack Rules", JOptionPane.INFORMATION_MESSAGE);
        switchToGameFrame();
    }

    private void NoButtonActionPerformed(java.awt.event.ActionEvent evt) {
        switchToGameFrame();
    }

    private void switchToGameFrame() {
        gamePanel = new gamePanel(parentPanel);
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.getContentPane().removeAll();
        topFrame.getContentPane().add(gamePanel);
        topFrame.revalidate();
        topFrame.repaint();
    }

    // Variables declaration - do not modify
    private javax.swing.JTextArea ExplainText;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton NoButton;
    private javax.swing.JTextArea WelcomeText;
    private javax.swing.JButton YesButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration       
}
