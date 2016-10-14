package butte.emily.casinoproject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by emilybutte on 10/13/16.
 */
public class HandTest {

    private Hand hand;
    private Card card1;
    private Card card2;
    private Card card3;

    @Before
    public void setUp() {
        card1 = new Card(2, 3); // 2 of Clubs
        card2 = new Card(11, 1); // Jack of Hearts
        card3 = new Card(8, 2); // 8 of Diamonds
        hand = new Hand();
        hand.addCard(card1);
        hand.addCard(card2);
        hand.addCard(card3);
    }

    @Test
    public void clearTest() {
        hand.clear();
        int expected = 0;
        int actual = hand.currentHand.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCardTest() {
        int expected = 3;
        int actual = hand.currentHand.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeCardTest() {
        hand.removeCard(card2);
        int expected = 2;
        int actual = hand.currentHand.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeCardOverloadTest() {
        hand.removeCard(0);
        String expected = "[Jack of Hearts, 8 of Diamonds]";
        String actual = hand.currentHand.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCardCountTest() {
        int expected = 3;
        int actual = hand.getCardCount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCardTest() {
        String expected = "8 of Diamonds";
        String actual = hand.getCard(2).toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortBySuitTest() {
        String expected = "[Jack of Hearts, 8 of Diamonds, 2 of Clubs]";
        String actual = hand.sortBySuit().toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortByValueTest() {
        String expected = "[2 of Clubs, 8 of Diamonds, Jack of Hearts]";
        String actual = hand.sortByValue().toString();
        Assert.assertEquals(expected, actual);
    }

}

