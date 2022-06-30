package tests.us_22;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndirimlerPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_002 {
    IndirimlerPage ip=new IndirimlerPage();

    //01_kullanici https://tradylinn.com/ adresine gider

    @Test
    public void test01() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

        //02_kullanici anasayfada İndirimli Ürünler de Tümünü gör e tıklar

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0,700)");
        Thread.sleep(2000);
        ip.tumunuGorLink.click();
        Thread.sleep(2000);

        //"03_Kullanici Varsayılan Sıralamayı Tıklar
        Select select = new Select(ip.dropdownElment);
        select.selectByIndex(0);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().toString().contains("indirimli-urunler/"));


        //En Cok İncelenene Gore Sıralayı Tıklar
        Select select1 = new Select(ip.dropdownElment);

        select1.selectByIndex(1);
        Thread.sleep(2000);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().toString().contains("popularity"));


        //En Cok  Oy Alana Gore Sıralayı Tıklar
        Select select2 = new Select(ip.dropdownElment);

        select.selectByIndex(2);

        Thread.sleep(3000);

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().toString().contains("rating"));

        //En Yeniye Gore Sıralayı Tıklar
        Select select3 = new Select(ip.dropdownElment);

        select.selectByIndex(3);
        Thread.sleep(2000);

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().toString().contains("date"));

        //Kullanici Fiyata Gore Sırala:Dusukten Yuksege Tıklar
        Select select4 = new Select(ip.dropdownElment);

        select.selectByIndex(4);
        Thread.sleep(3000);

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().toString().contains("price"));

        //Kullanici Fiyata Gore Sırala:Yuksekten Düşüğe Tıklar"
        Select select5 = new Select(ip.dropdownElment);

        select.selectByIndex(5);
        Thread.sleep(2000);

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().toString().contains("price-desc"));

        Driver.closeDriver();
    }
}

