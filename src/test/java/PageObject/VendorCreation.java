package PageObject;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VendorCreation extends BasePage{
	
	// constructor
	public VendorCreation(WebDriver driver) {
		super(driver);	
	}
	
	// locator 
	@FindBy(xpath = "//span[normalize-space()='Vendors']")
	WebElement clickvendors;
	
	@FindBy(xpath = "//span[@class='d-none d-md-flex']")
	WebElement clickcreatevendor;

	@FindBy(xpath = "//input[@placeholder='Vendor Organization Name']")
	WebElement vendororganizarioncreate ;
	
	@FindBy(xpath = "//div[@class='col-md-12 mt-3 form-group ng-star-inserted']//input[@id='inputName']")
	WebElement vendorcode;
	
	@FindBy(xpath = "//button[@class='btn btn_primary d-flex align-items-center fs-16 btn']")
	WebElement clickcontinue;
	
	@FindBy(xpath = "//button[@class='btn btn_primary d-flex align-items-center fs-16 btn']")
	WebElement clicksave;
	
	
	
	// methods 
	public void vendorclick() {
		clickvendors.click();
	}
	
	public void vendorcreation() {
		clickcreatevendor.click();
	} 
	
	public void uploadfile() {
	    // Locate the actual file input element
	    WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
	    // Send the file path directly
	    fileInput.sendKeys("C:\\New folder\\nature.jpg");
	}
	
	public void selectcvndorname() {
		String vendororgname[]= {"Apex Global Vendors","Zenith Trade Corporation","Elite Procurement Hub","Vertex Vendor Group","PrimeSource Vendors Pvt. Ltd.","Summit Procurement Agency","Fusion Trade Partners"};
		int randominedex = new Random().nextInt(vendororgname.length);
		int randomnumber = new Random().nextInt(1000); 
		String generatevendororgname=vendororgname[randominedex]+randomnumber;
//		vendororganizarioncreate.sendKeys(generatevendororgname);
		
		
		  if (isValidName(generatevendororgname)) {
		        vendororganizarioncreate.sendKeys(generatevendororgname);
		    } else {
		        System.err.println("Name must contain valid characters: " + generatevendororgname);
		        throw new IllegalArgumentException("Name must contain valid characters.");
		    }
	}
	private boolean isValidName(String name) {
	    // Only letters, numbers, and spaces are allowed
	    return name.matches("[a-zA-Z0-9 ]+");
	}
	
	public void vcode() {
		int code = 1000+new Random().nextInt(9000);
		vendorcode.sendKeys(String.valueOf(code));
	}
	
	public void continuebtn() {    
		clickcontinue.click();
	}
	
	public void savebtn() {
		clicksave.click();
	}
	
}
