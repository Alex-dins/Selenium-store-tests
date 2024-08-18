package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigReader {
    private final Properties properties;

    public ConfigReader() throws FileNotFoundException {
        final Logger LOGGER = Logger.getLogger(ConfigReader.class.getName());
        properties = new Properties();
       try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")){
        properties.load(input);
       } catch (IOException e){
           LOGGER.log(Level.SEVERE, "Failed to load configuration file.", e);
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
