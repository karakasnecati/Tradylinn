package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RaporlarPage {
   public RaporlarPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath ="//a[@href='https://tradylinn.com/store-manager/']")
    public WebElement storeManager;
    @FindBy(xpath = "(//span[@class='text'])[14]")
    public WebElement raporlar;
    @FindBy(xpath = "//*[text()='Year']")
    public WebElement year;
    @FindBy(xpath = "//*[text()='Last Month']")
    public WebElement lastMount;
    @FindBy(xpath = "(//*[text()='This Month'])[1]")
    public WebElement thisMonth;
    @FindBy(xpath = "//*[text()='Last 7 Days']")
    public WebElement last7Days;
    @FindBy(xpath = "//input[@class='wcfm-date-range']")
    public WebElement chooseDataRange;
    @FindBy(className ="apply-btn" )
    public WebElement close;

}
