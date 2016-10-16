package butte.emily.casinoproject;

import java.util.Scanner;

/**
 * Created by emilybutte on 10/11/16.
 */
public class UserInput {

    public String message;
    Scanner input = new Scanner(System.in);
    //StringBuilder stringBuilder = new StringBuilder(message);
    //make a message class that holds all the things you want to ask the user
    //this will remove the Sys out from the blackjack game

    public int getUserInfoInt(String message) {
        System.out.println(message);
        int answer = input.nextInt();
        return answer;
    }

    public double getUserInfoDouble(String message) {
        System.out.println(message);
        double answer = input.nextDouble();
        return answer;
    }

    public String getUserInfoString(String message) {
        System.out.println(message);
        String answer = input.next();
        return answer;
    }
}
