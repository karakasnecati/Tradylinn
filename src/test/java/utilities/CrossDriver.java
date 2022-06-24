package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossDriver {
    private CrossDriver(){

    }

    static WebDriver driver; // getDriver static oldugu icin bunun da static olmasi lazim

    public static WebDriver getDriver(String browser){ // Webdriver yerine void olsa driver'i bize getiremez cunku return yok
        browser = browser == null ? ConfigReader.getProperty("browser") : browser;
        if (driver==null){ // driver'a deger atanmamissa if'in icine girecek
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "opera":
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup(); // chrome uzerinden calisir ama ekrana acilan chrome'u getirmez. arka plan
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();

            }


               }


        return driver;
    }

    public static void closeDriver(){
        if (driver!=null) { // driver'a deger atanmissa
            driver.close();
            driver=null;
        }


    }
}
