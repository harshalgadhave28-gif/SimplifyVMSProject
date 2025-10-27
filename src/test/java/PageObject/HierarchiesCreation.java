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

public class HierarchiesCreation extends BasePage{
	
	// constructor 
	public HierarchiesCreation (WebDriver driver) {
		super(driver);
	}
	
	// locators 
	@FindBy(xpath = "//span[normalize-space()='Hierarchies']")
	WebElement Hierarchiesclick;
	
	@FindBy(xpath = "//button[@class='c-btn c-btn-primary-medium-left-icon mr_8 ng-star-inserted']")
	WebElement 	createnewbtn;
	
	@FindBy (xpath = "//ng-select[@formcontrolname='parent_hierarchy_id']//div[@class='ng-select-container ng-has-value']")
	WebElement 	ParentHierarchyselect;
	
	By dropdownoption= By.xpath("//div[@aria-expanded='true']//input[@type='text']");
	By dropdownoptions= By.xpath("//ng-select[@bindlabel='display_name']//input[@type='text']");
	
	@FindBy (xpath = "//input[@placeholder='Enter Name']")
	WebElement hirearchynames;

	// methods 
	public void clickhirer() {
		Hierarchiesclick.click();
	}
	
	public void clickcreatnew() {
		createnewbtn.click();
	}
	
	public void selectionparnthirearchy() {
		driver.findElement(By.xpath("//ng-dropdown-panel[@id='a530c2a6ccca']")).click();
		List <WebElement> options = driver.findElements(dropdownoption);
		int randomindex= new Random().nextInt(options.size());
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(options.get(randomindex)));
		options.get(randomindex).click();
	}
		
	public void hirarchymanageby() {
		driver.findElement(By.xpath("//ng-select[@role='listbox']//ng-dropdown-panel")).click();
		List <WebElement> optionns = driver.findElements(dropdownoptions);
		int randomind= new Random().nextInt(optionns.size());
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(optionns.get(randomind)));
		optionns.get(randomind).click();
	}
	
	public void hirearchyname() {
		String hirname[]= {"Product Support","Automation Team","Hyderabad Development Center","Cloud Operations","Europe Division","North America Unit",};
		int randomindex =new Random().nextInt(hirname.length);
		int randomnum= new Random().nextInt(1000);
		String generatehierrchys= hirname[randomindex]+randomnum;
		hirearchynames.sendKeys(generatehierrchys);
	}
	
	
}
