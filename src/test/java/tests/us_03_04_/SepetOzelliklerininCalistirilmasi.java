package tests.us_03_04_;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SepetPage;
import pages.SepeteUrunEklePage;
import tests.Login;
import utilities.Driver;
import utilities.ReusableMethod;
import utilities.TestBaseRapor;

public class SepetOzelliklerininCalistirilmasi extends TestBaseRapor {

    @Test

    public void testGiris() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        SiparislerPage siparislerPage = new SiparislerPage();
        SepetPage sepetPage = new SepetPage();
        SepeteUrunEklePage sepeteUrunEklePage = new SepeteUrunEklePage();
        Actions actions = new Actions(Driver.getDriver());

        // 1) kullanici tradylinn anasayfasına gider
        // 2) kullanici giriş yap sayfasina tiklar
        // 3) kullanici mail ve sifresini girer
        // 4) kullanici giris yap butonuna tiklar
        Login.giris();

        // 5. Kullanıcı 'Siparişlerim sekmesini tıklamalı
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        //siparislerPage.siparislerButonu.click();
        //js.executeScript("arguments[0].scrollIntoView(true)",siparislerPage.siparislerButonu);
        //js.executeScript("arguments[0].click();", siparislerPage.siparislerButonu);
        Driver.getDriver().navigate().to("https://tradylinn.com/my-account-2/orders/");

        // 6. Kullanıcı 'ürünlere göz at' butonuna tıklamalı
        //siparislerPage.urunlereGozAt.click();
        Driver.getDriver().navigate().to("https://tradylinn.com/shop/");

        // 7. kullanici 'Sepete 5 adet ürün eklemeli
        /*sepeteUrunEklePage.ilkUrunSepeteEkle.click();
        sepeteUrunEklePage.ikinciUrunSepeteEkle.click();
        sepeteUrunEklePage.ucuncuUrunSepeteEkle.click();
        sepeteUrunEklePage.dorduncuUrunSepeteEkle.click();
        sepeteUrunEklePage.besinciUrunSepeteEkle.click();*/

       /* for (WebElement each:sepeteUrunEklePage.secilecekUrunListesi
             ) {
            js.executeScript("arguments[0].click();",each);
        }
*/
       for (int i = 0; i < 5; i++) {
          Thread.sleep(2000);
            // actions.moveToElement(sepeteUrunEklePage.secilecekUrunListesi.get(i)).perform();
        //Thread.sleep(2000);
            //sepeteUrunEklePage.secilecekUrunListesi.get(i).click();
            js.executeScript("arguments[0].click();",sepeteUrunEklePage.secilecekUrunListesi.get(i));
        }

        // 8. Kullanici Sepete gidebilmeli
        //Thread.sleep(4000);
        //sepetPage.sepetimButonu.click();
        //js.executeScript("arguments[0].click();",sepetPage.sepetimButonu);

        // 9. Kullanıcı sepeti görüntüleyebilmeli
        //sepetPage.sepetiGoruntuleButonu.click();
        Driver.getDriver().navigate().to("https://tradylinn.com/cart/");


        // "Ürün", "Fiyat", "Miktar", "Ara Toplam", "Kupon Kullan", "Alışvevrişe Devam Et"... yazisinin görüldüğünü test et
        Assert.assertTrue(sepetPage.urunYazisi.isDisplayed());
        Assert.assertTrue(sepetPage.fiyatYazisi.isDisplayed());
        Assert.assertTrue(sepetPage.miktarYazisi.isDisplayed());
        Assert.assertTrue(sepetPage.araToplamYazisi.isDisplayed());
        Assert.assertTrue(sepetPage.kuponKullanButton.isDisplayed());
        Assert.assertTrue(sepetPage.alisVeriseDevamEtButton.isDisplayed());
        Assert.assertTrue(sepetPage.kargoBilgileriYazisi.isDisplayed());
        Assert.assertTrue(sepetPage.toplamBilgisi.isDisplayed());
        //"+(artı)" butonuna tıkla
        //artı butonuna basıp sayfayı yeniledigimde fiyat toplamı ve miktar hanesi guncellenmesi gerekir.Bunu kontrol etmek icin butona tıklamadan onceki fiyat bilgisini ve miktar hanesini kaydediyorum.
        String toplamFiyatYazisi1 = sepetPage.toplamFiyatYazisi.getText();
        int miktarHanesiSayisi1 = Integer.parseInt(sepetPage.miktarHanesi.getAttribute("value"));
        //Sepetteki 2. ürün için + butonuna tıklamayı tercih ettim.
        sepetPage.artiButton.click();
        //"Sepeti yenile" butonuna tıkla
        sepetPage.sepetiYenileButton.click();
        ReusableMethod.waitFor(5);
        //Fiyatın guncellendigini test et
        String toplamFiyatYazisi2 = sepetPage.toplamFiyatYazisi.getText();
        //önceki ve sonraki fiyat aynı değilse fiyat guncellenmiştir demektir.
        Assert.assertNotEquals(toplamFiyatYazisi2, toplamFiyatYazisi1);
        //Miktarın arttıgını test et
        int miktarHanesiSayisi2 = Integer.parseInt(sepetPage.miktarHanesi.getAttribute("value"));
        // sonraki miktar hanesi sayisi öncekinden 1 fazla ise miktar artmış demektir.
        Assert.assertTrue(miktarHanesiSayisi2 == miktarHanesiSayisi1 + 1);
        //"-(eksi)" butonuna tıkla
        sepetPage.eksiButton.click();
        //"Sepeti yenile" butonuna tıkla
        sepetPage.sepetiYenileButton.click();
        ReusableMethod.waitFor(5);
        //"Miktarın eksildigini test et
        int miktarHanesiSayisi3 = Integer.parseInt(sepetPage.miktarHanesi.getAttribute("value"));
        //miktarHanesiSayisi3 ,miktarHanesiSayisi2'den bir eksik ise miktar azalmış demektir.
        Assert.assertTrue(miktarHanesiSayisi3 == miktarHanesiSayisi2 - 1);
        //"Ödeme sayfasına git" butonuna tıkla
        sepetPage.odemeSayfasinaGitButton.click();
        //Ödeme sayfasına yönlendirildiğini test et
        //Ödeme sayfasına yönlendirildiğimizin delili olan "fatura detayları alanı" görünmeli
        Assert.assertTrue(sepetPage.faturaDetaylariAlani.isDisplayed());
        Driver.closeDriver();
    }
}