package tests;

import config.EndpointsMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.UrlHelper;

import java.io.FileNotFoundException;

public class LoginTest extends BaseTest{
    private UrlHelper urlHelper;
    private LoginPage loginPage;
    private HomePage homePage;
    private AccountPage accountPage;

    @Test
    public void successfulLogin() throws FileNotFoundException {
        urlHelper = new UrlHelper();
        driver.get(urlHelper.getBaseUrl() + EndpointsMap.LOGIN);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.login("testr@mail.com", "Test1234!");
        Assert.assertEquals(homePage.getSignOutBtn().getText(), "Sign out");
    }

    @Test
    public void unsuccessfulLogin() throws FileNotFoundException {
        urlHelper = new UrlHelper();
        driver.get(urlHelper.getBaseUrl() + EndpointsMap.LOGIN);

        loginPage = new LoginPage(driver);
        loginPage.login("test1@test.com", "test123");

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Authentication failed.");
    }
}
