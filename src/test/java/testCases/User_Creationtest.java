package testCases;

import org.testng.annotations.Test;

import PageObject.UserCreation;
import TestBase.BaseClass3;

public class User_Creationtest extends BaseClass3{
	@Test
	public void userss() {
		UserCreation UC= new UserCreation(driver);
		UC.clickofuser();
		UC.generateUniqueEmail();
		
	}
}
