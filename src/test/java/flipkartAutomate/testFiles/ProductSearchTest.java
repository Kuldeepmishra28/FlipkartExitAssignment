package flipkartAutomate.testFiles;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import flipkartAutomate.pages.HomePage;
import flipkartAutomate.pages.SearchResultPage;
import flipkartAutomate.utils.DriverManager;


public class ProductSearchTest extends BaseTest{
   
	private Logger logger=LogManager.getLogger(ProductSearchTest.class);
   
   @Test(priority=1)
   public void testSearchData() {
		if(driver == null) {
    		extentTest.log(Status.SKIP, "test skipped from hometest");
    		throw new SkipException("test skipped due to execution requirement");
 
    	}
		logger.info("Started testing valid product search functionality.");
		extentTest = extentReports.createTest( "Test to check whether a valid product is searched successfully");
	   String product = getTestData("testSearchData");
	  
	   HomePage homePage=new HomePage(driver);
	   SearchResultPage searchedPage=new SearchResultPage(driver);
	   try {
	   homePage.searchProduct(product);
       Assert.assertTrue(searchedPage.isSearchResultDisplayed());	   
       extentTest.log(Status.PASS, "Test passed to give valid product search result.");
       logger.info("Completed testing valid product search functionality.");
		}
		catch(Exception e){
			 extentTest.log(Status.FAIL, "Test failed to give valid product search result: " + e.getMessage());
			 logger.error("error in testing valid product search functionality: " + e.getMessage());
		}
	   }
 
   
   @Test(priority=2)
   public void testInvalidSearchData() {
		if(driver == null) {
   		extentTest.log(Status.SKIP, "test skipped from hometest");
   		throw new SkipException("test skipped due to execution requirement");

   	}
		logger.info("Started testing invalid product search functionality.");
		extentTest = extentReports.createTest( "Test to check an invalid product's search result. ");
	   String product = getTestData("testInvalidSearchData");
	  
	   HomePage homePage=new HomePage(driver);
	   SearchResultPage searchedPage=new SearchResultPage(driver);
	   try {
	   homePage.searchProduct(product);
	  Assert.assertTrue( searchedPage.isInvalidMessageDisplayed());
	  extentTest.log(Status.PASS, "Test passed to give proper result for an invalid search.");
	  logger.info("Completed testing invalid product search functionality.");
		}
		catch(Exception e){
			 extentTest.log(Status.FAIL, "Test failed to  give proper result for an invalid search: " + e.getMessage());
			 logger.error("error in testing invalid product search functionality: " + e.getMessage());
		}
	   }
   

}
   
	

