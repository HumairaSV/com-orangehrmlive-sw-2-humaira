package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import javax.rmi.CORBA.Util;

public class LoginTest extends Utility {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //sending data to the username field
        sendTextToElement(By.xpath("//input[@placeholder= 'Username']"), "Admin");
        //sending data to the password field
        sendTextToElement(By.xpath("//input[@placeholder= 'Password']"), "admin123");
        //click on the Login button
        clickOnElement(By.xpath("//button[contains(@class, 'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button')]"));
        //declaring the variable for expected error  from requirements
        String expectedText = "Dashboard";
        //getting the actual text from the element
        String actualText = getTextFromElement(By.xpath("//span/h6[contains(@class, 'oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module')]"));
        //verifying that the Login was successful and user is taken to the dashboard
        Assert.assertEquals("Login unsuccessful, user not navigated to Dashboard", expectedText, actualText);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
