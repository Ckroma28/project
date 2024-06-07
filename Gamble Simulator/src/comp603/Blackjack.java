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
    
    public void dealStartingHand() {
        userHand.add(deck.draw());
        userHand.add(deck.draw());
        dealerHand.add(deck.draw());
        dealerHand.add(deck.draw());
    }

    public List<String> getUserHand() {
        return userHand;
    }

    public List<String> getDealerHand() {
        return dealerHand;
    }

    public void hit(List<String> hand) {
        hand.add(deck.draw());
    }

    public int countHandValue(List<String> hand) {
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
}
