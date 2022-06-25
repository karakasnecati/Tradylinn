package tests.us_01_02;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HesabimPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
public class US_02 {

    LoginPage loginPage = new LoginPage();
    HesabimPage hesabimPage = new HesabimPage();

    @Test
    public void HesabimTest01() {

        // 01. kullanici  'https://tradylinn.com' url'sine gider
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

        //02. kullanci 'Giris Yap' butonuna tiklar,
        loginPage.girisYap.click();

        //03. kullanici mevcut email adresini girer
        loginPage.mailBox.sendKeys(ConfigReader.getProperty("validEmail"));
        // 04. kullanici mevcut sifresini girer
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));
        //05. kullanici giris yap butonuna tiklar
        loginPage.hesabagirisYap.click();

        //06. kullanici anasayfadan 'My Account' sekmesine tiklar
        loginPage.hesabim.click();

        //07. kullanici My Account yazisinin gorunurlugunu test eder
        Assert.assertTrue(hesabimPage.hesabimGorunum.isDisplayed());

        Driver.closeDriver();
    }

    @Test
    public void HesabimTest02() {

        // 01. kullanici  'https://tradylinn.com' url'sine gider
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

        //02. kullanci 'Giris Yap' butonuna tiklar,
        loginPage.girisYap.click();

        //03. kullanici mevcut email adresini girer
        loginPage.mailBox.sendKeys(ConfigReader.getProperty("validEmail"));
        // 04. kullanici mevcut sifresini girer
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));
        //05. kullanici giris yap butonuna tiklar
        loginPage.hesabagirisYap.click();

        //06. kullanici anasayfadan 'My Account' sekmesine tiklar
        loginPage.hesabim.click();

        //07. kullanici Orders, Downloads, addresses, account details,whislist ve
        // Logout seceneklerinin görünürlüğünü doğrular

        Assert.assertTrue(hesabimPage.ordersGorunum.isDisplayed());
        Assert.assertTrue(hesabimPage.downloadsGorunum.isDisplayed());
        Assert.assertTrue(hesabimPage.adressesGorunum.isDisplayed());
        Assert.assertTrue(hesabimPage.accountDetailsGorunum.isDisplayed());
        Assert.assertTrue(hesabimPage.whislistGorunum.isDisplayed());
        Assert.assertTrue(hesabimPage.logOutGorunum.isDisplayed());

        Driver.closeDriver();

    }
    @Test
    public void HesabimTest03() {

        // 01. kullanici  'https://tradylinn.com' url'sine gider
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

        //02. kullanci 'Giris Yap' butonuna tiklar,
        loginPage.girisYap.click();

        //03. kullanici mevcut email adresini girer
        loginPage.mailBox.sendKeys(ConfigReader.getProperty("validEmail"));
        // 04. kullanici mevcut sifresini girer
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));
        //05. kullanici giris yap butonuna tiklar
        loginPage.hesabagirisYap.click();

        //06. kullanici anasayfadan 'My Account' sekmesine tiklar
        loginPage.hesabim.click();

        //.07. kullanici Dashboard altında: Store manager, orders, downloads, addresses, account details,
        // appointments, wishlist sekmelerinin gorunurlulugunu dogrular
        Assert.assertTrue(hesabimPage.storeManagerGorunum.isDisplayed());
        Assert.assertTrue(hesabimPage.dBOrdersGorunum.isDisplayed());
        Assert.assertTrue(hesabimPage.dBDownloadsGorunum.isDisplayed());
        Assert.assertTrue(hesabimPage.dBAddressGorunum.isDisplayed());
        Assert.assertTrue(hesabimPage.dBAccountDetailsGorunum.isDisplayed());
        Assert.assertTrue(hesabimPage.dBAppointmentsGorunum.isDisplayed());
        Assert.assertTrue(hesabimPage.dBWhislistGorunum.isDisplayed());

        Driver.closeDriver();

    }
    @Test
    public void HesabimTest04() {

        // 01. kullanici  'https://tradylinn.com' url'sine gider
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));

        //02. kullanci 'Giris Yap' butonuna tiklar,
        loginPage.girisYap.click();

        //03. kullanici mevcut email adresini girer
        loginPage.mailBox.sendKeys(ConfigReader.getProperty("validEmail"));
        // 04. kullanici mevcut sifresini girer
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));
        //05. kullanici giris yap butonuna tiklar
        loginPage.hesabagirisYap.click();

        //06. kullanici anasayfadan 'My Account' sekmesine tiklar
        loginPage.hesabim.click();

       // 07. kullanici Dashboard altında: Support tickets, followings ve log out
        //seceneklerinin görünürlüğünü doğrular
        Assert.assertTrue(hesabimPage.dBSupportTicketsGorunum.isDisplayed());
        Assert.assertTrue(hesabimPage.dBFollowingsGorunum.isDisplayed());
        Assert.assertTrue(hesabimPage.dBLogoutGorunum.isDisplayed());

        Driver.closeDriver();

    }

}
