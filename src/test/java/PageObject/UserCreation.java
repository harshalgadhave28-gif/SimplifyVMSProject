package PageObject;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserCreation extends BasePage{
	public UserCreation(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//span[normalize-space()='User']")
	WebElement clickuser;
	
	@FindBy (xpath = "//div[@class='mt-2 menu_hover hover_blue subactive']//div[@class='d-flex align-items-center p_4 pl_12 line_height_26 cursor']")
	WebElement clickusers;
	
	@FindBy(xpath = "//span[@class='d-none d-md-flex']")
	WebElement createuser;
	
    private static final String BASE_EMAIL = "harshaltest@gmail.com";
    private static final AtomicInteger counter = new AtomicInteger(1);

	
//	public void clickofuser() {
//		new WebDriverWait(driver, Duration.ofSeconds(5))
//        .until(ExpectedConditions.elementToBeClickable(clickuser))
//        .click();
//		clickusers.click();
//		createuser.click();
//		
//	}
//	
    public void clickofuser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            // Click "User"
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(clickuser))).click();

            // Click "Users"
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(clickusers))).click();

            // Click "Create User"
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(createuser))).click();

        } catch (StaleElementReferenceException e) {
            System.out.println("⚠️ Element went stale, retrying...");

            // Re-locate elements manually if stale happens
            WebElement user = driver.findElement(By.xpath("//span[normalize-space()='User']"));
            WebElement users = driver.findElement(By.xpath("//span[normalize-space()='Users']"));
            WebElement createUser = driver.findElement(By.xpath("//span[@class='d-none d-md-flex']"));

            wait.until(ExpectedConditions.elementToBeClickable(user)).click();
            wait.until(ExpectedConditions.elementToBeClickable(users)).click();
            wait.until(ExpectedConditions.elementToBeClickable(createUser)).click();
        }
    }
	
	public String generateUniqueEmail() {
        // Example output: harshaltest+1730371285001@gmail.com
        int id = counter.getAndIncrement();
        long timestamp = Instant.now().getEpochSecond();
        return BASE_EMAIL.replace("@", "+" + timestamp + id + "@");
    }
}
