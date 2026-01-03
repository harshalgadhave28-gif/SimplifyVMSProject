package testCases;

import org.testng.annotations.Test;

import PageObject.RateConfig;
import TestBase.BaseClass2;

public class RateConfig_Creationtetst extends BaseClass2{
	
	@Test
	public void ratecon() {
		RateConfig RC= new RateConfig(driver);
		RC.ratecon();
	}
}
