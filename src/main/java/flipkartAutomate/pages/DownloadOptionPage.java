package flipkartAutomate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DownloadOptionPage extends BasePage {

	@FindBy(xpath="//img[@alt='Dropdown with more help links']")
	WebElement threeDotButton;
	
	@FindBy(xpath="//li[normalize-space()='Download App']")
	WebElement downloadOptionButton;
	
	@FindBy(xpath="//div[@class='n9nHoP']")
	WebElement iosOptionButton;
	
	@FindBy(xpath="//div[@class='+vOJ7l']")
	WebElement androidButton;
	
	public DownloadOptionPage(WebDriver driver) {
		super(driver);
	}
	
	public void checkAndroidDownloadFeatureVisibility() {
		threeDotButton.click();
		waitFun(driver,downloadOptionButton);
		downloadOptionButton.click();
		waitFun(driver,androidButton);
		androidButton.click();
	}
	
	public void checkIosDownloadFeatureVisibility() {
		threeDotButton.click();
		waitFun(driver,downloadOptionButton);
		downloadOptionButton.click();
		waitFun(driver,iosOptionButton);
		iosOptionButton.click();
	}
	
	public boolean isDownloadOptionDisplayed() {
		return androidButton.isDisplayed();
	}
	
}
