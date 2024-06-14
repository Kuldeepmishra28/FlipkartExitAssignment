package flipkartAutomate.testFiles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import flipkartAutomate.pages.DownloadOptionPage;
import flipkartAutomate.pages.HelplinePage;

public class DownloadOptionTest extends BaseTest{

	private Logger logger=LogManager.getLogger(DownloadOptionTest.class);
	@Test(priority=1)
	public void testAndroidDownloadOption() {
		if(driver == null) {
    		extentTest.log(Status.SKIP, "test skipped from hometest");
    		throw new SkipException("test skipped due to execution requirement");
    	}
		logger.info("Started testing download option for android.");
		extentTest = extentReports.createTest( "Test to check download option visibility for android");
		try {
		DownloadOptionPage downloadPage=new DownloadOptionPage(driver);
		downloadPage.checkAndroidDownloadFeatureVisibility();
		
		Assert.assertTrue(downloadPage.isDownloadOptionDisplayed());
		extentTest.log(Status.PASS, "Download option is available for the android device");
		logger.info("Completed testing download option for android." );
		}
		catch(Exception e){
			 extentTest.log(Status.FAIL, "failed to find download option: " + e.getMessage());
			 logger.error("Error in testing download option for android. " + e.getMessage());
		}
	}
	
	@Test(priority=2)
	public void testIosDownloadOption() {
		if(driver == null) {
    		extentTest.log(Status.SKIP, "test skipped from hometest");
    		throw new SkipException("test skipped due to execution requirement");
    	}
		logger.info("Started testing download option visibility for iOS device.");
		 extentTest = extentReports.createTest( "Test to check download option visibility for iOS");
		 
		DownloadOptionPage downloadPage=new DownloadOptionPage(driver);
		try {
		downloadPage.checkIosDownloadFeatureVisibility();
		Assert.assertTrue(downloadPage.isDownloadOptionDisplayed());
		extentTest.log(Status.PASS, "Download option is available for the iOS device");
		logger.info("Completed testing download option for iOS. ");
		}
		catch(Exception e){
			 extentTest.log(Status.FAIL, "failed to find download option: " + e.getMessage());
			 logger.error("error in download option visibility for iOS." + e.getMessage());
		}
	}
	
}
