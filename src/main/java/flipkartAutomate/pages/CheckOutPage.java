package flipkartAutomate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage{

	
	
//	@FindBy(xpath = "//div[@class='manufacturer_box']/div[2]")
//	WebElement removeButton;
//	
//	@FindBy(xpath="(//div[normalize-space()='Remove'])")
//	WebElement confirmRemove;
//	
	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(className="iIUzTJ")
	WebElement saveDisplay;
	
	
    private By removeButton = By.xpath("(//div[normalize-space()='Remove'])[1]");
    
    
    
    @FindBy(xpath="(//div[normalize-space()='Save for later'])[1]")
    WebElement saveButton;

    @FindBy(xpath="//div[@class='sBxzFz fF30ZI A0MXnh']")
    WebElement popupRemove;

    @FindBy(className="s2gOFd")
    WebElement emptyCart;
   
 
    public void removeProductFromCart() {
    	WebElement removeBtn = driver.findElement(removeButton);
    	removeBtn.click();
    	waitFun(driver,popupRemove);    	
    	popupRemove.click();
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void checkAddToFavourites() {
    	saveButton.click();
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public boolean isRemoveButtonDisplayed() {
    	WebElement removeBtn = driver.findElement(removeButton);
    	waitFun(driver,removeBtn);
    	return removeBtn.isDisplayed();
    	
    }
    
    public boolean isEmptyCartDisplayed() {
    	return emptyCart.isDisplayed();
    }
    
    public boolean isSaveDisplayed() {
    	waitFun(driver,saveDisplay);
    	return saveDisplay.isDisplayed();
    }
   
	
	
	
	
}
