package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TakipcilerPage {
    public TakipcilerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath ="//a[@href='https://tradylinn.com/store-manager/']")
    public WebElement storeManager;
    @FindBy(xpath = "(//span[@class='text'])[11]")
    public WebElement takipciler;
    @FindBy(xpath = "//h2[text()='Followers List']")
    public WebElement followersList;


}
