package butte.emily.casinoproject;

/**
 * Created by emilybutte on 10/11/16.
 */
public class PlayerDisplay {

    UserInput user = new UserInput();
    BlackJack blackJack = new BlackJack();
    CrazyEights crazyEights = new CrazyEights();
    SlotMachine slotMachine = new SlotMachine();


    public void welcome() {
        System.out.println("  ______   __       __                  __  __    __         ______          ______  __                    __           \n" +
                " /      \\ |  \\      |  \\                |  \\| \\  |  \\       /      \\       /      \\  |  \\                  |   \\          \n" +
                "|  $$$$$$\\| $$____   \\$$  ______         $$ | $$\\ | $$      |  $$$$$$\\     |  $$$$$$\\| $$____      ______   \\$$  ______  \n" +
                "| $$   \\$$| $$    \\ |  \\ /      \\        \\$ | $$$\\| $$      | $$__| $$     | $$   \\$$| $$    \\   |      \\   |  \\ /      \\ \n" +
                "| $$      | $$$$$$$\\| $$|  $$$$$$\\          | $$$$\\ $$      | $$    $$     | $$      | $$$$$$$\\  \\$$$$$$\\  | $$|   $$$$$$\\\n" +
                "| $$   __ | $$  | $$| $$| $$  | $$          | $$\\$$ $$      | $$$$$$$$     | $$   __ | $$  | $$ /      $$  | $$ | $$   \\$$\n" +
                "| $$__/  \\| $$  | $$| $$| $$__/ $$          | $$ \\$$$$      | $$  | $$     | $$__/  \\| $$  | $$ | $$$$$$$  | $$ | $$      \n" +
                " \\$$    $$| $$  | $$| $$| $$    $$          | $$  \\$$$      | $$  | $$      \\$$    $$| $$  | $$ \\$$    $$  | $$ | $$      \n" +
                "  \\$$$$$$  \\$$   \\$$ \\$$|$$$$$$$             \\$$   \\$$      \\ $$  \\ $$       \\$$$$$$  \\$$   \\$$  \\$$$$$$$   \\$$  \\$$      \n" +
                "                         | $$                                                                                            \n" +
                "                         | $$                                                                                            \n" +
                "                          \\$$                                                                                            ");
    }


    public void runCasino(Player player) {
        int game = user.getUserInfoInt(
                "Choose a game:\n" +
                        "1 - BLACKJACK\n" +
                        "2 - CRAZY_EIGHTS\n" +
                        "3 - SLOT MACHINE\n" +
                        "4 - EXIT");
        switch (game) {
            case 1:
                blackJack.runGame();
                break;
            case 2:
                crazyEights.runGame();
                break;
            case 3:
                slotMachine.runGame();
                break;
            case 4:
                break;
            default:
                System.out.println("Sorry, entry invalid. Please enter NUMBER");
        }
    }
}




