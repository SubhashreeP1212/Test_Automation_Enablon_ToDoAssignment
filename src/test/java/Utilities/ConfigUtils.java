package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
	
private Properties properties;
    
	private final String propertyFilePath= "./Config.properties";//path of property file
	//loading the property file using constructor
	public  ConfigUtils(){
    	FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 properties = new Properties();
		 
		//load properties file
		try {
			properties.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();		
	    }	
	}
	//Getting the browser details
	public  String getbrowser() {
		String browser=properties.getProperty("browser");
		return browser;
	}
	//Getting the URL
	public String geturl() {		
		String url=properties.getProperty("url");
		return url;
	}
	//Getting the first newTaskName
	public String getNewTaskName1() {		
		String taskName=properties.getProperty("taskname1");
		return taskName;		
	}
	//Getting the second newTaskName
	public String getNewTaskName2() {		
		String taskName=properties.getProperty("taskname2");
		return taskName;		
	}
	//Getting the Text to edit existing task
	public String geteditedText() {		
		String editedText=properties.getProperty("editedtext");
		return editedText;		
	}
	//getting Explicitwait time 
	public int getexplicitWaitTime() {		
		int waitTime =Integer.parseInt(properties.getProperty("explicitwait"));
		return waitTime;		
	}
	//getting ImplicitWait time 
	public int getimplicitWaitTime() {		
		int waitTime =Integer.parseInt(properties.getProperty("implicitwait"));
		return waitTime;		
	}
	//getting character or string not allowed for creating a task
	public String getbelowMinimumAllowedCharacter() {
		String minCharacter=properties.getProperty("mincharacter");		
		return minCharacter;
	}
}


