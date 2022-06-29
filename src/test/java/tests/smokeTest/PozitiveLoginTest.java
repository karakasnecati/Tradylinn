package tests.smokeTest;

import org.apache.commons.logging.Log;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitiveLoginTest {
    LoginPage loginPage;
    @Test
    public void dogruGiris() throws InterruptedException {
        loginPage=new LoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        Thread.sleep(2000);
        loginPage.girisYap.click();
        loginPage.mailBox.sendKeys(ConfigReader.getProperty("validEmail")+ Keys.ENTER);
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));
        loginPage.hesabagirisYap.click();
        Assert.assertTrue(loginPage.hesabagirisYap.isDisplayed());
    }
}