package comp603;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class SlotGui extends JPanel {

    private User user;
    private SlotMachine slotMachine;
    private JLabel balanceLabel;
    private JLabel resultLabel;

    public SlotGui(User user) {
        this.user = user;
        this.slotMachine = new SlotMachine(user);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        JLabel titleLabel = new JLabel("Slot Machine");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(titleLabel);

        balanceLabel = new JLabel("Balance: $" + user.getBalance());
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(balanceLabel);

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 36));
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(resultLabel);

        askForInstructions();
    }

    private void askForInstructions() {
        int response = JOptionPane.showConfirmDialog(this, "Would you like to know how to play?", "Instructions", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            displayInstructions();
        }
        removeComponentsAfterInstructions();
    }

    private void displayInstructions() {
        String instructions = "1. You can bet as much as you want, however it must be within your budget\n"
                + "2. Type 'Enter' to play and 'x' to quit the game\n"
                + "3. If the slot machine hits 2 of the same numbers, you win 1.5x the amount you bet\n"
                + "4. If the slot machine numbers hit all 3 of the same number, you win 3x the amount you bet\n"
                + "5. If all 3 numbers don't match, you lose the money that you bet\n"
                + "6. That is all you need to know on how to play the slot machine";
        JOptionPane.showMessageDialog(this, instructions, "Instructions", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean playAgainClicked = false; // Add this variable

    private void removeComponentsAfterInstructions() {
        removeAll();
        revalidate();
        repaint();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        if (!playAgainClicked) {
            resultLabel.setText("Press 'Enter' to start playing the slot machine.");
            add(resultLabel, gbc);

            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        handleBetInput();
                    }
                }
            });
            setFocusable(true);
            requestFocusInWindow();
        } else {
            handleBetInput();
            playAgainClicked = false; // Reset the flag after handling the bet input
        }
    }

    private void handleBetInput() {
        String betStr = JOptionPane.showInputDialog(this, "Enter your bet amount:");
        if (betStr != null) {
            try {
                double bet = Double.parseDouble(betStr);
                if (bet > 0 && bet <= user.getBalance()) {
                    handleSpin(bet);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid bet amount. Please bet within your balance.", "Error", JOptionPane.ERROR_MESSAGE);
                    requestFocusInWindow();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                requestFocusInWindow();
            }
        }
    }

    private void handleSpin(double bet) {
        int[] slots = slotMachine.spinSlots();
        double winnings = slotMachine.calculateWinnings(slots, bet);

        user.setBalance((int) (user.getBalance() + winnings));
        balanceLabel.setText("Balance: $" + user.getBalance());

        displayResults(slots, winnings);

        UserDB.updateUserBalance(user.getUsername(), user.getBalance());

        if (user.getBalance() <= 0) {
            JOptionPane.showMessageDialog(this, "You are out of balance. Please come back later.");
            System.exit(0);
        }
    }

    private void displayResults(int[] slots, double winnings) {
        removeAll();
        revalidate();
        repaint();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        StringBuilder resultText = new StringBuilder("<html><div style='text-align: center;'>Your numbers are:<br>");
        for (int slot : slots) {
            resultText.append(slot).append(" ");
        }
        resultText.append("<br>");
        if (winnings > 0) {
            resultText.append("You won: $").append(winnings);
        } else {
            resultText.append("You lost: $").append(-winnings);
        }
        resultText.append("</div></html>");

        resultLabel.setText(resultText.toString());
        add(resultLabel, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton playAgainButton = new JButton("Play Again");
        JButton quitButton = new JButton("Quit");

        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playAgainClicked = true; // Set the flag when Play Again button is clicked
                removeComponentsAfterInstructions();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(SlotGui.this);
                topFrame.getContentPane().removeAll();
                topFrame.add(new GameSelection(user));
                topFrame.validate();
                topFrame.repaint();
            }
        });

        buttonPanel.add(playAgainButton);
        buttonPanel.add(quitButton);

        gbc.gridy = 1;
        add(buttonPanel, gbc);
    }

    void updateUser(User user) {
        this.user = user;
        balanceLabel.setText("Balance: $" + user.getBalance());
    }
}
