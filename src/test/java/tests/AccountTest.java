package tests;

import config.EndpointsMap;
import data.CommonData;
import data.LoginData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.UrlHelper;
import data.FakeUser;

import java.io.FileNotFoundException;

public class AccountTest extends BaseTest{
    private LoginPage loginPage;
    private HomePage homePage;
    private ConfigReader configReader;
    private AccountPage accountPage;
    String firstName;
    String lastName;
    String birthDate ;

    @BeforeMethod
    public void openAccountPage() throws FileNotFoundException {
        setUp();
        UrlHelper urlHelper = new UrlHelper();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        configReader = new ConfigReader();

        driver.get(urlHelper.getBaseUrl() + EndpointsMap.LOGIN);

        loginPage.login(configReader.getValidEmail(), configReader.getValidPassword());
    }

    @Test
    public void successfulUpdateAccountInfo(){
        firstName = FakeUser.getFirstName();
        lastName = FakeUser.getLastName();
        birthDate = FakeUser.getBirthDate();
        homePage.getAccountBtn().click();
        accountPage.getInformationBtn().click();

        accountPage.selectGender().click();
        accountPage.fillAccountInfo(firstName, lastName, birthDate);
        accountPage.getPasswordField().sendKeys(configReader.getValidPassword());
        accountPage.getAgreementCheckbox().click();
        accountPage.getSaveBtn().click();

        Assert.assertEquals(getText(accountPage.getSuccessMessage()), CommonData.ACCOUNT_UPDATE_SUCCESS_MESSAGE);
    }

    @Test
    public void unsuccessfulUpdateAccountInfoWithIncorrectPassword(){
        firstName = FakeUser.getFirstName();
        lastName = FakeUser.getLastName();
        birthDate = FakeUser.getBirthDate();
        homePage.getAccountBtn().click();
        accountPage.getInformationBtn().click();

        accountPage.fillAccountInfo(firstName, lastName, birthDate);
        accountPage.getPasswordField().sendKeys(LoginData.INVALID_PASSWORD);
        accountPage.getAgreementCheckbox().click();
        accountPage.getSaveBtn().click();

        Assert.assertEquals(getText(accountPage.getErrorMessage()), CommonData.ACCOUNT_UPDATE_ERROR_MESSAGE);
    }
}
