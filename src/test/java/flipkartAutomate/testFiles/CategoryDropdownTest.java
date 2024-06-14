package flipkartAutomate.testFiles;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import flipkartAutomate.pages.HomePage;
import flipkartAutomate.pages.SearchResultPage;


public class CategoryDropdownTest extends BaseTest{

	private Logger logger=LogManager.getLogger(CategoryDropdownTest.class);
	  
	  @Test(priority=1)
	  public void testCategory() {
		  
		  if(driver == null) {
	    		extentTest.log(Status.SKIP, "test skipped from hometest");
	    		throw new SkipException("test skipped due to execution requirement");
	 
	    	}
		  logger.info("Started testing navigating  category.");
		  extentTest = extentReports.createTest( "Test to select product from category");
		  
		  try {
		  HomePage homePage=new HomePage(driver);
		  homePage.checkCategoryDropdown();
		  Assert.assertTrue(homePage.isCategoryProductDisplayed());
		  extentTest.log(Status.PASS, "Product is successfully retreived from category section");
		  logger.info("Completed testing categoryDropdownTest. ");
		  }
			catch(Exception e){
				 extentTest.log(Status.FAIL, "failed to open product category: " + e.getMessage());
				 logger.error("Error in navigating to product  category. : " + e.getMessage());
			}
	  }
	  
	
	  @Test(priority=2)
	public void testProductFromCategory() {
		  if(driver == null) {
	    		extentTest.log(Status.SKIP, "test skipped from hometest");
	    		throw new SkipException("test skipped due to execution requirement");
	 
	    	}
		  logger.info("Started testing navigating product through category.");
		  extentTest = extentReports.createTest( "Test to select product from category");
		  
		  try {
		  HomePage homePage=new HomePage(driver);
		  SearchResultPage searchPage=new SearchResultPage(driver);
		  
		  homePage.checkProductFromCategory();
		  Assert.assertTrue(searchPage.isProductHeaderDisplayed());
		  extentTest.log(Status.PASS, "Product is successfully retreived from category section");
		  logger.info("Completed testing categoryDropdownTest. ");
		  }
			catch(Exception e){
				 extentTest.log(Status.FAIL, "failed to find product from category: " + e.getMessage());
				 logger.error("Error in navigating to product through category. : " + e.getMessage());
			}
	  }
	  
	  
//	  @Factory
//	    public static Object[] createInstances() {
//	        Map<String, List<Object[]>> testMethodsToExecute = ExcelReader.getTestMethodsToExecute("Sheet1");
//
//	        // Debugging statement
//	        System.out.println("Selective cases are being executed.");
//
//	        List<Object[]> testCases = testMethodsToExecute.get("CategoryDropdownTest");
//	        Object[] instancesNull = new Object[1];
//	        if (testCases == null || testCases.isEmpty()) {
//	            // Handle the case where no test methods are marked for execution for this class
//	            System.out.println("No test methods marked for execution for AnotherTestClass.");
//	            instancesNull[0]= new CategoryDropdownTest("", ""); // Return an empty array to avoid instantiation error
//	            return instancesNull; // Return an empty array to avoid instantiation error
//	        }
//
//	        Object[] instances = new Object[testCases.size()];
//
//	        for (int i = 0; i < testCases.size(); i++) {
//	            String testCaseName = (String) testCases.get(i)[0];
//	            String testData = (String) testCases.get(i)[1];
//	            instances[i] = new CategoryDropdownTest(testCaseName, testData);
//	        }
//	        return instances;
//	    }

	  
	
}
