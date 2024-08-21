package utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigReader {
    private final Properties properties;
    private final Dotenv dotenv;

    public ConfigReader() throws FileNotFoundException {
        final Logger LOGGER = Logger.getLogger(ConfigReader.class.getName());
        properties = new Properties();
       try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")){
        properties.load(input);
       } catch (IOException e){
           LOGGER.log(Level.SEVERE, "Failed to load configuration file.", e);
//           throw new RuntimeException("Failed to load configuration file.");
       }
       dotenv = Dotenv.configure().load();
    }

    public String getBaseUrl(){
        return properties.getProperty("base.url");
    }

    public String getBrowser(){
        return properties.getProperty("browser");
    }

    public String getValidEmail(){
        return dotenv.get("VALID_USER_EMAIL");
    }

    public String getValidPassword(){
        return dotenv.get("VALID_USER_PASSWORD");
    }
}
