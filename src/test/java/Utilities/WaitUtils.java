package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	//instantiating driver and WebDriverWait object
	public WaitUtils(RemoteWebDriver driver,int seconds) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));	
	}	
	//Setting up implicit wait
	public void setImplicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));		
	}	
	//explicit wait for waiting till the element is visible
	public void waitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
