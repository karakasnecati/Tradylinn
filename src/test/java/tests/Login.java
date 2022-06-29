package tests;

import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class Login {

    public static void giris(){
        LoginPage loginPage=new LoginPage();
        // 1) kullanici tradylinn anasayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

        // 2) kullanici giris yapmak için giris yap sayfasina tiklar
        loginPage.girisYap.click();

        // 3) kullanici mail ve sifresini girer
        loginPage.mailBox.sendKeys(ConfigReader.getProperty("validEmail"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));

        // 4) kullanici giris yap butonuna tiklar
        loginPage.hesabagirisYap.click();
        ReusableMethod.waitFor(10);

        // 5) kullanici hesabım sayfasina tiklar
        loginPage.hesabim.click();

    }
}
