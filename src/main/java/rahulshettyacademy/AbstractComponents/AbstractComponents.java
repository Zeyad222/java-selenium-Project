package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;

public class AbstractComponents {

	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartButton;

	@FindBy(css = "[routerlink*='myorders']")
	WebElement OrderButton;
	
	public void waitForElementsToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementsToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	// --------------------------------------//
	// here in this fn invisibilityOf -> need to use a driver to findElement
	// So, using parameter for fn as a webElement ele,
	// then -> must declare @FindBy in the child class for WebElement
	// or leave driver.findElement("add findBy ")
	// By the way the findBy parameter is faster than WebElement in this case
	public void waitForElementsToDissapear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(findBy)));
	}

	public CartPage goToCartPage() {
		cartButton.click();
		CartPage cartPageObj = new CartPage(driver);
		return cartPageObj;
	}
	
	public OrderPage goToOrdersPage() {
		OrderButton.click();
		OrderPage orderPageObj = new OrderPage(driver);
		return orderPageObj;
	}
	
	

}
