package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {
    private WebDriver driver;

    private By subjectDropdown = By.id("id_contact");
    private By emailField = By.id("email");
    private By messageField = By.id("contactform-message");
    private By submitBtn = By.cssSelector("input[name='submitMessage']");
    private By errorMessage = By.cssSelector(".alert-danger ul li");
    private By successMessage = By.cssSelector(".alert-success ul li");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSubjectDropdown(){
        return driver.findElement(subjectDropdown);
    }

    public WebElement getEmailField(){
        return driver.findElement(emailField);
    }

    public WebElement getMessageField(){
        return driver.findElement(messageField);
    }

    public WebElement getSubmitBtn(){
        return driver.findElement(submitBtn);
    }

    public WebElement getErrorMessage(){
        return driver.findElement(errorMessage);
    }

    public WebElement getSuccessMessage(){
        return driver.findElement(successMessage);
    }

    public void selectSubject(String subject){
        Select subjectDropdown = new Select(getSubjectDropdown());
        subjectDropdown.selectByVisibleText(subject);
    }

    public void fillContactUsForm(String subject, String email, String message){
        selectSubject(subject);
        getEmailField().sendKeys(email);
        getMessageField().sendKeys(message);
        getSubmitBtn().click();
    }
}
