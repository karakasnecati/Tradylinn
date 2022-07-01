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
import utilities.TestBaseRapor;

public class MusteriEkleme extends TestBaseRapor {

    MusteriPage musteriPage;

    @BeforeMethod
    public void setUp() {
        Methods.musteriBolumGiris();
    }
    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void US16_TC001(){
        extentTest=extentReports.createTest("Musteri Bilgileri","Musteri Bilgileri Goruntulenebilmeli");
        musteriPage = new MusteriPage();
        extentTest.info("Musteriler bolumune girildi.");
        ReusableMethod.waitFor(5);
        int musteriSayisi=musteriPage.satirlarList.size();
        extentTest.info("Musteri sayisi belirlendi");
        Assert.assertFalse(musteriPage.satirlarList.isEmpty());
        extentTest.info("Musteriler Listesinin bos olup olmadigi test edildi.");
        Assert.assertTrue(musteriSayisi>0);
        extentTest.info("Musteri sayisinin sifirdan buyuk oldugu test edildi.");
    }

    @Test
    public void US16_TC002(){
        extentTest=extentReports.createTest("Bilgi Indirme","Musteri bilgileri indirilebilmeli");
        musteriPage = new MusteriPage();
        extentTest.info("Musteriler bolumune girildi");
        musteriPage.pdfButton.click();
        extentTest.info("Musteri bilgileri PDF formatinda indirildi");
        musteriPage.excelButton.click();
        extentTest.info("Musteri bilgileri excel formatinda indirildi");
        musteriPage.csvButton.click();
        extentTest.info("Musteri bilgileri csv formatinda indirildi");
    }

    @Test
    public void US16_TC003() {
        extentTest=extentReports.createTest("Musteri Ekleme","Yeni musteri eklenebilmeli");
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        musteriPage = new MusteriPage();
        extentTest.info("Musteriler bolumune girildi");
        int satirsayisi1 = musteriPage.satirlarList.size();
        extentTest.info("Mevcut musterilerin sayisi belirlendi");
        musteriPage.yeniEkleButton.click();
        extentTest.info("Yeni ekle butonuna tiklandi.");
        actions.click(musteriPage.userNameBox).sendKeys(faker.name().username())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .perform();
        extentTest.info("Yeni musteri username, mail, isim ve soyisim eklendi");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", musteriPage.submitDataButoon);
        extentTest.info("Submit butonuna tiklanarak ekleme yapildi.");
        ReusableMethod.waitFor(5);
        js.executeScript("arguments[0].click();", musteriPage.costumersButton);
        ReusableMethod.waitFor(5);
        int satirSayisi2 = musteriPage.satirlarList.size();
        extentTest.info("Musteriler bolumune tekrar gidilerek yeni listedeki kisi sayisi belirlendi");
        Assert.assertTrue(satirSayisi2 > satirsayisi1);
        extentTest.info("Kisi sayisinin arttigi test edildi");

    }
}
