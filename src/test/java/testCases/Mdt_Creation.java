package testCases;

import org.testng.annotations.Test;

import PageObject.MasterDataType;
import TestBase.BaseClass2;

public class Mdt_Creation extends BaseClass2{

	@Test
	public void mdtcreations() {
		MasterDataType MDT= new MasterDataType(driver);
		MDT.clcikmdt();
		MDT.creatclick();
		MDT.mdtnames();
		MDT.mdtsavebtn();
	}
	
	
	
}
