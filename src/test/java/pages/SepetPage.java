package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
<<<<<<< HEAD

public class SepetPage {
=======

public class SepetPage {

>>>>>>> 4ec5c0c7321787b68071716ed4794fe63b71670e
    public SepetPage() {
        PageFactory.initElements(Driver.getDriver(), "this");
    }

    @FindBy(xpath = "//a[@class='button checkout wc-forward']")
    public static WebElement odemeButonu;

    @FindBy (xpath = "//span[@class='cart-label']")
    public static WebElement sepetimButonu;

    @FindBy (xpath = "//a[@class='button wc-forward']")
<<<<<<< HEAD
    public WebElement sepetiGoruntuleButonu;

    @FindBy (xpath = "//tr[@class='woocomerce-cart-form__cart-item cart-item']")
    public WebElement sepetIcerik;
=======
    public static WebElement sepetiGoruntuleButonu;

    @FindBy (xpath = "//tr[@class='woocomerce-cart-form__cart-item cart-item']")
    public WebElement sepetIcerik;

    @FindBy (xpath = "//button[@class='woocommerce-button button woocommerce-form-login__submit']")
    public static WebElement hesabaGirisYap2;

    @FindBy(xpath = "//th[@class='product-thumbnail']")
    public static WebElement urunYazisi;

    @FindBy(xpath = "//th[@class='product-price']")
    public static WebElement fiyatYazisi;

    @FindBy(xpath = "//th[@class='product-quantity']")
    public static WebElement miktarYazisi;

    @FindBy(xpath = "//th[@class='product-subtotal']")
    public static WebElement araToplamYazisi;

    @FindBy(xpath="//button[@name='apply_coupon']")
    public static WebElement kuponKullanButton;

    @FindBy(xpath = "(//a[@href='https://tradylinn.com/shop/'])[1]")
    public static WebElement alisVeriseDevamEtButton;

    @FindBy(xpath = "(//h4[text()='Kargo Bilgileri'])[1]")
    public static WebElement kargoBilgileriYazisi;

    @FindBy(xpath = "//tr[@class='order-total']")
    public static WebElement toplamBilgisi;

    @FindBy (xpath = "(//button[@class='quantity-plus w-icon-plus'])[2]")
    public static WebElement artiButton;

    @FindBy (xpath="//button[@name='update_cart']")
    public static WebElement sepetiYenileButton;

    @FindBy (xpath = "//td[@data-title='Toplam']")
    public static WebElement toplamFiyatYazisi;

    @FindBy(xpath = "(//input[@type='number'])[2]")
    public static WebElement miktarHanesi;

    @FindBy(xpath = "(//button[@class='quantity-minus w-icon-minus'])[2]")
    public static WebElement eksiButton;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    public static WebElement odemeSayfasinaGitButton;

    @FindBy (xpath = "//div[@class='woocommerce-billing-fields']")
    public static WebElement faturaDetaylariAlani;

>>>>>>> 4ec5c0c7321787b68071716ed4794fe63b71670e
}
