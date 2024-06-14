package flipkartAutomate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelplinePage extends BasePage{

	@FindBy(xpath="//img[@alt='Dropdown with more help links']")
	WebElement threeDotButton;
	
	@FindBy(xpath="//li[normalize-space()='24x7 Customer Care']")
	WebElement helplineButton;
	
	@FindBy(xpath="//span[normalize-space()='Delivery related']")
	WebElement deliveryEnquiryButton;
	
	@FindBy(xpath="(//p[contains(text(),\"What should I do if my order is approved but hasn'\")])[1]")
	WebElement userEnquiryTitle;
	
	@FindBy(xpath="//button[normalize-space()='Yes']")
	WebElement confirmButton;
	
	@FindBy(xpath="//button[normalize-space()='No']")
	WebElement negateButton;
	
	@FindBy(xpath="//button[normalize-space()='Information content is not helpful.']")
	WebElement negateReasonButton;
	
	@FindBy(xpath="//span[@class='HPOC3V']")
	WebElement statusMessage;
	
	public HelplinePage(WebDriver driver) {
		super(driver);
	}
	
	public void checkHelpline() {
		threeDotButton.click();
		waitFun(driver,helplineButton);
		helplineButton.click();
		waitFun(driver,deliveryEnquiryButton);
		deliveryEnquiryButton.click();
		waitFun(driver,userEnquiryTitle);
		userEnquiryTitle.click();
		waitFun(driver,confirmButton);
		confirmButton.click();
		
	}
	public void checkHelplineDisagreeFeature() {
		threeDotButton.click();
		waitFun(driver,helplineButton);
		helplineButton.click();
		waitFun(driver,deliveryEnquiryButton);
		deliveryEnquiryButton.click();
		waitFun(driver,userEnquiryTitle);
		userEnquiryTitle.click();
		waitFun(driver,negateButton);
		negateButton.click();
		waitFun(driver,negateReasonButton);
	    negateReasonButton.click();
	}
	
	public boolean isStatusMessageDisplayed() {
		return statusMessage.isDisplayed();
	}
	
}
