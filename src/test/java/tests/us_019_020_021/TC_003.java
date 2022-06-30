package tests.us_019_020_021;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RaporlarPage;
import tests.Login;
import utilities.Driver;
import utilities.ReusableMethod;
import utilities.TestBaseRapor;




public class TC_003 extends TestBaseRapor {
    RaporlarPage raporlarPage;
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

   @Test(priority = 1)

      public void test01() throws InterruptedException {
       extentTest=extentReports.createTest("raporlar","raporlar goruntulenmeli specific bir tarih secilmeli");
          Login.giris();
          extentTest.info("login olundu");
         Thread.sleep(3000);
       raporlarPage = new RaporlarPage();
          raporlarPage.storeManager.click();
          extentTest.info("store manager girildi");
        jse.executeScript("window.scrollBy(0,700)");
          Thread.sleep(1000);
          raporlarPage.raporlar.click();
          extentTest.info("raporlara girildi");
          Assert.assertTrue(raporlarPage.year.isDisplayed());
          extentTest.pass("year goruldu");
          Assert.assertTrue(raporlarPage.lastMount.isDisplayed());
          extentTest.pass("lastMount goruldu");
          Assert.assertTrue(raporlarPage.thisMonth.isDisplayed());
          extentTest.pass("thisMonth goruldu");
          Assert.assertTrue(raporlarPage.last7Days.isDisplayed());
          extentTest.pass("last7Days goruldu");
          Driver.closeDriver();
      }

    @Test(priority = 2)
    public void test02() throws InterruptedException {
       extentTest=extentReports.createTest("specific tarih","spesific tarih secilmeli");
       Login.giris();
       extentTest.info("login olundu");
        raporlarPage = new RaporlarPage();
       ReusableMethod.waitFor(20);
       raporlarPage.storeManager.click();
        extentTest.info("store manager tiklandi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        raporlarPage.raporlar.click();
        extentTest.info("raporlara girildi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
         raporlarPage.chooseDataRange.click();
        extentTest.info("chooseDataRange butonuna tiklandi");
        ReusableMethod.waitFor(10);
        raporlarPage.chooseDataRange.sendKeys("2022-06-23 to 2022-07-04" );
        extentTest.info("spesific bir tarih gonderildi");
        raporlarPage.close.click();
        extentTest.info("close tiklandi");
        Assert.assertTrue(raporlarPage.chooseDataRange.isDisplayed());
        extentTest.pass("tarih goruldu");
        Driver.closeDriver();
}

}





