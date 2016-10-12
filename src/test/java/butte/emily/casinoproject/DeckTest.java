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
    private int[] test = new int[13];

    @Before
    public void setUp() {
        deck = new Deck();
//        card = new Card();
    }

    @Test
    public void cardsLeftTest() {

        int expected = 13;
        int actual = deck.cardsLeft(test);
        Assert.assertEquals(expected, actual);
    }
}
