package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;
import utils.WebDriverFactory;

import java.io.FileNotFoundException;

public class BaseTest {
    protected WebDriver driver;
    private ConfigReader configReader;

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        configReader = new ConfigReader();
        String browser = configReader.getBrowser();
        driver = WebDriverFactory.createWebDriver(browser);
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
