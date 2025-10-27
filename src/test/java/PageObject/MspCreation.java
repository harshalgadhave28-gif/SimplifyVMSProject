package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MspCreation extends BasePage{
	
	// constructor 
	public MspCreation (WebDriver driver) {
		super (driver);
	}
		// locator 
		@FindBy (xpath = "//span[normalize-space()='MSPs']")
		WebElement clickMsp;
		
		@FindBy (xpath = "//span[@class='d-none d-md-flex']")
		WebElement clickCreateMsp;
		
		@FindBy (xpath = "//input[@placeholder='MSP Organization Name']")
		WebElement MspOrgnaizationName;
		
		// file upload
//		@FindBy(xpath = "//a[normalize-space()='Browse']") 
//		WebElement fileUploadInput;
//
//		@FindBy(xpath = "") 
//		WebElement uploadButton;
		
		@FindBy (xpath = "//button[@class='btn btn_primary d-flex align-items-center fs-16 btn']")
		WebElement clickoncontinue;
		
		@FindBy (xpath = "//button[@class='btn btn_primary d-flex align-items-center fs-16 btn']")
		WebElement clicksave;
		
		public void MspClick() {
		clickMsp.click();	
		}
		
		public void MspCretion() {
			clickCreateMsp.click();
		}
		
       	public void OrganizationName(String MspOrgname) {
			MspOrgnaizationName.sendKeys(MspOrgname);
		}
       	
       	public void uploadfile() {
       		driver.findElement(By.xpath("//a[normalize-space()='Browse']")).sendKeys("C:\\New folder");
       	}
       	
	
    	public void continuebutton() {
			clickoncontinue.click();
		}
    	
    	public void clickbutton() {
    		clicksave.click();
    	}

}
