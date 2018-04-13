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
<<<<<<< HEAD
	public void testcase3(){
		System.out.println("Added for git");
	}

=======
	public void testCase5(){
		System.out.println("Added for git demo again");
	}


>>>>>>> 479f8777927b461eb7206e5beb1b518803890c98
	@Test
	public void testCase2(){
		System.out.println("Added after git");

	}
}
