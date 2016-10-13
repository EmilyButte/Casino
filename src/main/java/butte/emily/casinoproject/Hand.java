package butte.emily.casinoproject;

import java.util.ArrayList;

/**
 * Created by emilybutte on 10/12/16.
 */
public class Hand {

    ArrayList<Card> cardList = new ArrayList<>();

    //public Hand() {
//        cardList = new ArrayList<Card>();
//    }

    public void clear() {
        cardList.clear();
    }

    public void addCard(Card card) {
        if(card ==null) {
            throw new NullPointerException("Card can't be added to cardList.");
        }
        cardList.add(card);
    }

    public void removeCard(Card card) {
        cardList.remove(card);
    }

    public void removeCard(int position) {
        if(position < 0 || position >= cardList.size()) {
            throw new IllegalArgumentException("Position does not exist in cardList:" + position);
        }
        cardList.remove(position);
    }

    public int getCardCount() {
        return cardList.size();
    }

    public Card getCard(int position) {
        if(position < 0 || position >= cardList.size()) {
            throw new IllegalArgumentException("Position does not exist in hand:" + position);
        }
        return cardList.get(position);
    }

    public ArrayList<Card> sortBySuit() {
        ArrayList<Card> newHand = new ArrayList<Card>();
        while (cardList.size() > 0) {
            int position = 0;  // Position of minimal card.
            Card card = cardList.get(0);  // Minimal card.
            for (int i = 1; i < cardList.size(); i++) {
                Card c1 = cardList.get(i);
                if (c1.getSuit() < card.getSuit() ||  (c1.getSuit() == card.getSuit() && c1.getValue() < card.getValue()) ) {
                    position = i;
                    card = c1;
                }
            }
            cardList.remove(position);
            newHand.add(card);
        }
        cardList = newHand;
        return newHand;
    }

    public ArrayList sortByValue() {
        ArrayList<Card> newHand = new ArrayList<Card>();
        while (cardList.size() > 0) {
            int position = 0;  // Position of minimal card.
            Card card = cardList.get(0);  // Minimal card.
            for (int i = 1; i < cardList.size(); i++) {
                Card c1 = cardList.get(i);
                if ( c1.getValue() < card.getValue() ||
                        (c1.getValue() == card.getValue() && c1.getSuit() < card.getSuit()) ) {
                    position = i;
                    card = c1;
                }
            }
            cardList.remove(position);
            newHand.add(card);
        }
        cardList = newHand;
        return newHand;
    }
}
