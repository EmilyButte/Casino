package butte.emily.casinoproject;

/**
 * Created by emilybutte on 10/12/16.
 */
public class Deck {

    private Card[] deck;
    private int cardsUsed;
    private Card[] hand;
    private int currentCard;

    public Deck() {
        deck = new Card[52];
        int cardCount = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int value = 1; value <= 13; value++) {
                deck[cardCount] = new Card(value, suit);
                cardCount++;
            }
            cardsUsed = 0;
        }
    }

    public void shuffle() {
        for(int i = deck.length-1; i > 0; i--) {
            int random = (int) Math.random()*(i+1);
            Card temp = deck[i];
            deck[i] = deck[random];
            deck[random] = temp;
        }
        cardsUsed = 0;
    }

    public int cardsLeft(int cardsUsed){
        return deck.length - cardsUsed;
    }

    public Card deal() {
        if(currentCard < deck.length) {
            cardsUsed++;
        } else {
            throw new IllegalStateException("No cards left");
        }
        return deck[cardsUsed-1];
    }
}

