package testCases;

import org.testng.annotations.Test;

import PageObject.RateType;
import TestBase.BaseClass3;

public class RateType_Cration extends BaseClass3{
	
	@Test
	 public void Rtcreation() {
		RateType RT= new RateType(driver);
		RT.Rates();
//		RT.checkVisibility();
		RT.Recodcheck();
		RT.RateTypeName();
		RT.RateTypeCategoury();
		RT.Ratetypefilternames();
	}

}
