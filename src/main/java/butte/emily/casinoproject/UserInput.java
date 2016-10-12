package butte.emily.casinoproject;

import java.util.Scanner;

/**
 * Created by emilybutte on 10/11/16.
 */
public class UserInput {

    Scanner input = new Scanner(System.in);

    public int getUserInput() {
        System.out.println("What would you like to play? Enter a number.");
        return input.nextInt();
    }

    public double getBet() {
        System.out.println("How much would you like to bet?");
        return input.nextDouble();
    }
}
