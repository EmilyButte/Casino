package butte.emily.casinoproject;

/**
 * Created by emilybutte on 10/10/16.
 */
public class Card {

    public final static int SPADES = 0;
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;

    public final static int ACE = 1;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;

    private final int value;
    private final int suit;

    public final int getSuit() {
        return suit;
    }

    public final int getValue() {
        return value;
    }


    public Card(int value, int suit) {
//        if (suit != SPADES && suit != HEARTS && suit != DIAMONDS && suit != CLUBS) {
//            throw new IllegalArgumentException("Suit not valid.");
//        }
//        if (value < 1 || value > 13) {
//            throw new IllegalArgumentException("Card value is not valid.");
//        }
        this.value = value;
        this.suit = suit;
    }

    public String getSuitAsString() {
        switch (suit) {
            case SPADES:
                return "Spades";
            case HEARTS:
                return "Hearts";
            case DIAMONDS:
                return "Diamonds";
            case CLUBS:
                return "Clubs";
            default:
                return "error";
        }
    }

    public String getValueAsString() {
        switch (value) {
            case 1:
                return "Ace";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            default:
                return "King";
        }
    }

    @Override
    public String toString() {
        return getValueAsString() + " of " + getSuitAsString();
    }
}






