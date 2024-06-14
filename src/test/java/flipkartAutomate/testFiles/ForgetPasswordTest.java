package flipkartAutomate.testFiles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import flipkartAutomate.pages.HomePage;
import flipkartAutomate.pages.SellerPage;

public class ForgetPasswordTest extends BaseTest {

	private Logger logger=LogManager.getLogger(ForgetPasswordTest.class);
	@Test
	public void testForgetPassword() {
		if(driver == null) {
    		extentTest.log(Status.SKIP, "test skipped from hometest");
    		throw new SkipException("test skipped due to execution requirement");
 
    	}
		logger.info("Started testing forget password functionality.");
		extentTest = extentReports.createTest( "Test to check forgot password functionality");
		String credential= getTestData("testForgetPassword");
		
		HomePage homePage=new HomePage(driver);
		SellerPage sellerPage=new SellerPage(driver);
		try {
		homePage.clickSeller();
		sellerPage.checkForgetPassword(credential);
		
		Assert.assertTrue(sellerPage.isResetConfirm());
		extentTest.log(Status.PASS, "Test passed for checking forgot password functionality");
		logger.info("Completed testing forget password functionality. ");

		}
		catch(Exception e){
			 extentTest.log(Status.FAIL, "failed to execute forgot password functionality: " + e.getMessage());
			 logger.error("Error in forget password functionality." + e.getMessage());
		}
		}
	
}
