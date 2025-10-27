package testCases;

import org.testng.annotations.Test;

import PageObject.HierarchiesCreation;
import TestBase.BaseClass2;

public class Hierarchies_Creation extends BaseClass2{
	
	@Test
	public void hirerchycre() {
	HierarchiesCreation HC= new HierarchiesCreation(driver);
	HC.clickhirer();
	HC.clickcreatnew();
	HC.selectionparnthirearchy();
	HC.hirarchymanageby();
	HC.clickcreatnew();
	HC.hirearchyname();
	}
}
