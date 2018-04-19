//package co.pragra.selboot.testscripts;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
//import co.pragra.selboot.drivermanager.DriverManager;
//import co.pragra.selboot.pageobjects.HomePage;
//
//public class HomePageTest extends DriverManager {
//	
//	WebDriver driver = getDriverInstance();
//	
//	HomePage homepage;
//	
//	@BeforeSuite
//	public void testSetup(){
//		
//		driver.manage().window().maximize();
//		driver.get("http://booking.com");
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		homepage = new HomePage(driver);
//	}
//	
//	@Test
//	public void testInputBoxWrite(){
//		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		//driver.findElement(By.name("ss")).sendKeys("Hawaii");
////	homepage.popuplateInputDestiNation("Paris")
////			.selectcheckInDate("April 2018", "29")
////			.selectChecoutDate("May 2018", "12")
////			.selectNumberOfAdult("2")
////			.selectTravelPurpose();
//		
//	}
//	
//	@Test  // Only 30 Option
//	public void testtoCheckSize(){
//		
//		WebElement adultSelect = homepage.getNumberOfAdults();
//	
//		
//		Select sel = new Select(adultSelect);
//		// I am checking I should see 30 option, i should not see more than 30.
//		Assert.assertEquals(sel.getOptions().size(), 30);
//		sel.selectByValue("12");
//		Assert.assertTrue(sel.getFirstSelectedOption().getText().contains("14"));
//		
//	}
//	
////	@Test
////	public void testInputBoxClear(){
////		homepage.clearInputBox();
////	}
//}
