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

public class WrokflowCreation extends BasePage{
	
	// constructor 
	public WrokflowCreation(WebDriver driver) {
		super(driver);
	}
	
	// locator 
	@FindBy(xpath = "//span[normalize-space()='Workflows']")
	WebElement Workflowclick;
	
	@FindBy(xpath = "//span[@class='d-none d-md-flex']")
	WebElement Workflowcreation;
	
	By dropdownoption=By.xpath("//div[@aria-expanded='true']");
	// methods   

	@FindBy(xpath = "//button[normalize-space()='apply']")
		WebElement applayclcik;
	
	@FindBy (xpath = "//button[@class='c-btn c-btn-primary-medium-left-icon mr_8 d-flex align-items-center ng-star-inserted']")
	WebElement createnewclick;
	
	
	public boolean workclick() {
		Workflowclick.click();
		
		if(Workflowcreation.isDisplayed()) {
			System.out.println("Workflows title is visible");
			return true;
		}else {
			System.out.println("workflow title is not visible");
			return false;
		}
	}
	
	public void workflowmoduleselect() {
		driver.findElement(By.xpath("//div[contains(@class,'ng-option') and @role='option']\r\n")).click();
		List <WebElement> options = driver.findElements(dropdownoption);
		int randomindex= new Random().nextInt(options.size());
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(options.get(randomindex)));
		options.get(randomindex).click();
		applayclcik.click();
	}
	
	public void workflowcreationbtn() {
		createnewclick.click();
	}
	
}
