package tests.us_03_04_;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.SepetPage;
import pages.SepeteUrunEklePage;
import pages.SiparislerPage;
import tests.Login;
import utilities.Driver;
import utilities.TestBaseRapor;

public class AdresVeFaturaBilgileriEkleme extends TestBaseRapor {
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    SiparislerPage siparislerPage=new SiparislerPage();
    SepetPage sepetPage = new SepetPage();
    SepeteUrunEklePage sepeteUrunEklePage =new SepeteUrunEklePage();
    @Test
    public void giris() throws InterruptedException {
        // 1) kullanici tradylinn anasayfasına gider
        // 2) kullanici giriş yap sayfasina tiklar
        // 3) kullanici mail ve sifresini girer
        // 4) kullanici giris yap butonuna tiklar
        Login.giris();
        // 5. Kullanıcı 'Siparişlerim sekmesini tıklamalı
        // siparislerPage.siparislerButonu.click();
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

        // 6. Kullanıcı 'ürünlere göz at' butonuna tıklamalı
        //siparislerPage.urunlereGozAt.click();

        // 7. kullanici 'Sepete 5 adet ürün eklemeli
        /*sepeteUrunEklePage.ilkUrunSepeteEkle.click();
        sepeteUrunEklePage.ikinciUrunSepeteEkle.click();
        sepeteUrunEklePage.ucuncuUrunSepeteEkle.click();
        sepeteUrunEklePage.dorduncuUrunSepeteEkle.click();
        sepeteUrunEklePage.besinciUrunSepeteEkle.click();*/
        // 8. Kullanici Sepete gidebilmeli
        //sepetPage.sepetimButonu.click();
        Driver.getDriver().navigate().to("https://tradylinn.com/cart/");

        // 9. Kullanıcı ödeme sayfasına gidebilmeli
        //sepetPage.odemeButonu.click();
        Driver.getDriver().navigate().to("https://tradylinn.com/checkout-2/");

        Faker faker=new Faker(); //Adres ve fatura bilgilerini girmek icin faker olusturduk.
        //Ad kutusuna Adını gir
        Actions actions=new Actions(Driver.getDriver());
        actions.click(siparislerPage.adKutusu).sendKeys(Keys.CLEAR).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(Keys.DELETE+faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE+faker.company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE+faker.address().streetAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE+faker.address().buildingNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE+faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE+faker.address().cityName())
                .sendKeys(Keys.TAB)
                .sendKeys("Ankara")
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE+faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE+faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE+faker.address().fullAddress()).perform();
    }
}