package butte.emily.casinoproject;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by emilybutte on 10/12/16.
 */
public class DeckTest {

    private Deck deck;
    //private Card card;
    static List<List<Card>> previousDeck = new ArrayList<>();

    @Before
    public void setUp() {
        deck = new Deck(false);
    }

//    @Test //test order of deck 1 and deck2 to make sure they are not the same - check size as well
//    public void shuffle() {
//        deck.shuffle();
//        List<Card> shuffled = new ArrayList<>();
//        Iterators.(shuffled);
//    }

    @Test
    public void cardsLeftTest() {
        int expected = 42;
        int actual = deck.cardsLeft(10);
        Assert.assertEquals(expected, actual);
    }
}
