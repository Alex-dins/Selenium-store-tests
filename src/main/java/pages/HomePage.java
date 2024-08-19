package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    private By signOutBtn = By.cssSelector(".logout");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getSignOutBtn(){
        return driver.findElement(signOutBtn);
    }
}
