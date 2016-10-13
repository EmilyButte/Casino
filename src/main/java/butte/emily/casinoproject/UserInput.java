package butte.emily.casinoproject;

import java.util.Scanner;

/**
 * Created by emilybutte on 10/11/16.
 */
public class UserInput {

    Scanner input = new Scanner(System.in);

    public int getUserInfoInt(String message) {
        System.out.println(message);
        return input.nextInt();
    }

    public double getUserInfoDouble(String message) {
        System.out.println(message);
        return input.nextDouble();
    }

    public String getUserInfoString(String message) {
        System.out.println(message);
        return input.next();
    }
}


//try {
//            casino.startCasino();
//        } catch (Exception e) {
//            System.out.println("Enter a valid option");
//            casino.startCasino();
//        }