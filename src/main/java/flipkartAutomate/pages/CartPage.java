package flipkartAutomate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	@FindBy(xpath="//span[normalize-space()='Login']")
	WebElement cartLoginButton;
	
	public CartPage(WebDriver driver) {
		super(driver);
	}	
	
	public void clickCartLoginButton() {
		cartLoginButton.click();
	}
	
	
}
