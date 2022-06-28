package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class IndirimlerPage {
    public IndirimlerPage() {
        PageFactory.initElements(Driver.getDriver() ,this);
    }

    @FindBy(xpath = "//*[@id='main']/div/div/div[1]/div/div/div/section/div/div[2]/div/div/div/h2/a")
    public WebElement TumunuGorElement;

    @FindBy(xpath = "//*[text()='Sırala']")
    public WebElement SıralaElement;


    @FindBy (xpath = "//select[@name='orderby']")
    public WebElement dropdownElment;

    @FindBy(className = "    attachment-woocommerce_thumbnail size-woocommerce_thumbnail")
    public List<WebElement> urunlerListesi;

}


