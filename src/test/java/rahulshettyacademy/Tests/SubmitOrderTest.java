package rahulshettyacademy.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
//import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;
//import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductsCatalogue;
import rahulshettyacademy.pageobjects.checkOutPage;
import rahulshettyacademy.pageobjects.confirmationPage;

public class SubmitOrderTest extends BaseTest {

	String productName = "IPHONE 13 PRO";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		// By hiding this object i public initilized it in BaseTest and adding
		// Beforetest
		// annotation to make sure driver is calling before doing anything
//		LandingPage landingPageObj = LaunchingApplication();
		// sign-in
		ProductsCatalogue ProductsCatalogueObj = landingPageObj.loginApplication(input.get("email"),
				input.get("password"));

		// ---------------- mainpage -----------------------//

		// select a product

		// There is anothr way to declare the obj
		// it's declared in LandingPage class
		//
//		ProductsCatalogue ProductsCatalogueObj = new ProductsCatalogue(driver);
		//
		//

		ProductsCatalogueObj.addProductToCart(input.get("productName"));

		// select cart button
		// select product in cart page
		// object is declared in AbstractComponent page
//		CartPage cartPageObj = new CartPage(driver);
		CartPage cartPageObj = ProductsCatalogueObj.goToCartPage();
		boolean match = cartPageObj.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);

		// ------------checkout-page-----------------

		checkOutPage checkoutpageObj = cartPageObj.getToCheckOut();
//		checkOutPage checkoutpageObj = new checkOutPage();

		// another way to select egypt
//		String countryName = "eg";
		checkoutpageObj.SelectCountry("eg");

		confirmationPage confirmationpageObj = checkoutpageObj.submitOrder();
		String confirmMessage = confirmationpageObj.getconfirmationMessage();
		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistory() {
		// "IPHONE 13 PRO";
		ProductsCatalogue ProductsCatalogueObj = landingPageObj.loginApplication("zeyad_alaa222@outlook.com",
				"#ReDrunk0#");
		OrderPage ordersPageobj = ProductsCatalogueObj.goToOrdersPage();
		ordersPageobj.verifyOrderDisplay(productName);
		Assert.assertTrue(ordersPageobj.verifyOrderDisplay(productName));
	}

	
	
	// we update getData function
	// as in the future if we have for ex 15 parameters, it will be hard to
	// initialize them
	// in the main function in our case submitOrder fn
	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "/src/test/java/rahulshettyacademy/data/PurchaseOrder.json");
		
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
	
//{ "zeyad_alaa222@outlook.com", "#ReDrunk0#", "ADIDAS ORIGINAL" } 
//	HashMap<String,String> map = new HashMap<String,String>();
//	map.put("email", "zeyad_alaa222@outlook.com");
//	map.put("password", "#ReDrunk0#");
//	map.put("productName", "IPHONE 13 PRO");
//	
//	HashMap<String,String> map1 = new HashMap<String,String>();
//	map1.put("email", "zeyad_alaa222@outlook.com");
//	map1.put("password", "#ReDrunk0#");
//	map1.put("productName", "ADIDAS ORIGINAL");
}
