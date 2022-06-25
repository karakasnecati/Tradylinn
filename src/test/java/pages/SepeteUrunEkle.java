package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SepeteUrunEkle {
public SepeteUrunEkle(){
}
    @FindBy(xpath = "(//a[@data-quantity='1'])[1]")
    public static WebElement ilkUrunSepeteEkle;

    @FindBy (xpath = "(//a[@data-quantity='1'])[2]")
    public static WebElement ikinciUrunSepeteEkle;

    @FindBy (xpath = "(//a[@data-quantity='1'])[3]")
    public static WebElement ucuncuUrunSepeteEkle;

    @FindBy (xpath = "(//a[@data-quantity='1'])[4]")
    public static WebElement dorduncuUrunSepeteEkle;

    @FindBy (xpath = "(//a[@data-quantity='1'])[5]")
    public static WebElement besinciUrunSepeteEkle;
}
