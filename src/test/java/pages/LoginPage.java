package pages;

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

    @FindBy(xpath = "//a[@href='https://tradylinn.com/my-account-2/']")
    public WebElement hesabim;

}
