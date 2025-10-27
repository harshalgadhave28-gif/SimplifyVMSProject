package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	// constructor
	public LoginPage (WebDriver driver) {
		super (driver);
	}
	
	//locator
	@FindBy(xpath = "//input[@placeholder='Enter Your Email Address Or Username']")
	WebElement textusername;
	
	@FindBy(xpath = "//input[@placeholder='Enter Your Password']")
	WebElement textpassword;

	@FindBy (xpath = "//button[normalize-space()='Sign In']")
	WebElement btnclick;
	
	// methods
	public void setUserName(String uname) {
		textusername.sendKeys(uname);
	}
	
	public void setPassword(String pass) {
		textpassword.sendKeys(pass);
	}
	
	public void clicklogin() {
		btnclick.click();
	}
	
	

}
