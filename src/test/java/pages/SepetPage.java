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
    public static WebElement odemeButonu;

    @FindBy (xpath = "//span[@class='cart-label']")
    public static WebElement sepetimButonu;

    @FindBy (xpath = "//a[@class='button wc-forward']")
    public WebElement sepetiGoruntuleButonu;

    @FindBy (xpath = "//tr[@class='woocomerce-cart-form__cart-item cart-item']")
    public WebElement sepetIcerik;
}
