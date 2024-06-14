package flipkartAutomate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SellerPage extends BasePage{
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement sellerLogin;
	
    
	@FindBy(xpath="//input[@placeholder='Username or phone number or email']")
	WebElement enterCredential;
	
	@FindBy(xpath="//input[@placeholder='Enter password']")
	WebElement enterPassword;
	
	@FindBy(xpath="//span[normalize-space()='Next']")
	WebElement NextButton;
	
	@FindBy(xpath="//span[normalize-space()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@type='login-modal']")
	WebElement invalidStatus;
	
	@FindBy(xpath="//button[contains(text(),'Forgot Password?')]")
	WebElement forgerPasswordButton;
	
	@FindBy(xpath="//input[@placeholder='Registered Email Address']")
	WebElement emailInput;
	
	@FindBy(xpath="//span[contains(text(),'Send Password Reset link')]")
	WebElement resetButton;
	
	@FindBy(xpath="//button[contains(text(),'Back to login')]")
	WebElement resetConfirmation;
	
	
	public SellerPage(WebDriver driver) {
		super(driver);
	}
	
	public void checkSellerLogin(String credentials) {
		sellerLogin.click();
		waitFun(driver,enterCredential);
		
		String s[]=credentials.split(" ");
		
		
		enterCredential.sendKeys(s[0]);
		NextButton.click();
		waitFun(driver,enterPassword);
		enterPassword.sendKeys(s[1]);
		loginButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void checkForgetPassword(String credential) {
		sellerLogin.click();
		waitFun(driver,enterCredential);
		
		String s[]=credential.split(" ");
		
		
		enterCredential.sendKeys(s[0]);
		NextButton.click();	
		forgerPasswordButton.click();
		waitFun(driver,emailInput);
		emailInput.sendKeys(s[1]);
		resetButton.click();
	}
	
	public boolean isResetConfirm() {
		return resetConfirmation.isDisplayed();
	}
	
	
	public boolean isStatusDisplayed() {
		waitFun(driver,invalidStatus);
		return invalidStatus.isDisplayed();
	}
	
	
}
