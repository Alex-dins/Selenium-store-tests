package tests;

import config.EndpointsMap;
import data.CommonData;
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
        String firstName = FakeUser.getFirstName();
        String lastName = FakeUser.getLastName();
        String birthDate = FakeUser.getBirthDate();
        homePage.getAccountBtn().click();
        accountPage.getInformationBtn().click();

        accountPage.fillAccountInfo(firstName, lastName, birthDate);
        accountPage.getPasswordField().sendKeys(configReader.getValidPassword());
        accountPage.getAgreementCheckbox().click();
        accountPage.getSaveBtn().click();

        Assert.assertEquals(getText(accountPage.getSuccessMessage()), CommonData.ACCOUNT_UPDATE_SUCCESS_MESSAGE);
    }
}
