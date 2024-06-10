package comp603;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BlackjackGUITest {

    @Test
    public void testYesButtonActionPerformed() {
        BlackjackGUI blackjackGUI = new BlackjackGUI();

        // Mock the parent panel
        GameSelection parentPanel = new GameSelection();

        // Create a dummy frame to hold the BlackjackGUI
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(blackjackGUI);
        frame.setVisible(true);

        // Trigger the action performed by simulating button click
        blackjackGUI.YesButton.doClick();

        // After clicking YesButton, the game panel should be switched
        assertNotNull(blackjackGUI.gamePanel); // Assert that gamePanel is not null
    }
}
