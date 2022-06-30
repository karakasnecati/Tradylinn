package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MusteriPage {

    public MusteriPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManagerButton;

    @FindBy(xpath = "(//span[@class='text'])[7]")
    public WebElement costumersButton;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarList;

    @FindBy(xpath = "//a[contains(@class,'buttons-pdf')]")
    public WebElement pdfButton;

    @FindBy(xpath = "//a[contains(@class,'buttons-excel')]")
    public WebElement excelButton;

    @FindBy(xpath = "//a[contains(@class,'buttons-csv')]")
    public WebElement csvButton;

    @FindBy(xpath = "//*[text()='Yeni ekle']")
    public WebElement yeniEkleButton;

    @FindBy(id = "user_name")
    public WebElement userNameBox;

    @FindBy(id = "user_email")
    public WebElement userEmailBox;

    @FindBy(id = "first_name")
    public WebElement firstNameBox;

    @FindBy(id = "last_name")
    public WebElement lastNameBox;

    @FindBy(xpath = "//input[@name='submit-data']")
    public WebElement submitDataButoon;

    @FindBy(id = "bfirst_name")
    public WebElement bfirstNameBox;

    @FindBy(id = "blast_name")
    public WebElement blastnameBox;

    @FindBy(id = "bzip")
    public WebElement bzipBox;

    @FindBy(id = "bcompany_name")
    public WebElement bcompanyNameBox;

    @FindBy(id = "bphone")
    public WebElement bphoneBox;

    @FindBy(id = "baddr_1")
    public WebElement baddress1Box;

    @FindBy(id = "baddr_2")
    public WebElement baddress2Box;

    @FindBy(id = "bcity")
    public WebElement bcityBox;

    @FindBy(id = "bstate")
    public WebElement bstateBox;

    @FindBy(id = "bcountry")
    public WebElement bdropdownCountry;

    @FindBy(id = "same_as_billing")
    public WebElement checkBox;

    @FindBy(id = "sfirst_name")
    public WebElement sfirstNameBox;

    @FindBy(id = "slast_name")
    public WebElement slastnameBox;

    @FindBy(id = "szip")
    public WebElement szipBox;

    @FindBy(id = "scompany_name")
    public WebElement scompanyNameBox;


    @FindBy(id = "saddr_1")
    public WebElement saddress1Box;

    @FindBy(id = "saddr_2")
    public WebElement saddress2Box;

    @FindBy(id = "scity")
    public WebElement scityBox;

    @FindBy(id = "sstate")
    public WebElement sstateBox;

    @FindBy(id = "scountry")
    public WebElement sdropdownCountry;

    @FindBy(xpath = "(//span[@class='text'])[8]")
    public WebElement refundRequestGiris;

    @FindBy(xpath = "//thead//tr//th")
    public List<WebElement> refundRequestBaslikList;


}
