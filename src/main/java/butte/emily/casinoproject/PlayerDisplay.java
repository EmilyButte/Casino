package butte.emily.casinoproject;

import javax.swing.*;

/**
 * Created by emilybutte on 10/11/16.
 */
public class PlayerDisplay {

    private boolean playing = true;
    private int menuOption;
    public final static int BLACKJACK = 1;
    public final static int CRAZY_EIGHTS = 2;
    public final static int SLOT_MACHINE = 3;
    public final static int EXIT = 4;


    UserInput user = new UserInput();
    Deck deck = new Deck();
    BlackJack blackJack = new BlackJack();
    CrazyEights crazyEights = new CrazyEights();
    SlotMachine slotMachine = new SlotMachine();



    public void welcome() {
        System.out.println("  ______    __        __       __  __    __         ______          ______   __                  __           \n" +
                " /      \\ |  \\      |  \\              |  \\| \\  |  \\      /      \\       /      \\ |  \\                |  \\          \n" +
                "|  $$$$$$\\| $$____  \\$$  ______        | $$| $$\\ | $$      |  $$$$$$\\     |  $$$$$$\\| $$____      ______   \\$$  ______  \n" +
                "| $$   \\$$| $$    \\ |  \\ /      \\    \\$ | $$$\\| $$      | $$__| $$      | $$   \\$$| $$    \\   |      \\ |  \\ /      \\ \n" +
                "| $$       | $$$$$$$\\|$$| $$$$$$\\          | $$$$\\ $$      | $$    $$      | $$       | $$$$$$$\\  \\$$$$$$\\| $$|   $$$$$$\\\n" +
                "| $$   __  | $$  | $$| $$| $$  | $$          | $$\\$$ $$      | $$$$$$$$      | $$   __  | $$  | $$ /       $$  | $$| $$   \\$$\n" +
                "| $$__/  \\| $$  | $$| $$| $$__/ $$          | $$ \\$$$$      | $$  | $$      | $$__/  \\| $$  | $$ |  $$$$$$$  | $$| $$      \n" +
                " \\$$    $$| $$  | $$| $$| $$    $$          | $$  \\$$$      | $$  | $$      \\$$     $$| $$  | $$ \\$$    $$  | $$| $$      \n" +
                "  \\$$$$$$ \\$$  \\$$\\$$|$$$$$$$            \\$$   \\$$      \\$$  \\$$       \\$$$$$$  \\$$  \\$$  \\$$$$$$$  \\$$\\$$      \n" +
                "                         | $$                                                                                            \n" +
                "                         | $$                                                                                            \n" +
                "                         \\$$                                                                                            ");
    }

    public void menu() {

        System.out.println(
                "1 - BLACKJACK\n" +
                "2 - CRAZY_EIGHTS\n" +
                "3 - SLOT MACHINE\n" +
                "4 - EXIT");
    }

    public void runCasino(Player player) {
        menu();
        while (playing) {
            menuOption = user.getUserInput();
            switch (menuOption) {
                case BLACKJACK:
                    blackJack.runGame();
                    break;
                case CRAZY_EIGHTS:
                    crazyEights.runGame();
                    break;
                case SLOT_MACHINE:
                    slotMachine.runGame();
                    break;
                case EXIT:
                    break;
                default:
                    System.out.println("Please enter a valid option");
            }
        }
    }

    public void dealerHand() {
        Card dealerHand;
        dealerHand = deck.deal();
    }

    public void playerHand() {
        Card playerHand;
        playerHand = deck.deal();
    }
}
