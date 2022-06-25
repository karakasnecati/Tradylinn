package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

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

    @FindBy(xpath = "//div[@id='wcfm-products_info']")
    public WebElement girilenUrunMiktariSonucu;

    @FindBy(xpath = "//*[text()='Yeni ekle']")
    public WebElement addNewProduct;

    @FindBy(xpath = "//input[@id='is_virtual']")
    public WebElement virtual;

    @FindBy(xpath = "//input[@id='is_downloadable']")
    public WebElement downloadable;

    @FindBy(xpath = "//input[@id='pro_title']")
    public WebElement productTitle;

    @FindBy(xpath = "//input[@id='regular_price']")
    public WebElement productPrice;

    @FindBy(xpath = "//img[@id='featured_img_display']")
    public WebElement imgAdd1;

    @FindBy(xpath = "//*[@id='menu-item-browse']")
    public WebElement ortamKutuphanesi;

    @FindBy(xpath = "(//li[@tabindex='0'])[1]")
    public WebElement img1;

    @FindBy(xpath = "//button[text()='Seç']")
    public WebElement secButonu;

    @FindBy(xpath = "//img[@id='gallery_img_gimage_0_display']")
    public WebElement imgAdd2;

    @FindBy(xpath = "(//li[@data-id='9475'])[2]")
    public WebElement img2;

    @FindBy(xpath = "(//button[text()='Add to Gallery'])[2]")
    public WebElement addToGallery;

    @FindBy(xpath = "//img[@id='featured_img_display']")
    public WebElement imgDisplay;

    @FindBy(xpath = "//iframe[@id='excerpt_ifr']")
    public WebElement iframeShortDescription;

    @FindBy(xpath = "//html[@lang='tr']")
    public WebElement shortDescription;

    @FindBy(xpath = "//iframe[@id='description_ifr']")
    public WebElement iframeDescription;

    @FindBy(xpath = "//html[@lang='tr']")
    public WebElement description;

    @FindBy(xpath = "//*[@id='product_cats_checklist']/li")
    public  List<WebElement> categories;

    @FindBy(xpath = "//*[@id='product_brand']/li")
    public  List<WebElement> brands;




}
