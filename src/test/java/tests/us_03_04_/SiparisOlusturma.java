package tests.us_03_04_;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SepetPage;
import pages.SepeteUrunEklePage;
import pages.SiparislerPage;
import tests.Login;
import utilities.Driver;
import utilities.TestBaseRapor;

public class SiparisOlusturma extends TestBaseRapor {
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    SiparislerPage siparislerPage = new SiparislerPage();
    SepetPage sepetPage = new SepetPage();
    SepeteUrunEklePage sepeteUrunEklePage = new SepeteUrunEklePage();

    @Test
    public void giris() throws InterruptedException {
        // 1) kullanici tradylinn anasayfasına gider
        // 2) kullanici giriş yap sayfasina tiklar
        // 3) kullanici mail ve sifresini girer
        // 4) kullanici giris yap butonuna tiklar
        Login.giris();
        // 5. Kullanıcı 'Siparişlerim sekmesini tıklamalı
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

        //siparislerPage.siparislerButonu.click();

        // 6. Kullanıcı 'ürünlere göz at' butonuna tıklamalı
        //siparislerPage.urunlereGozAt.click();

        // 7. kullanici 'Sepete 5 adet ürün eklemeli
        /*sepeteUrunEklePage.ilkUrunSepeteEkle.click();
        sepeteUrunEklePage.ikinciUrunSepeteEkle.click();
        sepeteUrunEklePage.ucuncuUrunSepeteEkle.click();
        sepeteUrunEklePage.dorduncuUrunSepeteEkle.click();
        sepeteUrunEklePage.besinciUrunSepeteEkle.click();*/

        // 8. Kullanici Sepete gidebilmeli
        Driver.getDriver().navigate().to("https://tradylinn.com/cart/");

        // 9. Kullanıcı ödeme sayfasına gidebilmeli
        //sepetPage.odemeButonu.click();
        Driver.getDriver().navigate().to("https://tradylinn.com/checkout-2/");

        Faker faker = new Faker(); //Adres ve fatura bilgilerini girmek icin bir faker olusturduk.
//Ad kutusuna Adını gir
        siparislerPage.adKutusu.click();
        siparislerPage.adKutusu.sendKeys(faker.name().firstName());
        Actions actions = new Actions(Driver.getDriver()); //diğer bilgileri locate almadan yazabilmek icin actions olusturduk
        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()) //17_Soyad kutusuna soyadını gir
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name()) //18_Firma adi kutusuna firma adı gir
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().streetAddress()) //19_Sokak adresi kutusuna bina numarası ve sokak adi gir
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().buildingNumber()) //20_Sokak adresi(2) kutusuna Apartman adi vb. gir
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode()) //21_Posta kodu kutusuna posta kodu gir
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().cityName()) //22_ilçe/Semt kutusuna İlçe gir
                .sendKeys(Keys.TAB)
                .sendKeys("Ankara") //23_Şehir kutusuna şehir gir
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()) //24_Telefon kutusuna telefon numarası gir
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()) //25_E-posta kutusuna e-posta adresi gir
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).perform(); //26_Teslimat adresi kutusuna adres gir

        //"Siparişi Onayla" butonuna tıkla
        siparislerPage.siparisiOnaylaButton.click();
        //Siparişin onaylandığını test et
        //"Teşekkür ederiz. Siparişiniz alınmıştır" yazisi ekranda görünüyorsa
        //siparis onaylanmıs demektir.

        Assert.assertTrue(siparislerPage.siparisinizAlinmistirYazisi.isDisplayed());
        Driver.closeDriver();
    }
}