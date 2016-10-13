package butte.emily.casinoproject;

/**
 * Created by emilybutte on 10/11/16.
 */
public interface Game {
     void runGame();
     void endGame();
     double increasePlayerBalance(double bet);
     double decreasePlayerBalance(double bet);
}
