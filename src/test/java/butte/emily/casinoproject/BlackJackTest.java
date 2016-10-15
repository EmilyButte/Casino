package butte.emily.casinoproject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by emilybutte on 10/14/16.
 */
public class BlackJackTest {

    private BlackJack blackJack;

    @Before
    public void setUp() {
        blackJack = new BlackJack();
    }

//    @Test
//    public void endGameTest() {
//        String expected = "Game Over";
//         actual = blackJack.endGame();
//        Assert.assertEquals(expected, actual);
//    }

    @Test
    public void doYouWantToPlayAgainTest() {
        String playAgain = blackJack.doYouWantToPlayAgain();
        String expected = "YES";
        String actual = playAgain;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testToMakeSurePlayerIsDealtAHand() {
        int actual = blackJack.playerHand.getBlackJackValue();
        Assert.assertTrue(actual > 0 && actual < 21);
    }


    @Test
    public void testToMakeSureDealerIsDealtAHand() {
        blackJack.dealBlackJack();
        int actual = blackJack.dealerHand.getBlackJackValue();
        Assert.assertTrue(actual > 0 && actual < 21);
    }

    @Test
    public void testPlayerHasBlackJack(){
        String expected = "You win.";
        String actual = ;
        Assert.assertEquals(expected, actual);
    }
}
