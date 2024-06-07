package comp603;

import java.util.*;

public class SlotMachine {

    private User user;
    private Scanner scanner;
    private Random number;

    public SlotMachine(User user) {
        this.user = user;
        this.scanner = new Scanner(System.in);
        this.number = new Random();
    }

    private boolean askForInstructions() {
        while (true) {
            System.out.println("Would you like to know to how to play?");
            System.out.println("Type 'yes' to read instructions and 'no' to skip.");
            String response = scanner.next().trim().toLowerCase();
            switch (response) {
                case "yes":
                    displayTheInstructions();
                case "no":
                    return false;
                default:
                    System.out.println("Invalid input, please type in 'yes' or 'no'");
                    break;
            }
        }
    }

    private void displayTheInstructions() {
        System.out.println("Instructions:");
        System.out.println("1. You can bet as much as you want, however it must be within your budget");
        System.out.println("2. Type '1' to play and 'x' to quit the game");
        System.out.println("3. If the slot machine hits 2 of the same numbers, you win 1.5x the amount you betted");
        System.out.println("4. If the slot machine numbers hit all 3 of the same number, you win 3x the amount you betted");
        System.out.println("5. If all 3 numbers don't match, you lose the money that you betted");
        System.out.println("6. That is all you need to know on how to play the slot machine");
        delay(2000);
    }

    private boolean balanceDisplayed = false;

    public void play() {
        System.out.println("Welcome to the slot machine!");

        if (askForInstructions()) {
            displayTheInstructions();
        } else {
            System.out.println("Alright, let's continue on.\n");
            delay(2000);
        }

        while (true) {
            System.out.println("Your current balance is $" + user.getBalance());
            System.out.println("Type '1' to play or 'x' to quit.");

            String choice = scanner.next();
            switch (choice) {
                case "x":
                    System.out.println("Thank you for playing!");
                    return;
                case "1":
                    playRound();
                    break;
                default:
                    System.out.println("Invalid input. Please type '1' to play or 'x' to quit.");
            }
        }
    }

    private void playRound() {
        double betAmount = getBetAmount();
        if (betAmount <= 0 || betAmount > user.getBalance()) {
            System.out.println("Invalid bet amount. Please try again.");
            return;
        }

        int[] slots = spinSlots();
        displayResults(slots, betAmount);
        UserFileHandler.updateUserData(user, user.getBalance());
    }

    private double getBetAmount() {
        while (true) {
            try {
                System.out.print("Enter the amount of money you want to bet: $");
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid bet amount.");
                delay(2000);
                scanner.next();
            }
        }
    }

    private void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }

    int[] spinSlots() {
        int[] slots = {number.nextInt(10), number.nextInt(10), number.nextInt(10)};
        System.out.println(slots[0] + "  " + slots[1] + "  " + slots[2]);
        return slots;
    }

    private void displayResults(int[] slots, double betAmount) {
        if (slots[0] == slots[1] && slots[0] == slots[2]) {
            double winnings = betAmount * 3;
            user.setBalance((int) (user.getBalance() + winnings));
            System.out.println("You won $" + winnings);
        } else if (slots[0] == slots[1] || slots[0] == slots[2] || slots[1] == slots[2]) {
            double winnings = betAmount * 1.5;
            user.setBalance((int) (user.getBalance() + winnings));
            System.out.println("You won $" + winnings);
        } else {
            System.out.println("You lost $" + betAmount);
            user.setBalance((int) (user.getBalance() - betAmount));
        }
    }

    double calculateWinnings(int[] slots, double bet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
