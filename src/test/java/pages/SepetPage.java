package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class SepetPage {


    public SepetPage() {
        PageFactory.initElements(Driver.getDriver(), "this");
    }

    @FindBy(xpath = "//a[@class='button checkout wc-forward']")
    public WebElement odemeButonu;

    @FindBy (xpath ="(//*[text()='Sepetim'])[1]")
    public WebElement sepetimButonu;

    @FindBy (xpath = "//a[@class='button wc-forward']")
    public WebElement sepetiGoruntuleButonu;

    @FindBy (xpath = "//tr[@class='woocomerce-cart-form__cart-item cart-item']")
    public WebElement sepetIcerik;

    @FindBy (xpath = "//button[@class='woocommerce-button button woocommerce-form-login__submit']")
    public WebElement hesabaGirisYap2;

    @FindBy(xpath = "//th[@class='product-thumbnail']")
    public WebElement urunYazisi;

    @FindBy(xpath = "//th[@class='product-price']")
    public WebElement fiyatYazisi;

    @FindBy(xpath = "//th[@class='product-quantity']")
    public WebElement miktarYazisi;

    @FindBy(xpath = "//th[@class='product-subtotal']")
    public WebElement araToplamYazisi;

    @FindBy(xpath="//button[@name='apply_coupon']")
    public WebElement kuponKullanButton;

    @FindBy(xpath = "(//a[@href='https://tradylinn.com/shop/'])[1]")
    public WebElement alisVeriseDevamEtButton;

    @FindBy(xpath = "(//h4[text()='Kargo Bilgileri'])[1]")
    public WebElement kargoBilgileriYazisi;

    @FindBy(xpath = "//tr[@class='order-total']")
    public WebElement toplamBilgisi;

    @FindBy (xpath = "(//button[@class='quantity-plus w-icon-plus'])[2]")
    public WebElement artiButton;

    @FindBy (xpath="//button[@name='update_cart']")
    public WebElement sepetiYenileButton;

    @FindBy (xpath = "//td[@data-title='Toplam']")
    public WebElement toplamFiyatYazisi;

    @FindBy(xpath = "(//input[@type='number'])[2]")
    public WebElement miktarHanesi;

    @FindBy(xpath = "(//button[@class='quantity-minus w-icon-minus'])[2]")
    public WebElement eksiButton;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    public WebElement odemeSayfasinaGitButton;

    @FindBy (xpath = "//div[@class='woocommerce-billing-fields']")
    public WebElement faturaDetaylariAlani;


}
