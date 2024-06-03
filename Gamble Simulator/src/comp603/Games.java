package comp603;

import java.util.*;

public abstract class Games {

    protected User user;
    protected Scanner scanner;

    public Games(User user) {
        this.user = user;
        this.scanner = new Scanner(System.in);
    }

    public abstract void play();

    public boolean askPlayAgain() {
        System.out.println("\nDo you want to play again? (yes/no)");
        while (true) {
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (playAgain.equals("yes")) {
                return true;
            } else if (playAgain.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input! Please enter 'yes' or 'no'.");
            }
        }
    }
}
