package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;
     // bunun static olmasi  static blok icerisinde
    // Properties properties'e atama yapacagimiz icin
    // once ona ulasmaliyiz

    static { // static blok her seyden once calisir
        String dosyaYolu="configuration.properties";

        try {
            FileInputStream fis=new FileInputStream(dosyaYolu); // fis dosyayolu tanimladigimiz configuration.properties dosyasini okudu
                                                               // eger bulamazsam deyip throws atmamizi isterse kullandigimiz
            properties=new Properties();
            properties.load(fis);// fis'in okudugu bilgileri properties'e yukledi

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // her class da bunu import etmemiz gerekir o yuzden try catch yapmak daha kullanisli

    }

    public static String getProperty(String key){ // obje olusturmaya gerek kalmadan kullanmak icin static
      /*
         test method'undan yollagimiz string key degerini alip
         properties classindan getProperty() methodunu kullanarak
         bu key'e ait value'u bize getirdi.
     */

        return properties.getProperty(key);
    }

}
