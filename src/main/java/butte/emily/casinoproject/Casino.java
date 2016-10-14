package butte.emily.casinoproject;

/**
 * Created by emilybutte on 10/12/16.
 */
public class Casino {

    private Player player;
    private UserInput input;
    private PlayerDisplay display;

    public String name;
    public double balance;

    public void startCasino() {
        display = new PlayerDisplay();
        display.welcome();
        display.runCasino(player);
    }

    public void addPlayer() {
        input = new UserInput();
        name = input.getUserInfoString("What is your name?");
        balance = input.getUserInfoDouble("How much money would you like to play with?");

        player = new Player(name, balance);
        System.out.println("Get ready to play " + name + "." + "Your balance is " + balance);
    }
}
