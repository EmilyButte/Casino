package butte.emily.casinoproject;


/**
 * Created by emilybutte on 10/13/16.
 */
public class BlackJack implements Game {

    private double bet;
    private double balance;

    private String userAction;
    private double updatedBalance;
    private String playAgainStatus;

    private UserInput user = new UserInput();
    private Casino casino = new Casino();
    private Deck deck = new Deck();
    public BlackJackHand dealerHand;
    public BlackJackHand playerHand;

    public BlackJack() {
        dealerHand = new BlackJackHand();
        playerHand = new BlackJackHand();
    }

    public void runGame() {
        casino.addPlayer();
        getBet();
        playBlackJack();
    }

    public double getBet() {
        bet = user.getUserInfoDouble("How much do you want to bet?");
        validateBet();
        return bet;
    }

    public void validateBet() {
        if (bet < 0 || bet > casino.balance) {
            System.out.println("Your answer must be between 0 and " + casino.balance + '.');
            getBet();
        }
    }

    public void shuffleDeck() {
        deck.shuffle();
    }

    public void dealBlackJack() {
        dealerHand.addCard(deck.deal());
        dealerHand.addCard(deck.deal());
        playerHand.addCard(deck.deal());
        playerHand.addCard(deck.deal());
    }

    public void playBlackJack() {
        shuffleDeck();
        dealBlackJack();
        System.out.println("Your cards are:");
        for (int i = 0; i < playerHand.getCardCount(); i++) {
            System.out.println("    " + playerHand.getCard(i));
        }
        System.out.println("Your total is " + playerHand.getBlackJackValue());
        System.out.println("Dealer is showing the " + dealerHand.getCard(0));
        determineStateOfGame();
    }

    public void determineStateOfGame(){
        dealerBlackJack();
        playerBlackJack();
        askPlayerToHitOrStay();
    }

    public void dealerBlackJack() {
        if (dealerHand.getBlackJackValue() == 21) {
            System.out.println("Dealer has the " + dealerHand.getCard(0) + " and the " + dealerHand.getCard(1) + ".");
            System.out.println("User has the " + playerHand.getCard(0) + " and the " + playerHand.getCard(1) + ".");
            System.out.println("Dealer has Blackjack.  Dealer wins.");
        }
    }

    public void playerBlackJack() {
        if (playerHand.getBlackJackValue() == 21) {
            System.out.println("Dealer has the " + dealerHand.getCard(0) + " and the " + dealerHand.getCard(1) + ".");
            System.out.println("User has the " + playerHand.getCard(0) + " and the " + playerHand.getCard(1) + ".");
            System.out.println("You have Blackjack.  You win.");
            updatedBalance = casino.balance + bet;
            System.out.println("Your balance is " + updatedBalance);
        }
    }

    private String askPlayerToHitOrStay() {
        userAction = user.getUserInfoString("Hit or Stay?").toUpperCase();
        processHitOrStayAnswer();
        return userAction;
    }

    public String processHitOrStayAnswer() {
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
        System.out.println("Dealer's total is " + dealerHand.getBlackJackValue());//does this and the following line ever get executed?
        determineWinner();
        return userAction;
    }


    private Card hit() {
        System.out.println("User hits!");
        Card newCard = deck.deal();
        playerHand.addCard(newCard);
        System.out.println("Your card is the " + newCard);
        System.out.println("Your total is now " + playerHand.getBlackJackValue());
        if (playerHand.getBlackJackValue() <= 21) {
            askPlayerToHitOrStay();
        } else {
            System.out.println("You busted by going over 21.  You lose.");
            doYouWantToPlayAgain();
            processPlayAgainAnswer();
        }
        return newCard;
    }

    private void stay() {
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

    private void determineWinner() {
        if ((dealerHand.getBlackJackValue()) == (playerHand.getBlackJackValue())) {
            System.out.println("Dealer wins on a tie. You lose.");
        } else if ((dealerHand.getBlackJackValue() > (playerHand.getBlackJackValue()) && (dealerHand.getBlackJackValue() <= 20))) {
            System.out.println("Dealer wins.");
            balance -= bet;
        } else if ((playerHand.getBlackJackValue() > (dealerHand.getBlackJackValue())) && (playerHand.getBlackJackValue() <= 20)) {
            System.out.println("You win.");
            balance += bet;
        }
        System.out.println("Your balance is " + balance);
    }

    public String doYouWantToPlayAgain() {
        playAgainStatus = user.getUserInfoString("Do you want to play again? Yes or No").toUpperCase();
        return playAgainStatus;
    }

    public void processPlayAgainAnswer(){
        doYouWantToPlayAgain();
        switch (playAgainStatus) {
            case "YES":
                runGame();
                dealerHand.clear();
                playerHand.clear();
                break;
            case "NO":
                endGame();
                break;
            default:
                System.out.println("Invalid entry. Enter Yes or No.");
        }
    }

    public void endGame() {
        System.out.println("Game Over");
    }
}

