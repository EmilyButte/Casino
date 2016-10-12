package butte.emily.casinoproject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by emilybutte on 10/12/16.
 */
public class PlayerTest {

    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        player1 = new Player("Billy", 100.00);
        player2 = new Player("Lisa", 20.00);
    }

    @Test
    public void getNameTest() {
        String expected = "Billy";
        String actual = player1.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBalanceTest() {
        int expected = 100;
        int actual = (int) player1.getBalance();
        Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void getHand() {
//        Card expected = ;
//        Card actual = player.getHand();
//        Assert.assertEquals(expected, actual);
//    }
}
