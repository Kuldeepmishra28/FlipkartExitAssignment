package flipkartAutomate.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(name="q")
	WebElement searchBox;
	
	@FindBy(className="_2iLD__")
	WebElement searchButton;
	
	@FindBy(xpath="//span[contains(text(),'Fashion')]")
	WebElement categoryButton;
	
	@FindBy(linkText="VIEW ALL")
	WebElement dropdownList;
	
	@FindBy(xpath="//div[@class='lF7HP0']")
	WebElement categoryProduct;
	
	@FindBy(xpath="//span[contains(text(),'Grocery')]")
	WebElement pincodeGrocery;
	
	@FindBy(xpath = "//img[@title='Flipkart']")
    WebElement flipkartLogo;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//img[@alt='Cart']")
	WebElement cartButton;
	
	@FindBy(xpath="//a[normalize-space()='Become a Seller']")
	WebElement sellerButton;
	
	@FindBy(className="DByuf4")
	WebElement productImageButton;
	
	
	
	public void checkCategoryDropdown() {
		waitFun(driver,categoryButton);
		categoryButton.click();
		waitFun(driver,dropdownList);
		dropdownList.click();
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
	}	
	
	public String navigateToHome(String url) {
		return url;
	}
	
	public void searchProduct(String productName) {
	
		searchBox.sendKeys(productName);
		searchBox.submit();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	  public boolean isFlipkartLogoVisible() {
	       waitFun(driver,flipkartLogo);
	        return flipkartLogo.isDisplayed();
	    }
	
	
	public void checkPincode() {
		waitFun(driver,pincodeGrocery);
		pincodeGrocery.click();
		
	}
	
	public void clickLoginButton() {
		waitFun(driver,loginButton);
		loginButton.click();
	}
	
	public void clickCartButton() {
		waitFun(driver,cartButton);
		cartButton.click();
	}
	
	public void clickSeller() {
		waitFun(driver,sellerButton);
		sellerButton.click();
		
	}
	public void checkProductFromCategory() {
		checkCategoryDropdown();
		waitFun(driver,productImageButton);
		productImageButton.click();
	}
	
	
	public boolean isCategoryProductDisplayed() {
		return categoryProduct.isDisplayed();
	}
	
}
