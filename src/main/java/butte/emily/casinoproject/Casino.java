package butte.emily.casinoproject;

/**
 * Created by emilybutte on 10/12/16.
 */
public class Casino {

    Player player;
    UserInput input;
    PlayerDisplay display;


    public void startCasino() {
        display = new PlayerDisplay();
        display.welcome();
        display.runCasino(player);
    }

    public void addPlayer() {
        input = new UserInput();
        String name = input.getUserInfoString("What is your name?");
        double balance = input.getUserInfoDouble("How much money would you like to play with?");
        player = new Player(name, balance);
        System.out.println("Get ready to play " + name + "." + "Your balance is " + balance);
    }
}
