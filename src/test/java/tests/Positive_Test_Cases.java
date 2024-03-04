package tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pages.HomePage;
import Utilities.BaseClass;
import Utilities.OpenToDoLink;

public class Positive_Test_Cases {
	RemoteWebDriver driver;
	
	//setting up the browser and opening the application before the test starts
	@BeforeSuite
	public void openBrowser() {
		driver = BaseClass.getDriver();
		OpenToDoLink openingUrl = new OpenToDoLink(driver);
		openingUrl.openLink();
	}
	//Positive Scenario:Create a New Task
	@Test(priority=1)
	public void createANewTask() {
		HomePage page = new HomePage(driver);
		page.createNewTask();		
	}
	//Positive Scenario: Edit an existing Task
	@Test(dependsOnMethods = "createANewTask",priority=2)
	public void editExistingTask() {
		HomePage page = new HomePage(driver);
		page.editTaskName();		
	}
	//Positive Scenario: Mark an individual Task Completed	
	@Test(priority=3)
	public void MarkSingleTaskCompleted() {
		HomePage page = new HomePage(driver);
		page.markIndividualTaskCompleted();
	}
	//Positive Scenario: Mark All the Tasks Completed
	@Test(priority=4)
	public void MarkALLTaskCompleted() {
		HomePage page = new HomePage(driver);
		page.markAllTaskCompleted();
	}
	//Positive Scenario: Delete A Task
	@Test(priority=5)
	public void DeleteATask() {
		HomePage page = new HomePage(driver);
		page.deleteATask();
	}	
	//After the test completes Closing the browser and ending the session
	@AfterTest
	public void closeBroswer(){
	 BaseClass.closeBrowser(driver);		
	}
}
