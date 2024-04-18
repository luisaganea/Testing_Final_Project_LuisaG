import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners (ExtentTestNGITestListener.class)

public class LoginTest extends Hooks {

    public LoginPage loginPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, 10);
    }




    @Test
    public void loginTest() throws InterruptedException {
        //extentTest = extentReports.createTest("Testing the login functionality", "Testing loging functionality using test data provided");
        loginPage.clickLoginIcon();
        loginPage.setUsername();
        loginPage.setPassword();
        loginPage.clickLoginButton();
        assertEquals("dino",loginPage.getCorrectName().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "informatii");
        ExtentTestNGITestListener.getTest().pass("The user was able to login succesfully");

    }

    //@Test
  //  public void negativeloginTest() throws InterruptedException {
     //   ExtentTestNGITestListener = extentReports.createTest("Testing the login functionality without user name");
      //  loginPage.clickLoginIcon();
//setUsername();
    ///    loginPage.setPassword();
      //  loginPage.clickLoginButton();
     //   assertEquals(loginPage.getLoginError().getText(),"Please fill in the username");
      //  ExtentTestNGITestListener.pass("The user was not able to login succesfully");



    }


