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

public class UrunEkleme{
    UrunlerPage urunlerPage = new UrunlerPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test(priority = 1)
    public void TC_001_urun_ekleme() {
        Login.giris();
        urunlerPage.storeManager.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        urunlerPage.urunler.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @Test(priority = 2)
    public void TC_002_ekli_urun_bilgileri() {
        Assert.assertTrue(urunlerPage.status.isDisplayed());
        Assert.assertTrue(urunlerPage.stock.isDisplayed());
        Assert.assertTrue(urunlerPage.price.isDisplayed());
        Assert.assertTrue(urunlerPage.date.isDisplayed());
        ReusableMethod.waitFor(3);
        String str = urunlerPage.girilenUrunMiktariSonucu.getText();
        str = str.replaceAll("\\D", "");
        Integer tumUrunSayisi = Integer.valueOf(str);

        if (tumUrunSayisi > 0) {
            Assert.assertTrue(urunlerPage.girilenUrunMiktariSonucu.isDisplayed());
        } else Assert.assertTrue(urunlerPage.girilenUrunMiktariSonucu.isDisplayed());
    }

    @Test(priority = 3)
    public void TC_003_virtual_downloadable() {
        urunlerPage.addNewProduct.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(urunlerPage.virtual.isDisplayed());
        Assert.assertTrue(urunlerPage.downloadable.isDisplayed());
        urunlerPage.virtual.click();
        ReusableMethod.waitFor(3);
    }

    @Test(priority = 4)
    public void TC_004_title_price() {
        actions.click(urunlerPage.productTitle)
                .sendKeys(ConfigReader.getProperty("productTitle")).perform();

        actions.click(urunlerPage.productPrice)
                .sendKeys(ConfigReader.getProperty("productPrice")).perform();

        Assert.assertTrue(urunlerPage.productTitle.isEnabled());
        Assert.assertTrue(urunlerPage.productPrice.isEnabled());
    }

    @Test(priority = 5)
    public void TC_005_urun_resmi() {
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
    }

    @Test(priority = 6)
    public void TC_006_shortDescription_description() {
        Driver.getDriver().switchTo().frame(urunlerPage.iframeShortDescription);
        actions.click(urunlerPage.shortDescription)
                .sendKeys(ConfigReader.getProperty("shortDescription")).perform();
        Assert.assertTrue(urunlerPage.shortDescription.isEnabled());
        Driver.getDriver().switchTo().defaultContent();
        ReusableMethod.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Driver.getDriver().switchTo().frame(urunlerPage.iframeDescription);
        actions.click(urunlerPage.description)
                .sendKeys(ConfigReader.getProperty("description")).perform();
        Assert.assertTrue(urunlerPage.description.isEnabled());
        actions.sendKeys(Keys.PAGE_UP).perform();
        Driver.getDriver().switchTo().defaultContent();
    }

    @Test(priority = 7)
    public void TC_007_categories() {

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
    }

    @Test(priority = 8)
    public void TC_008_product_brands() {

        List<String> expectedBrands = new ArrayList<>(Arrays.asList("Elegant Auto Group", "Green Grass", "Node Js",
                "NS8", "RED", "Skysuite Tech", "Sterling"));
        System.out.println("expectedBrands = " + expectedBrands);
        List<String> actualBrands = new ArrayList<>();
        for (int i = 0; i < urunlerPage.brands.size(); i++) {
            if (expectedBrands.contains(urunlerPage.brands.get(i).getText())) {
                actualBrands.add(urunlerPage.brands.get(i).getText());
            }
        }
        System.out.println("actualBrands = " + actualBrands);
        Assert.assertEquals(actualBrands, expectedBrands, "istenen urun markalari sitede mevcut");

        Driver.closeDriver();
    }
}