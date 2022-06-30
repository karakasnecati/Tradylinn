package tests.us_019_020_021;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TakipcilerPage;
import tests.Login;
import utilities.Driver;
import utilities.ReusableMethod;
import utilities.TestBaseRapor;

public class TC_001 extends TestBaseRapor {
    TakipcilerPage takipcilerPage;
    Actions actions= new Actions(Driver.getDriver());
    @Test
    public void test01() {

        extentTest=extentReports.createTest("Takipciler","takipciler gorulebilmeli");
        Login.giris();
        extentTest.info("login olundu");
        takipcilerPage= new TakipcilerPage();
        takipcilerPage.storeManager.click();
        extentTest.info("storeManagera tiklandi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        takipcilerPage.takipciler.click();
        extentTest.info("takipcilere tiklandi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethod.waitFor(4);
        Assert.assertTrue(takipcilerPage.followersList.isDisplayed());
        extentTest.pass("takipci listesi goruldu");
        Driver.closeDriver();

    }
}
