package butte.emily.casinoproject;

import java.util.*;

/**
 * Created by emilybutte on 10/12/16.
 */
public class Deck {

    private ArrayList<Card> theDeck;
    int cardsUsed = 0;

    public Deck() {
        theDeck = new ArrayList<Card>();
        for (int suit = 1; suit <= 3; suit++) {
            for (int value = 1; value <= 13; value++) {
                theDeck.add(new Card(suit, value));
            }
        }
    }

    public ArrayList<Card> shuffle() {
        Collections.shuffle(theDeck);
        return theDeck;
    }

    public int cardsLeft(int cardsUsed){
        return theDeck.size() - cardsUsed;
    }

    public Card deal() {
        Card card = theDeck.remove(0);
        cardsUsed++;
        if(theDeck.size() == 0) {
            System.out.println("No cards remain in the currentHand.");
        }
        return card;
    }
}

