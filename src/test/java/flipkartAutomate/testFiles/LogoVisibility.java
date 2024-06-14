package flipkartAutomate.testFiles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import flipkartAutomate.pages.HomePage;

public class LogoVisibility extends BaseTest {
	private Logger logger=LogManager.getLogger(LogoVisibility.class);
	
	@Test(priority = 1)
    public void testFlipkartLogoVisibility() {

		
    	if(driver == null) {
    		extentTest.log(Status.SKIP, "test skipped from hometest");
    		throw new SkipException("test skipped due to execution requirement");
 
    	}
    	logger.info("Started testing flipkart logo visibility.");

    	extentTest = extentReports.createTest( "Test to check logo is visible on loading");
        HomePage homePage = new HomePage(driver);
        
        try {
        	Assert.assertTrue(homePage.isFlipkartLogoVisible(), "Flipkart logo is not visible on the home page!");
            extentTest.log(Status.PASS, "flipkart logo is visible on the home page");
            logger.info("Completed testing logo visibility for flipkart.");
		} catch (AssertionError e) {
	        extentTest.log(Status.FAIL, "Assertion failed: " + e.getMessage());
	        logger.error("error in testing logo visibility: " + e.getMessage());
	        throw e;
		}
    }
	
}
