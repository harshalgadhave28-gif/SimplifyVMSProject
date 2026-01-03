package PageObject;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HolidayCalendes extends BasePage{
	public HolidayCalendes (WebDriver driver) {
		super(driver);
	}
	
	// locators 
	@FindBy(xpath = "//span[normalize-space()='Holiday Calendars']")
	WebElement holidaycaledersbtn;
	
	@FindBy(xpath = "//button[@class='c-btn c-btn-primary-medium-left-icon mr_8 d-flex align-items-center ng-star-inserted']")
	WebElement holidaycreatebtn;

	@FindBy(xpath = "//input[@id='name']")
	WebElement calendername;
	
	@FindBy(xpath = "//label[@for='toggleSwitch1']")
	WebElement ctoggal;
	
	By dropdownOptions= By.xpath("//div[@role='option']//span[@class='ng-option-label ng-star-inserted']");
	
	@FindBy(xpath = "//label[@for='toggleSwitch2']")
	WebElement associatehire;
	
	@FindBy(xpath = "//label[@for='toggleSwitch3']")
	WebElement associatework;
	
	public void holidayclick() {
		holidaycaledersbtn.click();
		holidaycreatebtn.click();
	}
	public void calendarname() {
		String holiname[]= {"monthends","vacation","government holidays","visite holidays","seek leave","extra","important"};
		int randomenames= new Random().nextInt(holiname.length);
		int randomnum= new Random().nextInt(1000);
		String generatenames=holiname[randomenames]+randomnum;
		calendername.sendKeys(generatenames);
		ctoggal.click();
	}
	
	public void year() {
		driver.findElement(By.xpath("//ng-select[@id='year']//div[@class='ng-select-container']")).click();
		List<WebElement>options =driver.findElements(dropdownOptions);
		int randomIndex = new Random().nextInt(options.size());
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.elementToBeClickable(options.get(randomIndex)));
	    options.get(randomIndex).click();
	}
	
	
	public void associatedhirearchys() {
		associatehire.click();
		associatework.click();
	}
}
