package flipkartAutomate.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	
	
//public static WebDriver setUpDriver() {
//	String browser=PropertyManager.getProperty("browser").toLowerCase();
//	  boolean headless = Boolean.parseBoolean(PropertyManager.getProperty("headless"));
//	  System.out.println(browser);
//	WebDriver driver;
//	if("firefox".equals(browser)) {
//		WebDriverManager.firefoxdriver().setup();
//		FirefoxOptions options=new FirefoxOptions();
//		if(headless) {
//			options.addArguments("--headless");
//		}
//		driver=new FirefoxDriver(options);
//	}else if("edge".equals(browser)) {
//		WebDriverManager.iedriver().setup();
//		EdgeOptions options=new EdgeOptions();
//		if(headless) {
//			options.addArguments("--headless");
//		}
//		driver=new EdgeDriver(options);
//	}else {
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options=new ChromeOptions();
//		if(headless) {
//			options.addArguments("--headless");
//		}
//		driver=new ChromeDriver(options);
//	}
//	driver.manage().window().maximize();
//	return driver;
//}
}
