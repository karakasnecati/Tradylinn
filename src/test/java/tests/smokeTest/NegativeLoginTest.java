package tests.smokeTest;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class NegativeLoginTest extends TestBaseRapor {
    LoginPage loginPage;
    @Test
    public void yanlisSifre() throws InterruptedException {
        extentTest=extentReports.createTest("isim","Yanlis sifreyle siteye girilmemeli");
        loginPage=new LoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest.info("Siteye gidildi");
        Thread.sleep(2000);
        loginPage.girisYap.click();
        loginPage.mailBox.sendKeys(ConfigReader.getProperty("wrongEmail")+ Keys.ENTER);
        extentTest.info("Wrong email girildi");
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("wrongPassword"));
        extentTest.info("Wrong password girildi");
        loginPage.hesabagirisYap.click();
        extentTest.info("Sabmit butonuna tiklandi");
        Assert.assertTrue(loginPage.hesabagirisYap.isDisplayed());
        extentTest.pass("Yanlis sifre ve yanlis eamil adresiyle sayfaya giris yapilamadi.");
        Driver.closeDriver();
    }
}
