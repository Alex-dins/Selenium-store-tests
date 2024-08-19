package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
    private WebDriver driver;

    private By accountHeader = By.cssSelector(".page-header");

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getAccountHeader(){
        return driver.findElement(accountHeader);
    }
}
