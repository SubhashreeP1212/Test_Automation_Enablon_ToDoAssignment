package Utilities;

import org.openqa.selenium.remote.RemoteWebDriver;

public class OpenToDoLink {
	
    private RemoteWebDriver driver;
    //constructor to instantiate driver and maintain a single driver instance
	public OpenToDoLink(RemoteWebDriver driver) {
		this.driver = driver;	
	}
	//Opening the application
	public void openLink(){
		ConfigUtils config = new ConfigUtils();
		String url=config.geturl();//sending url from propertyfile				
		driver.get(url);//Opening the link		
	}		
}
