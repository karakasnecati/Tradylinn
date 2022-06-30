package tests.us_22;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndirimlerPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Collections;

public class DusuktenYuksegeFiyat {
    @Test
    public void test01() throws InterruptedException {

        IndirimlerPage ip = new IndirimlerPage();

        //01_kullanici https://tradylinn.com/ adresine gider

        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

        //02_kullanici anasayfada İndirimli Ürünler de Tümünü gör e tıklar

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0,700)");
        Thread.sleep(2000);
        ip.tumunuGorLink.click();
        Thread.sleep(2000);



        //03_kullanici Sırala cubugunda "Fiyata göre sırala: Düşükten yükseğe"
        // seçildiğinde fiyatların kucukten buyuge gore sıralandıgını test eder

        Select select = new Select(ip.dropdownElment);
        select.selectByIndex(5);
        ArrayList<Double> urunlerDouble = new ArrayList<>();

        for (
                WebElement each : ip.urunlerListesi
        ) {
            String fıyatStr = each.getText().replaceAll("^\\D", "");

            urunlerDouble.add(Double.parseDouble((fıyatStr)));

        }
        ArrayList<Double> KONTROLLIST = new ArrayList<>(urunlerDouble);
        Collections.sort(KONTROLLIST);
        Assert.assertEquals(KONTROLLIST, urunlerDouble);
    }


}
