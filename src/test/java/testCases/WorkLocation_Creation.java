package testCases;

import org.testng.annotations.Test;

import PageObject.WorkLocation;
import TestBase.BaseClass2;

public class WorkLocation_Creation extends BaseClass2{
	
	@Test 
	public void workloc() {
		WorkLocation WL= new WorkLocation(driver);
		WL.workclick();
		WL.createworklocation();
	}
	
	
}
