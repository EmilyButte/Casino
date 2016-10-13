package butte.emily.casinoproject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by emilybutte on 10/12/16.
 */
public class CardTest {

    private Card card;
    private Card card2;

    @Before
    public void setUp() {
        card = new Card(10, 1); //10 of Hearts
        card2 = new Card(3, 3); //3 of Clubs
    }

    @Test
    public void getSuitTest() {
        int expected = 1;
        int actual = card.getSuit();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSuitTest2() {
        int expected = 3;
        int actual = card2.getSuit();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getValueTest() {
        int expected = 10;
        int actual = card.getValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getValueTest2() {
        int expected = 3;
        int actual = card2.getValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getValueAsStringTest() {
        String expected = "10";
        String actual = card.getValueAsString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getValueAsStringTest2() {
        String expected = "3";
        String actual = card2.getValueAsString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSuiteAsStringTest(){
        String expected = "Hearts";
        String actual = card.getSuitAsString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSuiteAsStringTest2(){
        String expected = "Clubs";
        String actual = card2.getSuitAsString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        String expected = "10 of Hearts";
        String actual = card.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest2() {
        String expected = "3 of Clubs";
        String actual = card2.toString();
        Assert.assertEquals(expected, actual);
    }
}
