package TestBase;

import java.lang.System.Logger;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import PageObject.LoginPage;

public class BaseClass3 {
	public  WebDriver driver;
	public Logger logger;
	
	@BeforeClass
	
	@Parameters ({"os","browser"})

	public void setup(String os,String br){
		
		switch(br.toLowerCase())
		 {
			 case "chrome": driver= new ChromeDriver(); break;
			 case "edge": driver= new  EdgeDriver(); break;
		     default:
	         throw new IllegalArgumentException("Browser not supported: " + br);
		 }	
//		driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://qa-account.simplifysandbox.net/");
	driver.manage().window().maximize();
	LoginPage lp= new LoginPage(driver);
	lp.setUserName("admin");
	lp.setPassword("Admin@Simplify");
	lp.clicklogin();
	
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
      driver.findElement(By.xpath("//input[@placeholder='Search..']")).sendKeys("My Own Program-Sheetal");
      By orgResult = By.xpath("//p[contains(normalize-space(), 'My Own Program-Sheetal')]");
      wait.until(ExpectedConditions.elementToBeClickable(orgResult));
      driver.findElement(orgResult).click();
      driver.findElement(By.xpath("//body//app-root//button[2]")).click();
//      driver.findElement(By.xpath("//span[normalize-space()='Navigate to Dashboard']")).click();

  }

  public WebDriver getDriver() {
      return driver;
      
      
  }

}
