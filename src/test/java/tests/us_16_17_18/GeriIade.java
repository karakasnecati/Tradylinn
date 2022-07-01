package tests.us_16_17_18;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;

public class GeriIade {

    Methods methods;

    @BeforeMethod
    public void setUp() {
        Methods.refundRequestGiris();
    }
    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void US18_TC001() {

        methods = new Methods();
        methods.refundListPrint("Request ID");
    }

    @Test
    public void US18_TC002() {


        methods = new Methods();
        methods.refundListPrint("Order ID");
    }

    @Test
    public void US18_TC003() {

        methods = new Methods();
        methods.refundListPrint("Amount");

    }

    @Test
    public void US18_TC004() {

        methods = new Methods();
        methods.refundListPrint("Type");
        methods.refundListPrint("Reason");
    }

}
