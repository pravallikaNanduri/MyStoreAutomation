package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {
	private static SeleniumDriver seleniumDriver;
	private static WebDriver driver;
	private static WebDriverWait waitDriver;
	
	public final static Duration TIMEOUT = Duration.ofSeconds(20);
	public final static Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(10);
	
	public SeleniumDriver() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static WebDriverWait getWaitDriver() {
		SeleniumDriver.setWaitDriver();
		return waitDriver;
	}
	public static void setWaitDriver() {
		SeleniumDriver.waitDriver = new WebDriverWait(driver, TIMEOUT);
	}
	
	public static void openPage(String url) {
		
		driver.get(url);
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setUpDriver(WebDriver driver) {
		if(seleniumDriver==null) {
			seleniumDriver = new SeleniumDriver();
		}
	}
	
	public static void tearDown() {
		if(driver!=null) {
			driver.close();
			driver.quit();
		}
		seleniumDriver=null;
	}
	
	public static void takeScreenshot() {
	    try {
	    	TakesScreenshot ts = (TakesScreenshot) driver;
		    File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"/ScreenShots/Screenshot_"+new Date().getTime()+".png"));
		} catch (IOException e) {
			System.out.println("Exception while taking ScreenShot "+e.getMessage());
		}
	}
}
