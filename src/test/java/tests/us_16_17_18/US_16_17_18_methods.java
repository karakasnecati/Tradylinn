package tests.us_16_17_18;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HesabimPage;
import pages.LoginPage;
import pages.MusteriPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

import java.time.Duration;

public class US_16_17_18_methods {

    public static void musteriBolumGiris(){
        HesabimPage hesabimPage = new HesabimPage();
        MusteriPage musteriPage = new MusteriPage();
        LoginPage loginPage=new LoginPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(15));

        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        loginPage.girisYap.click();
        loginPage.mailBox.sendKeys(ConfigReader.getProperty("validEmail"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));
        loginPage.hesabagirisYap.click();
        ReusableMethod.waitFor(10);
        loginPage.hesabim.click();

    }

}
