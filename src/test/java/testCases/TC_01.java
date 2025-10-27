package testCases;

import org.testng.annotations.Test;

import PageObject.LoginPage;
import TestBase.BaseClass;

public class TC_01 extends BaseClass{

	@Test
	public void verify_login() {
		LoginPage lp= new LoginPage(driver);
		lp.setUserName("admin");
		lp.setPassword("Admin@Simplify");
		lp.clicklogin();
	}
	
}
