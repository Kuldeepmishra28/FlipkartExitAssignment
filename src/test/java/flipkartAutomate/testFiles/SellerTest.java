package flipkartAutomate.testFiles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import flipkartAutomate.pages.HomePage;
import flipkartAutomate.pages.SellerPage;

public class SellerTest extends BaseTest{

	private Logger logger=LogManager.getLogger(SellerTest.class);
	
	@Test(priority=1)
	public void testSellerFunctionality() {
		if(driver == null) {
    		extentTest.log(Status.SKIP, "test skipped from hometest");
    		throw new SkipException("test skipped due to execution requirement");
 
    	}
		logger.info("Started testing seller login functionality.");
		extentTest = extentReports.createTest( "Test to login from seller account.");
		String credential= getTestData("testSellerFunctionality");
		
		HomePage homePage=new HomePage(driver);
		SellerPage sellerPage=new SellerPage(driver);
		try {
		homePage.clickSeller();
		sellerPage.checkSellerLogin(credential);
		
		Assert.assertTrue(sellerPage.isStatusDisplayed());
		 extentTest.log(Status.PASS, "Test passed to perform login as seller with invalid credentials.");
		 logger.info("Completed testing seller login functionality.");
		 
		}
		catch(Exception e){
			 extentTest.log(Status.FAIL, "Test failed to perform login as seller with invalid credentials.: " + e.getMessage());
			 logger.error("Error in testing seller login functionality. " + e.getMessage());
		}
		
	}
	
}
