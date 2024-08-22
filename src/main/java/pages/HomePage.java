package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    private By signOutBtn = By.cssSelector(".logout");
    private By contactUsBtn = By.cssSelector("div#contact-link");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getSignOutBtn(){
        return driver.findElement(signOutBtn);
    }

    public WebElement getContactUsBtn(){
        return driver.findElement(contactUsBtn);
    }
}
