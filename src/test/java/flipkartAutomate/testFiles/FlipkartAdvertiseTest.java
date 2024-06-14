package flipkartAutomate.testFiles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import flipkartAutomate.pages.FlipkartAdvertisePage;

public class FlipkartAdvertiseTest extends BaseTest {

	private Logger logger=LogManager.getLogger(FlipkartAdvertiseTest.class);
	@Test
	public void testAdvertise() {
		if(driver == null) {
    		extentTest.log(Status.SKIP, "test skipped from hometest");
    		throw new SkipException("test skipped due to execution requirement");
 
    	}
		logger.info("Started testing flipkart advertise page visibility.");
				extentTest = extentReports.createTest( "Test to check flipkart Ads page.");
				String credential= getTestData("testAdvertise");
				FlipkartAdvertisePage adPage=new FlipkartAdvertisePage(driver);
				try {
	            adPage.checkAdPage(credential);
	            Assert.assertTrue(adPage.verifyAdPage());
	            extentTest.log(Status.PASS, "Flipkart advertise page is visible.");
	   		 logger.info("Completed testing flipkart ads functionality.");
	   		}
	   		catch(Exception e){
	   			 extentTest.log(Status.FAIL, "failed to find flipkart ads page: " + e.getMessage());
	   			 logger.error("Error in accessing flipkart ads functionality. : " + e.getMessage());
	   		}
	}
}
