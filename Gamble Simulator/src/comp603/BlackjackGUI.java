package comp603;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.*;

public class BlackjackGUI extends JPanel {

    private Blackjack blackjack;
    private JPanel gamePanel;
    private JLabel[] playerCards;
    private JLabel[] dealerCards;
    private JButton hitButton;
    private JButton standButton;
    private JLabel playerCountLabel;

    public BlackjackGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new JPanel();
        BJYesButton = new JButton();
        BJNoButton = new JButton();
        BJExplainText = new JTextArea();
        BJWelcomeText = new JTextArea();

        // Set the preferred size for the panel
        jPanel1.setPreferredSize(new Dimension(1000, 500));
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));

        BJYesButton.setText("Yes");
        BJYesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        BJYesButton.addActionListener(this::BJYesButtonActionPerformed);

        BJNoButton.setText("No");
        BJNoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        BJNoButton.addActionListener(this::BJNoButtonActionPerformed);

        BJExplainText.setEditable(false);
        BJExplainText.setColumns(20);
        BJExplainText.setRows(2);
        BJExplainText.setLineWrap(true);
        BJExplainText.setWrapStyleWord(true);
        BJExplainText.setText("Would you like an explanation of how to play the game?");
        BJExplainText.setMaximumSize(BJExplainText.getPreferredSize());

        BJWelcomeText.setEditable(false);
        BJWelcomeText.setColumns(20);
        BJWelcomeText.setFont(new Font("Segoe UI", 0, 48));
        BJWelcomeText.setRows(2);
        BJWelcomeText.setLineWrap(true);
        BJWelcomeText.setWrapStyleWord(true);
        BJWelcomeText.setText("Welcome to Blackjack!");
        BJWelcomeText.setMaximumSize(BJWelcomeText.getPreferredSize());

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(Box.createVerticalGlue());
        textPanel.add(BJWelcomeText);
        textPanel.add(Box.createVerticalStrut(20));
        textPanel.add(BJExplainText);
        textPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(BJYesButton);
        buttonPanel.add(Box.createHorizontalStrut(50));
        buttonPanel.add(BJNoButton);

        jPanel1.add(Box.createVerticalGlue());
        jPanel1.add(textPanel);
        jPanel1.add(Box.createVerticalStrut(20));
        jPanel1.add(buttonPanel);
        jPanel1.add(Box.createVerticalGlue());

        setLayout(new BorderLayout());
        add(jPanel1, BorderLayout.CENTER);
    }

    private void BJNoButtonActionPerformed(ActionEvent evt) {
        switchToGameFrame();
    }

    private void BJYesButtonActionPerformed(ActionEvent evt) {
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

    private void switchToGameFrame() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.getContentPane().removeAll();

        blackjack = new Blackjack(new User("player"));

        gamePanel = new JPanel();
        gamePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        playerCards = new JLabel[2];
        dealerCards = new JLabel[2];
        for (int i = 0; i < 2; i++) {
            playerCards[i] = createCardLabel();
            dealerCards[i] = createCardLabel();
        }

        gbc.gridx = 0;
        gbc.gridy = 0;
        gamePanel.add(dealerCards[0], gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gamePanel.add(dealerCards[1], gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gamePanel.add(playerCards[0], gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gamePanel.add(playerCards[1], gbc);

        hitButton = new JButton("Hit");
        hitButton.addActionListener(this::hitButtonActionPerformed);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.SOUTH;
        gamePanel.add(hitButton, gbc);

        standButton = new JButton("Stand");
        standButton.addActionListener(this::standButtonActionPerformed);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gamePanel.add(standButton, gbc);

        playerCountLabel = new JLabel("Player Count: 0");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        gamePanel.add(playerCountLabel, gbc);

        topFrame.getContentPane().add(gamePanel);
        topFrame.revalidate();
        topFrame.repaint();

        startGame();
    }

    private void startGame() {
        blackjack.dealStartingHand();
        updateCardLabels();
        updatePlayerCount();
    }

    private void updateCardLabels() {
        List<String> userHand = blackjack.getUserHand();
        List<String> dealerHand = blackjack.getDealerHand();

        for (int i = 0; i < userHand.size(); i++) {
            playerCards[i].setText(formatCardText(userHand.get(i)));
        }

        dealerCards[0].setText(formatCardText(dealerHand.get(0)));
        dealerCards[1].setText("[Hidden]");
    }

    private void updatePlayerCount() {
        int playerCount = countHandValue(blackjack.getUserHand());
        playerCountLabel.setText("Player Count: " + playerCount);
    }

    private void hitButtonActionPerformed(ActionEvent evt) {
        blackjack.hit(blackjack.getUserHand());
        updateCardLabels();
        updatePlayerCount();

        if (blackjack.countHandValue(blackjack.getUserHand()) > 21) {
            JOptionPane.showMessageDialog(this, "Bust! Dealer wins.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
        }
    }

    private void standButtonActionPerformed(ActionEvent evt) {
        while (blackjack.countHandValue(blackjack.getDealerHand()) < 17) {
            blackjack.hit(blackjack.getDealerHand());
        }

        boolean win = blackjack.determineWinner();
        dealerCards[1].setText(formatCardText(blackjack.getDealerHand().get(1)));

        String resultMessage = win ? "You win!" : "You lose!";
        JOptionPane.showMessageDialog(this, resultMessage, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        resetGame();
    }

    private void resetGame() {
        blackjack.resetGame();
        switchToGameFrame();
    }

    private JLabel createCardLabel() {
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(100, 150));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return label;
    }

    private String formatCardText(String card) {
        return "<html><body style='text-align: center;'>" + card.replace(" of ", "<br>") + "</body></html>";
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

    // Variables declaration - do not modify                     
    private JTextArea BJExplainText;
    private JButton BJNoButton;
    private JTextArea BJWelcomeText;
    private JButton BJYesButton;
    private JPanel jPanel1;
    // End of variables declaration                   
}
