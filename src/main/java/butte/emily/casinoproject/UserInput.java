package butte.emily.casinoproject;

import java.util.Scanner;

/**
 * Created by emilybutte on 10/11/16.
 */
public class UserInput {

    Scanner input = new Scanner(System.in);

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


//try {
//            casino.startCasino();
//        } catch (Exception e) {
//            System.out.println("Enter a valid option");
//            casino.startCasino();
//        }