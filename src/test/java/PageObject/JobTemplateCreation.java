package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class JobTemplateCreation extends BasePage {

    public JobTemplateCreation(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Job']")
    WebElement jobclick;

    @FindBy(xpath = "//span[normalize-space()='Job Templates']")
    WebElement jobtemplateclick;

    @FindBy(xpath = "//span[@class='d-none d-md-flex']")
    WebElement jobtemplatecreate;
    
    @FindBy(xpath = "//div[@class='w_100 form-group pb_0 ng-tns-c3849229685-4']//input[@id='Title']")
    WebElement titlename;
    
    @FindBy(xpath = "//input[@placeholder='Enter Job Template Code']")
    WebElement jobtempcodeclick;
    
//	By dropdownoptions= By.xpath("//div[@aria-expanded='true']//input[@type='text']");
	By dropdownoptions2=By.xpath("//ng-dropdown-panel//div[@role='listbox']//div[@role='option']");
//    By dropdownOptions = By.xpath("(//ng-dropdown-panel//div[@role='option'])");

	
//    @FindBy(xpath = "//div[text()='Select Value']")
//    WebElement jobtypecliks;
	
	@FindBy(xpath = "//label[@for='is_all_hierarchy']")
	WebElement Hierarchyselection;
	
	@FindBy(xpath = "//span[normalize-space()='Generate Using AI']")
	WebElement AutoDescription;
	
    public void jobtemplate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        // Wait for and click on Job
        wait.until(ExpectedConditions.elementToBeClickable(jobclick));
        jobclick.click();

        // Wait for and click on Job Templates
        wait.until(ExpectedConditions.elementToBeClickable(jobtemplateclick));
        jobtemplateclick.click();

        // Wait for and click on Create button
        wait.until(ExpectedConditions.elementToBeClickable(jobtemplatecreate));
        jobtemplatecreate.click();
    }
    
    public void jobtemptitle() {
    	String jobtitles[]= {"Software Test Engineer","QA Automation Engineer","Frontend Developer","Full Stack Developer","UI/UX Designer","Business Analyst","DevOps Engineer","Labour Category Administrator"};
		int notitles= new Random().nextInt(jobtitles.length);
		int ranno= new Random().nextInt(1000);
		String generatrandomname= jobtitles[notitles]+ranno;
		titlename.sendKeys(generatrandomname);
    }
    
    public void vcode() {
		int code = 1000+new Random().nextInt(9000);
		jobtempcodeclick.sendKeys(String.valueOf(code));
	}    
    
    // JOB TYPE SELECTION 
//    public void jtype() {
//    	driver.findElement(By.xpath("//div[text()='Select Value']")).click();;
//    	List <WebElement> optionns = driver.findElements(dropdownoptions);
//		int randomind= new Random().nextInt(optionns.size());
//		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(2));
//		wait.until(ExpectedConditions.elementToBeClickable(optionns.get(randomind)));
//		optionns.get(randomind).click();
//		Hierarchyselection.click();
//    }
    
//    public void jtype() {
//        // Step 1: Open dropdown
//    	WebElement selectValue = driver.findElement(By.xpath("//div[normalize-space(text())='Select Value']"));
//    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectValue);
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownOptions));
//        List<WebElement> options = driver.findElements(dropdownOptions);
//        int randomIndex = new Random().nextInt(options.size());
//        wait.until(ExpectedConditions.elementToBeClickable(options.get(randomIndex)));
//        options.get(randomIndex).click();
//
//        // Step 6: Select hierarchy (your action)
//        Hierarchyselection.click();
//    }
    
    public void hirarselection() {
    	Hierarchyselection.click();
    }

    // Primary Hierarchy Selection 
    public void PrimaryHierarchyselection() {
    	driver.findElement(By.xpath("//div[@aria-expanded='true']//input[@type='text']")).click();
    	List<WebElement>options1=driver.findElements(dropdownoptions2);
    	int randomind= new Random().nextInt(options1.size());
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(options1.get(randomind)));
		options1.get(randomind).click();
    }
    
    public void descriptionclick() {
    	AutoDescription.click();
    }
    
    // Labor Category Selection
   
    
}
