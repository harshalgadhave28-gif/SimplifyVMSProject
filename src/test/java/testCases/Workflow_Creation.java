package testCases;

import org.testng.annotations.Test;

import PageObject.WrokflowCreation;
import TestBase.BaseClass2;

public class Workflow_Creation extends BaseClass2{
	
	@Test
	public void workflows() {
		WrokflowCreation WC=new WrokflowCreation(driver);
		WC.workclick();
		WC.workflowmoduleselect();
		WC.workflowcreationbtn();
	}
	
	
	
}
