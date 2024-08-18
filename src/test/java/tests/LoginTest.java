package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void testPageTitle(){
        String actualTitle = driver.getTitle();
        System.out.println("Title: " + actualTitle);
    }
}
