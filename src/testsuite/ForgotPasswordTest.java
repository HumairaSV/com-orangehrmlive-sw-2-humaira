package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ForgotPasswordTest extends Utility {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void serShouldNavigateToForgotPasswordPageSuccessfully() {
        //click on the forgot password link
        clickOnElement(By.xpath("//p[text() = 'Forgot your password? ']"));
        //declaring the variable for expected error  from requirements
        String expectedText = "Reset Password";
        //getting the actual text from the element
        String actualText = getTextFromElement(By.xpath("//h6[contains(@class, 'oxd-text oxd-text--h6 orangehrm-forgot-password-title')]"));
        //verifying that the forgot password link navigates to reset password page
        Assert.assertEquals("Did not navigate to the Reset password page", expectedText, actualText);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
