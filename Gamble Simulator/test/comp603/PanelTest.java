package comp603;

import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PanelTest {

    @Test
    public void testEnterButtonActionPerformed() {
        Panel panel = new Panel();

        // Simulate entering a username and clicking the "Enter" button
        panel.UsernameBox.setText("testUser");
        panel.EnterButton.doClick();

        // After clicking the "Enter" button, user object should be initialized
        assertNotNull(panel.user);

        // Ensure that the username displayed in the welcome message is correct
        assertEquals("Welcome testUser, Your current balance is : $1000", JOptionPane.getRootFrame().getComponent(0).toString());
    }
}
