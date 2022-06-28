package tests.us_05_06_07;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UrunlerPage;
import tests.Login;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;
import utilities.TestBaseRapor;

import java.util.*;

public class UrunEkleme extends TestBaseRapor {
    UrunlerPage urunlerPage = new UrunlerPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    WebDriver.TargetLocator iframeGecis = Driver.getDriver().switchTo();

    @Test(priority = 1)
    public void TC_001_urun_ekleme() {
        extentTest = extentReports.createTest("Yeni Urun Ekleme", "Kullanici Store Manager olarak, Products'a gidip urun listesini gorebilmeli");
        Login.giris();
        extentTest.info("Store Maneger olarak giris yapildi");
        urunlerPage.storeManager.click();
        extentTest.info("Store Manager sekmesine tiklandi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        urunlerPage.urunler.click();
        extentTest.info("Urunler sekmesine tiklandi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(urunlerPage.sayfaBasligi.isDisplayed());
        extentTest.pass("Kullanici basarili bir sekilde sayfaya girdi");
    }

    @Test(priority = 2)
    public void TC_002_ekli_urun_bilgileri() {
        extentTest = extentReports.createTest("Urun Bilgisi Detaylari",
                "Productsta urun listemi görmeliyim; status, stock, price, date");
        List<WebElement> urunBaslikListesi = urunlerPage.urunBilgileriHead;
        int istenenBaslikIndexi = -3;
        for (int i = 0; i < urunBaslikListesi.size(); i++) {
            if (urunBaslikListesi.get(i).getText().equals(ConfigReader.getProperty("urunBaslik"))) {
                istenenBaslikIndexi = i + 1;
                break;
            }
        }
        extentTest.info("İstenen urun basligi bilgisi girildi");
        if (istenenBaslikIndexi != -3) {
            List<WebElement> istenenSutundakiElementler =
                    Driver.getDriver().findElements(By.xpath("//tbody//tr//td[" + istenenBaslikIndexi + "]"));
            for (WebElement each : istenenSutundakiElementler
            ) {
                System.out.println(ConfigReader.getProperty("urunBaslik") + " basliktaki urun bilgileri: " + each.getText());
                extentTest.info("Istenen basliktaki biligiler yazdirildi");
                Assert.assertTrue(each.isDisplayed(), "istenen basliktaki urun bilgileri goruntulendi");
                extentTest.pass("Kullanici istenen urun basligi biligilerini goruntuledi");
            }
        } else {
            System.out.println("istenen baslik bulunamadi");
        }
    }

    @Test(priority = 3)
    public void TC_003_virtual_downloadable() {
        extentTest = extentReports.createTest("Virtual, Downloadable",
                "Urun icin virtual veya downloadable secenegi olmali");
        urunlerPage.addNewProduct.click();
        extentTest.info("Yeni urun ekle tiklandi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        urunlerPage.virtual.click();
        extentTest.info("Virtual butonu tiklandi");
        Assert.assertTrue(urunlerPage.virtual.isSelected());
        extentTest.pass("Virtual butonu secildi");
        Assert.assertTrue(urunlerPage.downloadable.isEnabled());
        extentTest.pass("Virtual butonu secilebilir");
    }

    @Test(priority = 4)
    public void TC_004_title_price() {
        extentTest = extentReports.createTest("Urun Basligi, Urun Fiyati",
                "Urun ismi ekle; product title, satis miktari");
        urunlerPage.productTitle
                .sendKeys(ConfigReader.getProperty("productTitle"));
        extentTest.info("Urun adi girildi");
        urunlerPage.productPrice
                .sendKeys(ConfigReader.getProperty("productPrice"));
        extentTest.info("Urun fiyati girildi");
        Assert.assertTrue(urunlerPage.productTitle.isEnabled());
        extentTest.pass("Urun adi basarili bir şekilde girilebildi");
        Assert.assertTrue(urunlerPage.productPrice.isEnabled());
        extentTest.pass("Urun fiyati basarili bir sekilde girilebildi");
    }

    @Test(priority = 5)
    public void TC_005_urun_resmi() {
        extentTest = extentReports.createTest("Urun Fotografi", "Urun fotosu eklenebilmeli");
        urunlerPage.imgAdd1.click();
        extentTest.info("Sayfada fotograf ekle bloguna tiklandi");
        urunlerPage.ortamKutuphanesi.click();
        extentTest.info("Ortam kütüphanesine tiklandi");
        urunlerPage.img1.click();
        extentTest.info("Eklenecek ilk fotografa tiklandi");
        ReusableMethod.waitFor(5);
        urunlerPage.secButonu.click();
        extentTest.info("Sec butonu tiklandi");
        urunlerPage.imgAdd2.click();
        extentTest.info("Sayfada ikinci fotograf ekle bloguna tiklandi");
        urunlerPage.img2.click();
        extentTest.info("İkinci fotografa tiklandi");
        ReusableMethod.waitFor(5);
        urunlerPage.addToGallery.click();
        extentTest.info("Add To Gallery butonuna tiklandi");
        Assert.assertTrue(urunlerPage.imgDisplay.isDisplayed());
        extentTest.pass("Urun fotografinin basarili bir sekilde eklendigi dogrulandi");
    }

    @Test(priority = 6)
    public void TC_006_shortDescription_description() {
        extentTest = extentReports.createTest("Kısa ve Kapsamlı Tanimlama",
                "Kisa tanımlama ve genis tanımlama (short description, Description)");
        iframeGecis.frame(urunlerPage.iframeShortDescription);
        actions.click(urunlerPage.shortDescription)
                .sendKeys(ConfigReader.getProperty("shortDescription")).perform();
        extentTest.info("Kisa tanimlama metin kutusuna, istenen metin girildi");
        Assert.assertTrue(urunlerPage.shortDescription.isEnabled());
        extentTest.pass("Metin basarili bir sekilde girildi");
        iframeGecis.defaultContent();
        ReusableMethod.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        iframeGecis.frame(urunlerPage.iframeDescription);
        actions.click(urunlerPage.description)
                .sendKeys(ConfigReader.getProperty("description")).perform();
        extentTest.info("Genis tanimlama metin kutusuna, istenen metin girildi");
        Assert.assertTrue(urunlerPage.description.isEnabled());
        extentTest.pass("Metin basarili bir sekilde girildi");
        iframeGecis.defaultContent();
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    @Test(priority = 7)
    public void TC_007_categories() {
        extentTest = extentReports.createTest("Kategori",
                " Secilen ürünlerin kategorilerini belirlemeliyim");
        List<String> expectedCategories = new ArrayList<>(Arrays.asList("Besin Takviyeleri", "Çok Satanlar",
                "Elektrik & Elektronik", "Ev & Yaşam", "İndirimli Ürünler", "Kitap & Müzik & Film",
                "Kozmatik & Kişisel Bakım", "Moda & Giyim", "Oyuncak", "Takı & Aksesuar", "Yeni Ürünler"));
        extentTest.info("İstenen urun kategorileri 'expectedCategories' listesine eklendi");
        List<String> actualCategories = new ArrayList<>();
        for (WebElement each : urunlerPage.categories
        ) {
            actualCategories.add(each.getText());
        }
        extentTest.info("Sitede mevcut olan tum kategoriler 'actualCategories' listesine eklendi");
        Assert.assertTrue(actualCategories.containsAll(expectedCategories), "istenen urun kategorileri sitede mevcut");
        extentTest.pass("İstenen kategori isimlerinin sitede mevcut oldugu dogrulandi");
        for (WebElement kategori : urunlerPage.categoriesCheckList
        ) {
            if (kategori.getText().equals(ConfigReader.getProperty("urunKategori"))) {
                String attribute = kategori.getAttribute("data-item");
                for (WebElement buton : urunlerPage.categoriesButton
                ) {
                    if (buton.getAttribute("value").equals(attribute)) {
                        jse.executeScript("arguments[0].click();", buton);
                        extentTest.info("Istenen herhangi bir urun kategorisine tiklandi");
                        Assert.assertTrue(buton.isSelected());
                        extentTest.pass("Urun kategorisine basarili bir sekilde tiklandi");
                    }
                }
            }
        }
    }

    @Test(priority = 8)
    public void TC_008_product_brands() {
        extentTest = extentReports.createTest("Marka",
                "Secilen ürünlerin brandini belirlemeliyim");
        List<String> expectedBrands = new ArrayList<>(Arrays.asList("Elegant Auto Group", "Green Grass", "Node Js",
                "NS8", "RED", "Skysuite Tech", "Sterling"));
        extentTest.info("İstenen urun markalari 'expectedBrands' listesine eklendi");
        List<String> actualBrands = new ArrayList<>();
        for (WebElement each : urunlerPage.brands
        ) {
            actualBrands.add(each.getText());
        }
        extentTest.info("Sitede mevcut olan tum kategoriler 'actualBrands' listesine eklendi");
        Assert.assertTrue(actualBrands.containsAll(expectedBrands), "istenen urun markalari sitede mevcut");
        extentTest.pass("İstenen marka isimlerinin sitede mevcut oldugu dogrulandi");
        for (WebElement marka : urunlerPage.brandsCheckList
        ) {
            if (marka.getText().equals(ConfigReader.getProperty("urunMarka"))) {
                String attribute = marka.getAttribute("data-item");
                for (WebElement buton : urunlerPage.brandsButton
                ) {
                    if (buton.getAttribute("value").equals(attribute)) {
                        jse.executeScript("arguments[0].click();", buton);
                        extentTest.info("Istenen herhangi bir urun markasina tiklandi");
                        Assert.assertTrue(buton.isSelected());
                        extentTest.pass("Urun markasina basarili bir sekilde tiklandi");
                    }
                }
            }
        }
    }
}