package tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;
import Utilities.BaseClass;
import Utilities.OpenToDoLink;

public class Negative_Test_Cases {
RemoteWebDriver driver;

	//setting up the browser and opening the application before the test starts
	@BeforeSuite
	public void openBrowser() {
		driver = BaseClass.getDriver();
		OpenToDoLink openingUrl = new OpenToDoLink(driver);
		openingUrl.openLink();
	}
	//Creating a task to use it as a test data for NegativeScenarios
	@BeforeTest
	public void createANewTask() {
		HomePage page = new HomePage(driver);
		page.createNewTask();		
	}
	//Negative Scenario: Entering an Empty Task
	@Test(priority=1)
	public void enterAnEmptyTask() {
		HomePage page = new HomePage(driver);
		page.enterAEmptyTask();		
	}
	//Negative Scenario: Entering a Task less than minimum allowed character.
	@Test(priority=2)
	public void enterTasklessThanMinAllowedChar() {
		HomePage page = new HomePage(driver);
		page.enterLessThanMinCharacter();
	}
	//Negative Scenario: Verify if Completed Task displays under Active Task List	
	@Test(priority=3)
	public void verifyCompletedTasksInActiveTaskList() {
		HomePage page = new HomePage(driver);
		page.checkActiveTaskList();
	}
	//Negative Scenario: Verify if Active Task displays under Completed Task List
	@Test(priority=4)
	public void verifyActiveTasksInCompletedTaskList() {
		HomePage page = new HomePage(driver);
		page.addTaskToCompletedTask();
	}
	//After the test completes Closing the browser and ending the session
	@AfterTest
	public void closeBroswer(){
	 BaseClass.closeBrowser(driver);		
	}
}
