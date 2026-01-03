package PageObject;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FeeConfigCreation extends BasePage {
	public FeeConfigCreation (WebDriver driver) {
		super (driver);
	} 
	
	@FindBy(xpath = "//span[normalize-space()='Configurations']")
	WebElement config;
	
	@FindBy(xpath = "//span[normalize-space()='Fee Configurations']")
	WebElement feeconfig;
	
	@FindBy(xpath = "//span[@class='d-none d-md-flex']")
	WebElement feecreate;
	
	@FindBy(xpath = "//input[@placeholder='Fee Configuration name']")
	WebElement feeconfignames;
	
	@FindBy(xpath = "//label[@for='is_all_hierarchy']")
	WebElement allHierarchi;
	
	public void feeconfiguration() {
		 new WebDriverWait(driver, Duration.ofSeconds(5))
         .until(ExpectedConditions.elementToBeClickable(config))
         .click();
		feeconfig.click();
		feecreate.click();
	}
	
	public void feeconfignames() {
		String feecnmae[]= {"Percentage Fee","Flat Fee","Markup Fee","Margin Fee","Tiered Fee","Pass-Through Fee","Supplier Fee"};
		int randomnames= new Random().nextInt(feecnmae.length);
		int randomnamenum= new Random().nextInt(1000);
		String gennames=feecnmae[randomnames]+randomnamenum;
		feeconfignames.sendKeys(gennames);
	}
	
	public void feehirear() {
//		allHierarchi.click();
	}
	
}
