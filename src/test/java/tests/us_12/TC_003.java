package tests.us_12;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Accesspage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_003 {

    Accesspage trdln = new Accesspage();
    SoftAssert soft = new SoftAssert();
    Actions action = new Actions(Driver.getDriver());

    @Test
    public void US_12_TC_003() throws InterruptedException {

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
        //6-Kullanici 'Adres' butonuna tiklar
        JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].click();",trdln.adres);
        //7- Kullanici fatura adresini gorunur
        boolean faturaadresgorunur= trdln.faturaAdresleri.stream().allMatch(t->t.isDisplayed());
        soft.assertTrue(faturaadresgorunur);
        //8- Kullanici fatura adresini listeler
        trdln.faturaAdresleri.stream().forEach(t-> System.out.println(t.getText()));
        //7- Kullanici gönderim adresini gorunur
        boolean gonderimAdersiGorunur= trdln.gonderimAdresi.stream().allMatch(t->t.isDisplayed());
        soft.assertTrue(gonderimAdersiGorunur);
        System.out.println("gönderim adresi:");
        //8- Kullanici gönderim adresini listeler
        trdln.gonderimAdresi.stream().forEach(t-> System.out.println(t.getText()));

    }

}
