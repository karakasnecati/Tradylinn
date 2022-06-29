package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SiparislerPage {

<<<<<<< HEAD

=======
    public static WebElement adKutusu;
>>>>>>> 4ec5c0c7321787b68071716ed4794fe63b71670e

    public SiparislerPage(){
        PageFactory.initElements(Driver.getDriver(),"this");
    }
    @FindBy(xpath = "i[@class='w-icon-long-arrow-right'])[5]")
    public static WebElement orders;

<<<<<<< HEAD
    @FindBy(xpath = "//p[text()='Siparişler']")
    public WebElement siparislerButonu;

    @FindBy(xpath = "//a[@href='https://tradylinn.com/shop/'])[1]")
    public static WebElement urunlereGozAt;
}
=======
    @FindBy(xpath = "//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--orders']")
    public static WebElement siparislerButonu;

    @FindBy(xpath = "//a[@href='https://tradylinn.com/shop/'])[1]")
    public static WebElement urunlereGozAt;

    @FindBy(xpath = "//button[@id='place_order']")
    public static WebElement siparisiOnaylaButton;

    @FindBy(xpath="//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public static WebElement siparisinizAlinmistirYazisi;

}
>>>>>>> 4ec5c0c7321787b68071716ed4794fe63b71670e
