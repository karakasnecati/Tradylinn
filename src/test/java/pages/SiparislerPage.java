package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SiparislerPage {

    public SiparislerPage(){
        PageFactory.initElements(Driver.getDriver(),"this");
    }
    @FindBy(xpath = "i[@class='w-icon-long-arrow-right'])[5]")
    public WebElement orders;

    @FindBy(xpath = "//a[text()='Siparişler']")
    public WebElement siparislerButonu;

    @FindBy(xpath = "//a[@href='https://tradylinn.com/shop/'][1]")
    public WebElement urunlereGozAt;

    @FindBy(xpath = "//button[@id='place_order']")
    public WebElement siparisiOnaylaButton;

    @FindBy(xpath="//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement siparisinizAlinmistirYazisi;

    @FindBy(xpath = "//input[@id='billing_first_name']")
    public WebElement adKutusu;


}