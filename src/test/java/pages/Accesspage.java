package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Accesspage {
    public Accesspage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    Faker faker=new Faker();
    public String isim= String.valueOf(faker.name());
    public String soyIsim=faker.name().lastName();

    @FindBy(xpath = "//*[@id=\"header\"]/div/div[1]/div/div[2]/div/div[3]/div/div/a[1]/span")
    public WebElement girisyap;
    @FindBy(xpath = "(//input[@id=\"username\"])[1]")
    public WebElement email;
    @FindBy(xpath = "(//input[@id=\"password\"])[1]")
    public WebElement password;
    @FindBy(xpath = "(//button[@value=\"Giriş Yap\"])[1]")
    public WebElement login;
    @FindBy(xpath = "//*[@id=\"menu-item-1074\"]/a")
    public WebElement hesabim;
    @FindBy(xpath = "//nav[@class=\"woocommerce-MyAccount-navigation col-md-3 mb-8\"]/ul/li/a")
    public List<WebElement> pano;
    @FindBy(xpath = "//tr[@class='woocommerce-orders-table_row woocommerce-orders-table_row--status-on-hold order']")
    public List<WebElement> siparislerTble;

    @FindBy(xpath = "//h4[@class='icon-box-title text-normal']")
    public WebElement siparislerYazisi;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/div[3]/p")
    public WebElement indirmeler;
    @FindBy(xpath = "//*[text()='Adresler']")
    public WebElement adres;
    @FindBy(xpath = "//table[@class=\"address-table\"]//tbody[1]//tr")
    public List<WebElement> faturaAdresleri;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/div[3]/div[2]/div/address/table/tbody/tr")
    public List<WebElement> gonderimAdresi;
    @FindBy(xpath = "//*[text()='Hesap detayları']")
    public WebElement hesapDetaylari;
    @FindBy(xpath = "//label[@for='account_first_name']")
    public WebElement ad;
    @FindBy(xpath = "//label[@for='account_last_name']")
    public WebElement soyad;
    @FindBy(xpath = "//label[@for='account_display_name']")
    public WebElement gorunenAd;
    @FindBy(xpath = "//label[@for='account_email']")
    public WebElement mail;
    @FindBy(xpath = "//label[@for='user_description']")
    public WebElement biography;
    @FindBy(xpath = "//button[@value=\"Değişiklikleri kaydet\"]")
    public WebElement degisiklikUpdate;


    public String  select(String str){
        List<WebElement> element=Driver.getDriver().findElements(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/div/section/div/div[1]/div/div/div/h2/a"));
        String str1="";
        for(int i=0;i<element.size();i++){
            if(element.get(i).
                    getText().equalsIgnoreCase(str)){
                str1=element.get(i).getText();
                Driver.getDriver().findElements(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/div/section/div/div[2]/div/div/div/h2/a")).get(i).click();
            }
        }
        return str1;
    }

    public WebElement choiceElement(List<WebElement> myStoreMenu,String str){
        WebElement element=null;
        for (WebElement w:myStoreMenu) {
            if(w.getText().equalsIgnoreCase(str)){
                element=w;
            }
        }
        return element;
    }

}
