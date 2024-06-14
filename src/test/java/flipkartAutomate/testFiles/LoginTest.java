package flipkartAutomate.testFiles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import flipkartAutomate.pages.HomePage;
import flipkartAutomate.pages.LoginPage;

public class LoginTest extends BaseTest{

	private Logger logger=LogManager.getLogger(LoginTest.class);
	@Test
	public void testInvalidLogin() {
		if(driver == null) {
    		extentTest.log(Status.SKIP, "test skipped from hometest");
    		throw new SkipException("test skipped due to execution requirement");
 
    	}
		
		logger.info("Started testing user login for invalid case.");

		extentTest = extentReports.createTest( "Test to check invalid login functionality");
		HomePage homepage=new HomePage(driver);
		LoginPage loginPage=new LoginPage(driver);
	  String credential = getTestData("testInvalidLogin");

	  try {
	 homepage.clickLoginButton();
	 loginPage.enterLoginDetail(credential);
	 
	 Assert.assertTrue(loginPage.isWarningMessageDisplayed());
	 extentTest.log(Status.PASS, "Test passed to check invalid login functionality");
	 logger.info("Completed testing user login for invalid case.");
		}
		catch(Exception e){
			 extentTest.log(Status.FAIL, "failed to perform invalid login functionality: " + e.getMessage());
			 logger.error("error in testing user login. " + e.getMessage());
		}
	  }
	
}
