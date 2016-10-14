package butte.emily.casinoproject;


/**
 * Created by emilybutte on 10/13/16.
 */
public class BlackJack implements Game {

    public double bet;
    public double balance;
    public String name;
    public String userAction;

    UserInput user = new UserInput();
    Casino casino = new Casino();
    Player player = new Player(name, balance);
    Deck deck = new Deck();
    BlackJackHand dealerHand = new BlackJackHand();
    BlackJackHand userHand = new BlackJackHand();

    public void runGame() {
        casino.addPlayer();
        boolean playerWins = true;
        while (playerWins) {
            dealerHand.clear();
            userHand.clear();
            do {
                bet = user.getUserInfoDouble("How much do you want to bet?");
                if (bet < 0 || bet > casino.balance)
                    System.out.println("Your answer must be between 0 and " + casino.balance + '.');
            } while (bet < 0 || bet > casino.balance);
            if (bet == 0)
                break;
            playerWins = playBlackJack();
            if (playerWins)
                casino.balance = casino.balance + bet;
            else
                casino.balance = casino.balance - bet;
            if (casino.balance == 0) {
                System.out.println("Looks like you've are out of money!");
                break;
            }
        }
        System.out.println("You leave with $" + casino.balance + '.');
    }

    public boolean playBlackJack() {

        deck.shuffle();

        dealerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());

        userHand.addCard(deck.deal());
        userHand.addCard(deck.deal());

        if (dealerHand.getBlackJackValue() == 21) {
            System.out.println("Dealer has the " + dealerHand.getCard(0)
                    + " and the " + dealerHand.getCard(1) + ".");
            System.out.println("User has the " + userHand.getCard(0)
                    + " and the " + userHand.getCard(1) + ".");
            System.out.println("Dealer has Blackjack.  Dealer wins.");
            return false;
        }

        if (userHand.getBlackJackValue() == 21) {
            System.out.println("Dealer has the " + dealerHand.getCard(0)
                    + " and the " + dealerHand.getCard(1) + ".");
            System.out.println("User has the " + userHand.getCard(0)
                    + " and the " + userHand.getCard(1) + ".");
            System.out.println("You have Blackjack.  You win.");
            return true;
        }

        while (true) {
            System.out.println("Your cards are:");
            for (int i = 0; i < userHand.getCardCount(); i++)
                System.out.println("    " + userHand.getCard(i));
            System.out.println("Your total is " + userHand.getBlackJackValue());

            System.out.println("Dealer is showing the " + dealerHand.getCard(0));

            userAction = user.getUserInfoString("Hit or Stay?");
            userAction = userAction.toUpperCase();

            if (userAction.equals("HIT")) {
                hit();
            } else if (userAction.equals("STAY")) {
                stay();
            } else {
                System.out.println("Please respond hit or stay");
            }
            System.out.println("Dealer's total is " + dealerHand.getBlackJackValue());
            if (dealerHand.getBlackJackValue() == userHand.getBlackJackValue()) {
                System.out.println("Dealer wins on a tie.  You lose.");
                return false;
            } else if (dealerHand.getBlackJackValue() > userHand.getBlackJackValue()) {
                System.out.println("Dealer wins, " + dealerHand.getBlackJackValue()
                        + " points to " + userHand.getBlackJackValue() + ".");
                return false;
            } else if (userHand.getBlackJackValue() > dealerHand.getBlackJackValue() && userHand.getBlackJackValue() <=21){
                System.out.println("You win, " + userHand.getBlackJackValue()
                        + " points to " + dealerHand.getBlackJackValue() + ".");
                return true;
            }
        }
    }

    public boolean hit() {

        System.out.println("User hits!");
        Card newCard = deck.deal();
        userHand.addCard(newCard);
        System.out.println("Your card is the " + newCard);
        System.out.println("Your total is now " + userHand.getBlackJackValue());
        if (userHand.getBlackJackValue() > 21) {
            System.out.println("You busted by going over 21.  You lose.");
            System.out.println("Dealer's other card was the " + dealerHand.getCard(1));
        }
            return false;
    }

    public boolean stay() {
        System.out.println("User stays.");
        System.out.println("Dealer's cards are: ");
        System.out.println("    " + dealerHand.getCard(0));
        System.out.println("    " + dealerHand.getCard(1));
        while (dealerHand.getBlackJackValue() <= 16) {
            Card newCard = deck.deal();
            System.out.println("Dealer hits and gets the " + newCard);
            dealerHand.addCard(newCard);
            if (dealerHand.getBlackJackValue() > 21) {
                System.out.println("Dealer busted by going over 21. You win.");
            }
        }
        return true;
    }
}
