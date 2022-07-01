package tests.us_03_04_;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.SepetPage;
import pages.SepeteUrunEklePage;
import pages.SiparislerPage;
import tests.Login;
import utilities.Driver;
import utilities.TestBaseRapor;

public class SepeteUrunEkleme extends TestBaseRapor {
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    SiparislerPage siparislerPage=new SiparislerPage();
    SepetPage sepetPage = new SepetPage();
    SepeteUrunEklePage sepeteUrunEklePage =new SepeteUrunEklePage();

    @Test
    public void giris() throws InterruptedException {
        // kullanici tradylinn anasayfasına gider
        // kullanici giriş yap sayfasina tiklar
        // kullanici mail ve sifresini girer
        // kullanici giris yap butonuna tiklar
        // kullanici hesabim sekmesini tiklar
        Login.giris();
        // 5. Kullanıcı 'Siparişlerim sekmesini tıklamalı
        //siparislerPage.siparislerButonu.click();
        Driver.getDriver().navigate().to("https://tradylinn.com/my-account-2/orders/");
        // 6. Kullanıcı 'ürünlere göz at' butonuna tıklamalı
        //siparislerPage.urunlereGozAt.click();
        Driver.getDriver().navigate().to("https://tradylinn.com/shop/");
        // 7. kullanici 'Sepete 5 adet ürün eklemeli
        for (int i = 0; i < 5; i++) {
            Thread.sleep(2000);
            // actions.moveToElement(sepeteUrunEklePage.secilecekUrunListesi.get(i)).perform();
            //Thread.sleep(2000);
            //sepeteUrunEklePage.secilecekUrunListesi.get(i).click();
            js.executeScript("arguments[0].click();",sepeteUrunEklePage.secilecekUrunListesi.get(i));
        }
    }
}