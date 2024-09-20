package rahulshettyacademy.Tests;

//import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
		System.setProperty("edgedriver.chrome.driver", "/C:/Users/Zeyad/Documents/msedgedriver.exe/");
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		
		//sign-in
		driver.findElement(By.id("userEmail")).sendKeys("zeyad_alaa222@outlook.com");
		driver.findElement(By.id("userPassword")).sendKeys("#ReDrunk0#");
		driver.findElement(By.id("login")).click();
		
		//----------------  mainpage  -----------------------//
		
		//select a product
		List<WebElement> products = driver.findElements(By.cssSelector("div.card-body"));
		WebElement findProduct = products.stream().filter(s->
		s.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);
		findProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//----------------make sure that product is added to cart-----------------

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//for animation wait
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		//select product in cart page
		List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartproducts.stream().anyMatch(s->s.getText().equalsIgnoreCase("IPHONE 13 PRO"));
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		//------------checkout-page-----------------
		//another way to select egypt
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "eg").build().perform();
//		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("eg");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//section/button")));
		
		driver.findElement(By.xpath("//section/button[2]")).click();
	}

}
