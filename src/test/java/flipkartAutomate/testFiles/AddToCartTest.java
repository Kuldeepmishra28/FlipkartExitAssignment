package flipkartAutomate.testFiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import flipkartAutomate.pages.CheckOutPage;
import flipkartAutomate.pages.HomePage;
import flipkartAutomate.pages.ProductPage;
import flipkartAutomate.pages.SearchResultPage;


public class AddToCartTest extends BaseTest {

	private Logger logger=LogManager.getLogger(AddToCartTest.class);
	 
	
	@Test
	public void testAddToCart() {
		if(driver == null) {
    		extentTest.log(Status.SKIP, "test skipped ");
    		throw new SkipException("test skipped due to execution requirement");
 
    	}
		logger.info("Started testing add to cart functionality");
		extentTest = extentReports.createTest( "Test to verify the add to cart functionality");
		
		String productName= getTestData("testAddToCart");
		HomePage homePage=new HomePage(driver);
		SearchResultPage searchResultPage=new SearchResultPage(driver);
		ProductPage productPage=new ProductPage(driver);
		CheckOutPage checkoutPage=new CheckOutPage(driver);
	
		try {
		homePage.searchProduct(productName);
		searchResultPage.selectProduct();
		
		ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		productPage.addToCart();
		Assert.assertTrue(checkoutPage.isRemoveButtonDisplayed());
		  extentTest.log(Status.PASS, "Product is successfully added to the cart");
		  logger.info("Completed testing add to cart functionality successfully. ");
		}
		catch(Exception e){
			 extentTest.log(Status.FAIL, "failed to add to cart: " + e.getMessage());
			 logger.error("Error in add to cart method  : " + e.getMessage());
		}
	}
	
	
	
}
