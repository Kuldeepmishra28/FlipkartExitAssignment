package flipkartAutomate.testFiles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import flipkartAutomate.pages.HomePage;
import flipkartAutomate.pages.LoginPage;
import flipkartAutomate.pages.SignupPage;


public class SignUpTest extends BaseTest {
	private Logger logger=LogManager.getLogger(SignUpTest.class);
	
	@Test(priority=1)
	public void testSignUp() {
		if(driver == null) {
    		extentTest.log(Status.SKIP, "test skipped from hometest");
    		throw new SkipException("test skipped due to execution requirement");
 
    	}
		logger.info("Started testing invalid signup functionality.");
		extentTest = extentReports.createTest( "Test to register using invalid credentials.");
		String credential= getTestData("testSignUp");
		HomePage homePage=new HomePage(driver);
	    LoginPage loginPage=new LoginPage(driver);
	    SignupPage signupPage=new SignupPage(driver);
	    try {
	    homePage.clickLoginButton();
	    loginPage.clickSignUpButton();
	    signupPage.enterSignupDetail(credential);
	
	   Assert.assertTrue(signupPage.isWarningDisplayed());
	   extentTest.log(Status.PASS, "Test passed to perform signup through an invalid credential.");
	   logger.info("Completed testing invalid signup functionality.");
		}
		catch(Exception e){
			 extentTest.log(Status.FAIL, "Test failed to perform signup through an invalid credential.: " + e.getMessage());
			 logger.error("error in testing invalid signup functionality: " + e.getMessage());
		}
	    }
	
}
