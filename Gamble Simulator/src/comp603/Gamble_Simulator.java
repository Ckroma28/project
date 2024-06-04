package comp603;

import javax.swing.JFrame;

public class Gamble_Simulator {

    public static void main(String[] args) {
        // Create a JFrame to hold the panel
        JFrame frame = new JFrame("Gambling Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel panel = new Panel();
        frame.add(panel);

        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
}