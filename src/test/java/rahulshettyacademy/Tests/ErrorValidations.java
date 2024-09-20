package rahulshettyacademy.Tests;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
//import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductsCatalogue;
import rahulshettyacademy.pageobjects.checkOutPage;
import rahulshettyacademy.pageobjects.confirmationPage;

public class ErrorValidations extends BaseTest {

	@Test(groups = { "ErrorHandling" }, retryAnalyzer = Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {

		// By hiding this object i public initilized it in BaseTest and adding
		// Beforetest
		// annotation to make sure driver is calling before doing anything
//		LandingPage landingPageObj = LaunchingApplication();
		// sign-in with wrong pass
		landingPageObj.loginApplication("zed_alaa222@outlook.com", "1541asdas");

		Assert.assertEquals("Incorrect email or password.", landingPageObj.wrongMessages());

	}

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {

		ProductsCatalogue ProductsCatalogueObj = landingPageObj.loginApplication("zeyad_alaa222@outlook.com",
				"#ReDrunk0#");
		String productName = "IPHONE 13 PRO";
		ProductsCatalogueObj.addProductToCart(productName);
		CartPage cartPageObj = ProductsCatalogueObj.goToCartPage();
		Boolean match = cartPageObj.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		checkOutPage checkoutpageObj = cartPageObj.getToCheckOut();
		checkoutpageObj.SelectCountry("eg");

		confirmationPage confirmationpageObj = checkoutpageObj.submitOrder();
		String confirmMessage = confirmationpageObj.getconfirmationMessage();
		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

}
