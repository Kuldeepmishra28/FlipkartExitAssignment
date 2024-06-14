package flipkartAutomate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PincodePage extends BasePage {

	
	
	@FindBy(xpath="//input[@placeholder='Enter pincode']")
	WebElement pincodeInput;
	
	@FindBy(xpath="//div[@class='kifljp']")
	WebElement pincodeHeader;
	
	public PincodePage(WebDriver driver) {
		super(driver);
	}
	
	public void enterPincode(String pincode) {
		pincodeInput.sendKeys(pincode);
		pincodeInput.submit();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean confirmPincode(String pincode) {
		return pincodeHeader.getText().contains(pincode);
	}
}
