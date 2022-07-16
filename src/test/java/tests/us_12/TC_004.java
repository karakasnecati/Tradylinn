package tests.us_12;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Accesspage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_004 {
    Accesspage trdln = new Accesspage();
    SoftAssert soft = new SoftAssert();

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void US_12_TC_004() throws InterruptedException {

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
        //6-Kullanici "HESAP DETAYLARI" butonuna tıklar.
        JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].click();",trdln.hesapDetaylari);

        //7-Hesap detayları sayfasında
        //" Görünen ad / E-posta adresi /Biography "
        //başlıklarının oldugunu test eder



        Assert.assertTrue(trdln.ad.isDisplayed());
        Assert.assertTrue(trdln.soyad.isDisplayed());
        Assert.assertTrue(trdln.gorunenAd.isDisplayed());
        Assert.assertTrue(trdln.mail.isDisplayed());
        //08_kullanıcı görünen ad ve eposta adresi başlıklarının güncellenebildiğini test eder

        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(Keys.BACK_SPACE);
        trdln.ad.sendKeys(trdln.isim);
        Thread.sleep(1000);
        trdln.ad.sendKeys(Keys.TAB);
        trdln.soyad.sendKeys(trdln.soyIsim);
        Thread.sleep(1000);
        trdln.soyad.sendKeys(Keys.TAB+trdln.isim);
        //trdln.gorunenAd.sendKeys(trdln.isim);
        Thread.sleep(1000);

        JavascriptExecutor ss  =(JavascriptExecutor)Driver.getDriver();
        ss.executeScript("arguments[0].click();",trdln.degisiklikUpdate);


        js.executeScript("arguments[0].click();",trdln.hesapDetaylari);
        soft.assertEquals(trdln.ad.getAttribute("value"),trdln.isim);
        soft.assertEquals(trdln.soyad.getAttribute("value"),trdln.soyIsim);
        System.out.println(trdln.isim);
        System.out.println(trdln.soyIsim);

        Driver.closeDriver();
    }

}
