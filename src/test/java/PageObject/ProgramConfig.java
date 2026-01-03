package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgramConfig extends BasePage{
	
	public ProgramConfig (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='Configurations']")
	WebElement configuration;
	
	@FindBy(xpath = "//span[normalize-space()='Program Configuration']")
	WebElement programconfig;
	
	@FindBy(xpath = "//span[normalize-space()='Edit']")
	WebElement Editproconfig;
	
	public void configs() {
		configuration.click();
		programconfig.click();
		Editproconfig.click();
	}
	
	
	
	
}
