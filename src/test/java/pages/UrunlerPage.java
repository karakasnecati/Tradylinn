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
<<<<<<< HEAD

    @FindBy(xpath = "(//*[text()='Status'])[1]")
    public WebElement status;

    @FindBy(xpath = "(//*[text()='Price'])[1]")
    public WebElement price;

    @FindBy(xpath = "(//*[text()='Stock'])[1]")
    public WebElement stock;

    @FindBy(xpath = "(//*[text()='Date'])[1]")
    public WebElement date;

    @FindBy(xpath = "//a[@class='active']")
    public WebElement girilenUrunMiktariSonucu;

=======
    @FindBy(xpath = "//span[@class='wcfm-page-heading-text']")
    public WebElement sayfaBasligi;
    @FindBy(xpath = "//thead/tr/th")
    public List<WebElement> urunBilgileriHead;
>>>>>>> 4ec5c0c7321787b68071716ed4794fe63b71670e
    @FindBy(xpath = "//*[text()='Yeni ekle']")
    public WebElement addNewProduct;
    @FindBy(xpath = "//input[@id='is_virtual']")
    public WebElement virtual;
    @FindBy(xpath = "//input[@id='is_downloadable']")
    public WebElement downloadable;
<<<<<<< HEAD

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
=======
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
    public List<WebElement> categories;
    @FindBy(xpath = "//*[@id='product_cats_checklist']/li")
    public List<WebElement> categoriesCheckList;
    @FindBy(xpath = "//*[@id='product_cats_checklist']/li/input")
    public List<WebElement> categoriesButton;
    @FindBy(xpath = "//*[@id='product_brand']/li")
    public List<WebElement> brands;
    @FindBy(xpath = "//*[@id='product_brand']/li/input")
    public List<WebElement> brandsButton;
    @FindBy(xpath = "//*[@id='product_brand']/li")
    public List<WebElement> brandsCheckList;







>>>>>>> 4ec5c0c7321787b68071716ed4794fe63b71670e










    // hanife
<<<<<<< HEAD
    @FindBy(xpath = "//div[@id='wcfm_products_manage_form_inventory_head']")
    public WebElement inventory;

    @FindBy(xpath = "//input[@id='manage_stock']")
    public WebElement manageStockButonu;

=======
    @FindBy(xpath = "//input[@id='manage_stock']")
    public WebElement manageStock;
    @FindBy(xpath = "//div[@id='wcfm_products_manage_form_inventory_head']")
    public WebElement inventory;

>>>>>>> 4ec5c0c7321787b68071716ed4794fe63b71670e
    @FindBy(xpath = "//select[@id='backorders']")
    public WebElement allowBackordersButonu;

    @FindBy(xpath = "//input[@id='stock_qty']")
    public WebElement stockQtyButonu;

    @FindBy(xpath = "//div[@id='wcfm_products_manage_form_shipping_head']")
    public WebElement shipping;

<<<<<<< HEAD
=======
    @FindBy(xpath = "//p[*='Dimensions (cm)']")
    public WebElement dimensions;
    @FindBy(xpath = "//p[@class='_wcfmmp_processing_time wcfm_title']")
    public WebElement  processingTimeYazisi;

>>>>>>> 4ec5c0c7321787b68071716ed4794fe63b71670e
    @FindBy(xpath = "//input[@id='weight']")
    public WebElement weight;

    @FindBy(xpath = "//input[@id='length']")
    public WebElement length;

    @FindBy(xpath = "//input[@id='width']")
    public WebElement width;

    @FindBy(xpath = "//input[@id='height']")
    public WebElement height;

    @FindBy(xpath = "//select[@id='_wcfmmp_processing_time']")
<<<<<<< HEAD
    public WebElement ProcessingTimeButonu;
=======
    public WebElement processingTimeButonu;
>>>>>>> 4ec5c0c7321787b68071716ed4794fe63b71670e

    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[9]")
    public WebElement attributesButonu;

<<<<<<< HEAD
=======
    @FindBy(xpath = "//p[*='Attributes']")
    public WebElement attributesYazisi;

    @FindBy(xpath = "//input[@id='attributes_is_active_1']")
    public WebElement activeButonu;

>>>>>>> 4ec5c0c7321787b68071716ed4794fe63b71670e
    @FindBy(xpath = "//input[@id='attributes_is_active_1']")
    public WebElement collorButonu;

    @FindBy(xpath = "//select[@id='attributes_value_1']")
    public WebElement colorSecme;

<<<<<<< HEAD

    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[13]")
    public WebElement toptanGostermeAyarlari;














=======
    @FindBy(xpath = "//input[@id='attributes_is_active_2']")
    public WebElement sizeActiveButonu;

    @FindBy(xpath = "//input[@id='attributes_is_active_2']")
    public WebElement sizeButonu;


    //@FindBy(xpath = "//label[@class='wcfmfa fa-certificate']")
    //public WebElement toptanUrunSecme;
    @FindBy(xpath = "//*[@id=\"wcfm_products_manage_form_toptan-urun-gosterme-ayarlari_head\"]/div")
    public WebElement toptanUrunSecme;

    @FindBy(xpath = "//select[@id='piecetype']")
    public WebElement pieceTypebutonu;

    @FindBy(xpath = "//input[@id='unitpercart']")
    public WebElement unitsPerPieceButonu;

    @FindBy(xpath = "//input[@id='minorderqtytr']")
    public WebElement minOrderQuantityButonu;
>>>>>>> 4ec5c0c7321787b68071716ed4794fe63b71670e


}
