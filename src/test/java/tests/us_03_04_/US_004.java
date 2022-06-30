package tests.us_03_04_;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SepetPage;
import pages.SepeteUrunEkle;
import pages.SiparislerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class US_004 {

    @Test
    public static void giris() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        // 1) kullanici tradylinn anasayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

        // 2) kullanici giriş yap sayfasina tiklar
        loginPage.girisYap.click();

        // 3) kullanici mail ve sifresini girer
        loginPage.mailBox.sendKeys(ConfigReader.getProperty("validEmail"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));

        // 4) kullanici giris yap butonuna tiklar
        loginPage.hesabagirisYap.click();
        Thread.sleep(10000);
        loginPage.hesabim.click();

        // 5. Kullanıcı 'Siparişlerim sekmesini tıklamalı
        SiparislerPage.siparislerButonu.click();

        // 6. Kullanıcı 'ürünlere göz at' butonuna tıklamalı
        SiparislerPage.urunlereGozAt.click();

        // 7. kullanici 'Sepete 5 adet ürün eklemeli
        SepeteUrunEkle.ilkUrunSepeteEkle.click();
        SepeteUrunEkle.ikinciUrunSepeteEkle.click();
        SepeteUrunEkle.ucuncuUrunSepeteEkle.click();
        SepeteUrunEkle.dorduncuUrunSepeteEkle.click();
        SepeteUrunEkle.besinciUrunSepeteEkle.click();

        // 8. Kullanici Sepete gidebilmeli
        SepetPage.sepetimButonu.click();

        // 9. Kullanıcı sepeti görüntüleyebilmeli
        SepetPage.sepetiGoruntuleButonu.click();

// "Ürün", "Fiyat", "Miktar", "Ara Toplam", "Kupon Kullan", "Alışvevrişe Devam Et"... yazisinin görüldüğünü test et
        Assert.assertTrue(SepetPage.urunYazisi.isDisplayed());
        Assert.assertTrue(SepetPage.fiyatYazisi.isDisplayed());
        Assert.assertTrue(SepetPage.miktarYazisi.isDisplayed());
        Assert.assertTrue(SepetPage.araToplamYazisi.isDisplayed());
        Assert.assertTrue(SepetPage.kuponKullanButton.isDisplayed());
        Assert.assertTrue(SepetPage.alisVeriseDevamEtButton.isDisplayed());
        Assert.assertTrue(SepetPage.kargoBilgileriYazisi.isDisplayed());
        Assert.assertTrue(SepetPage.toplamBilgisi.isDisplayed());
//"+(artı)" butonuna tıkla
//artı butonuna basıp sayfayı yeniledigimde fiyat toplamı ve miktar hanesi guncellenmesi gerekir.
//Bunu kontrol etmek icin butona tıklamadan onceki fiyat bilgisini ve miktar hanesini kaydediyorum.
        String toplamFiyatYazisi1= SepetPage.toplamFiyatYazisi.getText();
        int miktarHanesiSayisi1= Integer.parseInt(SepetPage.miktarHanesi.getAttribute("value"));
//Sepetteki 2. ürün için + butonuna tıklamayı tercih ettim.
        SepetPage.artiButton.click();
//"Sepeti yenile" butonuna tıkla
        SepetPage.sepetiYenileButton.click();
        Thread.sleep(10000);
//Fiyatın guncellendigini test et
        String toplamFiyatYazisi2=SepetPage.toplamFiyatYazisi.getText();
//önceki ve sonraki fiyat aynı değilse fiyat guncellenmiştir demektir.
        Assert.assertNotEquals(toplamFiyatYazisi2, toplamFiyatYazisi1);
//Miktarın arttıgını test et
        int miktarHanesiSayisi2= Integer.parseInt(SepetPage.miktarHanesi.getAttribute("value"));
// sonraki miktar hanesi sayisi öncekinden 1 fazla ise miktar artmış demektir.
        Assert.assertTrue(miktarHanesiSayisi2==miktarHanesiSayisi1+1);
//"-(eksi)" butonuna tıkla
        SepetPage.eksiButton.click();
//"Sepeti yenile" butonuna tıkla
        SepetPage.sepetiYenileButton.click();
        Thread.sleep(10000);
//"Miktarın eksildigini test et
        int miktarHanesiSayisi3= Integer.parseInt(SepetPage.miktarHanesi.getAttribute("value"));
//miktarHanesiSayisi3 ,miktarHanesiSayisi2'den bir eksik ise miktar azalmış demektir.
        Assert.assertTrue(miktarHanesiSayisi3==miktarHanesiSayisi2-1);
//"Ödeme sayfasına git" butonuna tıkla
        SepetPage.odemeSayfasinaGitButton.click();
//Ödeme sayfasına yönlendirildiğini test et
//Ödeme sayfasına yönlendirildiğimizin delili olan "fatura detayları alanı" görünmeli
        Assert.assertTrue(SepetPage.faturaDetaylariAlani.isDisplayed());
        Driver.closeDriver();
    }
}