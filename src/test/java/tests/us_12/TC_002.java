package tests.us_12;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Accesspage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_002 {

    Accesspage trdln = new Accesspage();
    SoftAssert soft = new SoftAssert();
    Actions action = new Actions(Driver.getDriver());

    @Test
    public void US_12_TC_002() throws InterruptedException {

        //1- Kullanici URL e gider
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        // 2- Kullanıcı 'Giriş Yap / Üye Ol' butonuna tıklar
        trdln.girisyap.click();
        // 3- Kullanıcı e-mail adresini ve parola'yı girer
        trdln.email.sendKeys(ConfigReader.getProperty("validEmail"));
        trdln.password.sendKeys(ConfigReader.getProperty("validPassword"));
        // 4- Kullanıcı 'Giriş Yap' butonuna tıklar
        trdln.login.click();
        //  5- Kullanıcı 'Hesabım' butonuna tıklar
        Thread.sleep(10000);
        trdln.hesabim.click();

        //6- Kullanici sayfadan 'indirmeler' butonunu tıklar
        trdln.choiceElement( trdln.pano,"İndirmeler").click();

        //7-Kullanici "Henüz indirilecek bir ürün yok."yazısının göründüğünü test eder
        soft.assertTrue( trdln.indirmeler.getText().equals("Henüz indirilecek bir ürün yok."));

        Driver.closeDriver();


    }

}
