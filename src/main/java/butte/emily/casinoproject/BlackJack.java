package butte.emily.casinoproject;

/**
 * Created by emilybutte on 10/13/16.
 */
public class BlackJack implements Game {

    UserInput user = new UserInput();
    Casino casino = new Casino();

    public double balance;
    public double bet;

    public void runGame() {
        casino.addPlayer();
        boolean playerWins = true;
        while (playerWins) {
            do {
                bet = user.getUserInfoDouble("How much do you want to bet?");
                if (bet < 0 || bet > balance)
                    System.out.println("Your answer must be between 0 and " + balance + '.');
            } while (bet < 0 || bet > balance);
            if (bet == 0)
                break;
            playerWins = playBlackjack();
            if (playerWins)
                balance = balance + bet;
            else
                balance = balance - bet;
            if (balance == 0) {
                System.out.println("Looks like you've are out of money!");
                break;
            }
        }
        System.out.println("You leave with $" + balance + '.');
    }

    static boolean playBlackjack() {

        Deck deck = new Deck();
        BlackjackHand dealerHand = new BlackjackHand();
        BlackjackHand userHand = new BlackjackHand();
        UserInput user = new UserInput();

        //deck.shuffle();
        dealerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());
        userHand.addCard(deck.deal());
        userHand.addCard(deck.deal());

        if (dealerHand.getBlackjackValue() == 21) {
            System.out.println("Dealer has the " + dealerHand.getCard(0)
                    + " and the " + dealerHand.getCard(1) + ".");
            System.out.println("User has the " + userHand.getCard(0)
                    + " and the " + userHand.getCard(1) + ".");
            System.out.println("Dealer has Blackjack.  Dealer wins.");
            return false;
        }

        if (userHand.getBlackjackValue() == 21) {
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
            System.out.println("Your total is " + userHand.getBlackjackValue());

            System.out.println("Dealer is showing the " + dealerHand.getCard(0));

            String userAction = user.getUserInfoString("Hit or Stand?");

            do {
                userAction = userAction.toUpperCase();
                if (userAction != "HIT" && userAction != "STAND")
                    System.out.println("Please respond HIT or STAND");
            } while (userAction != "HIT" && userAction != "STAND");
            if (userAction == "STAND") {
                break;
            } else {
                Card newCard = deck.deal();
                userHand.addCard(newCard);
                System.out.println("User hits.");
                System.out.println("Your card is the " + newCard);
                System.out.println("Your total is now " + userHand.getBlackjackValue());
                if (userHand.getBlackjackValue() > 21) {
                    System.out.println("You busted by going over 21.  You lose.");
                    System.out.println("Dealer's other card was the "
                            + dealerHand.getCard(1));
                    return false;
                }
            }
        }
        System.out.println("User stands.");
        System.out.println("Dealer's cards are");
        System.out.println("    " + dealerHand.getCard(0));
        System.out.println("    " + dealerHand.getCard(1));
        while (dealerHand.getBlackjackValue() <= 16) {
            Card newCard = deck.deal();
            System.out.println("Dealer hits and gets the " + newCard);
            dealerHand.addCard(newCard);
            if (dealerHand.getBlackjackValue() > 21) {
                System.out.println("Dealer busted by going over 21. You win.");
                return true;
            }
        }
        System.out.println("Dealer's total is " + dealerHand.getBlackjackValue());

        if (dealerHand.getBlackjackValue() == userHand.getBlackjackValue()) {
            System.out.println("Dealer wins on a tie.  You lose.");
            return false;
        } else if (dealerHand.getBlackjackValue() > userHand.getBlackjackValue()) {
            System.out.println("Dealer wins, " + dealerHand.getBlackjackValue()
                    + " points to " + userHand.getBlackjackValue() + ".");
            return false;
        } else {
            System.out.println("You win, " + userHand.getBlackjackValue()
                    + " points to " + dealerHand.getBlackjackValue() + ".");
            return true;
        }
    }
}

//    public void endGame() {}
//
//    public double increasePlayerBalance(double bet){
//        return balance;
//    }
//
//    public double decreasePlayerBalance(double bet){
//        return balance;
//    }


