package butte.emily.casinoproject;

import java.util.Scanner;

/**
 * Created by emilybutte on 10/15/16.
 */
public class DummyUserInput {

    String dummyMessage;
    Scanner dummyInput = new Scanner(System.in);


    public int getUserInfoInt(String dummyMessage) {
        System.out.println(dummyMessage);
        int answer = 12;
        return answer;
    }

    public double getUserInfoDouble(String dummyMessage) {
        System.out.println(dummyMessage);
        double answer = 12.00;
        return answer;
    }

    public String getUserInfoString(String dummyMessage) {
        System.out.println(dummyMessage);
        String answer = "Hello";
        return answer;
    }
}
