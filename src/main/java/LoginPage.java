import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

    //place for locators and methods

    @FindBy (css = ".svg-inline--fa.fa-sign-in-alt.fa-w-16")
    private WebElement loginIcon;

    public void clickLoginIcon(){
        loginIcon.click();
    }

    @FindBy (id ="user-name")
    private WebElement username;

    public void setNormalUsername () {
        username.sendKeys ("dino");
    }

    public void setUsernameWithBugs () {
        username.sendKeys ("beetle");
    }

    public void setWrongUsername () {
        username.sendKeys ("Dino");
    }

    public void setSlowUsername () {
        username.sendKeys ("turtle");
    }


    public void setLockedUsername () {
        username.sendKeys ("locked");
    }

    @FindBy (id ="password")
    private WebElement password;
    public void setPassword () {
        password.sendKeys ("choochoo");
    }

    public void setIncorrectPassword () {
        password.sendKeys ("chochoo");
    }

    @FindBy (css =".btn.btn-primary")
    private WebElement loginButton;

    public void clickLoginButton() {
        loginButton.click();
    }

    //sign-out button
    @FindBy (css =".svg-inline--fa.fa-sign-out-alt.fa-w-16")
    private WebElement signoutButton;

    public void clickSignOutButton() {
        signoutButton.click();
    }

    @FindBy(linkText = "dino")
    private WebElement correctName1;

    public WebElement getCorrectName1 () {
        return correctName1;
    }

    @FindBy(linkText = "beetle")
    private WebElement correctName2;

    public WebElement getCorrectName2 () {
        return correctName2;
    }

    @FindBy(linkText = "turtle")
    private WebElement correctName3;

    public WebElement getCorrectName3 () {
        return correctName3;
    }

    @FindBy(css = ".navbar-text")
    private WebElement guestUser;

    public WebElement getGuestUser () {
        return guestUser;
    }

    @FindBy(css = ".error")
    private WebElement loginError;

    public WebElement getLoginError () {
        return loginError;
    }



    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18")
    private WebElement cartButton;

    public void clickCartButton() {
        cartButton.click();
    }



    @FindBy (css = ".text-center.container")
    private WebElement cartNote;

    public WebElement getCartNote(){
        return cartNote;
    }
}
