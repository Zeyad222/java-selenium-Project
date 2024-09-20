package rahulshettyacademy.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.*;

import java.io.IOException;
import java.util.List;

public class stepDefinitionsImpl extends BaseTest {

    public LandingPage landingPageObj;
    public ProductsCatalogue ProductsCatalogueObj;
    public checkOutPage checkoutpageObj;
    public confirmationPage confirmationpageObj;
    @Given("I landed on Ecommerce page")
    public void I_landed_on_Ecommerce_page() throws IOException {
        landingPageObj = LaunchingApplication();
    }

    @Given("^Logged in with useremail (.+) and password (.+)$")
    public void Logged_in_with_useremail_password(String useremail, String password){
        ProductsCatalogueObj = landingPageObj.loginApplication(useremail, password);
    }

    @When("^I add product (.+) to cart$")
    public void I_add_productName_to_cart(String productName){
//        List<WebElement> products = ProductsCatalogueObj.getProductsList();
        ProductsCatalogueObj.addProductToCart(productName);

    }
    @When("^Checkout (.+) and submit the order$")
    public void checkout_submit_orders(String productName) throws InterruptedException {
        CartPage cartPageObj = ProductsCatalogueObj.goToCartPage();
        boolean match = cartPageObj.verifyProductDisplay(productName);
        Assert.assertTrue(match);

        // ------------checkout-page-----------------
        checkoutpageObj = cartPageObj.getToCheckOut();
//		checkOutPage checkoutpageObj = new checkOutPage();

        // another way to select egypt
//		String countryName = "eg";
        checkoutpageObj.SelectCountry("eg");
        confirmationpageObj = checkoutpageObj.submitOrder();
    }
    @Then("{string} message is displayed on the ConfirmationPage")
    public void message_is_displayed_on_ConfirmationPage(String string){
        String confirmMessage = confirmationpageObj.getconfirmationMessage();
        AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase(string));
    }

    @Then("{string} message is displayed with warning")
    public void message_is_displayed_with_Warning(String stringArg1){
        Assert.assertEquals(stringArg1, landingPageObj.wrongMessages());

    }

}
