package flipkartAutomate.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void waitFun(WebDriver driver, WebElement element ) {
		 Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
