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

public class ClientCreation extends BasePage {
	
	public ClientCreation (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='Clients']")
	WebElement clickclient;
	
	@FindBy(xpath = "//span[@class='d-none d-md-flex']")
	WebElement clickcreateclient;
	
	@FindBy(xpath = "//input[@placeholder='Client Organization Name']")
	WebElement clientName;
	
	@FindBy(xpath = "//button[@class='btn btn_primary d-flex align-items-center fs-16 btn']")
	WebElement clickcontinue;
	
    By dropdownOptions = By.xpath("//div[@role='option' and contains(@class,'ng-option')]"); // Change locator as per your dropdown
	
    
    @FindBy(xpath = "//i[@class='material-icons mr_4 ml_4']")
    WebElement SaveClient;
    
	public void clientclick() {
		clickclient.click();
	}
	
	public void clientcreation() {
		clickcreateclient.click();
	}

	public void uploadfile() {
	    // Locate the actual file input element
	    WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
	    // Send the file path directly
	    fileInput.sendKeys("C:\\New folder\\dummy1.png");
	}
   	
	public void clickconti() {
		clickcontinue.click();
	}
	
	public void seleclientname() {
		String name[]= {"TechNova","Macrosoftt","AlphaCorp","BlueSky1","CyberSolutions"};
		int randominedex = new Random().nextInt(name.length);
		int randomnumber = new Random().nextInt(1000); 
		String generateclientname= name[randominedex]+randomnumber;
		clientName.sendKeys(generateclientname);
	}
	
	public void selectRandomDropdown() {
		driver.findElement(By.xpath("//ng-select[@placeholder='Select Country']//input[@type='text']")).click();
		List<WebElement> optioins =driver.findElements(dropdownOptions);
	    int randomIndex = new Random().nextInt(optioins.size());
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.elementToBeClickable(optioins.get(randomIndex)));
	    optioins.get(randomIndex).click();
	}
	
	public void savebtnn() {
		SaveClient.click();
	}

}
