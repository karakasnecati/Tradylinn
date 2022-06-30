package tests.us_01_02;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HesabimPage;
import tests.Login;
import utilities.Driver;
public class HesabimSayfasiBilgileri {

    HesabimPage hesabimPage = new HesabimPage();

    @Test
    public void HesabimTest01() throws InterruptedException {

        Login.giris();
        Thread.sleep(8000);

        //kullanici My Account yazisinin gorunurlugunu test eder
        Assert.assertTrue(hesabimPage.hesabimGorunum.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void HesabimTest02() throws InterruptedException {

     Login.giris();

        // kullanici Orders, Downloads, addresses, account details,whislist ve
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
    public void HesabimTest03() throws InterruptedException {

        Login.giris();

        //kullanici Dashboard altında: Store manager, orders, downloads, addresses, account details,
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
    public void HesabimTest04() throws InterruptedException {

        Login.giris();

        // kullanici Dashboard altında: Support tickets, followings ve log out
        //seceneklerinin görünürlüğünü doğrular
        Assert.assertTrue(hesabimPage.dBSupportTicketsGorunum.isDisplayed());
        Assert.assertTrue(hesabimPage.dBFollowingsGorunum.isDisplayed());
        Assert.assertTrue(hesabimPage.dBLogoutGorunum.isDisplayed());

        Driver.closeDriver();

    }

}
