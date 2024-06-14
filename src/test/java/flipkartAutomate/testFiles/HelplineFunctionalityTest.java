package flipkartAutomate.testFiles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import flipkartAutomate.pages.HelplinePage;

public class HelplineFunctionalityTest extends BaseTest{

	private Logger logger=LogManager.getLogger(HelplineFunctionalityTest.class);
	@Test(priority=1)
	public void testHelplineFeature() {
		if(driver == null) {
    		extentTest.log(Status.SKIP, "test skipped from hometest");
    		throw new SkipException("test skipped due to execution requirement");
    	}
		
		logger.info("Started testing helpline feature for agreeing.");
		extentTest = extentReports.createTest( "Test to check helpline enquiry functionality");
		HelplinePage helplinePage=new HelplinePage(driver);
		try {
		helplinePage.checkHelpline();
		
		Assert.assertTrue(helplinePage.isStatusMessageDisplayed());
		extentTest.log(Status.PASS, "Test passed to get helpline enquiry functionality");
		logger.info("Completed testing helpline feature for agreeing.");

		}
		catch(Exception e){
			 extentTest.log(Status.FAIL, "failed to perform helpline enquiry functionality: " + e.getMessage());
			 logger.error("error in testing helpline feature.: " + e.getMessage());
		}
	}
	
	@Test(priority=2)
	public void testHelplineDisagreeFeature() {
		if(driver == null) {
    		extentTest.log(Status.SKIP, "test skipped from hometest");
    		throw new SkipException("test skipped due to execution requirement");
    	}
		
		logger.info("Started testing helpline feature for disagreeing.");

		extentTest = extentReports.createTest( "Test to check helpline enquiry functionality");
		HelplinePage helplinePage=new HelplinePage(driver);
		try {
		helplinePage.checkHelplineDisagreeFeature();
		
		Assert.assertTrue(helplinePage.isStatusMessageDisplayed());
		extentTest.log(Status.PASS, "Test passed to get helpline enquiry functionality");
		logger.info("Completed testing helpline feature for disagreeing.");
		}
		catch(Exception e){
			 extentTest.log(Status.FAIL, "failed to perform helpline enquiry functionality: " + e.getMessage());
			 logger.error("error in testing helpline feature.: " + e.getMessage());
		}
		
	}
	
}
