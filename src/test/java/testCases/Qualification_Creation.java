package testCases;

import org.testng.annotations.Test;

import PageObject.QualificationCreation;
import TestBase.BaseClass3;

public class Qualification_Creation extends BaseClass3{
	
	@Test
	public void JobModule() {
		QualificationCreation QC= new QualificationCreation(driver);
		QC.jobs();
		QC.jovdetails();
	}
	
	

}
