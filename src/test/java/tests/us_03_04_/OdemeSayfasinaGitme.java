package tests.us_03_04_;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SepetPage;
import pages.SepeteUrunEklePage;
import pages.SiparislerPage;
import tests.Login;
import utilities.Driver;
import utilities.TestBaseRapor;

public class OdemeSayfasinaGitme extends TestBaseRapor {
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    SiparislerPage siparislerPage = new SiparislerPage();
    SepetPage sepetPage = new SepetPage();
    SepeteUrunEklePage sepeteUrunEklePage = new SepeteUrunEklePage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void giris() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        // 1) kullanici tradylinn anasayfasına gider
        // 2) kullanici giriş yap sayfasina tiklar
        // 3) kullanici mail ve sifresini girer
        // 4) kullanici giris yap butonuna tiklar
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
            js.executeScript("arguments[0].click();", sepeteUrunEklePage.secilecekUrunListesi.get(i));
        }

        // 8. Kullanici Sepete gidebilmeli
        Thread.sleep(4000);
        //sepetPage.sepetimButonu.click();
        Driver.getDriver().navigate().to("https://tradylinn.com/cart/");

        // 9. Kullanıcı ödeme sayfasına gidebilmeli
        Driver.getDriver().navigate().to("https://tradylinn.com/checkout-2/");
    }
}