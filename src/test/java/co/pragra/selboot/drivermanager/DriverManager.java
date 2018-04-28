package co.pragra.selboot.drivermanager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import co.pragra.selboot.config.AppConfig;

public class DriverManager {
	
	
	
	private static WebDriver driver;
	private static final Logger logger = Logger.getLogger(DriverManager.class);
	
	public DriverManager(){
		
	}
	
	public WebDriver getDriverInstance(){
		if(driver == null ){
			if(AppConfig.get("browser-type").isEmpty()||AppConfig.get("browser-type")==null){
				logger.info("Browser Type is missing please set a browser type to one of the following- [chrome,firefox]");
			}
			if(AppConfig.get("browser-type").equalsIgnoreCase("chrome")){
				logger.info("Following are the properties for chrome"+ AppConfig.get("chrome.executable"));
				System.setProperty("webdriver.chrome.driver", AppConfig.get("chrome.executable"));
				driver = new ChromeDriver();
			}else
				if(AppConfig.get("browser-type").equalsIgnoreCase("firefox")){
					System.setProperty("webdriver.gecko.driver", AppConfig.get("firefox.executable"));
					driver = new FirefoxDriver();
				}else
			if(AppConfig.get("broswer-type").equalsIgnoreCase("edge")){
				System.setProperty("webdriver.edge.driver", AppConfig.get("edge.executable"));
				driver = new EdgeDriver();
			}
		}
		//** Please collabrate to add other drivers
		return driver;
	}
}
