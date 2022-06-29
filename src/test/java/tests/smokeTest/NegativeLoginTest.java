package tests.smokeTest;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {
    LoginPage loginPage;
    @Test
    public void yanlisSifre() throws InterruptedException {
        loginPage=new LoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        Thread.sleep(2000);
        loginPage.girisYap.click();
        loginPage.mailBox.sendKeys(ConfigReader.getProperty("wrongEmail")+ Keys.ENTER);
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("wrongPassword"));
        loginPage.hesabagirisYap.click();
        Assert.assertTrue(loginPage.hesabagirisYap.isDisplayed());
    }
}
