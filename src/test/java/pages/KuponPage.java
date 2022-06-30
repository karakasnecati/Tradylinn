package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;
import java.util.Random;

public class KuponPage {
    public KuponPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    public Random rnd = new Random();
    public String codeID= String.valueOf(rnd.nextInt(10000));

    @FindBy(xpath = "//a[.='Store Manager']")
    public WebElement storeManager;

    @FindBy (xpath = "(//span[@class='text'])[6]")
    public WebElement kuponlarSekmesi;


    @FindBy (xpath = "(//span[@class='text'])[19]")
    public WebElement yeniEkleButonu;

    @FindBy (xpath = "//input[@name='title']")
    public WebElement kupunKoduBox;

    @FindBy (xpath = "//textarea[@id='description']")
    public WebElement descriptionBox;

    @FindBy (xpath = "//select[@id='discount_type']")
    public WebElement discountTypeBox;

    @FindBy (xpath = "//input[@id='coupon_amount']")
    public WebElement amountKuponBox;

    @FindBy (xpath = "//input[@id='expiry_date']")
    public WebElement expriyDate;

    @FindBy (xpath = "//select[@class='ui-datepicker-month']")
    public WebElement aySecimi;

    @FindBy (xpath = "//select[@class='ui-datepicker-year']")
    public WebElement yilSecimi;

    @FindBy (xpath = "(//a[@class='ui-state-default'])[18]")
    public WebElement gunSecimi;

    @FindBy (xpath = "//input[@id='free_shipping']")
    public WebElement freeShippin;

    @FindBy (xpath = "//input[@id='show_on_store']")
    public WebElement showOnStore;

    @FindBy (xpath = "//input[@name='minimum_amount']")
    public WebElement maxSpend;

    @FindBy (xpath = "//input[@name='maximum_amount']")
    public WebElement minSpend;

    @FindBy (xpath = "//input[@name='individual_use']")
    public WebElement bireyselKullanimSecenegi;
    @FindBy (xpath = "//input[@name='exclude_sale_items']")
    public WebElement baziUrunlerHaric;

    @FindBy (xpath = "//select[@id='exclude_product_categories']")
    public WebElement baziKategorilerHaric;

    @FindBy (xpath = "//div[@id='coupons_manage_limit']")
    public WebElement limitButonu;

    @FindBy (xpath = "//input[@id='usage_limit']")
    public WebElement usageLimit;

    @FindBy (xpath = "//input[@id='limit_usage_to_x_items']")
    public WebElement usageLimitItems;

    @FindBy (xpath = "//input[@id='usage_limit_per_user']")
    public WebElement usageLimitPerUser;

    @FindBy (xpath = "//input[@id='wcfm_coupon_manager_submit_button']")
    public WebElement submitButonu;




    @FindBy (xpath = "//h2[.='Add Coupon']")
    public WebElement addCouponYazsi;

    @FindBy (xpath = "//label[@class='wcfmfa fa-user']")
    public WebElement restrictionYazisi;

    @FindBy (xpath = "//h2[.='Coupons Listing']")
    public WebElement kuponListesi;




}
