package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class ProductsCatalogue extends AbstractComponents {

	WebDriver driver;

	public ProductsCatalogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	List<WebElement> products = driver.findElements(By.cssSelector("div.card-body"));

	// -------Page Factory ---------//
	//
	// instead of taking object from driver and findelement
	//
	@FindBy(css = "div.card-body")
	List<WebElement> products;

//	@FindBy(css = ".ng-animating")
//	WebElement animatedWait;

	By productsTowait = By.cssSelector("div.card-body");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastContainer = By.cssSelector("#toast-container");
	By animatedWait = By.cssSelector(".ng-animating");

	public List<WebElement> getProductsList() {
		waitForElementsToAppear(productsTowait);
		return products;
	}

	public WebElement getProductsByName(String productName) {
		WebElement findProduct = getProductsList().stream()
				.filter(s -> s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return findProduct;
	}

	public void addProductToCart(String productName) {
		getProductsByName(productName).findElement(addToCart).click();
		waitForElementsToAppear(toastContainer);
		// for animation wait
		waitForElementsToDissapear(animatedWait);

	}
}
