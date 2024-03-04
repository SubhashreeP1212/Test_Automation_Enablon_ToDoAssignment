package Utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

 public class BaseClass {
  //starting a browser	
  public static RemoteWebDriver getDriver() {
		ConfigUtils config = new ConfigUtils();				
		String browser= config.getbrowser();//reading browser from propertyfile invoking functions in ConfigUtils
		RemoteWebDriver driver=null;
		
   //opening the browser as per the browser details mentioned in the propertyfile.
   		if(browser!=null&&browser.equals("chrome")) {
			driver=new ChromeDriver();//Initiates Chrome browser
		}
		else if(browser!=null&&browser.equals("firefox")) {
			driver=new FirefoxDriver();//Initiates Chrome browser
		}
		else if(browser!=null&&browser.equals("edge")) {
			driver=new EdgeDriver();//Initiates Chrome browser
		}
		else {
			driver=new ChromeDriver();//if no testdata provided then default browser is Chrome
		}
		//maximizing the browser
		driver.manage().window().maximize();//window will be maximized
		return driver;//returning the same browser instance that is initiated		
	}
  //Closing the browser
  public static void closeBrowser(RemoteWebDriver driver){	   
		driver.close();	//Closing the current browser window			
		driver.quit(); //ending the session
	} 
}
