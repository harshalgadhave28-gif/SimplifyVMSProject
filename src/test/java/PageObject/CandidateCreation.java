package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CandidateCreation extends BasePage {
	public CandidateCreation (WebDriver driver) {
		 super(driver);
	}
	
	
	@FindBy(xpath = "//span[@class='layout-menuitem-text ng-tns-c2428658477-13']")
	WebElement candidateclcik;
	
	public void candidatecr() {	
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(candidateclcik));
		candidateclcik.click();
	}
	
	
	
	
}
