package TestBase;

import java.lang.System.Logger;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	
	@BeforeClass
	@Parameters ({"os","browser"})
	
	public void setup(String os,String br) {	
		 switch(br.toLowerCase())
		 {
			 case "chrome": driver= new ChromeDriver(); break;
			 case "edge": driver= new  EdgeDriver(); break;
		     default:
	         throw new IllegalArgumentException("Browser not supported: " + br);
		 }
//	driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://qa-account.simplifysandbox.net/");
	driver.manage().window().maximize();
	}
	
	 public WebDriver getDriver() {
	        return driver;
	    }

}
