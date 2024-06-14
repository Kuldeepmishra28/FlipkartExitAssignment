package flipkartAutomate.testFiles;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import flipkartAutomate.pages.CheckOutPage;
import flipkartAutomate.pages.HomePage;
import flipkartAutomate.pages.ProductPage;
import flipkartAutomate.pages.SearchResultPage;

public class RemoveFromCartTest extends BaseTest {
  
	private Logger logger=LogManager.getLogger(RemoveFromCartTest.class);
	
	@Test
	public void testRemoveFromCart() {
		if(driver == null) {
    		extentTest.log(Status.SKIP, "test skipped from hometest");
    		throw new SkipException("test skipped due to execution requirement");
 
    	}
		logger.info("Started testing remove from cart functionality.");
		extentTest = extentReports.createTest( "Test to remove a product from the cart.");
		String productName= getTestData("testAddToCart");;
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
		checkoutPage.removeProductFromCart();
		
		Assert.assertTrue(checkoutPage.isEmptyCartDisplayed());
		 extentTest.log(Status.PASS, "Test passed to remove a product from the cart.");
		 logger.info("Completed testing remove from cart functionality.");
		}
		catch(Exception e){
			 extentTest.log(Status.FAIL, "Test failed to remove a product from the cart: " + e.getMessage());
			 logger.error("Error in testing remove from cart functionality: " + e.getMessage());
		}
		}
	
}
