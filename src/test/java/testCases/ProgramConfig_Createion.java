package testCases;

import org.testng.annotations.Test;

import PageObject.ProgramConfig;
import TestBase.BaseClass2;

public class ProgramConfig_Createion extends BaseClass2 {
	
	@Test
	public void proconfig() {
		ProgramConfig PC= new ProgramConfig(driver);
		PC.configs();
	}
}
