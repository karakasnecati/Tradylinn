package tests.us_03_04_;

import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class TC_002 {
    @Test
    public static void giris(){
        LoginPage loginPage=new LoginPage();
        // 1) kullanici tradylinn anasayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

        // 2) kullanici hesabım sayfasina tiklar
        loginPage.hesabim.click();

        // 3) kullanici mail ve sifresini girer
        loginPage.mailBox.sendKeys(ConfigReader.getProperty("validEmail"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));

        // 4) kullanici giris yap butonuna tiklar
        loginPage.hesabagirisYap.click();
        ReusableMethod.waitFor(40);

        // 5. Kullanıcı 'Siparişlerim sekmesini tıklamalı
        SiparislerPage.orders.click();

        // 6. Kullanıcı 'ürünlere göz at' butonuna tıklamalı
        SiparislerPage.urunlereGozAt.click();

        // 7. kullanici 'Sepete ürün eklemeli
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