package flipkartAutomate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

//	
	@FindBy(xpath="(//button[normalize-space()='Add to cart'])[1]")
	WebElement addToCartBtn;
	
	@FindBy(xpath="(//div[@class='DOjaWF YJG4Cf'])[2]")
    WebElement productHeadline;
	
	
//	private By addToCartButton2 = By.xpath("(//button[normalize-space()='Add to cart'])[1]");
//	WebElement addToCartButton2;
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
    private By productTitle = By.xpath("(//img[@class='_53J4C-'])[1]") ;
    
    public String addToCart() {
        
 
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (!isElementInView(addToCartBtn)) {
            js.executeScript("window.scrollBy(0, 250);");
        }
 
        removeOverlays();
 
        waitFun(driver,addToCartBtn);
        
        WebElement titlElement = driver.findElement(productTitle);
        String title = titlElement.getText();
        System.out.println(title);
 
        addToCartBtn.click();
        
        return title;
    }
 
    private boolean isElementInView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (boolean) js.executeScript(
            "var rect = arguments[0].getBoundingClientRect(); " +
            "return (rect.top >= 0 && rect.left >= 0 && " +
            "rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && " +
            "rect.right <= (window.innerWidth || document.documentElement.clientWidth));",
            element);
    }
 
    private void removeOverlays() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
            "var overlays = document.getElementsByClassName('overlay-class-name');" +
            "for (var i = 0; i < overlays.length; i++) {" +
            "  overlays[i].style.display = 'none';" +
            "}");
    }

public boolean isProductDisplayed() {
	return productHeadline.isDisplayed();
	
}
	
}
