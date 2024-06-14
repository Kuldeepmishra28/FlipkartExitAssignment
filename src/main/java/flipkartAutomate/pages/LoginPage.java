package flipkartAutomate.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	@FindBy(xpath="//input[@class='r4vIwl BV+Dqf']")
	WebElement loginInput;
	
	@FindBy(xpath="//button[@class='QqFHMw twnTnD _7Pd1Fp']")
	WebElement otpButton;
	
	@FindBy(className="azBkHf")
	WebElement signUpButton;
	
	@FindBy(xpath="//span[contains(text(),'Please enter valid Email ID/Mobile number')]")
	WebElement warningMessage;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}	
	
	public void enterLoginDetail(String phoneNo) {
		loginInput.sendKeys(phoneNo);
        otpButton.click();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isLoginDisplayed() {
		return loginInput.isDisplayed();
	}
	
	public void clickSignUpButton() {
		waitFun(driver,signUpButton);
		signUpButton.click();
	}
	
	public boolean isWarningMessageDisplayed() {
		waitFun(driver,warningMessage);
		return warningMessage.isDisplayed();
	}
	
	
}
