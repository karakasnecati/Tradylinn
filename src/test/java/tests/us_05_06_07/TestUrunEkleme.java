package tests.us_05_06_07;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UrunlerPage;
import tests.Login;
import utilities.Driver;

public class TestUrunEkleme{
    UrunlerPage urunlerPage=new UrunlerPage();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void UrunEkleme(){
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

        // 6- kullanici urun seceneklerinde Virtual ve Downloadable butonlari oldugunu dogrular

        Assert.assertTrue(urunlerPage.virtual.isDisplayed());
        Assert.assertTrue(urunlerPage.downloadable.isDisplayed());

    }
}
