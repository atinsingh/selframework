package co.pragra.selboot.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import co.pragra.selboot.config.AppConfig;
import co.pragra.selboot.drivermanager.DriverManager;

public class TestClass extends DriverManager {

	WebDriver driver;
	
	@BeforeSuite
	public void setUp(){
		driver = getDriverInstance();
		driver.get(AppConfig.getProperty("site.url"));
	}
	
	
	@Test
	public void testcase1(){
		System.out.println("Alll Good");
	}
	
	@Test
	public void testCase5(){
		System.out.println("Added for git demo again");
	}
}
