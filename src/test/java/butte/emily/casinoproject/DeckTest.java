package butte.emily.casinoproject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by emilybutte on 10/12/16.
 */
public class DeckTest {

    private Deck deck;
    //private Card card;


    @Before
    public void setUp() {
        deck = new Deck(false);
//        card = new Card();
    }

    @Test
    public void cardsLeftTest() {
        int expected = 42;
        int actual = deck.cardsLeft(10);
        Assert.assertEquals(expected, actual);
    }


}
