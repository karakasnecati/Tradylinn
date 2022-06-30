package tests.us_01_02;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UyeOlPage;
import utilities.ConfigReader;
import utilities.Driver;
public class SaticiOlarakUyeOlma {
    public UyeOlPage uyeOlPage=new UyeOlPage();

    @Test
    public void UyeOl(){

        // 01. kullanici  'https://tradylinn.com' url'sine gider
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

        // 02. kullanci 'Uye Ol ' düğmesine tıklar
        uyeOlPage.uyeOlButonu.click();

        //03. kullanici 'Satici Ol' butonuna click yapar
        uyeOlPage.saticiOlButonu.click();

        //04. kullanici 'Registration sayfasinda email, password,
        // confirme password gorunurlugunu test eder
        Assert.assertTrue(uyeOlPage.emailGoruntu.isDisplayed());
        Assert.assertTrue(uyeOlPage.passwordGoruntu.isDisplayed());
        Assert.assertTrue(uyeOlPage.comfirmPasswordGoruntu.isDisplayed());

        //05. kullanici gecerli bir unique email girer
        uyeOlPage.emailBox.sendKeys("javateam23@gmail.com");

        //06. kullanici gecerli Guclu bir password girer :
        //kucuk harf, büyük harf, rakam ve special karakter kullanılmalı
        uyeOlPage.passwordBox.sendKeys("Java12345");

        //7. kullanici gecerli Guclu bir password'u tekrar confirme password butonuna girer
        uyeOlPage.confirmPasswordBox.sendKeys("Java12345");

        //8. kullanici 'Register' butonunu tıklar
        uyeOlPage.registerButonu.click();
        Driver.closeDriver();

    }
}

