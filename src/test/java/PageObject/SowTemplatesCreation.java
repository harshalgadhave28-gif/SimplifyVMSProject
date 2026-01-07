package PageObject;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class SowTemplatesCreation extends BasePage{
	public  SowTemplatesCreation(WebDriver driver) {
		super(driver);
	}
	
	// locators  sow module 
	@FindBy(xpath = "//span[normalize-space()='SOW']")
	WebElement Sow;

	@FindBy(xpath = "//span[normalize-space()='SOW Templates']")
	WebElement SowTemplate;  // sowtempmoduleclick
	
	@FindBy(xpath = "//p[normalize-space()='SOW Template ID']")
	WebElement SOWTemplateID;
	
	@FindBy(xpath = "//p[normalize-space()='SOW Template Title']")
	WebElement SOWTemplateTitle;  // titles 

	@FindBy(xpath = "//p[normalize-space()='SOW Type']")
	WebElement SowType;   // 
	
	@FindBy(xpath = "//p[normalize-space()='Created on']")
	WebElement Createdon;
	
	@FindBy(xpath = "//input[contains(@class, 'fs_12') and @placeholder='SOW Template Title']")
	WebElement SOWtemptitle; //SOW Template Title
	
	@FindBy(xpath = "//input[contains(@class, 'fs_12') and @placeholder='SOW Template ID']")
	WebElement SOWTemplateIDD;  // SOW Template ID
	
	@FindBy(xpath = "//ng-select[@class='small arrow min-width ng-select-typeahead ng-select-searchable ng-select-clearable ng-select ng-select-single ng-pristine ng-valid ng-touched ng-select-bottom']//input[@type='text']")
	WebElement SOWType;
	
	@FindBy(xpath = "//i[normalize-space()='add']")
	WebElement CreatenewSowTemp;
	
	@FindBy(xpath = "//span[normalize-space()='Create New SOW Template']")
	WebElement CreateNewSOWTemplate;
	
	@FindBy(xpath = "//button[@id='sow-template-save-btn']")
	WebElement SaveSow;
	
	@FindBy(xpath = "//div[@aria-label='Please fill in all required fields.']")
	WebElement SOWSaveError;
	
	@FindBy(xpath = "//span[normalize-space()='SOW type is required.']")
	WebElement Sowtypeisrequired;
	
	@FindBy(xpath = "//span[normalize-space()='SOW template title is required.']")
	WebElement SOWTemplateTitlerequired;
	
	@FindBy(xpath = "//span[normalize-space()='Hierarchies is required.']")
	WebElement Hierarchiesrequired;
	
	@FindBy(xpath = "//span[normalize-space()='SOW description is required.']")
	WebElement descriptionmandatory;
	
	@FindBy(xpath = "//input[@aria-autocomplete='list']")
	WebElement SelectSowTypename;
	
	By dropdownoptions= By.xpath("//div[@role='option']//span");  
	@FindBy(xpath = "//input[@aria-autocomplete='list']")
	WebElement SSTclcik;
	
	@FindBy(xpath = "//input[@id='sow-template-title']")
	WebElement EnterSowTempTitle;
	
	@FindBy(xpath = "//input[@aria-autocomplete='list']")
	WebElement SOWTypeNme;
	
	@FindBy(xpath = "//span[contains(@class,'fs_13') and normalize-space()='Select Hierarchies']")
	WebElement SowHirearchySelection;
	
    @FindBy(xpath = "//div[@role='checkbox' and contains(@class,'p-checkbox-box')]")
    WebElement hirarchyslect;
	
    @FindBy(xpath = "//button[@id='sow-ai-generate-btn']")
    WebElement GenerateUsingAI;
    
    @FindBy(xpath = "//button[@id='sow-template-save-btn']")
    WebElement SowTempSave;
    
    @FindBy(xpath = "//div[@class='ql-editor ql-blank']//p")
    WebElement SowDescriptionadd;
    
//    @FindBy(xpath = "//label[@for='is_update_sow_desc']")  // toggal
//    WebElement AllowSOWDescriptionUpload;
//    
//    @FindBy(xpath = "//label[@for='is_sow_assignment']")
//    WebElement EnableSOWAssignments;
//
//    @FindBy(xpath = "//label[@for='enforcementtogg']")
//    WebElement EnforceMilestoneBudgetLimits;
//    
//    @FindBy(xpath = "//label[@for='enforcementtogg1']")
//    WebElement EnforceCompletionDate;

    
	public void sow() {     
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(Sow))).click();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(SowTemplate))).click();
        
	}
	
	public void sowlistingpage() {  // listing title check
		if(SOWTemplateTitle.isDisplayed()) {
			System.out.println("the SOW Template Title is visible");
		}else {
			System.out.println("the SOW Template Title is not visible");
		}
		
		if(SOWTemplateID.isDisplayed()) {
			System.out.println("the SOW Template ID is visible");	
		}else {
			System.out.println("the SOW Template ID is is not visible");
		}
		if(SowType.isDisplayed()) {
			System.out.println("Sow Type is visible");
		}else {
			System.out.println("Sow type is not visible");
		}
		if(Createdon.isDisplayed()) {
			System.out.println("Created On date is visible");
		}else {
			System.out.println("created on date is not visible");
		}
	}
    public void generateAndEnterRandomSOWTitle() {  // enter text in sow template title 
        // Generate random letters
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(SOWtemptitle));
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder randomText = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            randomText.append(letters.charAt(random.nextInt(letters.length())));
        }

        // Add random number
        int randomNumber = random.nextInt(1000);
        String randomTitle = randomText.toString() + "_" + randomNumber;

        // Enter into input field
        input.sendKeys(randomTitle);
        }
	
    public void generateAndEnterRandomSowTempId() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    	WebElement input = wait.until(ExpectedConditions.elementToBeClickable(SOWTemplateIDD));
    	String letteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    	StringBuilder randomText= new StringBuilder();
    	Random random = new Random();
    	for(int i = 0; i < 6; i++) {
    		randomText.append(letteres.charAt(random.nextInt(letteres.length())));
    	}
    	   // Add random number
        int randomNumber = random.nextInt(1000);
        String randomTitle = randomText.toString() + "_" + randomNumber;

        // Enter into input field
        input.sendKeys(randomTitle);
    }
    
    public void createnewsowtemp() {
    	CreatenewSowTemp.click();
    	if(CreateNewSOWTemplate.isDisplayed()) {
    		System.out.println("Create New SOW Template title is visible");
    	}
    	else {
    		System.out.println("Create New SOW Template is not visible");
    	}
    }
    
    public void SaveSowTemplate() {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	if(SaveSow.isDisplayed()) {
    		SaveSow.click();
    	}
    	try {
            WebElement errorMsg = wait.until(
            ExpectedConditions.visibilityOf(SOWSaveError));
            if(errorMsg.isDisplayed()){
            	System.out.println("Error is valid");
            	
            	// checking the error messages 
            	if (Sowtypeisrequired.isDisplayed()) {
            	System.out.println("Sow Template is required");	
            	} else {
            		System.out.println("Sow..................");
            	}
            	
            	if(SOWTemplateTitlerequired.isDisplayed()) {
            		System.out.println("SOW template title is required.");
            	} else {
            		System.out.println("sow ...........");
            	}
            	
            	if(Hierarchiesrequired.isDisplayed()) {
            		System.out.println("Hierarchies is required");
            	} else {
            		System.out.println("Hire........");
            	}
            	
            	if(descriptionmandatory.isDisplayed()) {
            		System.out.println("SOW description is required.");
            	} else {
            		System.out.println("SOW.....");
            	}
            	
            }
    	}catch(TimeoutException e){
    		 System.out.println("SOW Template saved successfully (No error shown)");
    	}
    	}
    
    public void sowtempleatetitleCreates() {   // sow template title creation
    	String names[]= {
    	"Standard SOW Template","Master SOW Template","Default SOW Agreement","Global SOW Template","Corporate SOW Template",
    	"IT Services SOW","Software Development SOW","Application Support SOW"
    	};
    	int randomindex= new Random().nextInt(names.length);
    	int randomnumber= new Random().nextInt(1000);
    	String GenerateRateType= names[randomindex]+randomnumber;
    	EnterSowTempTitle.sendKeys(GenerateRateType);
    	
    }
    
    public void SOWTypesnameee() {   // sow type selectionfrom dropdown
    	SSTclcik.click();
    	List<WebElement> optioins =driver.findElements(dropdownoptions);
	    int randomIndex = new Random().nextInt(optioins.size());
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	    wait.until(ExpectedConditions.elementToBeClickable(optioins.get(randomIndex)));
	    optioins.get(randomIndex).click(); 
	}
    
    public void SelectHierarchiesfromsow() {
    	SowHirearchySelection.click();
    	hirarchyslect.click(); 
//    	GenerateUsingAI.click();   for AI Generate Discription 
//    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//    	wait.until(ExpectedConditions.elementToBeClickable(SowTempSave));
    	SowDescriptionadd.sendKeys("discription");
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    	wait.until(ExpectedConditions.elementToBeClickable(SowTempSave)).click();
    }
//    public void selectConfigToggals() {
//    	AllowSOWDescriptionUpload.click();
//    	EnableSOWAssignments.click();
//    	EnforceMilestoneBudgetLimits.click();
//    	EnforceCompletionDate.click();	
//    }
    
    
    
    }
    
   
    
    
    



