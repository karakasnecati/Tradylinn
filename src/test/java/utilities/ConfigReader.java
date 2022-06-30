package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;

    static {
        String dosyaYolu="src/configuration.properties";
        try {
<<<<<<< HEAD
            FileInputStream fis=new FileInputStream(dosyaYolu);
            properties=new Properties();
=======
            FileInputStream fis=new FileInputStream(dosyaYolu);       properties=new Properties();
>>>>>>> master
            properties.load(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD

=======
>>>>>>> master
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
