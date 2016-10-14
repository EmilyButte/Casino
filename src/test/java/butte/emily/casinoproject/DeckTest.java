package butte.emily.casinoproject;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.Object;

import java.util.*;

/**
 * Created by emilybutte on 10/12/16.
 */
public class DeckTest {

    public Deck deck;
    private ArrayList<Card> theDeck;


    @Before
    public void setUp() {
        deck = new Deck();
        theDeck = new ArrayList<>();
    }

    @Test
    public void testShuffle() {
        Iterator<Card> preShuffleDeck = theDeck.iterator();
        ArrayList<Card> shuffledDeck = deck.shuffle(theDeck);
        Assert.assertFalse(preShuffleDeck.equals(shuffledDeck));
        //Assert.assertTrue(!theDeck.size() == shuffledDeck.size()));
    }

    @Test
    public void cardsLeftTest() {
        int expected = 42;
        int actual = deck.cardsLeft(10);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealTest() {
        for(int i =0; i < 2; i++) {
            deck.deal();
        }
        int expected = 50;
        int actual = deck.cardsLeft(0);
        Assert.assertEquals(expected, actual);
    }
}
