package butte.emily.casinoproject;

/**
 * Created by emilybutte on 10/13/16.
 */
public class SlotMachine implements Game{
    Deck deck = new Deck();
    Player player = new Player("Emily", 100);

    public double balance;
    public double bet;
    boolean playerWins;

    public void runGame(){

    }


    public void endGame() {

    }

    public double increasePlayerBalance(double bet){
        return balance;

    }
    public double decreasePlayerBalance(double bet){
        return balance;
    }
}
