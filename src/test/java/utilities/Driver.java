package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    // is yerinde kullanibilecek bir driver classi oldu.


    //frameWork

    /*
    POM'de Driver icin TestBase classina extends etmek
    yerine Driver classindan static methodlar kullanarak
    Driver olusturup ilgili ayarlarin yapilmasi ve en sonra
    Driverin kapatilmasi tercih edilmistir.

    POM'de Driver classindaki getDriver()'nin obje olusturularak kullanilmasini engellemek icin
    Singleton pattern kullanimi benimsenmistir

    Singleton Pattern : tekli kullanim bir classin farkli classlardan
    obje olusturularak kullanimini engellemek icin kullanilir.

    Bunu saglamak icin yapmamiz gereken sey oldukca basit
    obje olusturmak icin kullanilan cons.'i private yaptigimizde
    baska classlardan Driver classindan obje olusturulmasi mumkun degildir

     */
    private Driver(){

    }

    static WebDriver driver; // getDriver static oldugu icin bunun da static olmasi lazim

    public static WebDriver getDriver(){ // Webdriver yerine void olsa driver'i bize getiremez cunku return yok

        if (driver==null){ // driver'a deger atanmamissa if'in icine girecek
           switch (ConfigReader.getProperty("browser")){
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


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
