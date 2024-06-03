package comp603;

import java.util.*;

public class Coinflip extends Games {

    private Scanner scanner;
    private int balance;
    private User user;

    public Coinflip(User user) {
        super(user);
        this.user = user;
        this.balance = user.getBalance();
        scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("Welcome to Coinflip!");
        explanation();

        while (true) {
            try {
                double betAmount = placeBetAmount();
                String guess = chooseHeadsOrTails();
                boolean isHeads = flipCoin();
                displayResult(isHeads);
                updateBalance(betAmount, guess, isHeads);
                if (!playAgain()) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please input a valid number.");
            }
        }
        System.out.println("Thanks for playing!");
    }

    private void explanation() {
        System.out.println("Would you like an explanation on how this game works? (yes/no)");
        String response = scanner.nextLine().toLowerCase();
        if (response.equals("yes")) {
            System.out.println("\nCoinflip is an easy game!");
            System.out.println("A coin is flipped, you can choose either heads or tails,");
            System.out.println("If you guess correctly, you win!");
            System.out.println("If you don't, you lose your bet!");
        } else if (response.equals("no")) {
            System.out.println("Alright, good luck!");
        } else {
            System.out.println("Invalid input, continuing with game...");
        }
    }

    private double placeBetAmount() {
        while (true) {
            try {
                System.out.println("\nYour balance is: $" + balance);
                System.out.println("Enter how much you would like to bet:");
                double bet = Double.parseDouble(scanner.nextLine());
                if (bet > balance || bet <= 0) {
                    System.out.println("Invalid bet, please input a valid bet.");
                } else {
                    return bet;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please input a valid number.");
            }
        }
    }

    private String chooseHeadsOrTails() {
        while (true) {
            System.out.println("Choose heads or tails (enter 'h' for heads or 't' for tails)");
            String guess = scanner.nextLine().toLowerCase();
            if (guess.equals("h") || guess.equals("t")) {
                return guess;
            } else {
                System.out.println("Invalid response please try again.");
            }
        }
    }

    private boolean flipCoin() {
        Random random = new Random();
        return random.nextBoolean();
    }

    private void displayResult(boolean isHeads) {
        String result = isHeads ? "heads" : "tails";
        System.out.println("Flipping coin...");
        System.out.println("The coin landed on " + result + "!");
    }

    private void updateBalance(double betAmount, String guess, boolean isHeads) {
        if ((guess.equals("h") && isHeads) || (guess.equals("t") && !isHeads)) {
            balance += betAmount;
            System.out.println("Congratulations! Your new balance is: $" + balance);
            UserFileHandler.updateUserData(user, balance);
        } else {
            balance -= betAmount;
            System.out.println("Oh no you guessed incorrectly! Your new balance is: $" + balance);
            UserFileHandler.updateUserData(user, balance);
        }
    }

    private boolean playAgain() {
        System.out.println("\nWould you like to play again? (yes/no)");
        String response = scanner.nextLine().toLowerCase();
        return response.equals("yes");
    }
}
