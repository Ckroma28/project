package comp603;

import java.util.*;

public class Blackjack {

    private Deck deck;
    private List<String> userHand;
    private List<String> dealerHand;
    private final HashMap<String, Double> userData;
    private int balance;
    private final User user;
    private Scanner scanner;

    public Blackjack(User user) {
        this.deck = new Deck();
        this.userHand = new ArrayList<>();
        this.dealerHand = new ArrayList<>();
        this.user = user;
        String username = user.getUsername();
        this.userData = new HashMap<>();
        User loadedUser = UserFileHandler.loadUsersData(username);
        this.userData.put(loadedUser.getUsername(), (double) loadedUser.getBalance());
        this.balance = loadedUser.getBalance();
        scanner = new Scanner(System.in);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgainLoop = true;

        System.out.println("Welcome to Blackjack!");
        explanation();

        while (playAgainLoop) {
            deck.shuffle();
            resetGame();
            System.out.println("Your balance is: $" + balance);

            double betAmount = 0;
            boolean validBet = false;

            do {
                try {
                    System.out.println("Enter your bet amount:");
                    betAmount = scanner.nextDouble();
                    scanner.nextLine();

                    if (betAmount <= 0 || betAmount > balance) {
                        System.out.println("Invalid bet amount. Please enter a bet amount between 1 and your balance.");
                    } else {
                        validBet = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid numeric bet amount.");
                    scanner.nextLine();
                }
            } while (!validBet);

            dealStartingHand();
            printHands(true);

            while (true) {
                System.out.println("Hit or Stand? (h/s): ");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("h")) {
                    hit(userHand);
                    printHands(true);
                    System.out.println(countHandValue(userHand));

                    if (countHandValue(userHand) > 21) {
                        System.out.println("Bust! Dealer wins.");
                        balance -= betAmount;

                        if (!askPlayAgain(scanner)) {
                            resetGame();
                            playAgainLoop = false;
                        }
                        break;
                    }
                } else if (choice.equalsIgnoreCase("s")) {
                    while (countHandValue(dealerHand) < 17) {
                        hit(dealerHand);
                    }
                    boolean win = determineWinner();
                    printHands(false);
                    System.out.println("Dealer's hand: " + dealerHand);

                    if (win) {
                        System.out.println("You win!");
                        balance += betAmount;
                        UserFileHandler.updateUserData(user, balance);
                    } else if (!win && countHandValue(userHand) == countHandValue(dealerHand)) {
                        System.out.println("Tie!");
                    } else {
                        System.out.println("You lose!");
                        balance -= betAmount;
                        UserFileHandler.updateUserData(user, balance);
                    }

                    System.out.println("Your balance is: $" + balance);
                    if (!askPlayAgain(scanner)) {
                        playAgainLoop = false;
                    }
                    resetGame();
                    break;
                } else {
                    System.out.println("Invalid choice! Please enter 'h' or 's'.");
                }
            }
        }
    }

    public void dealStartingHand() {
        userHand.add(deck.draw());
        userHand.add(deck.draw());
        dealerHand.add(deck.draw());
        dealerHand.add(deck.draw());
    }

    private void hit(List<String> hand) {
        hand.add(deck.draw());
    }

    private void printHands(boolean showDealer) {
        System.out.println("Your hand: " + userHand + " ");

        if (showDealer) {
            System.out.println("Dealer's hand: [" + dealerHand.get(0) + ", (?)]");
        }
    }

    private int countHandValue(List<String> hand) {
        int count = 0;
        int aceCount = 0;

        for (String card : hand) {
            String[] parts = card.split(" ");
            String rank = parts[0];

            if (rank.equals("Ace")) {
                aceCount++;
                count += 11;
            } else if (rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
                count += 10;
            } else {
                count += Integer.parseInt(rank);
            }
        }
        while (count > 21 && aceCount > 0) {
            count -= 10;
            aceCount--;
        }
        return count;
    }

    public boolean determineWinner() {
        int userValue = countHandValue(userHand);
        int dealerValue = countHandValue(dealerHand);

        if (dealerValue > 21 || userValue > dealerValue) {
            return true;
        } else if (userValue == dealerValue) {
            return false;
        } else {
            return false;
        }
    }
    
    public void resetGame() {
        userHand.clear();
        dealerHand.clear();
    }
    
    public boolean askPlayAgain(Scanner scanner) {
        System.out.println("\nDo you want to play again? (yes/no)");
        String playAgain;
        do {
            playAgain = scanner.nextLine().trim().toLowerCase();
            if (playAgain.equals("yes") || playAgain.equals("no")) {
                break;
            } else {
                System.out.println("Invalid input! Please enter 'yes' or 'no'.");
            }
        } while (true);
        return playAgain.equals("yes");
    }
    
    private void explanation() {
        System.out.println("Would you like an explanation on how this game works? (yes/no)");
        String response = scanner.nextLine().toLowerCase();
        if (response.equals("yes")) {
            System.out.println("The goal of blackjack is to get your count closest to 21.");
            System.out.println("The user and dealer both get 2 cards each.");
            System.out.println("The user must get a higher count than the dealer to win.");
            System.out.println("If the user has a smaller count value than the dealer they lose.");
            System.out.println("Each card is worth what the rank is (e.g. 9 is worth 9 counts)");
            System.out.println("Cards such as Jack, Queen or King have a count value of 10.");
            System.out.println("Ace cards work differently.");
            System.out.println("If a hand with 2 cards and one of those cards is an Ace,");
            System.out.println("The Ace is worth 11 counts. If a hand has more than 2 cards,");
            System.out.println("The Ace is worth 1 count.\n");
        } else if (response.equals("no")) {
            System.out.println("Alright, good luck!");
        } else {
            System.out.println("Invalid input, continuing with game...");
        }
    }
}
