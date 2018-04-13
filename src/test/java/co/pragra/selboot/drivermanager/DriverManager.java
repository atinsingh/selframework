package co.pragra.selboot.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import co.pragra.selboot.config.AppConfig;

public class DriverManager {
	private WebDriver driver;
	
	public DriverManager(){
		
	}
	
	public WebDriver getDriverInstance(){
		if(AppConfig.getProperty("browser-type").equalsIgnoreCase("chrome")){
			//Required by Selenium 
			System.setProperty("webdriver.chrome.driver", AppConfig.getProperty("chrome.executable"));
			driver = new ChromeDriver();
		}else
			if(AppConfig.getProperty("browser-type").equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", AppConfig.getProperty("firefox.executable"));
				driver = new FirefoxDriver();
			}else
		if(AppConfig.getProperty("broswer-type").equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", AppConfig.getProperty("edge.executable"));
			driver = new EdgeDriver();
		}
		//** Please collabrate to add other drivers
		return driver;
	}
}
