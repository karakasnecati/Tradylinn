package tests.us_03_04_;

import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
<<<<<<< HEAD

public class TC_002 {
    @Test
    public static void giris(){
=======
import utilities.ReusableMethod;

public class TC_002 {
    @Test
    public static void giris() throws InterruptedException {
>>>>>>> 4ec5c0c7321787b68071716ed4794fe63b71670e
        LoginPage loginPage=new LoginPage();
        // 1) kullanici tradylinn anasayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

<<<<<<< HEAD
        // 2) kullanici hesabım sayfasina tiklar
        loginPage.hesabim.click();
=======
        // 2) kullanici giriş yap sayfasina tiklar
        loginPage.girisYap.click();
>>>>>>> 4ec5c0c7321787b68071716ed4794fe63b71670e

        // 3) kullanici mail ve sifresini girer
        loginPage.mailBox.sendKeys(ConfigReader.getProperty("validEmail"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));

        // 4) kullanici giris yap butonuna tiklar
        loginPage.hesabagirisYap.click();
<<<<<<< HEAD

        // 5. Kullanıcı 'Siparişlerim sekmesini tıklamalı
        SiparislerPage.orders.click();
=======
        Thread.sleep(10000);
        loginPage.hesabim.click();

        // 5. Kullanıcı 'Siparişlerim sekmesini tıklamalı
        SiparislerPage.siparislerButonu.click();
>>>>>>> 4ec5c0c7321787b68071716ed4794fe63b71670e

        // 6. Kullanıcı 'ürünlere göz at' butonuna tıklamalı
        SiparislerPage.urunlereGozAt.click();

<<<<<<< HEAD
        // 7. kullanici 'Sepete ürün eklemeli
=======
        // 7. kullanici 'Sepete 5 adet ürün eklemeli
>>>>>>> 4ec5c0c7321787b68071716ed4794fe63b71670e
        SepeteUrunEkle.ilkUrunSepeteEkle.click();
        SepeteUrunEkle.ikinciUrunSepeteEkle.click();
        SepeteUrunEkle.ucuncuUrunSepeteEkle.click();
        SepeteUrunEkle.dorduncuUrunSepeteEkle.click();
        SepeteUrunEkle.besinciUrunSepeteEkle.click();

        // 8. Kullanici Sepete gidebilmeli
        SepetPage.sepetimButonu.click();

        // 9. Kullanıcı ödeme sayfasına gidebilmeli
        SepetPage.odemeButonu.click();

    }
}