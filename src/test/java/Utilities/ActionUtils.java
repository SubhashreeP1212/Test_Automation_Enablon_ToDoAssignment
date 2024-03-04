package Utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ActionUtils {
	private RemoteWebDriver driver;
    private Actions actions;
    //using constructor to instantiate the driver and action class object
    public ActionUtils(RemoteWebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }
    //action to move to a particular element
    public void moveToElementaction(WebElement element) {
        actions.moveToElement(element).perform();
    }
    //action to double click an element and send text and Keys
   public void doubleClickElementandSendKeys(WebElement element ,String text) {
	   actions.doubleClick(element).sendKeys(text).sendKeys(Keys.ENTER).build().perform();
   }  
}
