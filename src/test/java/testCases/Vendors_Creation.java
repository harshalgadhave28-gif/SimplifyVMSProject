package testCases;

import org.testng.annotations.Test;

import PageObject.VendorCreation;
import TestBase.BaseClass2;

public class Vendors_Creation extends BaseClass2{
	
	@Test
	public void vendorcre() {
		VendorCreation vc= new VendorCreation(driver);
		vc.vendorclick();
		vc.vendorcreation();
		vc.uploadfile();
		vc.selectcvndorname();
		vc.vcode();
		vc.continuebtn();
		vc.savebtn();
		}
	
}
