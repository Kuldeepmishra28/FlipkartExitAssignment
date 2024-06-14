package flipkartAutomate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterSellerPage extends BasePage {

	@FindBy(xpath="//button[contains(text(),'Start Selling')]")
	WebElement startSellerButton;
	
	@FindBy(xpath="//input[@placeholder='Enter Mobile Number']")
	WebElement phoneNumber;
	
	@FindBy(xpath="//input[@placeholder='Enter Email ID']")
	WebElement emailInput;
	
	@FindBy(xpath="//label[@for='everything']")
	WebElement selectCategory;
	
	@FindBy(xpath="//input[@placeholder='Enter GSTIN']")
	WebElement gstInput;
	
	
	@FindBy(xpath="//span[contains(text(),'Register & Continue')]")
	WebElement registerButton;
	
	@FindBy(xpath="//p[contains(text(),'Invalid GSTIN. Please try again')]")
	WebElement postRegisterWarning;
	
	public RegisterSellerPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickStartRegistration() {
		startSellerButton.click();
	}
	
	public void enterSellerDetails(String sellerData) {
	
		waitFun(driver,phoneNumber);
		String data[]=sellerData.split(" ");
		phoneNumber.sendKeys(data[0]);
		emailInput.sendKeys(data[1]);
		selectCategory.click();
		gstInput.sendKeys(data[2]);
		registerButton.click();
		
	}
	
	public boolean isWarningDisplayed() {
		return postRegisterWarning.isDisplayed();
	}
	
	
}
