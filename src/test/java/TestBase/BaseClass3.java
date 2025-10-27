package TestBase;

import java.lang.System.Logger;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
	
	driver.findElement(By.xpath("//input[@placeholder='Search..']")).sendKeys("Stonebridge National Distribution");
	driver.findElement(By.xpath("//p[@class='truncate-text blue-text cursor-pointer d-inline-block text-nowrap ng-star-inserted']")).click();
	driver.findElement(By.xpath("//body//app-root//button[2]")).click();
	}

}
