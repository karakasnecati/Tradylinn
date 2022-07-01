package tests.us_16_17_18;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBaseRapor;

public class GeriOdemePlani extends TestBaseRapor {

    Methods methods;

    @BeforeMethod
    public void setUp() {
        Methods.refundRequestGiris();
    }
    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void US18_TC001() {

        extentTest=extentReports.createTest("Geri Iade","Geri iade planı olmalı");
        methods = new Methods();
        extentTest.info("musteri bolumune gidildi");
        extentTest.info("Geri odeme planina tiklandi");
        extentTest.info("Geri odeme talepleri listelendi");
        extentTest.info("Tablo basliklari liste atandi");
        methods.refundListPrint("Request ID");
        extentTest.info("Requested ID basliginin olup olmadigi test edildi");
        extentTest.info("Requested ID altindaki bilgiler konsolda yazdirildi");
    }

    @Test
    public void US18_TC002() {

        extentTest=extentReports.createTest("Geri Iade","Geri iade planı olmalı");
        methods = new Methods();
        extentTest.info("musteri bolumune gidildi");
        extentTest.info("Geri odeme planina tiklandi");
        extentTest.info("Geri odeme talepleri listelendi");
        extentTest.info("Tablo basliklari liste atandi");
        methods.refundListPrint("Order ID");
        extentTest.info("Order ID basliginin olup olmadigi test edildi");
        extentTest.info("Order ID altindaki bilgiler konsolda yazdirildi");
    }

    @Test
    public void US18_TC003() {
        extentTest=extentReports.createTest("Geri Iade","Geri iade planı olmalı");
        methods = new Methods();
        extentTest.info("musteri bolumune gidildi");
        extentTest.info("Geri odeme planina tiklandi");
        extentTest.info("Geri odeme talepleri listelendi");
        extentTest.info("Tablo basliklari liste atandi");
        methods.refundListPrint("Urun Adedi");
        extentTest.info("Urun adedi basliginin olup olmadigi test edildi");
        extentTest.info("Urun adedi altindaki bilgiler konsolda yazdirildi");
    }

    @Test
    public void US18_TC004() {
        extentTest=extentReports.createTest("Geri Iade","Geri iade planı olmalı");
        methods = new Methods();
        extentTest.info("musteri bolumune gidildi");
        extentTest.info("Geri odeme planina tiklandi");
        extentTest.info("Geri odeme talepleri listelendi");
        extentTest.info("Tablo basliklari liste atandi");
        methods.refundListPrint("Type");
        extentTest.info("Urun tipi basliginin olup olmadigi test edildi");
        extentTest.info("Urun tipi basligi altindaki bilgiler konsolda yazdirildi");
        methods.refundListPrint("Reason");
        extentTest.info("Geri odeme sebebi basliginin olup olmadigi test edildi");
        extentTest.info("Geri odeme sebebi basliginin altindaki bilgiler konsolda yazdirildi");


    }

}
