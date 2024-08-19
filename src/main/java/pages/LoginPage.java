package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    private By emailField = By.id("field-email");
    private By passwordField = By.id("field-password");
    private By signInBtn = By.id("submit-login");
    private By createAccountBtn = By.linkText("No account? Create one here");
    private By forgotPasswordBtn = By.linkText("Forgot your password?");
    private By errorMessage = By.cssSelector("#content ul li");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getEmailField(){
        return driver.findElement(emailField);
    }

    public WebElement getPasswordField(){
        return driver.findElement(passwordField);
    }

    public WebElement getSignInBtn(){
        return driver.findElement(signInBtn);
    }

    public WebElement getCreateAccountBtn(){
        return driver.findElement(createAccountBtn);
    }

    public WebElement getForgotPasswordBtn(){
      return driver.findElement(forgotPasswordBtn);
    }

    public WebElement getErrorMessage(){
       return driver.findElement(errorMessage);
    }

    public void login(String email, String password){
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getSignInBtn().click();
    }
}
