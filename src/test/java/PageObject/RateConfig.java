package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RateConfig extends BasePage{
	public RateConfig(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='Rate']")
	WebElement Rateclick;
	
	@FindBy(xpath = "//div[@class='nav-bar']//div[1]//li[1]//div[1]//div[1]//div[2]")
	WebElement Ratetype;
	
	@FindBy(xpath = "//span[@class='d-none d-md-flex']")
	WebElement RateCreate;
	
	
	

}
