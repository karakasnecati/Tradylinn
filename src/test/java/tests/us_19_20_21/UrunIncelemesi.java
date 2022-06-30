package tests.us_19_20_21;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IncelemelerPage;
import tests.Login;
import utilities.Driver;
import utilities.ReusableMethod;
import utilities.TestBaseRapor;


public class UrunIncelemesi extends TestBaseRapor {
    IncelemelerPage incelemelerPage;
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("incelemeler", "store manager olarak urunler incelenebilmeli");
        ReusableMethod.waitFor(10);
        Login.giris();
        extentTest.info("login olundu");
        Thread.sleep(3000);
        incelemelerPage = new IncelemelerPage();
        incelemelerPage.storeManager.click();
        extentTest.info("store Managera tiklandi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        incelemelerPage.incelemeler.click();
        extentTest.info("incelemelere tiklandi");
        incelemelerPage.productReviews.click();
        extentTest.info("productReviews tiklandi");
        Assert.assertTrue(incelemelerPage.author.isDisplayed());
        extentTest.pass("autor goruldu");
        Assert.assertTrue(incelemelerPage.comment.isDisplayed());
        extentTest.pass("commet goruldu");
        Assert.assertTrue(incelemelerPage.rating.isDisplayed());
        extentTest.pass("rating goruldu");
        Assert.assertTrue(incelemelerPage.product.isDisplayed());
        extentTest.pass("product goruldu");
        Assert.assertTrue(incelemelerPage.dated.isDisplayed());
        extentTest.pass("dated goruldu");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        incelemelerPage.showing1to3of3entries.click();
        Assert.assertTrue(incelemelerPage.showing1to3of3entries.isDisplayed());
        extentTest.pass("showing1to3of3entries");

        Driver.closeDriver();

    }
}
