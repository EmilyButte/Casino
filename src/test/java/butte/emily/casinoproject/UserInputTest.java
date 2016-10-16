package butte.emily.casinoproject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by emilybutte on 10/15/16.
 */
public class UserInputTest {

    private DummyUserInput dummyUserInput;

    @Before
    public void setUp() {
        dummyUserInput = new DummyUserInput();
    }

    @Test
    public void getUserInputIntTest() {
        int expected = 12;
        int actual = dummyUserInput.getUserInfoInt("Enter an Integer");
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getUserInfoDoubleTest() {
        int expected = (int) 12.00;
        int actual = (int) dummyUserInput.getUserInfoDouble("Enter a double.");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getUserInfoString() {
        String expected = "Hello";
        String actual = dummyUserInput.getUserInfoString("Enter a string");
        Assert.assertEquals(expected, actual);
    }
}
