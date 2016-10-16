package butte.emily.casinoproject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by emilybutte on 10/14/16.
 */
public class BlackJackTest {

    private BlackJack blackJack;
    private Player player;
    private BlackJackHand hand;
    private Card card1;
    private Card card2;

    @Before
    public void setUp() {
        blackJack = new BlackJack();
        player = new Player("Emily", 100.00);
        hand = new BlackJackHand();
        card1 = new Card(10, 3); // 10 of Clubs
        card2 = new Card(1, 1); // Ace of Diamonds
    }

//    @Test
//    public void endGameTest() {
//        String expected = "Game Over";
//         actual = blackJack.endGame();
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void doYouWantToPlayAgainTest() {
//        String playAgain = blackJack.doYouWantToPlayAgain();
//        String expected = "YES";
//        String actual = playAgain;
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testToMakeSurePlayerIsDealtAHand() {
//        int actual = blackJack.playerHand.getBlackJackValue();
//        Assert.assertTrue(actual > 0 && actual < 21);
//    }
//
//
//    @Test
//    public void testToMakeSureDealerIsDealtAHand() {
//        blackJack.dealBlackJack();
//        int actual = blackJack.dealerHand.getBlackJackValue();
//        Assert.assertTrue(actual > 0 && actual < 21);
//    }
//
//    @Test
//    public void testPlayerHasBlackJack(){
//        String expected = "You win.";
//        String actual = blackJack.playBlackJack();
//        Assert.assertEquals(expected, actual);
//    }
}
