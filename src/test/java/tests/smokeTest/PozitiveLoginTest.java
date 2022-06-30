package tests.smokeTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class PozitiveLoginTest extends TestBaseRapor {
    LoginPage loginPage;
    @Test
    public void dogruGiris() throws InterruptedException {
        extentTest=extentReports.createTest("isim","Dogru sifreyle siteye girilmeli");
        loginPage=new LoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest.info("Siteye gidildi");
        Thread.sleep(2000);
        loginPage.girisYap.click();
        loginPage.mailBox.sendKeys(ConfigReader.getProperty("validEmail")+ Keys.ENTER);
        extentTest.info("Valid email girildi");
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));
        extentTest.info("Valid password girildi");
        loginPage.hesabagirisYap.click();
        extentTest.info("Sabmit butonuna tiklandi");
        Assert.assertTrue(loginPage.hesabagirisYap.isDisplayed());
        extentTest.pass("Dogru sifre ve dogru eamil adresiyle sayfaya giris yapildi.");
        Driver.closeDriver();
    }
}