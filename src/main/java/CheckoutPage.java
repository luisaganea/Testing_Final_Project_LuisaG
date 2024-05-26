import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage extends BasePage {

    public WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 100);
    }

    //place for locators and methods

    // search for mouse product
    @FindBy(id = "input-search")
    private WebElement searchBar;

    public void setSearchBar() {
        searchBar.sendKeys("mouse");
    }

    //click search button
    @FindBy(css = ".btn.btn-light.btn-sm")
    private WebElement searchButton;

    public void clickSearchButton() {
        searchButton.click();
    }


    //Shopping Bag Home Page Icon

    @FindBy(css = ".svg-inline--fa.fa-shopping-bag.fa-w-14.fa-3x.brand-logo")
    private WebElement shoppingBagIcon;

    public void clickShoppingBagIcon() {
        shoppingBagIcon.click();
    }

    //getter Frozen Mouse Product
    @FindBy(linkText = "Refined Frozen Mouse")
    private WebElement frozenMouse;

    public WebElement getFrozenMouse() {
        return frozenMouse;
    }

    //getter  Practical Mouse Product
    @FindBy(linkText = "Practical Metal Mouse")
    private WebElement practicalMouse;

    public WebElement getPracticalMouse() {
        return practicalMouse;
    }


    //click  Soft Pizza Product

    @FindBy(linkText = "Gorgeous Soft Pizza")
    private WebElement softPizza;

    public void clickSoftPizza() {
        softPizza.click();
    }


    // getter Soft Pizza
    public WebElement getSoftPizza() {
        return softPizza;
    }


    //Add Soft Pizza to Wish List
    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16.fa-3x")
    private WebElement AddSoftPizzaToWishList;

    public void clickAddSoftPizzaToWishList() {
        AddSoftPizzaToWishList.click();
    }


    //click Wish List
    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16")
    private WebElement wishList;

    public void clickWishList() {
        wishList.click();
    }

    //Delete Wish List
    @FindBy(css = ".svg-inline--fa.fa-heart-broken.fa-w-16.fa-2x")
    private WebElement deleteWishList;

    public void clickDeleteWishList() {
        deleteWishList.click();
    }


    // click Awesome Granite Chips Product link
    @FindBy(linkText = "Awesome Granite Chips")
    private WebElement addProductGraniteChipsToCartLink;

    public void clickAddProductGraniteChipsToCartLink() {
        addProductGraniteChipsToCartLink.click();
    }


    //getter Awesome Granite Chips link
    public WebElement getAddProductGraniteChipsToCartLink() {
        return addProductGraniteChipsToCartLink;
    }


    //add to cart button
    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x")
    private WebElement addToCartButton;

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    //add to cart button from wish list page
    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-2x")
    private WebElement addToCartButtonFromWishlist;

    public void clickAddToCartButtonFromWishlist() {
        addToCartButtonFromWishlist.click();
    }

    //add to cart button from home page

    /*@FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-2x")
    private WebElement homePageCartButton;

    public void clickHomePageCartButton() {
        homePageCartButton.click();
    }*/

    //increase quantity
    @FindBy(css = ".svg-inline--fa.fa-plus-circle.fa-w-16")
    private WebElement increaseQuantityButton;

    public void clickIncreaseQuantityButton() {
        increaseQuantityButton.click();
    }

    //decrease quantity
    @FindBy(css = ".svg-inline--fa.fa-minus-circle.fa-w-16 ")
    private WebElement decreaseQuantityButton;

    public void clickDecreaseQuantityButton() {
        decreaseQuantityButton.click();
    }


    // click Checkout Button
    @FindBy(css = ".svg-inline--fa.fa-angle-right.fa-w-8")
    private WebElement CheckoutButton;

    public void clickCheckoutButton() {
        CheckoutButton.click();
    }

    // locator first name
    @FindBy(id = "first-name")
    private WebElement firstNameField;

    //getter first name
    public WebElement getFirstNameField() {

        return firstNameField;
    }

    // send keys first name
    public void enterFirstNameField() {
        firstNameField.sendKeys("A");

    }

    //mandatory field error
    @FindBy(css = ".error")
    private WebElement mandatoryFieldError;

    public WebElement getMandatoryFieldError() {
        return mandatoryFieldError;
    }

    //getter last name
    @FindBy(id = "last-name")
    private WebElement lastNameField;

    public WebElement getLastNameField() {

        return lastNameField;
    }

    //last name send keys
    public void enterLastNameField() {
        lastNameField.sendKeys("B");
    }

    //getter address
    @FindBy(id = "address")
    private WebElement addressField;

    public WebElement getAddressField() {

        return addressField;
    }

    //address send keys

    public void enterAddressField() {
        addressField.sendKeys("23 ABC ST");
    }

    //continue checkout
    @FindBy(css = ".svg-inline--fa.fa-angle-right.fa-w-8")
    private WebElement continueCheckout;

    public void clickContinueCheckout() {
        continueCheckout.click();
    }

    //complete order

    @FindBy(css = ".svg-inline--fa.fa-angle-right.fa-w-8")
    private WebElement completeOrder;

    public void clickCompleteOrder() {
        completeOrder.click();
    }

    // basket icon click

    @FindBy(css = ".svg-inline--fa.fa-trash.fa-w-14")
    private WebElement basketIcon;

    public void clickBasketIcon() {
        basketIcon.click();
    }


    @FindBy(css = ".text-center.container")
    private WebElement cartNote;

    public WebElement getCartNote() {
        return cartNote;
    }

    @FindBy(css = ".text-muted")
    private WebElement pageNote;

    public WebElement getPageNote() {
        return pageNote;
    }

    @FindBy(css = ".text-center container")
    private WebElement pageMessage;

    public WebElement getpageMessage() {
        return pageMessage;
    }

    //Number of products in the Cart Icon

    @FindBy(css = ".fa-layers-counter.shopping_cart_badge")
    private WebElement cartIconBadge;

    public WebElement getCartIconBadge() {
        return cartIconBadge;
    }


    @FindBy(linkText = "Licensed Steel Gloves")
    private WebElement addLicensedSteelGlovesToCartLink;

    public void clickAddLicensedSteelGlovesToCartLink() {
        addLicensedSteelGlovesToCartLink.click();
    }


    @FindBy(css = ".svg-inline--fa.fa-shopping-bag.fa-w-14.fa-3x.brand-logo")
    private WebElement HomePageLogo;

    public void clickHomePageLogo() {
        HomePageLogo.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-angle-left.fa-w-8")
    private WebElement continueShoppingButton;

    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }


    @FindBy(linkText = "Practical Wooden Bacon")
    private WebElement addPracticalWoodenBaconToCartLink;

    public void clickPracticalWoodenBaconLink() {
        addPracticalWoodenBaconToCartLink.click();
    }

    @FindBy(linkText = "Incredible Concrete Hat")
    private WebElement addIncredibleConcreteHatToCartLink;

    public void clickIncredibleConcreteHat() {
        addIncredibleConcreteHatToCartLink.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18")
    private WebElement cartButton;

    public void clickCartButton() {
        cartButton.click();
    }


    @FindBy(css = ".sort-products-select.form-control.form-control-sm")
    private WebElement sortProductsDropDown;


    public WebElement getSortProductsDropDown() {
        return sortProductsDropDown;
    }


    @FindBy(xpath = "(//td[@class='amount'])[1]")
    private WebElement itemPrice;


    public double productPrice() {
        String amountValue = itemPrice.getText();
        String cleanAmountValue = amountValue.replace("$", "");
        return Double.parseDouble(cleanAmountValue);

    }


    public void selectOption(WebElement element, String option) {
        Select optionSelect = new Select(element);
        optionSelect.selectByVisibleText(option);
    }

    @FindBy(css = ".svg-inline--fa.fa-plus-circle.fa-w-16")
    private WebElement plusQuantity;

    public void clickPlusQuantity() {
        plusQuantity.click();
    }

    @FindBy(xpath = "(//TD[@class='amount'])[2]")
    private WebElement taxAmount;

    public double taxPrice() {
        String taxValue = taxAmount.getText();
        String cleanTaxValue = taxValue.replace("$", "");
        return Double.parseDouble(cleanTaxValue);

    }

    @FindBy(xpath = "(//TD[@class='amount'])[3]")
    private WebElement totalAmount;

    public double totalPrice() {
        String totalValue = totalAmount.getText();
        String cleanTotalValue = totalValue.replace("$", "");
        return Double.parseDouble(cleanTotalValue);
    }


    //click login button
    @FindBy(css = ".svg-inline--fa.fa-sign-in-alt.fa-w-16")
    private WebElement loginIcon;

    public void clickLoginIcon() {
        loginIcon.click();
    }


    //Normal User Name
    @FindBy(id = "user-name")
    private WebElement username;

    public void setNormalUsername() {
        username.sendKeys("dino");
    }

    //Correct password
    @FindBy(id = "password")
    private WebElement password;

    public void setPassword() {
        password.sendKeys("choochoo");
    }

    //set username with bugs
    public void setUsernameWithBugs() {
        username.sendKeys("beetle");
    }

    //set slow user
    public void setSlowUser() {
        username.sendKeys("turtle");
    }

    //click login
    @FindBy(css = ".btn.btn-primary")
    private WebElement loginButton;

    public void clickLoginButton() {
        loginButton.click();
    }

    //sign-out button
    @FindBy(css = ".svg-inline--fa.fa-sign-out-alt.fa-w-16")
    private WebElement signoutButton;

    public void clickSignOutButton() {
        signoutButton.click();
    }
    // element and method for Awesome product price
    @FindBy(css = "div.col-md-auto div[style='width: 100px;']")
    private WebElement itemPriceForAwesomeProduct;


    public double priceforAwesomeProduct() {
        String amountValueForAwesome = itemPriceForAwesomeProduct.getText();
        String cleanAmountValueForAwesome = amountValueForAwesome.replace("$", "");
        return Double.parseDouble(cleanAmountValueForAwesome);

    }
    // element and method for Gorgeous pizza price
    @FindBy(css = "div.col-md-auto[style='margin-top: 7px;'] div[style='width: 100px;']")
    private WebElement itemPriceForGorgeousProduct;


    public double priceforGorgeousProduct() {
        String amountValueForGorgeous = itemPriceForGorgeousProduct.getText();
        String cleanAmountValueForGorgeous = amountValueForGorgeous.replace("$", "");
        return Double.parseDouble(cleanAmountValueForGorgeous);

    }
}