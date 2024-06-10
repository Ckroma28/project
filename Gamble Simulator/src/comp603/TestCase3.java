package comp603;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TestCase3 {
    public static void main(String[] args) {
        // Create a dummy user
        User user = new User("testuser", 1000);

        // Create an instance of GameSelection
        GameSelection gameSelection = new GameSelection();

        // Update the user in the GameSelection panel
        gameSelection.updateUser(user);

        // Check if user information is correctly updated
        String currentUserText = gameSelection.CurrentUserText.getText();
        String currentBalanceText = gameSelection.CurrentBalanceText.getText();
        System.out.println(currentUserText);
        System.out.println(currentBalanceText);

        // Simulate clicking the Coinflip button
        gameSelection.CoinflipButton.doClick();

        // Verify the CoinflipGUI is set
        System.out.println("Coinflip button clicked. CoinflipGUI should be active.");

        // Simulate clicking the Slots button
        gameSelection.SlotsButton.doClick();

        // Verify the SlotGui is set
        System.out.println("Slots button clicked. SlotGui should be active.");

        // Simulate clicking the Quit button
        gameSelection.QuitButton.doClick();
    }
}