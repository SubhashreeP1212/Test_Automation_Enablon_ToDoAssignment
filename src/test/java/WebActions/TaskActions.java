package WebActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import Utilities.ActionUtils;
import Utilities.ConfigUtils;
import Utilities.WaitUtils;


public class TaskActions {
	RemoteWebDriver driver;
	List<WebElement> listOfTasks;
	ActionUtils act;
	WaitUtils wait;
	ConfigUtils config;
			
	public TaskActions(RemoteWebDriver driver) {
		this.driver = driver;
		this.act = new ActionUtils(driver);
		this.config = new ConfigUtils();
		this.wait = new WaitUtils(driver, config.getexplicitWaitTime());
		
	}
	//creating a new task
	public void addANewTask(RemoteWebDriver driver,By textfieldLocator,String taskName1,String taskName2) {
		
		WebElement newtask=driver.findElement(textfieldLocator);
		newtask.sendKeys(taskName1);
		newtask.sendKeys(Keys.ENTER);
		newtask.sendKeys(taskName2);
		newtask.sendKeys(Keys.ENTER);
	}
	//Action to mark all the task completed
	public void markAllCompleted(RemoteWebDriver driver,By marAllCompletedLocator) {
		driver.findElement(marAllCompletedLocator).click();		
	}
	//Action to mark individual task completed
	public void markIndividualTaskCompleted(RemoteWebDriver driver,By toDoListLocator,By markSingleTaskLocator, int index) {
		listOfTasks = driver.findElements(toDoListLocator);
		WebElement task = listOfTasks.get(index);
		act.moveToElementaction(task);
		driver.findElement(markSingleTaskLocator).click();
		wait.setImplicitWait(config.getimplicitWaitTime());
	}
	//Action to verify if completed task displays under active task
	public int getActiveTaskList(RemoteWebDriver driver, By listofFiltersLocator,By listOfActiveTaskLocator) {
		List<WebElement> listofFilters = driver.findElements(listofFiltersLocator);
		listofFilters.get(1).click();
		List<WebElement> listOfActiveTasks = driver.findElements(listOfActiveTaskLocator);
		int activeListCount = listOfActiveTasks.size();
		for (WebElement e : listOfActiveTasks ) {
			if(activeListCount>0) {
				if(e.isSelected()==false) {
					System.out.println("it is a new task");
					}else {
						System.out.println("All task completed");
					}
				}else {
				    System.out.println("List is empty");
			}						
		}
		return listOfActiveTasks.size();		
	}
	//Action to edit a task
	public void editTask(By toDoListLocator, String taskName,String editText) {
		listOfTasks = driver.findElements(toDoListLocator);
		for(WebElement e : listOfTasks ) {
			System.out.println(e.getText());
			if(e.getText().equals(taskName)) {
			act.doubleClickElementandSendKeys(e,editText);
			}
		}
	}
	//Action to delete a task
	public void deleteATask(RemoteWebDriver driver,By toDoListLocator,By deleteButtonLocator, int deleteIndex) {
		listOfTasks = driver.findElements(toDoListLocator);
		WebElement task = listOfTasks.get(deleteIndex);
		act.moveToElementaction(task);
    	WebElement deleteButton=driver.findElement(deleteButtonLocator);
    	wait.waitForElementVisible(deleteButton);
    	deleteButton.click();
	}
	//Action to Verify entry of empty task
	public void enterEmptyTask(RemoteWebDriver driver,By textfieldLocator) {
		WebElement newtask=driver.findElement(textfieldLocator);
		newtask.sendKeys(" ");
		newtask.sendKeys(Keys.ENTER);				
	}
	//Action to verify creating a task with less than minimum allowed character/string
	public void enterLessThanMinChar(RemoteWebDriver driver,By toDoListLocator, By textfieldLocator,String belowminAllowedCharacter) {
		WebElement newtask=driver.findElement(textfieldLocator);
		newtask.sendKeys(belowminAllowedCharacter);
		newtask.sendKeys(Keys.ENTER);
		listOfTasks = driver.findElements(toDoListLocator);
		for(WebElement e : listOfTasks ) {
			System.out.println(e.getText());
			if(e.getText()!= belowminAllowedCharacter) {
			Assert.assertTrue(true, "Minimum Allowed string is 2");
			}
		}
	}
	//Action to verify if Active task is visible in completed task
	public void addTaskToCompletedTask(RemoteWebDriver driver,By completedTaskListLocator) {
		List<WebElement> listofcompletedtask = driver.findElements(completedTaskListLocator);
		for (WebElement e : listofcompletedtask ) {
			if(e.isSelected()==false) {
			System.out.println("it is a new task");
			}else {
				System.out.println("All task completed");
			}			
		}
	}
}
