package tests.us_22;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndirimlerPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC_001 {


    //01_kullanici https://tradylinn.com/ adresine gider

    @Test
    public void test01() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

        IndirimlerPage tr = new IndirimlerPage();

//02_kullanici Tumunu gor e tıkladıgında o kategorideki sayfaya gider

      JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0,700)");


        Thread.sleep(7000);
        tr.TumunuGorElement.click();
        Thread.sleep(7000);

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().toString().contains("indirimli"));

        Driver.closeDriver();
    }

}
