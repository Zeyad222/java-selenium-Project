package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartproducts;

	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(css = "[routerlink*='cart']")
//	WebElement cartButton;

	// The reasaon for hide this fn here
	// As this is reusable so i add it in AbstractComponent class
//	public void selectCartButton() {
//		cartButton.click();
//	}

	public boolean verifyProductDisplay(String productName) {
		boolean match = cartproducts.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
		return match;
	}

	public checkOutPage getToCheckOut() throws InterruptedException {
		Thread.sleep(2000);
		checkoutEle.click();
		return new checkOutPage(driver);
	}

}
