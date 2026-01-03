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

public class RateType extends BasePage{
	
	// Constructor 
	public RateType (WebDriver driver) {
		super(driver);
	}
	
	// locators 
	@FindBy(xpath = "//span[normalize-space()='Rate']")  // Rate type  
	WebElement RateClick;
	
	@FindBy(xpath = "//span[normalize-space(text())='Rate Type']") //Rate type click 
	WebElement RateTypeClick;
	
	@FindBy(xpath = "//h3[normalize-space()='Rate Type']")  // Rate type visibility
	WebElement Ratetypevisibility;	

	@FindBy(xpath = "//p[normalize-space()='Rate Type Name']")  // Ratatypenamevisibility
	WebElement Ratatypenamevisibility;
	
	@FindBy(xpath = ".form-control small min-width fs_12 ng-valid ng-star-inserted ng-touched ng-dirty") // Ratetypefilternames
	WebElement RateTypeFilterName;
	
	@FindBy(xpath = "//span[@class='d-none d-md-flex']")   // rate card new 
	WebElement RateCreateNew;

	@FindBy(xpath = "//input[@id='input-rate-type-name']")  // rate type name 
	WebElement RateTypeName;
	
	@FindBy(xpath = "//input[@aria-autocomplete='list']") // rate type categoury
	WebElement RateTypeCategoury;
	
	@FindBy(xpath = "//div[@role='option']//span")  // rate type categoury drop
	WebElement RateTypeCategouryDrop;
	
	By dropdownoptions= By.xpath("//div[@role='option']//span");  
	
	@FindBy(xpath = "//button[@id='btn-save-rate']")  // Rtc save 
	WebElement RTCSave;
	
	
	
//	 Method 
	public void Rates(){   // use Explicit wait due to staleelement reference exception
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(RateClick))).click();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(RateTypeClick))).click();
        
        // title visibility
        if (Ratetypevisibility.isDisplayed()) {
        	System.out.println("the text is visible");
        } else {
        	System.out.println("the text is not visible");
        }
        
        // subtitle visibility 
        // Rate type name 
        if (Ratatypenamevisibility.isDisplayed()) {
        	System.out.println("the header title rate type name is visible");
        } else {
        	System.out.println("the heaeder title rate type name is  not visible ");
        }
        
        RateCreateNew.click(); 
	}	
	
	public void Recodcheck() {
		List<WebElement>rows =driver.findElements(By.xpath("//table[contains(@class,'c-listing-table')]//tbody/tr"));
        System.out.println("Total number of Rate Type records: " + rows.size());
	}
	
	public void RateTypeName() {                    // Ratetupe name
		String name []= {"Regular Rate","Monthly Rate","Weekly Rate","Markup Rate","Double Time Rate","Overtime Rate","Night Shift Rate"};
		int randomoindex = new Random().nextInt(name.length);
		int randomnumber = new Random().nextInt(1000);
		String generateratetye= name[randomoindex]+randomnumber;
		RateTypeName.sendKeys(generateratetye);
	}
	
	public void RateTypeCategoury() {               // Ratatype Categoury
		RateTypeCategoury.click();
		List<WebElement> optioins =driver.findElements(dropdownoptions);
	    int randomIndex = new Random().nextInt(optioins.size());
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	    wait.until(ExpectedConditions.elementToBeClickable(optioins.get(randomIndex)));
	    optioins.get(randomIndex).click();
	    RTCSave.click();
	}
	public void Ratetypefilternames() {
		String Spelling[]= {"rthnbgfv","rtgbdvfd","srnbrsfd","tryhtgsf"};
		int randomindex= new Random().nextInt(Spelling.length);
		int randomnumber= new Random().nextInt(1000);
		String generateratetye= Spelling[randomindex]+randomnumber;
		RateTypeFilterName.sendKeys(generateratetye);
	}
	
	
	
}
