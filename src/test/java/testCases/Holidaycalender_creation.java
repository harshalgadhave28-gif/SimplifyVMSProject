package testCases;

import org.testng.annotations.Test;

import PageObject.HolidayCalendes;
import TestBase.BaseClass2;

public class Holidaycalender_creation extends BaseClass2{
	@Test 
	public void holi() {
		HolidayCalendes hc=new HolidayCalendes(driver);
		hc.holidayclick();
		hc.calendarname();
		hc.year();
	}
	
	
	
}
