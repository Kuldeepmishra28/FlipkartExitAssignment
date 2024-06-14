package flipkartAutomate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipkartAdvertisePage extends BasePage{

	@FindBy(xpath="//img[@alt='Dropdown with more help links']")
	WebElement threeDotButton;
	
	@FindBy(xpath="//li[normalize-space()='Advertise']")
	WebElement advertiseButton;
	
	@FindBy(xpath="//input[@placeholder='Enter email']")
	WebElement emailInput;
	
	@FindBy(xpath="//input[@placeholder='Enter password']")
	WebElement passwordInput;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement loginBtn;
	
	
	public FlipkartAdvertisePage(WebDriver driver) {
		super(driver);
	}
	
	public void checkAdPage(String credential) {
		threeDotButton.click();
		waitFun(driver,advertiseButton);
		advertiseButton.click();
		String s[]=credential.split(" ");
		
		waitFun(driver,emailInput);
		emailInput.sendKeys(s[0]);
		passwordInput.sendKeys(s[1]);
		loginBtn.click();
	}
	public boolean verifyAdPage() {
		return driver.getTitle().contains("Ads");
	}
	
	
}
