package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UrunlerPage {

    public UrunlerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement urunler;

    @FindBy(xpath = "(//*[text()='Status'])[1]")
    public WebElement status;

    @FindBy(xpath = "(//*[text()='Price'])[1]")
    public WebElement price;

    @FindBy(xpath = "(//*[text()='Stock'])[1]")
    public WebElement stock;

    @FindBy(xpath = "(//*[text()='Date'])[1]")
    public WebElement date;

    @FindBy(xpath = "//*[text()='Yeni ekle']")
    public WebElement addNewProduct;

    @FindBy(xpath = "//input[@id='is_virtual']")
    public WebElement virtual;

    @FindBy(xpath = "//input[@id='is_downloadable']")
    public WebElement downloadable;
}
