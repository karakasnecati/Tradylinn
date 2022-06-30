package tests.us_16_17_18;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MusteriPage;
import utilities.Driver;
import utilities.ReusableMethod;

public class US_16 {

    MusteriPage musteriPage;

    @BeforeMethod
    public void setUp() {
        US_16_17_18_methods.musteriBolumGiris();
    }
    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void US16_TC001(){

        musteriPage = new MusteriPage();
        ReusableMethod.waitFor(5);
        int musteriSayisi=musteriPage.satirlarList.size();
        Assert.assertFalse(musteriPage.satirlarList.isEmpty());
        Assert.assertTrue(musteriSayisi>0);

    }

    @Test
    public void US16_TC002(){

        musteriPage = new MusteriPage();
        musteriPage.pdfButton.click();
        musteriPage.excelButton.click();
        musteriPage.csvButton.click();

    }

    @Test
    public void US16_TC003() {
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        musteriPage = new MusteriPage();
        int satirsayisi1 = musteriPage.satirlarList.size();
        musteriPage.yeniEkleButton.click();
        actions.click(musteriPage.userNameBox).sendKeys(faker.name().username())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .perform();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", musteriPage.submitDataButoon);
        ReusableMethod.waitFor(5);
        js.executeScript("arguments[0].click();", musteriPage.costumersButton);
        ReusableMethod.waitFor(5);
        int satirSayisi2 = musteriPage.satirlarList.size();
        Assert.assertTrue(satirSayisi2 > satirsayisi1);

    }
}
