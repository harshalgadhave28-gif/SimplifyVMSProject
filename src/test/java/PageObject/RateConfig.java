package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RateConfig extends BasePage{
	public RateConfig(WebDriver driver) {
		super(driver);
	}
	
//	@FindBy(xpath = "//span[normalize-space()='Rate']")
//	WebElement Rateclick;
	
	@FindBy(xpath = "//div[@class='nav-bar']//div[1]//li[1]//div[1]//div[1]//div[2]")
	WebElement Ratetype;
	
	@FindBy(xpath = "//span[@class='d-none d-md-flex']")
	WebElement RateCreate;
	
	public void ratecon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement rateButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Rate']")));
		rateButton.click();
		Ratetype.click();
	}
	
	
}
