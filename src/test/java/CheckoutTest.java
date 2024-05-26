import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.swing.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


@Listeners(ExtentTestNGITestListener.class)


public class CheckoutTest extends Hooks {

    public CheckoutPage checkoutPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, 50);
    }


    @Test(description = "Search products-guest mode")
    public void searchTest() {
        checkoutPage.setSearchBar();
        checkoutPage.clickSearchButton();
        assertEquals("Refined Frozen Mouse", checkoutPage.getFrozenMouse().getText());
        assertEquals("Practical Metal Mouse", checkoutPage.getPracticalMouse().getText());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Search function works as expected for mouse product");
    }

    @Test(description = "Verify Homepage button")
    public void homePageButtonTest() {
        checkoutPage.clickCartButton();
        checkoutPage.clickShoppingBagIcon();
        assertEquals(checkoutPage.getPageNote().getText(),"Products");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The shoppin bag homepage Icon woks as expected ");
    }



    @Test(description = "Add Product to Wish List from HomePage=Guest")
    public void addProductFromHomePagetoWishListTest() {
        checkoutPage.clickSoftPizza();
        checkoutPage.clickAddSoftPizzaToWishList();
        checkoutPage.clickWishList();
        assertEquals(checkoutPage.getSoftPizza().getText(),"Gorgeous Soft Pizza" );
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The product has been added to the Wishlist");
    }

    @Test(description = "Add Product to Cart from Wishlist-Guest")
    public void addProductFromWishListTest() {
        checkoutPage.clickSoftPizza();
        checkoutPage.clickAddSoftPizzaToWishList();
        checkoutPage.clickWishList();
        checkoutPage.clickAddToCartButtonFromWishlist();
        checkoutPage.clickCartButton();
        assertEquals(checkoutPage.getSoftPizza().getText(), "Gorgeous Soft Pizza");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The product has been added to the Cart from Wishlist page");

    }

    @Test(description = "Simple checkout test using 'Awesome' product-Guest")
    public void checkoutTest() throws InterruptedException {
        checkoutPage.clickAddProductGraniteChipsToCartLink();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterFirstNameField();
        checkoutPage.enterLastNameField();
        checkoutPage.enterAddressField();
        checkoutPage.clickContinueCheckout();
        checkoutPage.clickCompleteOrder();
        assertEquals(checkoutPage.getPageNote().getText(),"Order complete");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The order with one product has been complete");
    }


    @Test(description = "Simple Checkout test with multiple products-Guest")
    public void checkoutMultipleTest() {
        checkoutPage.clickAddLicensedSteelGlovesToCartLink();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickHomePageLogo();
        checkoutPage.clickPracticalWoodenBaconLink();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterFirstNameField();
        checkoutPage.enterLastNameField();
        checkoutPage.enterAddressField();
        checkoutPage.clickContinueCheckout();
        checkoutPage.clickCompleteOrder();
        assertEquals(checkoutPage.getPageNote().getText(), "Order complete");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The order with multiple products has been complete");
    }

    @Test(description = "Negative Checkout test-missing First name-Guest")
    public void negativeCheckoutTest1() {
        checkoutPage.clickAddLicensedSteelGlovesToCartLink();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterLastNameField();
        checkoutPage.enterAddressField();
        checkoutPage.clickContinueCheckout();
        assertEquals( checkoutPage.getMandatoryFieldError().getText(), "First Name is required");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Order cannot be completed without First name");
    }

    @Test(description = "Negative Checkout test-missing Last Name-Guest")
    public void negativeCheckoutTest2() {
        checkoutPage.clickAddLicensedSteelGlovesToCartLink();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterFirstNameField();
        checkoutPage.enterAddressField();
        checkoutPage.clickContinueCheckout();
        assertEquals(checkoutPage.getMandatoryFieldError().getText(), "Last Name is required" );
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Order cannot be completed without Last name");
    }

    @Test(description = "Negative Checkout test-missing Address-Guest")
    public void negativeCheckoutTest3() {
        checkoutPage.clickAddLicensedSteelGlovesToCartLink();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterFirstNameField();
        checkoutPage.enterLastNameField();
        checkoutPage.clickContinueCheckout();
        assertEquals(checkoutPage.getMandatoryFieldError().getText(), "Address is required");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Order cannot be completed without Address");
    }

    @Test(description = "Simple checkout test increasing quantity-Guest")
    public void checkoutIncreaseQuantityTest() throws InterruptedException {
        checkoutPage.clickAddProductGraniteChipsToCartLink();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.clickIncreaseQuantityButton();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterFirstNameField();
        checkoutPage.enterLastNameField();
        checkoutPage.enterAddressField();
        checkoutPage.clickContinueCheckout();
        checkoutPage.clickCompleteOrder();
        assertEquals(checkoutPage.getPageNote().getText(), "Order complete");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Increasing quantity function works as expected. Order Complete");
    }

    @Test(description = "Simple checkout test decreasing quantity-Guest")
    public void checkoutDecreaseQuantityTest() throws InterruptedException {
        checkoutPage.clickAddProductGraniteChipsToCartLink();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.clickIncreaseQuantityButton();
        checkoutPage.clickDecreaseQuantityButton();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterFirstNameField();
        checkoutPage.enterLastNameField();
        checkoutPage.enterAddressField();
        checkoutPage.clickContinueCheckout();
        checkoutPage.clickCompleteOrder();
        assertEquals(checkoutPage.getPageNote().getText(), "Order complete");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Decreasing quantity function works as expected. Order Complete");
    }

    @Test(description = "Delete Cart with one product from basket icon-Guest")
    public void DeleteCartFromBasketIconTest() throws InterruptedException {
        checkoutPage.clickAddProductGraniteChipsToCartLink();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.clickBasketIcon();
        assertEquals(checkoutPage.getCartNote().getText(), "How about adding some products in your cart?");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Deleting Cart function from basket icon works as expected-no product in the cart");
    }

    @Test(description = "Delete Cart with one product from minus icon-Guest")
    public void DeleteCartFromMinusIconTest() throws InterruptedException {
        checkoutPage.clickIncredibleConcreteHat();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.clickDecreaseQuantityButton();
        assertEquals(checkoutPage.getCartNote().getText(), "How about adding some products in your cart?");
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Deleting Cart function from minus icon works as expected-no product in the cart");
    }

    @Test(description = "Sort by price low to high-Guest")

    public void sortProductsByPriceLowTest() throws InterruptedException {
        checkoutPage.selectOption(checkoutPage.getSortProductsDropDown(), "Sort by price (low to high)");
        Thread.sleep(4000);

    }

    @Test(description = "Sort by price high to low-Guest")
    public void sortProductsByPriceHighTest() throws InterruptedException {
        checkoutPage.selectOption(checkoutPage.getSortProductsDropDown(), "Sort by price (high to low)");
        Thread.sleep(4000);

    }

    @Test(description = "Sort by name A to Z-Guest")
    public void sortProductsByNameATOZTest() throws InterruptedException {
        checkoutPage.selectOption(checkoutPage.getSortProductsDropDown(), "Sort by name (A to Z)");
        Thread.sleep(4000);
    }

    @Test(description = "Sort by name Z to A-Guest")
    public void sortProductsByNameZTOATest() throws InterruptedException {
        checkoutPage.selectOption(checkoutPage.getSortProductsDropDown(), "Sort by name (Z to A)");
        Thread.sleep(4000);
    }


    @Test(description = "Changing quantity test. Asserting that the price is updated correctly-Guest")
    public void updatePriceTest() {
        checkoutPage.clickAddProductGraniteChipsToCartLink();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product is: " + checkoutPage.productPrice());
        double expectedTotal = checkoutPage.productPrice() * 2;
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product after updating should be: " + expectedTotal);
        checkoutPage.clickPlusQuantity();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product after update is: " + checkoutPage.productPrice());
        assertEquals(checkoutPage.productPrice(), expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product is matching the expected price");

    }

    @Test(description = "Calculating the total price of a product  with taxes-Guest")
    public void totalPriceWithTaxesTest() {
        checkoutPage.clickAddProductGraniteChipsToCartLink();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product is: " + checkoutPage.productPrice());
        double expectedTotal = checkoutPage.productPrice() + checkoutPage.taxPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The  expected total price should be " + expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The  actual total price should be " +checkoutPage.totalPrice());
        assertEquals(checkoutPage.totalPrice(), expectedTotal);

    }

    @Test(description = "Calculating the total price of two products -Guest")
    public void totalPriceForTwoProducts() {
        checkoutPage.clickAddProductGraniteChipsToCartLink();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.clickContinueShoppingButton();
        checkoutPage.clickSoftPizza();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product is: " + checkoutPage.priceforAwesomeProduct());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product is: " + checkoutPage.priceforGorgeousProduct());
        double expectedTotal = checkoutPage.priceforAwesomeProduct()+checkoutPage.priceforGorgeousProduct();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The  actual total price should be " +checkoutPage.totalPrice());
        assertEquals(checkoutPage.totalPrice(), expectedTotal);

    }

    @Test(description = "Verify Cart after adding a product-normal user")
    public void verifyCartTest1() throws InterruptedException {

        checkoutPage.clickLoginIcon();
        checkoutPage.setNormalUsername();
        checkoutPage.setPassword();
        checkoutPage.clickLoginButton();
        checkoutPage.clickAddToCartButtonFromWishlist();
        checkoutPage.clickCartButton();
        assertEquals(checkoutPage.getAddProductGraniteChipsToCartLink().getText(),"Awesome Granite Chips");
        ExtentTestNGITestListener.getTest().pass("Successfull add to the cart");

    }

    @Test(description = "Verify Cart after adding a product-user with bugs")
    public void verifyCartTest2() throws InterruptedException {
        checkoutPage.clickLoginIcon();
        checkoutPage.setUsernameWithBugs();
        checkoutPage.setPassword();
        checkoutPage.clickLoginButton();
        checkoutPage.clickAddToCartButtonFromWishlist();
        checkoutPage.clickCartButton();
        assertEquals(checkoutPage.getCartNote().getText(), "Awesome Granite Chips");
        ExtentTestNGITestListener.getTest().fail("Unsuccessfull add to the cart");

    }

    @Test(description = "Verify Cart after signing out-slow user")
    public void verifyCartTest3() throws InterruptedException {
        //ExtentTestNGITestListener.e = extentReports.createTest("Testing the login functionality", "Test logging functionality using test data provided");
        checkoutPage.clickLoginIcon();
        checkoutPage.setSlowUser();
        checkoutPage.setPassword();
        checkoutPage.clickLoginButton();
        checkoutPage.clickAddProductGraniteChipsToCartLink();
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickCartButton();
        checkoutPage.clickSignOutButton();
        assertEquals(checkoutPage.getCartIconBadge().getText(),"0");
        ExtentTestNGITestListener.getTest().pass("Unsuccessfull clearing of the cart after signing out");

    }
}