package testCases;

import org.testng.annotations.Test;

import PageObject.MspCreation;
import TestBase.BaseClass2;

public class Msp_Creation extends BaseClass2{
	@Test 
	
	public void verifylogin1() {
		MspCreation ad=new MspCreation(driver);
		ad.MspClick();
		ad.MspCretion();
		ad.OrganizationName("Mrf Industres");
		ad.continuebutton();
		ad.clickbutton();
		ad.uploadfile();
		
		
		
	}
	
}
