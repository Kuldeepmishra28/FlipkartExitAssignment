package flipkartAutomate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage{

	@FindBy(xpath="//input[@class='r4vIwl BV+Dqf']")
	WebElement phoneInput;
	
	@FindBy(xpath="//span[contains(text(),'CONTINUE')]")
	WebElement continueButton;
	
	@FindBy(xpath="//input[@class='r4vIwl BV+Dqf']")
	WebElement otpInput;
	
	@FindBy(xpath="//span[contains(text(),'Signup')]")
	WebElement signUpButton;
	
	@FindBy(xpath="//span[contains(text(),'Please enter valid OTP')]")
	WebElement actionWarning;
	
	public SignupPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterSignupDetail(String userData) {
		
		waitFun(driver,phoneInput);
		
		String s[]=userData.split(" ");
		
		
		phoneInput.sendKeys(s[0]);
		continueButton.click();
		waitFun(driver,otpInput);
		otpInput.sendKeys(s[1]);
		signUpButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean isWarningDisplayed() {
		waitFun(driver,actionWarning);
		return actionWarning.isDisplayed();
	}
	
	
}
