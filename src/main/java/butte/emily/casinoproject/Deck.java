package butte.emily.casinoproject;

import java.util.*;

/**
 * Created by emilybutte on 10/12/16.
 */
public class Deck {

    private ArrayList<Card> theDeck;

    public Deck() {
        theDeck = new ArrayList<Card>();
        for (int suit = 0; suit <= 3; suit++) {
            for (int value = 1; value <= 13; value++) {
                theDeck.add(new Card(suit, value));
            }
        }
    }

    public ArrayList<Card> shuffle(List<?> theDeck) {
        Collections.shuffle(Arrays.asList(theDeck));
        return null;
    }

    public int cardsLeft(int cardsUsed){
        return theDeck.size() - cardsUsed;
    }

    public Card deal() {
        int cardsUsed = 0;
        Card card = theDeck.remove(0);
        cardsUsed++;
        if(theDeck.size() == 0) {
            System.out.println("No cards remain in the deck.");
        }
        return card;
    }
}

