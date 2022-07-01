package tests.us_16_17_18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.LoginPage;
import pages.MusteriPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;
import java.util.List;

public class Methods {



    public static void storeManagerGiris(){

        MusteriPage musteriPage = new MusteriPage();
        LoginPage loginPage=new LoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        loginPage.girisYap.click();
        loginPage.mailBox.sendKeys(ConfigReader.getProperty("validEmail"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));
        loginPage.hesabagirisYap.click();
        ReusableMethod.waitFor(10);
        loginPage.hesabim.click();
        musteriPage.storeManagerButton.click();

    }

    public static void musteriBolumGiris(){
        storeManagerGiris();
        MusteriPage musteriPage = new MusteriPage();
        musteriPage.costumersButton.click();
    }

    public static void refundRequestGiris(){
        storeManagerGiris();
        MusteriPage musteriPage = new MusteriPage();
        musteriPage.refundRequestGiris.click();
        ReusableMethod.waitFor(5);
    }

    public void refundListPrint(String requestInformation) {

        MusteriPage musteriPage = new MusteriPage();
        List<WebElement> tabloBaslikList = musteriPage.refundRequestBaslikList;

        int istenenBaslikIndexi=-3;
        for (int i = 0; i < tabloBaslikList.size(); i++) {
            if (tabloBaslikList.get(i).getText().equals(requestInformation)){
                istenenBaslikIndexi=i+1;
                break;
            }
        }

        if (istenenBaslikIndexi!=-3){
            List<WebElement> istenenSutundakiElementler= Driver.getDriver().findElements(By.xpath("//tbody//tr//td["+istenenBaslikIndexi+"]"));
            for (WebElement each:istenenSutundakiElementler
            ) {
                System.out.println(each.getText());
            }
        }else{
            System.out.println("istenen baslik bulunamadi");
            Assert.assertTrue(tabloBaslikList.contains(requestInformation));
        }
    }




}
