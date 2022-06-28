package tests.us_08_09_10_11;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UrunlerPage;
import tests.Login;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;
import utilities.TestBaseRapor;
import java.util.List;

public class UrunEkleme2 extends TestBaseRapor {
    UrunlerPage urunlerPage=new UrunlerPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();

    @Test(priority = 1)
    public void TC_001_stok_bilgileri_girme(){
        extentTest=extentReports.createTest("Stok Bilgilerini Girme","TC_001");
        Login.giris();
        ReusableMethod.waitFor(5);
        extentTest.info("Store manager olarak hesaba giris yapildi");

        urunlerPage.storeManager.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Store manager sekmesine girildi");

        urunlerPage.urunler.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.pass("Urunler sekmesine girildi");

        Assert.assertTrue(urunlerPage.status.isDisplayed());
        Assert.assertTrue(urunlerPage.stock.isDisplayed());
        Assert.assertTrue(urunlerPage.price.isDisplayed());
        Assert.assertTrue(urunlerPage.date.isDisplayed());
        extentTest.info("Status,Stock,Price ve Date basliklari dogrulandi");

        urunlerPage.addNewProduct.click();
        extentTest.info("Add new Product butonu tiklandi");

        js.executeScript("window.scrollBy(0,1400)");
        ReusableMethod.waitFor(3);
        urunlerPage.manageStock.click();
        ReusableMethod.waitFor(3);
        extentTest.info("Manage Stock butonu tiklandi");

        Assert.assertTrue(urunlerPage.inventory.isDisplayed());
        Assert.assertTrue(urunlerPage.shipping.isDisplayed());
        Assert.assertTrue(urunlerPage.attributesButonu.isDisplayed());
        extentTest.info("inventory,Shipping,Attributes basliklari dogrulandi");

        urunlerPage.stockQtyButonu.clear();
        actions.click(urunlerPage.stockQtyButonu)
                .sendKeys(ConfigReader.getProperty("StockQty")).perform();
        extentTest.info("Stok Miktari girildi");

        Select select = new Select(urunlerPage.allowBackordersButonu);

        List<WebElement> allowBackordersOptions=select.getOptions();
        for (WebElement allowBackordersButonu: allowBackordersOptions
        ) {
            allowBackordersButonu.click();
        }
        extentTest.info("On siparis bilgisi girildi");
    }

    @Test(priority = 2)
    public void TC_002_stok_bilgisi_girme() {
        extentTest=extentReports.createTest("Urunun Boyutlari  ve Teslimat bilgileri","TC_001_002_003");

        urunlerPage.shipping.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethod.waitFor(3);
        extentTest.info("Shipping butonu tiklandi");
        js.executeScript("arguments[0].scrollIntoView(true)",urunlerPage.shipping);

        Assert.assertTrue(urunlerPage.weight.isDisplayed());
        Assert.assertTrue(urunlerPage.dimensions.isDisplayed());
        Assert.assertTrue(urunlerPage.processingTimeYazisi.isDisplayed());
        extentTest.info("weight,dimensions,processingTime basliklari goruldu");

        urunlerPage.length.clear();
        actions.click().sendKeys(ConfigReader.getProperty("length")).perform();
        urunlerPage.width.clear();
        actions.click().sendKeys(ConfigReader.getProperty("width")).perform();
        urunlerPage.height.clear();
        actions.click().sendKeys(ConfigReader.getProperty("height")).perform();
        ReusableMethod.waitFor(3);
        extentTest.info("kilo ve boyut bilgileri girildi");

        Select select=new Select(urunlerPage.processingTimeButonu);
        List<WebElement> processingTimeoptions=select.getOptions();
        for (WebElement processingTimeButonu:processingTimeoptions
        ) {
            processingTimeButonu.click();
        }
        extentTest.pass("teslimat suresi girildi");
    }

    @Test(priority = 3)
    public void TC_003_urunu_renk_boyut_bilgisini_girme(){
        extentTest=extentReports.createTest("Urunun Renk ve Boyutlari","TC_001_002");

        urunlerPage.attributesButonu.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        js.executeScript("arguments[0].scrollIntoView(true)",urunlerPage.attributesButonu);

        ReusableMethod.waitFor(3);
        extentTest.info("Attrinutes butonu tiklandi");

        urunlerPage.collorButonu.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethod.waitFor(3);
        extentTest.info("color butonu tiklandi");

        Assert.assertTrue(urunlerPage.activeButonu.isDisplayed());
        ReusableMethod.waitFor(3);
        extentTest.info("color butonu gorundu");

        Select select = new Select(urunlerPage.colorSecme);
        List<WebElement> colorSecmeOptions = select.getOptions();
        for (WebElement colorSecme:colorSecmeOptions
        ) {
            colorSecme.click();
        }
        ReusableMethod.waitFor(3);
        extentTest.info("Renk secildi");

        urunlerPage.sizeActiveButonu.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethod.waitFor(3);
        extentTest.info("size butonu tiklandi");

        Assert.assertTrue(urunlerPage.sizeButonu.isDisplayed());
        ReusableMethod.waitFor(3);
        extentTest.info("active butonu gorundu");

        Select select1 = new Select(urunlerPage.sizeButonu);
        List<WebElement> sizeOptions=select1.getOptions();
        for (WebElement sizeButonu:sizeOptions
        ) {
            sizeButonu.click();
        }
        extentTest.info("Urunun boyutlari secildi");
    }
    @Test(priority = 4)
    public void TC_004_urun_cesidi_miktari_girme() {
        extentTest=extentReports.createTest("Urun Miktari","TC_001_002_003");
        urunlerPage.toptanUrunSecme.click();
        actions.sendKeys(Keys.DOWN).perform();
        js.executeScript("arguments[0].scrollIntoView(true)",urunlerPage.toptanUrunSecme);
        ReusableMethod.waitFor(4);
        extentTest.info("Toptan urun gosterme basligi goruldu");

        Select select = new Select(urunlerPage.pieceTypebutonu);
        select.selectByVisibleText(ConfigReader.getProperty("piectype"));
        ReusableMethod.waitFor(3);
        extentTest.info("Urun cesidi secildi");

        urunlerPage.unitsPerPieceButonu.clear();
        actions.click().sendKeys(ConfigReader.getProperty("unitsPerPiece")).perform();
        ReusableMethod.waitFor(3);
        extentTest.info("Urunun adet miktari girildi");

        urunlerPage.minOrderQuantityButonu.clear();
        actions.click().sendKeys(ConfigReader.getProperty("minOrderQuantity")).perform();
        ReusableMethod.waitFor(3);
        extentTest.pass("Urunun min. degeri yazildi");

    }

    }
