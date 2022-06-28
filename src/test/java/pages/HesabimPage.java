package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HesabimPage {
    public HesabimPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//h2[@class='page-title']")
    public WebElement hesabimGorunum;

    @FindBy(xpath = "(//div[@class='icon-box text-center'])[1]")
    public WebElement ordersGorunum;

    @FindBy(xpath = "(//div[@class='icon-box text-center'])[2]")
    public WebElement downloadsGorunum;

    @FindBy(xpath = "(//div[@class='icon-box text-center'])[3]")
    public WebElement adressesGorunum;

    @FindBy(xpath = "(//div[@class='icon-box text-center'])[4]")
    public WebElement accountDetailsGorunum;

    @FindBy(xpath = "(//div[@class='icon-box text-center'])[5]")
    public WebElement whislistGorunum;

    @FindBy(xpath = "(//div[@class='icon-box text-center'])[6]")
    public WebElement logOutGorunum;

    @FindBy(xpath = "  @FindBy(xpath = \"(//div[@class='icon-box text-center'])[6]\")\n" +
            "    public WebElement logOutGorunum;")
    public WebElement storeManagerGorunum;

    @FindBy(xpath = "//a[@href='https://tradylinn.com/my-account-2/orders/']")
    public static WebElement dBOrdersGorunum;

    @FindBy(xpath = "//a[@href='https://tradylinn.com/my-account-2/downloads/']")
    public WebElement dBDownloadsGorunum;

    @FindBy(xpath = "//a[@href='https://tradylinn.com/my-account-2/edit-address/']")
    public WebElement dBAddressGorunum;

    @FindBy(xpath = "//a[@href='https://tradylinn.com/my-account-2/edit-account/']")
    public WebElement dBAccountDetailsGorunum;

    @FindBy(xpath = "//a[@href='https://tradylinn.com/my-account-2/appointments/']")
    public WebElement dBAppointmentsGorunum;

    @FindBy(xpath = "(//a[@href='https://tradylinn.com/favorilerim/'])[2]")
    public WebElement dBWhislistGorunum;

    @FindBy(xpath = "//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--support-tickets']")
    public WebElement dBSupportTicketsGorunum;

    @FindBy(xpath = "//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--followings']")
    public WebElement dBFollowingsGorunum;

    @FindBy(xpath = "//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout']")
    public WebElement dBLogoutGorunum;
}


