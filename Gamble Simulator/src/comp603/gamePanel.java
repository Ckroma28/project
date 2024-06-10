package comp603;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class gamePanel extends javax.swing.JPanel {
    
    private JTextArea DealerCard1;
    private JTextArea DealerCard2;
    private JTextArea DealerCard3;
    private JTextArea DealerCard4;
    private JTextArea DealerCard5;
    private JTextArea PlayerHand1;
    private JTextArea PlayerHand2;
    private JTextArea PlayerHand3;
    private JTextArea PlayerHand4;
    private JTextArea PlayerHand5;
    private List<String> userHand;
    private List<String> dealerHand;
    private List<String> userCount;
    private List<String> dealerCount;
    private final Deck deck;
    int pressedAmount = 0;
    GameSelection parentPanel;
    int balance = 1000;

    public gamePanel(GameSelection parentPanel) {
        initComponents();
        this.deck = new Deck();
        this.userHand = new ArrayList<>();
        this.dealerHand = new ArrayList<>();
        startGame();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        DealerCard2 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        DealerCard1 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        DealerCard5 = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        DealerCard4 = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        DealerCard3 = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        PlayerHand3 = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        PlayerHand2 = new javax.swing.JTextArea();
        jScrollPane13 = new javax.swing.JScrollPane();
        PlayerHand4 = new javax.swing.JTextArea();
        jScrollPane14 = new javax.swing.JScrollPane();
        PlayerHand5 = new javax.swing.JTextArea();
        jScrollPane15 = new javax.swing.JScrollPane();
        PlayerHand1 = new javax.swing.JTextArea();
        HitButton = new javax.swing.JButton();
        StandButton = new javax.swing.JButton();
        QuitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        

        setMaximumSize(new java.awt.Dimension(1000, 500));
        setMinimumSize(new java.awt.Dimension(1000, 500));

        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 500));

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setToolTipText("");
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane6.setMaximumSize(new java.awt.Dimension(100, 150));
        jScrollPane6.setMinimumSize(new java.awt.Dimension(100, 150));
        jScrollPane6.setPreferredSize(new java.awt.Dimension(100, 150));
        
        DealerCard2.setEditable(false);
        DealerCard2.setColumns(20);
        DealerCard2.setRows(5);
        jScrollPane6.setViewportView(DealerCard2);

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setToolTipText("");
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane7.setMaximumSize(new java.awt.Dimension(100, 150));
        jScrollPane7.setMinimumSize(new java.awt.Dimension(100, 150));
        jScrollPane7.setPreferredSize(new java.awt.Dimension(100, 150));

        DealerCard1.setEditable(false);
        DealerCard1.setColumns(20);
        DealerCard1.setRows(5);
        jScrollPane7.setViewportView(DealerCard1);

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setToolTipText("");
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane8.setMaximumSize(new java.awt.Dimension(100, 150));
        jScrollPane8.setMinimumSize(new java.awt.Dimension(100, 150));
        jScrollPane8.setPreferredSize(new java.awt.Dimension(100, 150));

        DealerCard5.setEditable(false);
        DealerCard5.setColumns(20);
        DealerCard5.setRows(5);
        jScrollPane8.setViewportView(DealerCard5);

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane9.setToolTipText("");
        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane9.setMaximumSize(new java.awt.Dimension(100, 150));
        jScrollPane9.setMinimumSize(new java.awt.Dimension(100, 150));
        jScrollPane9.setPreferredSize(new java.awt.Dimension(100, 150));

        DealerCard4.setEditable(false);
        DealerCard4.setColumns(20);
        DealerCard4.setRows(5);
        jScrollPane9.setViewportView(DealerCard4);

        jScrollPane10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane10.setToolTipText("");
        jScrollPane10.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane10.setMaximumSize(new java.awt.Dimension(100, 150));
        jScrollPane10.setMinimumSize(new java.awt.Dimension(100, 150));
        jScrollPane10.setPreferredSize(new java.awt.Dimension(100, 150));

        DealerCard3.setEditable(false);
        DealerCard3.setColumns(20);
        DealerCard3.setRows(5);
        jScrollPane10.setViewportView(DealerCard3);

        jScrollPane11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane11.setToolTipText("");
        jScrollPane11.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane11.setMaximumSize(new java.awt.Dimension(100, 150));
        jScrollPane11.setMinimumSize(new java.awt.Dimension(100, 150));
        jScrollPane11.setPreferredSize(new java.awt.Dimension(100, 150));

        PlayerHand3.setEditable(false);
        PlayerHand3.setColumns(20);
        PlayerHand3.setRows(5);
        jScrollPane11.setViewportView(PlayerHand3);

        jScrollPane12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane12.setToolTipText("");
        jScrollPane12.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane12.setMaximumSize(new java.awt.Dimension(100, 150));
        jScrollPane12.setMinimumSize(new java.awt.Dimension(100, 150));
        jScrollPane12.setPreferredSize(new java.awt.Dimension(100, 150));

        PlayerHand2.setEditable(false);
        PlayerHand2.setColumns(20);
        PlayerHand2.setRows(5);
        jScrollPane12.setViewportView(PlayerHand2);

        jScrollPane13.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane13.setToolTipText("");
        jScrollPane13.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane13.setMaximumSize(new java.awt.Dimension(100, 150));
        jScrollPane13.setMinimumSize(new java.awt.Dimension(100, 150));
        jScrollPane13.setPreferredSize(new java.awt.Dimension(100, 150));

        PlayerHand4.setEditable(false);
        PlayerHand4.setColumns(20);
        PlayerHand4.setRows(5);
        jScrollPane13.setViewportView(PlayerHand4);

        jScrollPane14.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane14.setToolTipText("");
        jScrollPane14.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane14.setMaximumSize(new java.awt.Dimension(100, 150));
        jScrollPane14.setMinimumSize(new java.awt.Dimension(100, 150));
        jScrollPane14.setPreferredSize(new java.awt.Dimension(100, 150));

        PlayerHand5.setEditable(false);
        PlayerHand5.setColumns(20);
        PlayerHand5.setRows(5);
        jScrollPane14.setViewportView(PlayerHand5);

        jScrollPane15.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane15.setToolTipText("");
        jScrollPane15.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane15.setMaximumSize(new java.awt.Dimension(100, 150));
        jScrollPane15.setMinimumSize(new java.awt.Dimension(100, 150));
        jScrollPane15.setPreferredSize(new java.awt.Dimension(100, 150));

        PlayerHand1.setEditable(false);
        PlayerHand1.setColumns(20);
        PlayerHand1.setRows(5);
        jScrollPane15.setViewportView(PlayerHand1);

        HitButton.setText("Hit");
        HitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HitButtonActionPerformed(evt);
            }
        });

        StandButton.setText("Stand");

        QuitButton.setText("Quit");
        QuitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitButtonActionPerformed(evt);
            }
        });

        jTextPane1.setEditable(false);
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(QuitButton)
                        .addGap(472, 472, 472)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(StandButton)
                    .addComponent(HitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(467, 467, 467))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(HitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(QuitButton)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(StandButton)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>                        
    
    private void startGame() {
        dealStartingHand();
        setDealerCardText(DealerCard1, dealerHand.get(0));
        setPlayerHandText(PlayerHand1, userHand.get(0));
        setDealerCardText2(DealerCard2, dealerHand.get(1));
        setPlayerHandText2(PlayerHand2, userHand.get(1));
    }
    
    private void QuitButtonActionPerformed(java.awt.event.ActionEvent evt) {
    JOptionPane.showMessageDialog(this, "Thanks for Playing!");

    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
    topFrame.getContentPane().removeAll();
    topFrame.add(parentPanel);
    topFrame.validate();
    topFrame.repaint();
    }
    
    private void HitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        deck.shuffle();

        switch (pressedAmount) {
            case 0:
                userHand.add(deck.draw());
                setPlayerHandText(PlayerHand3, userHand.get(2));

                if (countHandValue(userHand) > 21) {
                    showLose();
                }
                break;
            case 1:
                userHand.add(deck.draw());
                setPlayerHandText2(PlayerHand4, userHand.get(3));
                if (countHandValue(userHand) > 21) {
                    showLose();
                }
                break;
            case 2:
                userHand.add(deck.draw());
                setPlayerHandText3(PlayerHand5, userHand.get(4));
                    showLose();
                break;
            default:
                break;
        }
        pressedAmount++;
    }

    private int countHandValue(List<String> hand) {
        int count = 0;
        int aceCount = 0;

        for (String card : hand) {
            String[] parts = card.split(" ");
            String rank = parts[0];

            if (rank.equals("Ace")) {
                aceCount++;
                count += 11;
            } else if (rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
                count += 10;
            } else {
                count += Integer.parseInt(rank);
            }
        }
        while (count > 21 && aceCount > 0) {
            count -= 10;
            aceCount--;
        }
        return count;
    }
    
    public boolean determineWinner() {
        int userValue = countHandValue(userCount);
        int dealerValue = countHandValue(dealerCount);

        if (dealerValue > 21 || userValue > dealerValue) {
            return true;
        } else if (userValue == dealerValue) {
            return false;
        } else {
            return false;
        }
    }
   
    private static void showLose() {
        JOptionPane.showMessageDialog(null, "You Lose!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void setDealerCardText(JTextArea DealerCard1, String text) {
        DealerCard1.setText(text);
    }
    public static void setDealerCardText2(JTextArea DealerCard2, String text) {
        DealerCard2.setText(text);
    }
    public static void setDealerCardText3(JTextArea DealerCard3, String text) {
        DealerCard3.setText(text);
    }
    public static void setDealerCardText4(JTextArea DealerCard4, String text) {
        DealerCard4.setText(text);
    }
    public static void setDealerCardText5(JTextArea DealerCard5, String text) {
        DealerCard5.setText(text);
    }
    public static void setPlayerHandText(JTextArea PlayerHand1, String text2) {
        PlayerHand1.setText(text2);
    }
    public static void setPlayerHandText2(JTextArea PlayerHand2, String text2) {
        PlayerHand2.setText(text2);
    }
    public static void setPlayerHandText3(JTextArea PlayerHand3, String text2) {
        PlayerHand3.setText(text2);
    }
    public static void setPlayerHandText4(JTextArea PlayerHand4, String text2) {
        PlayerHand4.setText(text2);
    }
    public static void setPlayerHandText5(JTextArea PlayerHand5, String text2) {
        PlayerHand5.setText(text2);
    }
    
    public void dealStartingHand() {
            userHand.add(deck.draw());
            userHand.add(deck.draw());
            dealerHand.add(deck.draw());
            dealerHand.add(deck.draw());
        }

    // Variables declaration - do not modify                     
    private javax.swing.JButton HitButton;
    private javax.swing.JButton QuitButton;
    private javax.swing.JButton StandButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration                   
}
