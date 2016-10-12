package butte.emily.casinoproject;

/**
 * Created by emilybutte on 10/12/16.
 */
public class App {

    public static void main(String[] args) {

        Casino casino = new Casino();

        try {
            casino.startCasino();
        } catch (Exception e) {
            System.out.println("Enter a valid option");
            casino.startCasino();
        }
    }
}