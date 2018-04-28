package co.pragra.selboot.testscripts;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
		driver.get("http://pragra.co");
		//driver.get("https://www.cn.ca");
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		homepage = new HomePage(driver);
	}
	
	@Test
	public void testInputBoxWrite(){
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.findElement(By.name("ss")).sendKeys("Hawaii");
//	homepage.popuplateInputDestiNation("Paris")
//			.selectcheckInDate("April 2018", "29")
//			.selectChecoutDate("May 2018", "12")
//			.selectNumberOfAdult("2")
//			.selectTravelPurpose();
		
	}
	
	@Test  // Only 30 Option
	public void testtoCheckSize(){
		
//		WebElement adultSelect = homepage.getNumberOfAdults();
//	
//		
//		Select sel = new Select(adultSelect);
//		// I am checking I should see 30 option, i should not see more than 30.
//		Assert.assertEquals(sel.getOptions().size(), 30);
//		sel.selectByValue("12");
//		Assert.assertTrue(sel.getFirstSelectedOption().getText().contains("12"));
		
	}
	
	@Test
	public void testCheckBox(){
//		WebElement travelPurpose = driver.findElement(By.name("sb_travel_purpose"));
//		if(!travelPurpose.isSelected()){
//			travelPurpose.click();
//		}
//		
		
		//Assert.assertEquals(travelPurpose.getAttribute("value"), "business");
	}
	
//	@Test
//	public void testRadioButton(){
//		 WebElement female = driver.findElement(By.xpath("//input[@value='f']"));
//	        if (!female.isSelected()) {
//	        female.click();
//	        }  
//	        Assert.assertTrue(female.isSelected());    
//	}
//	
//	@Test
//	public void handleAllRadios(){
//		List<WebElement> radioGroup  = driver.findElements(By.xpath("//input[@type='radio' and @class='rbutton']"));
//		int enableButtons =0;
//		int disableButton = 0;
//		for(WebElement elm : radioGroup){
//			if(elm.isEnabled()){
//				enableButtons++;
//				System.out.println(" Button is enbled "+ elm.getText());
//			}else{
//				disableButton++;
//				System.out.println(" Button is not enbled "+ elm.getText());
//				elm.click();
//			}
//		}
//		
//		System.out.println("Enable is = "+ enableButtons + "and Disable is "+ disableButton);
//	}
//	
//	
//	@Test
//	public void testDoubleClick(){
//		WebElement button = driver.findElement(By.id("dblclik"));
//		Actions builder = new Actions(driver);
//		builder.doubleClick(button).perform();
//		WebElement span = driver.findElement(By.id("msg"));
//		Assert.assertTrue(span.getText().contains("Yeah"));
//	}
//	
//	@Test
//	public void testDragAndDrop(){
//		WebElement source = driver.findElement(By.id("draggable"));
//		WebElement target = driver.findElement(By.id("droppable"));
//		Actions builder = new Actions(driver);
//		builder.dragAndDrop(source, target).perform();
//		Assert.assertTrue(target.getText().contains("Dropped"));
//	}
//	
	@Test
	public void testAlert(){
		WebElement alertButton = driver.findElement(By.xpath("//body/div[8]/div[@class='row']/div[@class='col-4']/button[@class='btn btn-success']"));
		alertButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		driver.switchTo().alert();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(alert.getText(), "Enjoy737373");
		alert.dismiss();
	
	}
	
	@Test
	public void checkSlider(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement elm = wait.until(ExpectedConditions.elementToBeClickable(By.className("q_slider")));
		
		driver.findElement(By.className("q_slider"));
		driver.findElement(By.className("q_slider"));
		driver.findElement(By.className("q_slider"));
		driver.findElement(By.className("q_slider"));
		driver.findElement(By.className("q_slider"));
		driver.findElement(By.className("q_slider"));
		driver.findElement(By.className("q_slider"));
		driver.findElement(By.className("q_slider"));
		driver.findElement(By.className("q_slider"));
		
		
		
	}
	
	@Test
	public void test(){
		
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

	}
	
////	@Test
////	public void testInputBoxClear(){
////		homepage.clearInputBox();
////	}
//	
	
	/*
	 * Simulate the Mouse over
	 */
//	@Test
//	public void testMouseOver(){
//			
//		WebElement ourServiceLink = driver.findElement(By.id("ctl07_repMainNav_topLevelLink_1"));
//		
//		WebElement supplyChainLink = driver.findElement(By.id("ctl07_repMainNav_repSecondLevel_1_secondLevelLink_3"));
//		
//		WebElement marineLink = driver.findElement(By.id("ctl07_repMainNav_repSecondLevel_1_repThirdLevel_3_thirdLevelLink_4"));
//		
//		Actions builder = new Actions(driver);
//		builder.moveToElement(ourServiceLink).moveToElement(supplyChainLink).moveToElement(marineLink).click().perform();
//		
//		builder.perform();
//		
//		Assert.assertTrue(driver.getTitle().contains("Marine"));
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
}

