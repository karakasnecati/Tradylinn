package tests.us_05_06_07;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UrunlerPage;
import tests.Login;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

import java.util.*;

public class UrunEkleme {
    UrunlerPage urunlerPage = new UrunlerPage();
    Actions actions = new Actions(Driver.getDriver());

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

        // 4- kullanici Status, Stock, Price ve Date basliklarini urun eklenebildigini dogrular

        // Status
        Assert.assertTrue(urunlerPage.status.isDisplayed());
        // Stock
        Assert.assertTrue(urunlerPage.stock.isDisplayed());
        // Price
        Assert.assertTrue(urunlerPage.price.isDisplayed());
        // Date
        Assert.assertTrue(urunlerPage.date.isDisplayed());
        ReusableMethod.waitFor(3);
        // giris yapilan urun miktari sonucu
        Assert.assertTrue(urunlerPage.girilenUrunMiktariSonucu.isDisplayed());

        // 5- kullanici Add New Product butonuna tiklar
        urunlerPage.addNewProduct.click();

        // 6- kullanici Virtual, Downloadable butonlari oldugunu dogrular ve Virtual'e tiklar

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(urunlerPage.virtual.isDisplayed());
        Assert.assertTrue(urunlerPage.downloadable.isDisplayed());

        urunlerPage.virtual.click();
        ReusableMethod.waitFor(3);

        // 7- kullanici urun adi olarak "Hasir Sapka", Fiyat olarak da "60" TL girer
        // ve giris yapilabildigini dogrular

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

        // 10- Kullanici Store Manager olarak, urun kategorilerini dogrular
        // Kategoriler: Besin takviyeleri, Cok satanlar, Elektrik & Elektronik, Ev & yasam, Indirimli ürünler,
        // Kitap & müzik &Film, Kozmetik & kisisel, Moda & Giyim, Oyuncak, Taki & aksesuar, Yeni ürünler

        // expected Categories
        List<String> expectedCategories = new ArrayList<>(Arrays.asList("Besin Takviyeleri", "Çok Satanlar",
                "Elektrik & Elektronik", "Ev & Yaşam", "İndirimli Ürünler", "Kitap & Müzik & Film",
                "Kozmatik & Kişisel Bakım", "Moda & Giyim", "Oyuncak", "Takı & Aksesuar", "Yeni Ürünler"));

        System.out.println("expectedCategories = " + expectedCategories);

        // actual Categories
        List<String> actualCategories = new ArrayList<>();
        for (int i = 0; i < urunlerPage.categories.size(); i++) {
            if (expectedCategories.contains(urunlerPage.categories.get(i).getText())) {
                actualCategories.add(urunlerPage.categories.get(i).getText());
            }
        }

        System.out.println("actualCategories = " + actualCategories);
        // Test
        Assert.assertEquals(actualCategories, expectedCategories, "istenen urun kategorileri sitede mevcut");
        actions.sendKeys(Keys.PAGE_UP).perform();

        // 11- Kullanici Store Manager olarak, urun markalarını dogrular
        //Markalar: Elegant Auto group,Green Grass,Node JS, NS8, RED, SkySuite Tech, Sterling

        // expected Brands
        List<String> expectedBrands = new ArrayList<>(Arrays.asList("Elegant Auto Group", "Green Grass", "Node Js",
                "NS8", "RED", "Skysuite Tech", "Sterling"));
        System.out.println("expectedBrands = " + expectedBrands);

        // actual Brands
        List<String> actualBrands = new ArrayList<>();
        for (int i = 0; i < urunlerPage.brands.size(); i++) {
            if (expectedBrands.contains(urunlerPage.brands.get(i).getText())) {
                actualBrands.add(urunlerPage.brands.get(i).getText());
            }
        }

        System.out.println("actualBrands = " + actualBrands);

        // Test
        Assert.assertEquals(actualBrands, expectedBrands, "istenen urun markalari sitede mevcut");

        // 12- yeter artık! Kullanici sayfayi kapatsin :)

        Driver.closeDriver();
    }
}