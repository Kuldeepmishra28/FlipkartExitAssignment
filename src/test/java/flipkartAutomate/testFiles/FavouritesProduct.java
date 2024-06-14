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

public class FavouritesProduct extends BaseTest{

	private Logger logger=LogManager.getLogger(FavouritesProduct.class);
	@Test
	public void testFavouritesProduct() {
		if(driver == null) {
    		extentTest.log(Status.SKIP, "test skipped from hometest");
    		throw new SkipException("test skipped due to execution requirement");
 
    	}
		logger.info("Started testing save product to favourites.");
				extentTest = extentReports.createTest( "Test to check save product to favourites.");
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
		checkoutPage.checkAddToFavourites();
		
		Assert.assertTrue(checkoutPage.isSaveDisplayed());
		extentTest.log(Status.PASS, "Test passed to add product to the favourites");
		logger.info("Completed testing adding to favourites product. ");

		}
		catch(Exception e){
			 extentTest.log(Status.FAIL, "failed to save product to the favourites: " + e.getMessage());
			 logger.error("error in saving product to favourites. " + e.getMessage());
		}
	}
	
}
