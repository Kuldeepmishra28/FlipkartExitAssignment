package flipkartAutomate.testFiles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import flipkartAutomate.pages.HomePage;
import flipkartAutomate.pages.RegisterSellerPage;
import flipkartAutomate.pages.SellerPage;

public class RegisterSellerTest extends BaseTest{
	private Logger logger=LogManager.getLogger(RegisterSellerTest.class);
	
	@Test
	public void testSellerRegistration() {
		if(driver == null) {
    		extentTest.log(Status.SKIP, "test skipped from hometest");
    		throw new SkipException("test skipped due to execution requirement");
 
    	}
		logger.info("Started testing seller registration functionality.");
		
		extentTest = extentReports.createTest( "Test to check registration for a seller on the portal.");
		String sellerData= getTestData("testSellerRegistration");
		HomePage homePage=new HomePage(driver);
		SellerPage sellerPage=new SellerPage(driver);
		try {
		homePage.clickSeller();
		RegisterSellerPage registerSellerPage=new RegisterSellerPage(driver);
		registerSellerPage.clickStartRegistration();
		registerSellerPage.enterSellerDetails(sellerData);
		
		Assert.assertTrue(registerSellerPage.isWarningDisplayed());
		 extentTest.log(Status.PASS, "Test passed to register a seller on flipkart.");
		 logger.info("Completed testing register seller functionality.");
		}
		catch(Exception e){
			 extentTest.log(Status.FAIL, "Test failed to register a seller on flipkart: " + e.getMessage());
			 logger.error("error in testing seller registration functionality: " + e.getMessage());
		}
	}

}
