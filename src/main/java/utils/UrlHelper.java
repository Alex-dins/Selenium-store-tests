package utils;

import java.io.FileNotFoundException;

public class UrlHelper {
    public ConfigReader configReader;

    public UrlHelper() throws FileNotFoundException {
        configReader = new ConfigReader();
    }

    public String getBaseUrl(){
        return configReader.getBaseUrl();
    }
}
