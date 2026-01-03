package TestBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import PageObject.LoginPage;

public class BaseClass2 {
    public WebDriver driver;

    @BeforeClass
    @Parameters({"os", "browser", "execution_env"})
    public void setup(String os, String br, String execution_env) throws MalformedURLException {

        if (execution_env.equalsIgnoreCase("remote")) {
            // ----- Running on Docker Grid -----
            DesiredCapabilities capabilities = new DesiredCapabilities();

            // Set platform
            if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("linux")) {
                capabilities.setPlatform(Platform.LINUX);
            } else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            } else {
                System.out.println("No matching OS found!");
                return;
            }

            // Set browser
            switch (br.toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;
                default:
                    System.out.println("No matching browser found!");
                    return;
            }

            // Connect to Docker Selenium Grid
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new ChromeOptions());
            System.out.println("✅ Test running on Docker Grid: " + br);
            

        } else if (execution_env.equalsIgnoreCase("local")) {
            // ----- Running locally -----
            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Browser not supported: " + br);
            }
            System.out.println("Test running locally: " + br);
        }

        // Common setup for both local & remote
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://qa-account.simplifysandbox.net/");

        // Login
        LoginPage lp = new LoginPage(driver);
        lp.setUserName("admin");
        lp.setPassword("Admin@Simplify");
        lp.clicklogin();

        // Search and click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.findElement(By.xpath("//input[@placeholder='Search..']")).sendKeys("My Own Program-Sheetal");
        By orgResult = By.xpath("//p[contains(normalize-space(), 'My Own Program-Sheetal')]");
        wait.until(ExpectedConditions.elementToBeClickable(orgResult));
        driver.findElement(orgResult).click();
        driver.findElement(By.xpath("//body//app-root//button[2]")).click();
    }

    public WebDriver getDriver() {
        return driver;
       
    }
}

