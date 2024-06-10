package comp603;

import java.util.*;

public class Deck {

    private final List<String> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    public void initializeDeck() {
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        for (String suit : suits) {
            for (String rank : ranks) {
                this.cards.add(rank + " of " + suit);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }
    

    public String draw() {
        if (!this.cards.isEmpty()) {
            return this.cards.remove(0);
        } else {
            return null;
        }
    }
}
