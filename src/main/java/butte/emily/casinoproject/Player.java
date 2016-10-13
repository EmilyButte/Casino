package butte.emily.casinoproject;

/**
 * Created by emilybutte on 10/11/16.
 */
public class Player {

    private String name;
    private double balance;
    private Card hand;

    public Player(String name, double balance) {
        this.name = name;
        this.balance = balance;
        hand = new Card();
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Card getHand() {
        return hand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setHand(Card hand) {
        this.hand = hand;
    }
}
