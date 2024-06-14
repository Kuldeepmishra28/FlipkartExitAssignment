package flipkartAutomate.testFiles;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import flipkartAutomate.pages.HomePage;
import flipkartAutomate.pages.PincodePage;


public class PincodeTest extends BaseTest {
	
	private Logger logger=LogManager.getLogger(PincodeTest.class);
	
	  private HomePage homepage;
	  private PincodePage pincodePage;
	
	
	   
	  @BeforeMethod
	  public void instanceSet() {
		   homepage=new HomePage(driver);
		   pincodePage=new PincodePage(driver);
	  }
	  
	  
	  @Test(priority=1)
	  public void testPincode() {
			if(driver == null) {
	    		extentTest.log(Status.SKIP, "test skipped from hometest");
	    		throw new SkipException("test skipped due to execution requirement");
	 
	    	}
			logger.info("Started testing valid pincode functionality.");

			extentTest = extentReports.createTest( "Test to check delivery pincode functionality");
		  String pincode = getTestData("testPincode");
	
		  try {
		  homepage.checkPincode();
		  pincodePage.enterPincode(pincode);
		 Assert.assertTrue(pincodePage.confirmPincode(pincode)); 
		 extentTest.log(Status.PASS, "Test passed to update valid pincode address");
		 logger.info("Completed testing valid pincode functionality.");
			}
			catch(Exception e){
				 extentTest.log(Status.FAIL, "Test failed to update valid pincode address: " + e.getMessage());
				 logger.error("error in testing valid pincode functionality: " + e.getMessage());
			}
		  }
	  
	  @Test(priority=2)
	  public void testIncorrectPincode() {
			if(driver == null) {
	    		extentTest.log(Status.SKIP, "test skipped from hometest");
	    		throw new SkipException("test skipped due to execution requirement");
	 
	    	}
			logger.info("Started testing invalid pincode functionality.");
			extentTest = extentReports.createTest( "Test to check delivery pincode functionality");
		  String pincode = getTestData("testIncorrectPincode");
	try {
		  homepage.checkPincode();
		  pincodePage.enterPincode(pincode);
		  Assert.assertFalse(pincodePage.confirmPincode(pincode)); 
		  extentTest.log(Status.PASS, "Test passed to not update invalid pincode address");
		  logger.info("Completed testing invalid pincode functionality.");
	}
	catch(Exception e){
		 extentTest.log(Status.FAIL, "Test failed for invalid pincode address: " + e.getMessage());
		 logger.error("error in testing invalid pincode functionality: " + e.getMessage());
	}
	}


}
