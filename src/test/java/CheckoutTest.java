import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


@Listeners(ExtentTestNGITestListener.class)


public class CheckoutTest extends Hooks {

    public CheckoutPage checkoutPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Simple checkout test using 'Awesome' product")
    public void checkoutTest() throws InterruptedException {


    }

    @Test
    public void searchTest() {
        checkoutPage.setSearchBar();
        checkoutPage.clickSearchButton();

        assertEquals("Refined Frozen Mouse", checkoutPage.getFrozenMouse().getText());


        assertEquals("Practical Metal Mouse", checkoutPage.getPracticalMouse().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The system ");
    }

    @Test
    public void sortProductsTest() throws InterruptedException {
        checkoutPage.selectOption(checkoutPage.getSortProductsDropDown(), "Sort by price (low to high)");
        Thread.sleep(4000);
    }

    @Test(description = "Calculationg the price when changing quantity")
    public void quantityOfProductTest() {
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product is" + checkoutPage.productPrice());
        checkoutPage.productPrice();
        double expectedTotal = checkoutPage.productPrice() * 2;
        checkoutPage.clickPlusQuantity();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product after increasing quantity is" + checkoutPage.productPrice());
        assertEquals(checkoutPage.productPrice(), expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price is matched");

    }

    @Test(description = "Calculating the total price with taxes")
    public void totalPriceWithTaxesTest() {
        checkoutPage.clickAddProductGraniteChipsToCartButton();
        checkoutPage.clickCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product is: " + checkoutPage.productPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The tax price is: " + checkoutPage.taxPrice());
        double expectedTotal = checkoutPage.productPrice() + checkoutPage.taxPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The total price should be " + expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The total price is " + checkoutPage.totalPrice());
        assertEquals(checkoutPage.totalPrice(), expectedTotal);
    }

}

