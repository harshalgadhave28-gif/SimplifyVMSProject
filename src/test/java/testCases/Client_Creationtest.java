package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import PageObject.ClientCreation;
import TestBase.BaseClass2;

public class Client_Creationtest extends BaseClass2{

	@Test 
	public void clientcreate() {
		ClientCreation cr= new ClientCreation(driver);
		cr.clientclick();
		cr.clientcreation();
//		cr.clientorgname("Vedant Industries");
		cr.seleclientname();
		cr.uploadfile();
		cr.clickconti();
     	driver.findElement(By.xpath("//ng-select[@placeholder='Select Country']//div[@class='ng-select-container']"));
		cr.selectRandomDropdown();
		cr.savebtnn();
		
	}
}
