package tests;

import config.EndpointsMap;
import data.CommonData;
import data.LoginData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.UrlHelper;

import java.io.FileNotFoundException;

public class LoginTest extends BaseTest{
    private UrlHelper urlHelper;
    private LoginPage loginPage;
    private HomePage homePage;
    private ConfigReader configReader;

    @Test
    public void successfulLogin() throws FileNotFoundException {
        urlHelper = new UrlHelper();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        configReader = new ConfigReader();

        driver.get(urlHelper.getBaseUrl() + EndpointsMap.LOGIN);

        loginPage.login(configReader.getValidEmail(), configReader.getValidPassword());

        Assert.assertEquals(getText(homePage.getSignOutBtn()), CommonData.SIGN_OUT_BTN_TEXT);
    }

    @Test
    public void unsuccessfulLogin() throws FileNotFoundException {
        urlHelper = new UrlHelper();
        loginPage = new LoginPage(driver);

        driver.get(urlHelper.getBaseUrl() + EndpointsMap.LOGIN);

        loginPage.login(LoginData.INVALID_EMAIL, LoginData.INVALID_PASSWORD);

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(getText(loginPage.getErrorMessage()), CommonData.ERROR_LOGIN_MESSAGE);
    }
}
