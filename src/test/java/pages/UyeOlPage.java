package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UyeOlPage {

    public  UyeOlPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "//*[@class='register inline-type']")
    public WebElement uyeOlButonu;

    @FindBy(xpath = "(//*[@href='https://tradylinn.com/vendor-register/'])[2]")
    public WebElement saticiOlButonu;

    @FindBy(xpath = "//p[@class='user_email wcfm_ele wcfm_title']")
    public WebElement emailGoruntu;

    @FindBy(xpath = "//p[@class='passoword wcfm_ele wcfm_title']")
    public WebElement passwordGoruntu;

    @FindBy(xpath = "//p[@class='confirm_pwd wcfm_ele wcfm_title']")
    public WebElement comfirmPasswordGoruntu;

    @FindBy(xpath = "//input[@id='user_email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='passoword']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@id='confirm_pwd']")
    public WebElement confirmPasswordBox;

    @FindBy(xpath = "//input[@id='wcfm_membership_register_button']")
    public WebElement registerButonu;



}