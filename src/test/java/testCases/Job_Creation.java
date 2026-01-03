package testCases;

import org.testng.annotations.Test;

import PageObject.JobCreation;
import TestBase.BaseClass3;

public class Job_Creation extends BaseClass3{
	@Test
	public void jobbbC() {
		JobCreation JC= new JobCreation(driver);
		JC.jobprocess();
		JC.jobmanager();
		JC.jobtype();
		JC.worklocation();
		JC.Managedymsp();
	}

}
