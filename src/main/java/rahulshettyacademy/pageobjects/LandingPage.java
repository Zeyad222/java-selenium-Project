package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);// Calls the parent class's constructor
		this.driver = driver;//refers to the class-level field, and `driver` refers to the parameter
		PageFactory.initElements(driver, this); // Initializes WebElements
	}

//	driver.findElement(By.id("userEmail")).sendKeys("zeyad_alaa222@outlook.com");
//	WebElement username = driver.findElement(By.id("userEmail"));

	// -------Page Factory ---------//
	//
	// instead of taking object from driver and findelement
	//
	@FindBy(id = "userEmail")
	WebElement useremail;

	@FindBy(id = "userPassword")
	WebElement userpassword;

	@FindBy(id = "login")
	WebElement submit;
	
	//Error message for Error validations
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessaegespass;
	

	public String wrongMessages() {
		waitForWebElementsToAppear(errorMessaegespass);
		return errorMessaegespass.getText();
	}
	

	// we change void to ProductsCatalogue
	// Instead of declaring object for each class
	// here we make sure that the object is returned of class of ProductCatalogue
	// to be resuable
	public ProductsCatalogue loginApplication(String email, String password) {
		useremail.sendKeys(email);
		userpassword.sendKeys(password);
		submit.click();
		ProductsCatalogue ProductsCatalogueObj = new ProductsCatalogue(driver);
		return ProductsCatalogueObj;
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
		
	}
}
