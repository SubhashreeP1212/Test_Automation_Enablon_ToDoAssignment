package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import Utilities.ConfigUtils;
import WebActions.TaskActions;

public class HomePage {
		
	private RemoteWebDriver driver;
	private TaskActions action;
	private ConfigUtils config;
		
	//initializing the driver object ,Action object and ConfigUTils object
	public HomePage(RemoteWebDriver driver) {
		this.driver = driver;
		this.action = new TaskActions(driver);
		this.config = new ConfigUtils();
	}
	//page class for all locators
	By taskInputField = By.id("todo-input");
	By markIndividualTask = By.cssSelector("input.toggle");
	By markAllCompleted = By.cssSelector("input.toggle-all");
	By taskName = By.cssSelector("label[data-testid='todo-item-label']");
	By incompleteTask = By.cssSelector("span.todo-count");
	By allTaskslink = By.xpath("//li/a[text()='All']");
	By activeTasksLink = By.xpath("//li/a[text()='Active']");
	By completedTasksLink = By.xpath("//li/a[text()='Completed']");
	By clearCompletedTasksButton = By.cssSelector("button.clear-completed");
	By deleteButton= By.cssSelector("button.destroy");
	By listOfFilters = By.xpath("//ul[@class='filters']/li");
	By listOfActiveTask = By.xpath("//ul[@class='todo-list']/li[@data-testid='todo-item']");
	By completedTaskList = By.xpath("//li[@class='completed']/div/input");
	By listOfAllTask = By.xpath("//ul[@class='todo-list']/li");
	
	
   //invoking create new task action
	public void createNewTask() {
		String newTaskName1 = config.getNewTaskName1();
		String newTaskName2 = config.getNewTaskName2();
		action.addANewTask(driver, taskInputField, newTaskName1,newTaskName2);		
		}
	//invoking edit existing task action
	public void editTaskName() {
		String newTaskName =config.getNewTaskName1();
		String editText=config.geteditedText();
		action.editTask(listOfAllTask,newTaskName, editText);
	}
	//invoking mark all task completed action
	public void markAllTaskCompleted() {
		action.markAllCompleted(driver, markAllCompleted);
	}
	//invoking mark an individual task completed action
	public void markIndividualTaskCompleted() {
		action.markIndividualTaskCompleted(driver, listOfAllTask, markIndividualTask, 0);
	}
	//invoking active task list action
	public void checkActiveTaskList() {
		action.getActiveTaskList(driver, listOfFilters, listOfActiveTask);
	}
	//invoking deleting a task action
	public void deleteATask() {
		action.deleteATask(driver,listOfAllTask, deleteButton, 0);
	}
	//invoking entering a empty task action
	public void enterAEmptyTask() {
		action.enterEmptyTask(driver, taskInputField);
	}
	//invoking validation to check min allowed character action
	public void enterLessThanMinCharacter() {
		String belowMinimumAllowedCharacter = config.getbelowMinimumAllowedCharacter();
		action.enterLessThanMinChar(driver, listOfAllTask, taskInputField,belowMinimumAllowedCharacter);		
	}
	//invoking validation of completedtasklist action
	public void addTaskToCompletedTask() {
		action.addTaskToCompletedTask(driver, completedTaskList);	
	}

}