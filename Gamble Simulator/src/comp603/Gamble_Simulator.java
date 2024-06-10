package comp603;

import javax.swing.JFrame;

public class Gamble_Simulator {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gambling Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel panel = new Panel(frame); // Pass the frame to the Panel
        frame.add(panel);

        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}
