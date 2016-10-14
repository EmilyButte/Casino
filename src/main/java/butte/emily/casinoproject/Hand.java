package butte.emily.casinoproject;

import java.util.ArrayList;

/**
 * Created by emilybutte on 10/12/16.
 */
public class Hand {

    ArrayList<Card> currentHand = new ArrayList<>();

    public void clear() {
        currentHand.clear();
    }

    public void addCard(Card card) {
        if(card == null) {
            throw new NullPointerException("Card can't be added to currentHand.");
        }
        currentHand.add(card);
    }

    public void removeCard(Card card) {
        currentHand.remove(card);
    }

    public void removeCard(int position) {
        if(position < 0 || position >= currentHand.size()) {
            throw new IllegalArgumentException("Position does not exist in currentHand:" + position);
        }
        currentHand.remove(position);
    }

    public int getCardCount() {
        return currentHand.size();
    }

    public Card getCard(int position) {
        if(position < 0 || position >= currentHand.size()) {
            throw new IllegalArgumentException("Position does not exist in hand:" + position);
        }
        return currentHand.get(position);
    }

    public ArrayList<Card> sortBySuit() {
        ArrayList<Card> newHand = new ArrayList<Card>();
        while (currentHand.size() > 0) {
            int position = 0;  // Position of minimal card.
            Card card = currentHand.get(0);  // Minimal card.
            for (int i = 1; i < currentHand.size(); i++) {
                Card c1 = currentHand.get(i);
                if (c1.getSuit() < card.getSuit() ||  (c1.getSuit() == card.getSuit() && c1.getValue() < card.getValue()) ) {
                    position = i;
                    card = c1;
                }
            }
            currentHand.remove(position);
            newHand.add(card);
        }
        currentHand = newHand;
        return newHand;
    }

    public ArrayList sortByValue() {
        ArrayList<Card> newHand = new ArrayList<Card>();
        while (currentHand.size() > 0) {
            int position = 0;  // Position of minimal card.
            Card card = currentHand.get(0);  // Minimal card.
            for (int i = 1; i < currentHand.size(); i++) {
                Card c1 = currentHand.get(i);
                if ( c1.getValue() < card.getValue() ||
                        (c1.getValue() == card.getValue() && c1.getSuit() < card.getSuit()) ) {
                    position = i;
                    card = c1;
                }
            }
            currentHand.remove(position);
            newHand.add(card);
        }
        currentHand = newHand;
        return newHand;
    }
}
