package flipkartAutomate.testFiles;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import flipkartAutomate.pages.CartPage;
import flipkartAutomate.pages.HomePage;
import flipkartAutomate.pages.LoginPage;
//import flipkartAutomate.utils.ExcelReader;

public class CartLoginTest extends BaseTest {

	private Logger logger=LogManager.getLogger(CartLoginTest.class);
	
	@Test
	public void testCartLogin() {
		
		if(driver == null) {
    		extentTest.log(Status.SKIP, "test skipped from hometest");
    		throw new SkipException("test skipped due to execution requirement");
 
    	}
		logger.info("Started testing login through cart.");
		extentTest = extentReports.createTest( "Test to verify the login from cart page functionality");
		
		HomePage homePage=new HomePage(driver);
		CartPage cartPage=new CartPage(driver);
		LoginPage loginPage=new LoginPage(driver);
		
		try {
		homePage.clickCartButton();
		cartPage.clickCartLoginButton();
		assertTrue(loginPage.isLoginDisplayed());
		 extentTest.log(Status.PASS, "Login is available from the cart");
		 logger.info("Completed testing login through cart functionality.");
		}
		catch(Exception e){
			 extentTest.log(Status.FAIL, "failed to find login from cart: " + e.getMessage());
			 logger.error("Error in login through cart functionality. : " + e.getMessage());
		}
	}

//	@Factory
//    public static Object[] createInstances() {
//        Map<String, List<Object[]>> testMethodsToExecute = ExcelReader.getTestMethodsToExecute("Sheet1");
//
//        // Debugging statement
//        System.out.println("Selective cases are being executed.");
//
//        List<Object[]> testCases = testMethodsToExecute.get("CartTest");
//        Object[] instancesNull = new Object[1];
//        if (testCases == null || testCases.isEmpty()) {
//            // Handle the case where no test methods are marked for execution for this class
//            System.out.println("No test methods marked for execution for AnotherTestClass.");
//            instancesNull[0]= new CartTest("", ""); // Return an empty array to avoid instantiation error
//            return instancesNull; // Return an empty array to avoid instantiation error
//        }
//
//        Object[] instances = new Object[testCases.size()];
//
//        for (int i = 0; i < testCases.size(); i++) {
//            String testCaseName = (String) testCases.get(i)[0];
//            String testData = (String) testCases.get(i)[1];
//            instances[i] = new CartTest(testCaseName, testData);
//        }
//        return instances;
//    }

	
}
