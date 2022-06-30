package tests.us_16_17_18;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MusteriPage;
import utilities.Driver;
import utilities.ReusableMethod;

public class MusteriBilgiEkleme {

    MusteriPage musteriPage;
    Actions actions;
    Faker faker;

    @BeforeMethod
    public void setUp() {
        Methods.musteriBolumGiris();
    }
    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void US17_TC001() {

        faker = new Faker();
        musteriPage=new MusteriPage();
        ReusableMethod.waitFor(5);
        WebElement editCustomer=Driver.getDriver().findElement(By.xpath("//tbody//tr["+musteriPage.satirlarList.size()+"]//td[8]//a[2]"));
        JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].click();",editCustomer);

        String firstName = musteriPage.firstNameBox.getAttribute("value");
        String lastName = musteriPage.lastNameBox.getAttribute("value");

        musteriPage.bfirstNameBox.sendKeys(firstName);
        musteriPage.blastnameBox.sendKeys(lastName);
        musteriPage.bcompanyNameBox.sendKeys(faker.company().name());
        musteriPage.bphoneBox.sendKeys(faker.phoneNumber().phoneNumber());
        musteriPage.baddress1Box.sendKeys(faker.address().fullAddress());
        musteriPage.baddress2Box.sendKeys(faker.address().secondaryAddress());
        Select select=new Select(musteriPage.bdropdownCountry);
        select.selectByVisibleText("Türkiye");
        musteriPage.bcityBox.sendKeys(faker.address().cityName());
        Select select2=new Select(musteriPage.bstateBox);
        select2.selectByIndex(7);
        musteriPage.bzipBox.sendKeys(faker.address().zipCode());

    }

    @Test
    public void US17_TC002() {
        actions = new Actions(Driver.getDriver());
        faker = new Faker();
        musteriPage = new MusteriPage();

        ReusableMethod.waitFor(5);
        WebElement editCustomer=Driver.getDriver().findElement(By.xpath("//tbody//tr["+musteriPage.satirlarList.size()+"]//td[8]//a[2]"));
        JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].click();",editCustomer);

        String firstName = musteriPage.firstNameBox.getAttribute("value");
        String lastName = musteriPage.lastNameBox.getAttribute("value");

        musteriPage.bfirstNameBox.sendKeys(firstName);
        musteriPage.blastnameBox.sendKeys(lastName);
        musteriPage.bcompanyNameBox.sendKeys(faker.company().name());
        musteriPage.bphoneBox.sendKeys(faker.phoneNumber().phoneNumber());
        musteriPage.baddress1Box.sendKeys(faker.address().fullAddress());
        musteriPage.baddress2Box.sendKeys(faker.address().secondaryAddress());
        Select select=new Select(musteriPage.bdropdownCountry);
        select.selectByVisibleText("Türkiye");
        musteriPage.bcityBox.sendKeys(faker.address().cityName());
        Select select2=new Select(musteriPage.bstateBox);
        select2.selectByIndex(7);
        musteriPage.bzipBox.sendKeys(faker.address().zipCode());

        if (!musteriPage.checkBox.isSelected()){
            musteriPage.checkBox.click();
        }

        Assert.assertTrue(musteriPage.checkBox.isSelected());

    }

    @Test
    public void US17_TC003() {
        actions = new Actions(Driver.getDriver());
        faker = new Faker();
        musteriPage = new MusteriPage();
        ReusableMethod.waitFor(5);
        WebElement editCustomer=Driver.getDriver().findElement(By.xpath("//tbody//tr["+musteriPage.satirlarList.size()+"]//td[8]//a[2]"));
        JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].click();",editCustomer);

        String firstName = musteriPage.firstNameBox.getAttribute("value");
        String lastName = musteriPage.lastNameBox.getAttribute("value");

        musteriPage.bfirstNameBox.sendKeys(firstName);
        musteriPage.blastnameBox.sendKeys(lastName);
        musteriPage.bcompanyNameBox.sendKeys(faker.company().name());
        musteriPage.bphoneBox.sendKeys(faker.phoneNumber().phoneNumber());
        musteriPage.baddress1Box.sendKeys(faker.address().fullAddress());
        musteriPage.baddress2Box.sendKeys(faker.address().secondaryAddress());
        Select select=new Select(musteriPage.bdropdownCountry);
        select.selectByVisibleText("Türkiye");
        musteriPage.bcityBox.sendKeys(faker.address().cityName());
        Select select2=new Select(musteriPage.bstateBox);
        select2.selectByIndex(7);
        musteriPage.bzipBox.sendKeys(faker.address().zipCode());

        if (musteriPage.checkBox.isSelected()){
            js.executeScript("arguments[0].click();",musteriPage.checkBox);
        }

        musteriPage.sfirstNameBox.sendKeys(firstName);
        musteriPage.slastnameBox.sendKeys(lastName);
        musteriPage.scompanyNameBox.sendKeys(faker.company().name());
        musteriPage.saddress1Box.sendKeys(faker.address().fullAddress());
        musteriPage.saddress2Box.sendKeys(faker.address().secondaryAddress());
        Select select3=new Select(musteriPage.sdropdownCountry);
        select3.selectByVisibleText("Türkiye");
        musteriPage.scityBox.sendKeys(faker.address().cityName());
        Select select4=new Select(musteriPage.sstateBox);
        select4.selectByIndex(6);
        musteriPage.szipBox.sendKeys(faker.address().zipCode());

        js.executeScript("arguments[0].click();",musteriPage.submitDataButoon);

    }

}
