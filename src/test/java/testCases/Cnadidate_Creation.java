package testCases;

import org.testng.annotations.Test;

import PageObject.CandidateCreation;
import TestBase.BaseClass3;

public class Cnadidate_Creation extends BaseClass3 {
	@Test
	public void Can() {
		CandidateCreation CC = new CandidateCreation(driver);
		CC.candidatecr();
	}
}
