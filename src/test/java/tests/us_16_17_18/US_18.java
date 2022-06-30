package tests.us_16_17_18;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MusteriPage;
import utilities.Driver;

public class US_18 {

    US_16_17_18_methods methods;

    @BeforeMethod
    public void setUp() {
        US_16_17_18_methods.refundRequestGiris();
    }
    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void US18_TC001() {

        methods = new US_16_17_18_methods();
        methods.refundListPrint("Request ID");
    }

    @Test
    public void US18_TC002() {


        methods = new US_16_17_18_methods();
        methods.refundListPrint("Order ID");
    }

    @Test
    public void US18_TC003() {

        methods = new US_16_17_18_methods();
        methods.refundListPrint("Amount");

    }

    @Test
    public void US18_TC004() {

        methods = new US_16_17_18_methods();
        methods.refundListPrint("Type");
        methods.refundListPrint("Reason");
    }

}
