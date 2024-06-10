package comp603;

import javax.swing.JFrame;

public class TestCase1 {
    public static void main(String[] args) {
        // Tests Creation and instantiation of coinflipGUI
        JFrame frame = new JFrame("Coinflip Game");
        GameSelection parentPanel = new GameSelection();
        CoinflipGUI coinflipGUI = new CoinflipGUI(parentPanel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.add(coinflipGUI);
        frame.setVisible(true);
    }
}
