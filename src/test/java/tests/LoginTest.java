package tests;

import config.EndpointsMap;
import data.CommonData;
import data.LoginData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.UrlHelper;

import java.io.FileNotFoundException;

public class LoginTest extends BaseTest{
    private LoginPage loginPage;
    private HomePage homePage;
    private ConfigReader configReader;

    @BeforeMethod
    public void openLoginPage() throws FileNotFoundException {
        setUp();
        UrlHelper urlHelper = new UrlHelper();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        configReader = new ConfigReader();

        driver.get(urlHelper.getBaseUrl() + EndpointsMap.LOGIN);
    }

    @Test
    public void successfulLogin() {
        loginPage.login(configReader.getValidEmail(), configReader.getValidPassword());

        Assert.assertEquals(getText(homePage.getSignOutBtn()), CommonData.SIGN_OUT_BTN_TEXT);
    }

    @Test
    public void unsuccessfulLogin() {
        loginPage.login(LoginData.INVALID_EMAIL, LoginData.INVALID_PASSWORD);

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(getText(loginPage.getErrorMessage()), CommonData.ERROR_LOGIN_MESSAGE);
    }
}
