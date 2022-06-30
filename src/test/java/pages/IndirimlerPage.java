package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class IndirimlerPage {

<<<<<<< HEAD


=======
    public IndirimlerPage() {

        PageFactory.initElements(Driver.getDriver() ,this);
    }

    @FindBy(xpath = "(//a[@href='https://tradylinn.com/product-category/indirimli-urunler/'])[4]")
    public WebElement tumunuGorLink;


    @FindBy (xpath = "//select[@name='orderby']")
    public WebElement dropdownElment;

    @FindBy(className = "attachment-woocommerce_thumbnail size-woocommerce_thumbnail")
    public List<WebElement> urunlerListesi;
>>>>>>> master

}


