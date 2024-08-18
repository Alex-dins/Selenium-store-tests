package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;

    public ConfigReader() throws FileNotFoundException {
        properties = new Properties();
       try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")){
        properties.load(input);
       } catch (IOException e){
        e.printStackTrace();
           throw new RuntimeException("Failed to load configuration file.");
       }
    }

    public String getBaseUrl(){
        return properties.getProperty("base.url");
    }

    public String getBrowser(){
        return properties.getProperty("browser");
    }
}
