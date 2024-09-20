package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class checkOutPage extends AbstractComponents {

	WebDriver driver;

	public checkOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".action__submit ")
	WebElement submit;

	@FindBy(xpath = "//section/button[2]")
	WebElement selectChoiceCountry;

	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "//section/button")
	WebElement neededNameCountry;

//	By result = By.cssSelector("//section/button");
	By result = By.cssSelector(".ta-results");
	public void SelectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementsToAppear(By.cssSelector(".ta-results"));
		selectChoiceCountry.click();
	}

	public confirmationPage submitOrder() {
		submit.click();
		return new confirmationPage(driver);
	}
//	driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("eg");
//	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//section/button")));

}
