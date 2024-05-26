import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.testng.Assert.*;

@Listeners (ExtentTestNGITestListener.class)

public class LoginTest extends Hooks {

    public LoginPage loginPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Successfull login test-normal user")
    public void loginTest1() throws InterruptedException {
        //ExtentTestNGITestListener.e = extentReports.createTest("Testing the login functionality", "Test logging functionality using test data provided");
        loginPage.clickLoginIcon();
        loginPage.setNormalUsername();
        loginPage.setPassword();
        loginPage.clickLoginButton();
        assertEquals(loginPage.getCorrectName1().getText(),"dino");
        //ExtentTestNGITestListener.getTest().log(Status.INFO, "details");
        ExtentTestNGITestListener.getTest().pass("The user was able to login successfully");

    }

    @Test(description = "Successfull login test-user with bugs")
    public void loginTest2() throws InterruptedException {
        //ExtentTestNGITestListener.e = extentReports.createTest("Testing the login functionality", "Test logging functionality using test data provided");
        loginPage.clickLoginIcon();
        loginPage.setUsernameWithBugs();
        loginPage.setPassword();
        loginPage.clickLoginButton();
        assertEquals(loginPage.getCorrectName2().getText(), "beetle");
        //ExtentTestNGITestListener.getTest().log(Status.INFO, "details");
        ExtentTestNGITestListener.getTest().pass("The user was able to login successfully");

    }

    @Test(description = "Successfull login test-slow user")
    public void loginTest3() throws InterruptedException {
        //ExtentTestNGITestListener.e = extentReports.createTest("Testing the login functionality", "Test logging functionality using test data provided");
        loginPage.clickLoginIcon();
        loginPage.setSlowUsername();
        loginPage.setPassword();
        loginPage.clickLoginButton();
        assertEquals(loginPage.getCorrectName3().getText(), "turtle" );
        ExtentTestNGITestListener.getTest().pass("The user was able to login successfully");

    }

    @Test(description = "Unsuccessfull login test- without username")
    public void negativeLoginTest1() throws InterruptedException {

        loginPage.clickLoginIcon();
        loginPage.setPassword();
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginError().getText(), "Please fill in the username!");
        ExtentTestNGITestListener.getTest().pass("The user was not able to login succesfully");
    }

    @Test(description = "Unsuccessfull login test- without password")
    public void negativeLoginTest2() throws InterruptedException {

        loginPage.clickLoginIcon();
        loginPage.setNormalUsername();
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginError().getText(), "Please fill in the password!");
        ExtentTestNGITestListener.getTest().pass("The user was not able to login succesfully");
    }

    @Test(description = "Unsuccessfull login test- wrong User name")
    public void negativeLoginTest3() throws InterruptedException {

        loginPage.clickLoginIcon();
        loginPage.setWrongUsername();
        loginPage.setPassword();
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginError().getText(), "Incorrect username or password!");
        ExtentTestNGITestListener.getTest().pass("The user was not able to login succesfully");
    }

    @Test(description = "Unsuccessfull login test- wrong password")
    public void negativeLoginTest4() throws InterruptedException {

        loginPage.clickLoginIcon();
        loginPage.setNormalUsername();
        loginPage.setIncorrectPassword();
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginError().getText(), "Incorrect username or password!");
        ExtentTestNGITestListener.getTest().pass("The user was not able to login succesfully");
    }

    @Test(description = "Unsuccessfull login test- locked user")
    public void negativeLoginTest5() throws InterruptedException {

        loginPage.clickLoginIcon();
        loginPage.setLockedUsername();
        loginPage.setPassword();
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLoginError().getText(), "The user has been locked out.");
        ExtentTestNGITestListener.getTest().pass("The user was not able to login succesfully");
    }

    @Test(description = "Verifying signing out- slow user")
    public void signingoutTest() throws InterruptedException {

        loginPage.clickLoginIcon();
        loginPage.setSlowUsername();
        loginPage.setPassword();
        loginPage.clickLoginButton();
        assertEquals(loginPage.getCorrectName3().getText(),"turtle");
        loginPage.clickSignOutButton();
        assertEquals(loginPage.getGuestUser().getText(), "Hello guest!");
        ExtentTestNGITestListener.getTest().pass("The user has signed out succesfully");
    }

}