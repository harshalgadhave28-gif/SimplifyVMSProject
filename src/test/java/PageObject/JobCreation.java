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

public class JobCreation extends BasePage{
	public JobCreation(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='Create Job']")
	WebElement jobcreatebtn;
	
	@FindBy (xpath = "//h2[@class='fs_23 font-semibold m-0 mt-2' and normalize-space()='Create Job']")
	WebElement createjobtxt;
	
	
	By dropdownoptions = By.xpath("//ng-dropdown-panel//div[@role='option']//span");  // Select and click a random option
//	By dropdownoptions2 = By.xpath("//div[@role='listbox']//div[@role='option']");
	By ddropdownoptions2= By.xpath("//ng-dropdown-panel//div[@role='option']");
	By ddropdownoptions3= By.xpath("//ng-dropdown-panel//div[@role='option']");
	By ddropdownoptions4= By.xpath("//ng-dropdown-panel//div[@role='option']");

	
	public void jobprocess(){
		jobcreatebtn.click();
		createjobtxt.isDisplayed();
	}
	
	public void jobmanager() {
		WebElement input = driver.findElement(By.xpath("//input[@aria-autocomplete='list']"));  // click on dropdown 
	    input.click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ng-dropdown-panel//div[@role='option']")));  //all the click abel items 
	    List<WebElement> options = driver.findElements(dropdownoptions);
	    int randomIndex = new Random().nextInt(options.size());
	    wait.until(ExpectedConditions.elementToBeClickable(options.get(randomIndex)));
	    options.get(randomIndex).click();
	}
	
	public void jobtype() {
		WebElement input = driver.findElement(By.xpath("//ng-select[@placeholder='Select Job Type']//div[@class='ng-select-container']"));
		input.click();
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(2) );
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ng-dropdown-panel//div[@role='option']")));
	    List<WebElement> options = driver.findElements(ddropdownoptions2);
	    int randomIndex = new Random().nextInt(options.size());
	    wait.until(ExpectedConditions.elementToBeClickable(options.get(randomIndex)));
	    options.get(randomIndex).click();
	    
	}
	
	public void worklocation() {
		WebElement input = driver.findElement(By.xpath("//ng-select[@class='ng-select-searchable ng-select-clearable ng-select ng-select-single ng-untouched ng-pristine ng-invalid']//div[@class='ng-select-container']"));
		input.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2) );
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ng-select[@class='ng-select-searchable ng-select-clearable ng-select ng-select-single ng-valid ng-touched ng-dirty ng-select-opened ng-select-bottom']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ng-dropdown-panel//div[@role='option']")));
	    List<WebElement> options = driver.findElements(ddropdownoptions3);
	    int randomIndex = new Random().nextInt(options.size());
	    wait.until(ExpectedConditions.elementToBeClickable(options.get(randomIndex)));
	    options.get(randomIndex).click();
}
	
	public void Managedymsp() {
		WebElement input2 =driver.findElement(By.xpath("//ng-select[@class='ng-select-searchable ng-select-clearable ng-select ng-select-single ng-pristine ng-valid ng-touched ng-select-bottom']//div[@class='ng-select-container']"));
		input2.click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ng-dropdown-panel//div[@role='option']")));
	    List<WebElement> options = driver.findElements(ddropdownoptions4);
	    int randomIndex = new Random().nextInt(options.size());
	    wait.until(ExpectedConditions.elementToBeClickable(options.get(randomIndex)));
	    options.get(randomIndex).click(); 	
	}
	

	
}
