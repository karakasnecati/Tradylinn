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

    @FindBy(xpath = "//input[@name='submit-data']")
    public WebElement submitDataButoon;

    @FindBy(xpath = "//input[@name='submit-data']")
    public WebElement ubmitDataButoon;

    @FindBy(xpath = "//input[@name='submit-data']")
    public WebElement submitDataButoo;

}
