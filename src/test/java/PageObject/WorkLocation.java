package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkLocation extends BasePage{
	// constructor 
	public  WorkLocation(WebDriver driver) {
		super(driver);
	}
	
	// locator
	@FindBy(xpath = "//span[normalize-space()='Work Locations']")
	WebElement worklocationsclick;
	
	@FindBy(xpath = "//span[@class='d-none d-md-flex']")
	WebElement worklocationcrate;
	
	@FindBy (xpath = "//div[@class='page-title d-flex align-items-center font_w_bold ng-tns-c677220879-5']//div[@class='ng-tns-c677220879-5']")
	WebElement namevalid;
	
	
	// methods
	public void workclick() {
		worklocationsclick.click();
	}
	
	public boolean createworklocation() {
		worklocationcrate.click();
	try{
		if(namevalid.isDisplayed()) {
			System.out.println("Create New Work Location");
			return true;
		}else {
			System.out.println("Create New Work Location is not created");
			return false;
		}
	}catch(Exception e){
		System.out.println("Error: Title element not found! " + e.getMessage());
        return false;
	}
	}
	
	
}

	
