package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
    private WebDriver driver;

    private By accountHeader = By.cssSelector(".page-header");
    private By informationBtn = By.id("identity-link");
    private By firstNameField = By.id("field-firstname");
    private By lastNameField = By.id("field-lastname");
    private By birthDateField = By.id("field-birthday");
    private By passwordField = By.id("field-password");
    private By agreementCheckbox = By.cssSelector("input[name='psgdpr']");
    private By saveBtn = By.cssSelector("[data-link-action]");
    private By successMessage = By.cssSelector(".alert-success ul li");

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getAccountHeader(){
        return driver.findElement(accountHeader);
    }

    public WebElement getInformationBtn(){
        return driver.findElement(informationBtn);
    }

    public void fillAccountInfo(String firstName, String lastName, String birthDate){
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(birthDateField).clear();
        driver.findElement(birthDateField).sendKeys(birthDate);
    }

    public WebElement getAgreementCheckbox(){
        return driver.findElement(agreementCheckbox);
    }

    public WebElement getPasswordField(){
        return driver.findElement(passwordField);
    }

    public WebElement getSaveBtn(){
        return driver.findElement(saveBtn);
    }

    public WebElement getSuccessMessage(){
        return driver.findElement(successMessage);
    }
}
