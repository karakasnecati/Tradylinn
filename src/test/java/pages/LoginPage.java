package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Giriş Yap']")
    public WebElement girisYap;

    @FindBy(xpath = "(//input[@name='username'])[1]")
    public WebElement mailBox;

    @FindBy(xpath = "(//input[@name='password'])[1]")
    public WebElement passwordBox;

    @FindBy(xpath = "(//button[@name='login'])[1]")
    public WebElement hesabagirisYap;

    @FindBy(xpath = "//li[@id='menu-item-1074']")
    public WebElement hesabim;

}
