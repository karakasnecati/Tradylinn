package tests.us_13_14_15;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KuponPage;
import tests.Login;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;
import utilities.ReusableMethod;

public class US13_14_15 {

    Actions actions = new Actions(Driver.getDriver());
    KuponPage kuponPage = new KuponPage();

    @Test (priority = 1)
    public void US_13() {
        Login.giris();
        kuponPage.storeManager.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethod.waitFor(10);
        kuponPage.kuponlarSekmesi.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethod.waitFor(3);
        kuponPage.yeniEkleButonu.click();
        kuponPage.kupunKoduBox.sendKeys(kuponPage.codeID);
        kuponPage.descriptionBox.sendKeys("Team23'e ozel kupondur");
        Select select1 = new Select(kuponPage.discountTypeBox);
        select1.selectByVisibleText("Fixed Product Discount");
        kuponPage.amountKuponBox.sendKeys("25");
        actions.sendKeys(Keys.TAB).perform();
        Select select2 = new Select(kuponPage.aySecimi);
        select2.selectByIndex(4);
        Select select3 = new Select(kuponPage.yilSecimi);
        ReusableMethod.waitFor(3);
        select3.selectByIndex(110);
        kuponPage.gunSecimi.click();
        ReusableMethod.waitFor(3);
        actions.sendKeys(Keys.TAB).perform();
        kuponPage.freeShippin.click();
        ReusableMethod.waitFor(3);
        kuponPage.showOnStore.click();
        ReusableMethod.waitFor(3);
        Assert.assertTrue(kuponPage.addCouponYazsi.isDisplayed());
    }

    @Test (priority = 2)
    public void US_14() {
        //    9- kullanici minimum spend girer
        kuponPage.minSpend.sendKeys("100000");
        actions.sendKeys(Keys.TAB).perform();
        //    10- kullanici  maximum spend  girer
        kuponPage.maxSpend.sendKeys("10000");
        ReusableMethod.waitFor(3);
        kuponPage.bireyselKullanimSecenegi.click();
        ReusableMethod.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        kuponPage.baziUrunlerHaric.click();
        ReusableMethod.waitFor(2);
        actions.sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).perform();
        ReusableMethod.waitFor(2);
        actions.sendKeys(Keys.TAB).perform();
        ReusableMethod.waitFor(2);
        actions.sendKeys(Keys.TAB).perform();
        ReusableMethod.waitFor(2);
        Select select = new Select(kuponPage.baziKategorilerHaric);
        select.selectByIndex(3);
        select.selectByIndex(5);
        select.selectByIndex(7);
        select.selectByIndex(9);
        Assert.assertTrue(kuponPage.restrictionYazisi.isDisplayed());
        ReusableMethod.waitFor(15);

    }


    @Test (priority = 3)
    public void US_15(){

        actions.sendKeys(Keys.PAGE_UP).perform();

        kuponPage.limitButonu.click();
        kuponPage.usageLimit.sendKeys("5");
        ReusableMethod.waitFor(3);
        kuponPage.usageLimitItems.sendKeys("25");
        ReusableMethod.waitFor(3);
        kuponPage.usageLimitPerUser.sendKeys("3");
        ReusableMethod.waitFor(3);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.PAGE_DOWN).perform();
        kuponPage.submitButonu.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethod.waitFor(15);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        kuponPage.kuponlarSekmesi.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        kuponPage.kuponListesi.isDisplayed();
    }


}