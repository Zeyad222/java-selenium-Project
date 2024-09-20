package rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTest {

    public WebDriver driver;
    public LandingPage landingPageObj;

    public WebDriver IntializeDriver() throws IOException {

        Properties prop = new Properties();
        // convert file to input stream object
        FileInputStream file = new FileInputStream(
                System.getProperty("user.dir") + "/src/main/java/rahulshettyacademy/resources/GlobalData.properties");
        prop.load(file);

        String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
//        String browserName = prop.getProperty("browser");

        if (browserName.contains("chrome")) {

//            WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "C:/Users/Zeyad/Documents/chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
//			System.setProperty("webdriver.edge.driver", "C:/Users/Zeyad/Documents/msedgedriver.exe");
//			driver = new EdgeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.firefox.driver", "C:/Users/Zeyad/Documents/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;
    }

    // Screenshot when tests failed
    public String getScreenShot(String testCaseName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }

    // now this function is general for read and convert Json file
    //
    //
    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        // read json to string
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        // string to hashmap jackson databind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {});
        return data;
        //{map,map}
    }

    // @BeforeMethod(groups = { "ErrorHandling" })
    @BeforeMethod(alwaysRun = true)
    public LandingPage LaunchingApplication() throws IOException {
        driver = IntializeDriver();
        // sign-ins
        landingPageObj = new LandingPage(driver);
        landingPageObj.goTo();

        return landingPageObj;
    }

//	@AfterTest
//	public void closeDriver() throws IOException {
//
//		driver.close();
//	}

}
