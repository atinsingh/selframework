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
		
		driver.manage().window().maximize();
		driver.get("http://booking.com");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		homepage = new HomePage(driver);
	}
	
	@Test
	public void testInputBoxWrite(){
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.findElement(By.name("ss")).sendKeys("Hawaii");
		homepage.popuplateInputDestiNation("Paris").checkInDate("April 2018", "29");
		homepage.selectNumberOfAdult("10");
	}
	
//	@Test
//	public void testInputBoxClear(){
//		homepage.clearInputBox();
//	}
}
