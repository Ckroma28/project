package comp603;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.*;

public class CoinflipGUI extends JPanel {

    JTextField betAmountField;
    JTextArea resultArea;
    JButton flipButton;
    JButton quitButton;
    int balance;
    DecimalFormat df;
    GameSelection parentPanel;

    public CoinflipGUI(GameSelection parentPanel) {
        this.parentPanel = parentPanel;

        setLayout(null);

        df = new DecimalFormat("#.##");
        balance = 1000; // Initial balance

        JLabel betLabel = new JLabel("Bet Amount:");
        betLabel.setBounds(50, 30, 100, 25);
        add(betLabel);

        betAmountField = new JTextField();
        betAmountField.setBounds(150, 30, 150, 25);
        add(betAmountField);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(50, 80, 300, 150);
        add(scrollPane);

        flipButton = new JButton("Flip Coin");
        flipButton.setBounds(50, 240, 100, 25);
        flipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playCoinflip();
            }
        });
        add(flipButton);

        quitButton = new JButton("Quit");
        quitButton.setBounds(250, 240, 100, 25);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitGame();
            }
        });
        add(quitButton);
    }

    private void playCoinflip() {
        try {
            double betAmount = Double.parseDouble(betAmountField.getText());
            if (betAmount > balance || betAmount <= 0) {
                JOptionPane.showMessageDialog(this, "Invalid bet amount.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String guess = JOptionPane.showInputDialog(this, "Choose heads or tails (h/t):").toLowerCase();
            if (!guess.equals("h") && !guess.equals("t")) {
                JOptionPane.showMessageDialog(this, "Invalid guess.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean isHeads = flipCoin();
            String result = isHeads ? "heads" : "tails";
            String message = "The coin landed on " + result + "!\n";

            if ((guess.equals("h") && isHeads) || (guess.equals("t") && !isHeads)) {
                balance += betAmount;
                message += "Congratulations! You won $" + df.format(betAmount) + ". Your new balance is: $" + df.format(balance);
            } else {
                balance -= betAmount;
                message += "Oh no! You lost $" + df.format(betAmount) + ". Your new balance is: $" + df.format(balance);
            }
            resultArea.append(message + "\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid bet amount.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean flipCoin() {
        Random random = new Random();
        return random.nextBoolean();
    }

    private void quitGame() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.getContentPane().removeAll();
        topFrame.add(parentPanel);
        topFrame.validate();
        topFrame.repaint();
    }
}
