package comp603;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TestCase2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Coinflip Game Simulation");
            GameSelection parentPanel = new GameSelection();
            CoinflipGUI coinflipGUI = new CoinflipGUI(parentPanel);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 350);
            frame.add(coinflipGUI);
            frame.setVisible(true);

            // Simulate user input
            simulateUserInteraction(coinflipGUI);
        });
    }

    private static void simulateUserInteraction(CoinflipGUI coinflipGUI) {
        // Set a valid bet amount
        coinflipGUI.betAmountField.setText("100");

        // Simulate a button press for flipping the coin
        coinflipGUI.flipButton.doClick();

        // Simulate choosing heads (h)
        JOptionPane.showInputDialog(coinflipGUI, "Choose heads or tails (h/t):", "h");

        // Print results to the console
        System.out.println("Result area content:");
        System.out.println(coinflipGUI.resultArea.getText());

        // Print balance to the console
        System.out.println("Current balance: $" + coinflipGUI.balance);
    }
}
