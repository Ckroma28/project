package comp603;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlotGui extends JPanel {

    private User user;
    private SlotMachine slotMachine;
    private JLabel balanceLabel;
    private JLabel resultLabel;
    private JButton instructionsButton;
    private JButton quitButton;

    public SlotGui(User user) {
        this.user = user;
        this.slotMachine = new SlotMachine(user);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Slot Machine");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(titleLabel);

        balanceLabel = new JLabel("Balance: $" + user.getBalance());
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(balanceLabel);

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(resultLabel);

        // Instructions Button
        instructionsButton = new JButton("Instructions");
        instructionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInstructions();
                removeInstructionsButton();
            }
        });
        add(instructionsButton);

        JButton spinButton = new JButton("Spin");
        spinButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        spinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSpin();
            }
        });
        add(spinButton);

        // Quit Button
        quitButton = new JButton("Quit");
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitToHomepage();
            }
        });
        add(quitButton);

        askForInstructions();
    }

    private void askForInstructions() {
        int response = JOptionPane.showConfirmDialog(this, "Would you like to know how to play?", "Instructions", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            displayInstructions();
        }
        removeInstructionsButton();
    }

    private void displayInstructions() {
        String instructions = "1. You can bet as much as you want, however it must be within your budget\n"
                + "2. Type '1' to play and 'x' to quit the game\n"
                + "3. If the slot machine hits 2 of the same numbers, you win 1.5x the amount you bet\n"
                + "4. If the slot machine numbers hit all 3 of the same number, you win 3x the amount you bet\n"
                + "5. If all 3 numbers don't match, you lose the money that you bet\n"
                + "6. That is all you need to know on how to play the slot machine";
        JOptionPane.showMessageDialog(this, instructions, "Instructions", JOptionPane.INFORMATION_MESSAGE);
    }

    private void removeInstructionsButton() {
        remove(instructionsButton);
        revalidate();
        repaint();
    }

    private void handleSpin() {
        String betStr = JOptionPane.showInputDialog(this, "Enter your bet amount:");
        if (betStr != null) {
            try {
                double bet = Double.parseDouble(betStr);
                if (bet > 0 && bet <= user.getBalance()) {
                    user.setBalance((int) (user.getBalance() - bet));
                    balanceLabel.setText("Balance: $" + user.getBalance());

                    int[] slots = slotMachine.spinSlots();
                    double winnings = slotMachine.calculateWinnings(slots, bet);
                    user.setBalance((int) (user.getBalance() + winnings));
                    balanceLabel.setText("Balance: $" + user.getBalance());

                    displayResults(slots, winnings);
                    UserFileHandler.updateUserData(user, user.getBalance());
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid bet amount. Please bet within your balance.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void displayResults(int[] slots, double winnings) {
        StringBuilder resultText = new StringBuilder("Your numbers are: ");
        for (int slot : slots) {
            resultText.append(slot).append(" ");
        }
        resultText.append("\n");
        if (winnings > 0) {
            resultText.append("You won: $").append(winnings);
        } else {
            resultText.append("You lost: $").append(-winnings);
        }
        resultLabel.setText(resultText.toString());
    }

    private void quitToHomepage() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.getContentPane().removeAll();
        GameSelection gameSelection = new GameSelection();
        gameSelection.updateUser(user);
        topFrame.add(gameSelection);
        topFrame.validate();
        topFrame.repaint();
    }
}
