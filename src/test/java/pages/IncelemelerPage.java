package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class IncelemelerPage {
   public   IncelemelerPage(){
         PageFactory.initElements(Driver.getDriver(),this);
     }

    @FindBy(xpath ="//a[@href='https://tradylinn.com/store-manager/']")
    public WebElement storeManager;
    @FindBy(xpath = "(//span[@class='text'])[16]")
    public WebElement incelemeler;
    @FindBy(xpath = "(//span[@class='text'])[19]")
    public WebElement productReviews;
    @FindBy(xpath = "//th[@class='sorting_disabled'][1]")
    public WebElement author;
    @FindBy(xpath = "//th[@class='sorting_disabled'][2]")
    public WebElement comment;
    @FindBy(xpath = "//th[@class='sorting_disabled'][3]")
    public WebElement rating;
    @FindBy(xpath = "//th[@class='sorting_disabled'][4]")
    public WebElement product;
    @FindBy(xpath = "//th[@class='sorting_disabled'][5]")
    public WebElement dated;
    @FindBy(xpath = "//div[@id='wcfm-reviews_info']")
    public WebElement showing1to3of3entries;

}
