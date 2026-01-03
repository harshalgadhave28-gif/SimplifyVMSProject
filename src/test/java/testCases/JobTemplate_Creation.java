package testCases;

import org.testng.annotations.Test;

import PageObject.JobTemplateCreation;
import TestBase.BaseClass3;

public class JobTemplate_Creation extends BaseClass3{
	
	@Test
	public void Jobs() {
		JobTemplateCreation JT = new JobTemplateCreation(driver);
		JT.jobtemplate();
		JT.jobtemptitle();
		JT.vcode();
//		JT.jtype();
		JT.hirarselection();
		JT.PrimaryHierarchyselection();
		JT.descriptionclick();
	}
	
	
	
}
