package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SepeteUrunEklePage {
public SepeteUrunEklePage(){
    PageFactory.initElements(Driver.getDriver(),this);
}

@FindBy (xpath = "//a[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart']")
public List<WebElement> secilecekUrunListesi;


    @FindBy(xpath = "(//a[@data-quantity='1'])[6]")
    public WebElement ilkUrunSepeteEkle;

    @FindBy (xpath = "(//a[@data-quantity='1'])[2]")
    public WebElement ikinciUrunSepeteEkle;

    @FindBy (xpath = "(//a[@data-quantity='1'])[3]")
    public WebElement ucuncuUrunSepeteEkle;

    @FindBy (xpath = "(//a[@data-quantity='1'])[4]")
    public WebElement dorduncuUrunSepeteEkle;

    @FindBy (xpath = "(//a[@data-quantity='1'])[5]")
    public WebElement besinciUrunSepeteEkle;
}
