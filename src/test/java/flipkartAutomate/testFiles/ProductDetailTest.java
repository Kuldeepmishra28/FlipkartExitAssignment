package flipkartAutomate.testFiles;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import flipkartAutomate.pages.HomePage;
import flipkartAutomate.pages.ProductPage;
import flipkartAutomate.pages.SearchResultPage;

public class ProductDetailTest extends BaseTest{
 
	private Logger logger=LogManager.getLogger(ProductDetailTest.class);
	@Test
	public void testProductDetails() {
		if(driver == null) {
    		extentTest.log(Status.SKIP, "test skipped from hometest");
    		throw new SkipException("test skipped due to execution requirement");
 
    	}
		logger.info("Started testing product details functionality.");
		extentTest = extentReports.createTest( "Test to check the details of the searched product.");
		HomePage homePage=new HomePage(driver);
		SearchResultPage searchResultPage=new SearchResultPage(driver);
        ProductPage productPage=new ProductPage(driver);
        String productName= getTestData("testProductDetails");
        try {
		homePage.searchProduct(productName);
		searchResultPage.selectProduct();
		
		ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Assert.assertTrue(productPage.isProductDisplayed());
		 extentTest.log(Status.PASS, "Test passed to present the details of the searched product");
		 logger.info("Completed testing product details functionality.");
		}
		catch(Exception e){
			 extentTest.log(Status.FAIL, "Test failed to present the details of the searched product: " + e.getMessage());
			 logger.error("Error in testing product details functionality: " + e.getMessage());
		}
		
	}
}
