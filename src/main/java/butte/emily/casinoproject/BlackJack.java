package butte.emily.casinoproject;


/**
 * Created by emilybutte on 10/13/16.
 */
public class BlackJack implements Game {

    public double bet;
    public double balance;
    public String userAction;
    private double updatedBalance;


    UserInput user = new UserInput();
    Casino casino = new Casino();
    Deck deck = new Deck();
    BlackJackHand dealerHand = new BlackJackHand();
    BlackJackHand playerHand = new BlackJackHand();

    public void runGame() {
        casino.addPlayer();
        getBet();
        dealBlackJack();
        playBlackJack();
    }

    public double getBet() {
        bet = user.getUserInfoDouble("How much do you want to bet?");
        if (bet < 0 || bet > casino.balance) {
            System.out.println("Your answer must be between 0 and " + casino.balance + '.');
            bet = user.getUserInfoDouble("How much do you want to bet?");
        }
            return bet;
    }

    public String doYouWantToPlayAgain() {
        String playAgain = user.getUserInfoString("Do you want to play again? Yes or No").toUpperCase();
        switch (playAgain) {
            case "YES":
                playBlackJack();
                break;
            case "NO":
                endGame();
                break;
            default:
                System.out.println("Invalid entry. Enter Yes or No.");
        }
        return playAgain;
    }

    public void endGame() {
        System.out.println("Game Over");
    }


    public void dealBlackJack() {
        deck.shuffle();

        dealerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());

        playerHand.addCard(deck.deal());
        playerHand.addCard(deck.deal());
    }


    public void playBlackJack() {
        boolean playing = true;

        while (playing) {
            if (dealerHand.getBlackJackValue() == 21) {
                System.out.println("Dealer has the " + dealerHand.getCard(0) + " and the " + dealerHand.getCard(1) + ".");
                System.out.println("User has the " + playerHand.getCard(0) + " and the " + playerHand.getCard(1) + ".");
                System.out.println("Dealer has Blackjack.  Dealer wins.");
            } else if (playerHand.getBlackJackValue() == 21) {
                System.out.println("Dealer has the " + dealerHand.getCard(0) + " and the " + dealerHand.getCard(1) + ".");
                System.out.println("User has the " + playerHand.getCard(0) + " and the " + playerHand.getCard(1) + ".");
                System.out.println("You have Blackjack.  You win.");
                updatedBalance = casino.balance + bet;
                System.out.println("Your balance is " + updatedBalance);
            } else {
                System.out.println("Your cards are:");
                for (int i = 0; i < playerHand.getCardCount(); i++) {
                    System.out.println("    " + playerHand.getCard(i));
                }
                System.out.println("Your total is " + playerHand.getBlackJackValue());
                System.out.println("Dealer is showing the " + dealerHand.getCard(0));
                hitOrStay();
            }
            playing = false;
        }
    }

    public String hitOrStay() {
        userAction = user.getUserInfoString("Hit or Stay?").toUpperCase();
        while(playerHand.getBlackJackValue() < 21) {
            switch (userAction) {
                case "HIT":
                    hit();
                    break;
                case "STAY":
                    stay();
                    break;
                default:
                    System.out.println("Please respond hit or stay");
            }
            break;
        }
        System.out.println("Dealer's total is " + dealerHand.getBlackJackValue());
        determineWinner();
        return userAction;
    }

    public void determineWinner() {
        if ((dealerHand.getBlackJackValue()) == (playerHand.getBlackJackValue())) {
            System.out.println("Dealer wins on a tie. You lose.");
        } else if ((dealerHand.getBlackJackValue() > (playerHand.getBlackJackValue()) && (dealerHand.getBlackJackValue() <= 20))) {
            System.out.println("Dealer wins.");
            balance -= bet;
        } else if ((playerHand.getBlackJackValue() > (dealerHand.getBlackJackValue())) && (playerHand.getBlackJackValue() <= 20)) {
            System.out.println("You win.");;
            balance += bet;
        }
        System.out.println("Your balance is " + balance);
    }


    public Card hit() {
        System.out.println("User hits!");
        Card newCard = deck.deal();
        playerHand.addCard(newCard);
        System.out.println("Your card is the " + newCard);
        System.out.println("Your total is now " + playerHand.getBlackJackValue());
        if (playerHand.getBlackJackValue() <= 21) {
            hitOrStay();
        } else {
            System.out.println("You busted by going over 21.  You lose.");
            doYouWantToPlayAgain();
        }
        return newCard;
    }

    public void stay() {
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
    }
}

