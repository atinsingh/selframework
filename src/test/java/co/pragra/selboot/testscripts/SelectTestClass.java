//package co.pragra.selboot.testscripts;
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
//
//public class SelectTestClass extends DriverManager {
//	
//	WebDriver driver = getDriverInstance();
//	
//	@BeforeSuite
//	public void setUp(){
//		driver.manage().window().maximize();
//		driver.get("file:///C:/Users/dhsengar/Desktop/select.html");
//	}
//	
//	@Test
//	public void testSelect(){
//		WebElement selectElm = driver.findElement(By.id("s12"));
//		Select sel = new Select(selectElm);
//		
//		//first Assertion
//		
//		Assert.assertTrue(sel.isMultiple());
//	
//		Assert.assertEquals(sel.getOptions().size(), 5);
//		
////		sel.selectByValue("in");
////		Assert.assertEquals(sel.getFirstSelectedOption().getText(), "India");
////		
//		
//		sel.selectByIndex(2);
//		sel.selectByValue("us");
//		
//		Assert.assertEquals(sel.getAllSelectedOptions().size(), 2);
//		
//	}
//}
