package testCases;

import org.testng.annotations.Test;

import PageObject.FeeConfigCreation;
import TestBase.BaseClass2;

public class FeeConfig_Creationtest extends BaseClass2 {
	
	@Test
	public void feeees() {
		FeeConfigCreation FC= new FeeConfigCreation(driver);
		FC.feeconfiguration();
		FC.feeconfignames();
	}
	
}
