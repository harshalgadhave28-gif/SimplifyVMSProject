package PageObject;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QualificationCreation extends BasePage{
	
	public QualificationCreation(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='Job']")
	WebElement jobclick;
	
	@FindBy(xpath = "//span[normalize-space()='Qualifications']")
	WebElement qualificationclick;
	
	@FindBy(xpath = "//button[@class='c-btn c-btn-primary-medium-left-icon mr_8 d-flex align-items-center ng-star-inserted']")
	WebElement createqualification;
	
	@FindBy(xpath = "//input[@placeholder='Enter Qualification Type Name']")
	WebElement Qualificationtypename;
	
	@FindBy(xpath = "//input[@placeholder='Enter Qualification Type Code']")
	WebElement QualificationCode;
	
	
	public void jobs() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//span[normalize-space()='Qualifications']")
		));
		element.click();
		qualificationclick.click();
		createqualification.click();
	}
	
	public void jovdetails() {
		String qualificationtype[]= {"Bachelor’s Degree","Master’s Degree","Doctorate / Ph.D.","Microsoft Certified (AZ-900, etc.)","Oracle Certified Java Programmer","CCNA (Networking)","Digital Marketing Certificate","PGDM"};
		int noqualification= new Random().nextInt(qualificationtype.length);
		int ranno= new Random().nextInt(1000);
		String generatrandomname= qualificationtype[noqualification]+ranno;
		Qualificationtypename.sendKeys(generatrandomname);
	}
	
	public void Qualificcode() {
		  int code = (int)(Math.random() * 9000) + 1000;
	        String qualificationCode = String.valueOf(code);
	        System.out.println(qualificationCode);
	        
	        // Enter in field
	        QualificationCode.sendKeys(qualificationCode);
	    }

	
}
