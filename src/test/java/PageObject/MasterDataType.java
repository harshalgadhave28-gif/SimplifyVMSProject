package PageObject;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MasterDataType extends BasePage{
	
	// constructor 
	public MasterDataType (WebDriver driver) {
		super(driver);
	}
	
	// locator
	@FindBy(xpath = "//span[normalize-space()='Master Data Types']")
	WebElement mdtclick;
	
	@FindBy (xpath = "//h3[normalize-space()='Master Data Types']")
	WebElement mdttitlevisibility;
	
	@FindBy(xpath = "//button[@class='c-btn c-btn-primary-medium-left-icon mr_8 d-flex align-items-center ng-star-inserted']")
	WebElement mdtcreation;
	
	@FindBy(xpath = "//input[@placeholder='Enter Name']")
	WebElement mdtname;
	
	@FindBy(xpath = "//button[@class='btn btn_success bg_success m-0 ng-star-inserted']")
	WebElement savemdt;
	
	@FindBy(xpath = "//span[@class='ml_4']")
	WebElement seveerror;
	
	
	public boolean clcikmdt() {
		mdtclick.click();

        try {
            // Check if title element is displayed
            if (mdttitlevisibility.isDisplayed()) {
                System.out.println("Master Data Types title is visible!");
                return true;
            } else {
                System.out.println("Master Data Types title is NOT visible!");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error: Title element not found! " + e.getMessage());
            return false;
        }
       
	}
	
	public void creatclick() {
		mdtcreation.click();
	}
	
	public void mdtnames() {
		String name[]= {"Bank Details","Business Partner","Cost Center","Region / Territory","Product / Material","Department","Currency","Tax Codes","Chart of Accounts","Price List","Shipment Method"};
		int randomindex= new Random().nextInt(name.length);
		int randomnumber = new Random().nextInt(1000); 
		String genrateMDTname=name[randomindex]+randomnumber;
		mdtname.sendKeys(genrateMDTname);
	
		// toggle on
		WebElement toggalbtn=driver.findElement(By.xpath("//label[@for='toggleSwitch2']"));
		if (!toggalbtn.isSelected()) {
			toggalbtn.click();
			System.out.println("Toggle is turned ON");
		}
		else {
			System.out.println("toggal is off");
		}
		
	}
	
	public boolean mdtsavebtn() {
		savemdt.click();
		
	try {
		if(seveerror.isDisplayed()) {
			System.out.println("Name must contain at least one letter and cannot be numeric error is visible");
			return true;

		}else {
			System.out.println("Name must contain at least one letter and cannot be numeric error is not visible");
			return false;
		}
		
	}catch(Exception e) {
		System.out.println("Error: Title element not found! " + e.getMessage());
        return false;
	}
	}
	
	

}
