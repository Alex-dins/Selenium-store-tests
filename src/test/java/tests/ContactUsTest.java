package tests;

import data.ContactUsData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import utils.UrlHelper;

import java.io.FileNotFoundException;

public class ContactUsTest extends BaseTest{
    private UrlHelper urlHelper;
    private HomePage homePage;
    private ContactUsPage contactUsPage;

    @Test
    public void successfulSendForm() throws FileNotFoundException {
        urlHelper = new UrlHelper();
        homePage = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);

        driver.get(urlHelper.getBaseUrl());

        homePage.getContactUsBtn().click();
        contactUsPage.fillContactUsForm(ContactUsData.CUSTOMER_SERVICE, ContactUsData.EMAIL, ContactUsData.MESSAGE);

        Assert.assertEquals(getText(contactUsPage.getSuccessMessage()), ContactUsData.SUCCESS_MESSAGE);
    }

    @Test
    public void sendFormWithoutEmail() throws FileNotFoundException {
        urlHelper = new UrlHelper();
        homePage = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);

        driver.get(urlHelper.getBaseUrl());

        homePage.getContactUsBtn().click();
        contactUsPage.getMessageField().sendKeys(ContactUsData.MESSAGE);
        contactUsPage.getSubmitBtn().click();

        Assert.assertEquals(getText(contactUsPage.getErrorMessage()), ContactUsData.EMPTY_EMAIL_ERROR_MESSAGE);
    }

    @Test
    public void sendFormWithoutMessage() throws FileNotFoundException {
        urlHelper = new UrlHelper();
        homePage = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);

        driver.get(urlHelper.getBaseUrl());

        homePage.getContactUsBtn().click();
        contactUsPage.getEmailField().sendKeys(ContactUsData.EMAIL);
        contactUsPage.getSubmitBtn().click();

        Assert.assertEquals(getText(contactUsPage.getErrorMessage()), ContactUsData.EMPTY_MESSAGE_ERROR_MESSAGE);
    }
}
