package tests.us_05_06_07;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UrunlerPage;
import tests.Login;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

import java.util.Random;

public class UrunEkleme {
    UrunlerPage urunlerPage = new UrunlerPage();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();

    @Test
    public void TestUrunEkleme() {
        // 1- Kullanici store manager olarak heabıma giris yapar
        Login.giris();

        // 2- kullanici store manager linkine tiklar
        urunlerPage.storeManager.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // 3- kullanici urunler sekmesine tiklar
        urunlerPage.urunler.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // 4- kullanici Status, Stock, Price ve Date basliklarini dogrular

        Assert.assertTrue(urunlerPage.status.isDisplayed());
        Assert.assertTrue(urunlerPage.stock.isDisplayed());
        Assert.assertTrue(urunlerPage.price.isDisplayed());
        Assert.assertTrue(urunlerPage.date.isDisplayed());

        // 5- kullanici Add New Product butonuna tiklar
        urunlerPage.addNewProduct.click();

        // 6- kullanici Virtual, Downloadable butonlari oldugunu dogrular ve Virtual'e tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(urunlerPage.virtual.isDisplayed());
        Assert.assertTrue(urunlerPage.downloadable.isDisplayed());

        urunlerPage.virtual.click();
        ReusableMethod.waitFor(3);

        // 7- kullanici urun adi olarak "Hasir Sapka", Fiyat olarak da "60" TL girer ve etkin oldugunu dogrular
        actions.click(urunlerPage.productTitle)
                .sendKeys(ConfigReader.getProperty("productTitle")).perform();

        actions.click(urunlerPage.productPrice)
                .sendKeys(ConfigReader.getProperty("productPrice")).perform();

        Assert.assertTrue(urunlerPage.productTitle.isEnabled());
        Assert.assertTrue(urunlerPage.productPrice.isEnabled());

        // 8- kullanici urun resmi ekler ve eklediğini dogrular
        urunlerPage.imgAdd1.click();
        urunlerPage.ortamKutuphanesi.click();
        urunlerPage.img1.click();
        ReusableMethod.waitFor(3);
        urunlerPage.secButonu.click();
        urunlerPage.imgAdd2.click();
        urunlerPage.img2.click();
        ReusableMethod.waitFor(3);
        urunlerPage.addToGallery.click();

        Assert.assertTrue(urunlerPage.imgDisplay.isDisplayed());

        // 9- Kullanici Store Manager olarak, urune dair acıklamalar ekler ve etkin oldugunu dogrular

        //shortDescription
        Driver.getDriver().switchTo().frame(urunlerPage.iframeShortDescription);

        actions.click(urunlerPage.shortDescription)
                .sendKeys(ConfigReader.getProperty("shortDescription")).perform();
        // test
        Assert.assertTrue(urunlerPage.shortDescription.isEnabled());
        Driver.getDriver().switchTo().defaultContent();
        ReusableMethod.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // description
        Driver.getDriver().switchTo().frame(urunlerPage.iframeDescription);
        actions.click(urunlerPage.description)
                .sendKeys(ConfigReader.getProperty("description")).perform();
        // test
        Assert.assertTrue(urunlerPage.description.isEnabled());
        actions.sendKeys(Keys.PAGE_UP).perform();
        Driver.getDriver().switchTo().defaultContent();

        // 10- Kullanici Store Manager olarak, ekledigi urunun kategorilerini belirler

        // Kategoriler: Besin takviyeleri, Cok satanlar, Elektrik & Elektronik, Ev & yasam, Indirimli ürünler,
        // Kitap & müzik &Film, Kozmetik & kisisel, Moda & Giyim, Oyuncak, Taki & aksesuar, Yeni ürünler

        actions.sendKeys(Keys.ARROW_UP).perform();
/*
        ArrayList<String> eklenebilirKategoriler = new ArrayList<>(Arrays.asList("Besin Takviyeleri", "Çok Satanlar",
                "Elektrik & Elektronik", "Ev & Yaşam", "İndirimli Ürünler", "Kitap & Müzik & Film",
                "Kozmatik & Kişisel", "Moda & Giyim", "Oyuncak", "Takı & Aksesuar", "Yeni Ürünler"));

        ArrayList<String> tumKategoriler = new ArrayList<>();
        for (WebElement each : urunlerPage.categories
        ) {
            tumKategoriler.add(each.getText());
        }

      Random random = new Random();
        int sayi = random.nextInt(urunlerPage.categoriesButton.size());
        System.out.println(sayi + 1);
        WebElement isaretli = urunlerPage.categoriesButton.get(sayi + 1);

        ReusableMethod.waitFor(3);
        while (isaretli.isSelected()){
            if (!isaretli.isSelected()) {
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                isaretli.click();
            }else isaretli.click();
        }

*/

    }
}
