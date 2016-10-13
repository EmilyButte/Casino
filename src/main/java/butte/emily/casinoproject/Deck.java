package butte.emily.casinoproject;

/**
 * Created by emilybutte on 10/12/16.
 */
public class Deck {

    private Card[] deck;
    private int cardsUsed;

    //if false, Jokers are included.
    public Deck() {
        this(false);
    }

    public Deck(boolean includeJokers) {
        if(includeJokers) {
            deck = new Card[54];
        } else {
            deck = new Card[52];
        }

        int cardCount = 0;
        for(int suit = 0; suit <= 3; suit++) {
            for(int value = 1; value <= 13; value++) {
                deck[cardCount] = new Card(value, suit);
                cardCount++;
            }
        }
        if(includeJokers) {
            deck[53] = new Card(1, Card.JOKER);
            deck[54] = new Card(2, Card.JOKER);
        }
        cardsUsed = 0;
        System.out.println(deck);
    }

    public Card[] getDeck() {
        return deck;
    }

    public void shuffle() {
        //rearranges the 52 cards in random order
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
        if(cardsUsed == deck.length) {
            throw new IllegalStateException("No cards left");
        }
        cardsUsed++;
        return deck[cardsUsed-1];
    }

    public boolean hasJokers() {
        return deck.length == 54;
    }
}
