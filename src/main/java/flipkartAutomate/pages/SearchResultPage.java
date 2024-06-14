package flipkartAutomate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

	@FindBy(className="_53J4C-")
	WebElement productSelectElement;
	
	@FindBy(className="BHPsUQ")
	WebElement invalidProductMessage;
	
	@FindBy(className="_7dPnhA")
	WebElement productHeader;
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	public void selectProduct() {
		waitFun(driver,productSelectElement);
		productSelectElement.click();
		
	}
	public boolean isSearchResultDisplayed(){
		return productSelectElement.isDisplayed();
	}
	
	public boolean isInvalidMessageDisplayed() {
		return invalidProductMessage.isDisplayed();
	}
	
	public boolean isProductHeaderDisplayed() {
		waitFun(driver,productHeader);
		return productHeader.isDisplayed();
	}
	
}
