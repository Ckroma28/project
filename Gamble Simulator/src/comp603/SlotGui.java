package comp603;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SlotGui extends JFrame {

    private User user;
    private SlotMachine slotMachine;
    private JLabel balanceLabel;

    public SlotGui(User user) {
        this.user = user;
        this.slotMachine = new SlotMachine();

        setTitle("Slot Machine");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Slot Machine");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);

        balanceLabel = new JLabel("Balance: $" + user.getBalance());
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(balanceLabel);

        JButton spinButton = new JButton("Spin");
        spinButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        spinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] slots = slotMachine.spin();
                displayResults(slots);
            }
        });
        panel.add(spinButton);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void displayResults(int[] slots) {
        // Logic to display the results, e.g., symbols/icons based on the slot numbers
        StringBuilder resultText = new StringBuilder("Result: ");
        for (int slot : slots) {
            resultText.append(slot).append(" ");
        }
        JOptionPane.showMessageDialog(this, resultText.toString());
    }
}

class SlotMachine {
    private Random random;

    public SlotMachine() {
        this.random = new Random();
    }

    public int[] spin() {
        int[] result = {random.nextInt(10), random.nextInt(10), random.nextInt(10)};
        return result;
    }
}
