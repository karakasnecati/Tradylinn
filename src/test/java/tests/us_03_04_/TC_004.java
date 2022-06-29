package tests.us_03_04_;

<<<<<<< HEAD
import org.testng.annotations.Test;
import pages.*;
=======
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SepetPage;
import pages.SepeteUrunEkle;
import pages.SiparislerPage;
>>>>>>> 4ec5c0c7321787b68071716ed4794fe63b71670e
import utilities.ConfigReader;
import utilities.Driver;

public class TC_004 {
    @Test
<<<<<<< HEAD
    public static void giris(){
        LoginPage loginPage=new LoginPage();
        // 1) kullanici tradylinn anasayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

        // 2) kullanici hesabım sayfasina tiklar
        loginPage.hesabim.click();
=======
    public static void giris() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        // 1) kullanici tradylinn anasayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

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

<<<<<<< HEAD
=======
        Faker faker = new Faker(); //Adres ve fatura bilgilerini girmek icin bir faker olusturduk.
//16_Ad kutusuna Adını gir
        SiparislerPage.adKutusu.sendKeys(faker.name().firstName());
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

        //27_"Siparişi Onayla" butonuna tıkla
        SiparislerPage.siparisiOnaylaButton.click();
//28_Siparişin onaylandığını test et
//"Teşekkür ederiz. Siparişiniz alınmıştır" yazisi ekranda görünüyorsa
//siparis onaylanmıs demektir.

        Assert.assertTrue(SiparislerPage.siparisinizAlinmistirYazisi.isDisplayed());
        Driver.closeDriver();
>>>>>>> 4ec5c0c7321787b68071716ed4794fe63b71670e
    }
}