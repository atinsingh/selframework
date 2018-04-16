package co.pragra.selboot.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import co.pragra.selboot.drivermanager.DriverManager;
import co.pragra.selboot.pageobjects.HomePage;

public class HomePageTest extends DriverManager {
	
	WebDriver driver = getDriverInstance();
	
	HomePage homepage;
	
	@BeforeSuite
	public void testSetup(){
		driver.get("http://booking.com");
		homepage = new HomePage(driver);
	}
	
	@Test
	public void testInputBoxWrite(){
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.findElement(By.name("ss")).sendKeys("Hawaii");
		homepage.popuplateInputDestiNation("Hawaii").checkInDate("April 2018", "22");
	}
	
//	@Test
//	public void testInputBoxClear(){
//		homepage.clearInputBox();
//	}
}
