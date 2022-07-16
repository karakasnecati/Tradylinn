package tests.us_12;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Accesspage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_001 {

    Accesspage trdln=new Accesspage();
    SoftAssert soft=new SoftAssert();
    Actions action=new Actions(Driver.getDriver());

    @Test
    public void US_12_TC_001() throws InterruptedException {

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

        //6- Kullanici 'Siparisler' butonunu tiklar
        trdln.choiceElement( trdln.pano,"Siparişler").click();
        //7- Kullanici siparislerin oldugunu goruntuler
        System.out.println(trdln.siparislerYazisi.isDisplayed());
        Thread.sleep(2000);

        //8- Kullanici siparislerin oldugunu listeler

        for (WebElement each: trdln.siparislerTble
        ) {
            System.out.println(" siparisler listesi : "+ each.getText());

        }
        Driver.closeDriver();


    }


}
