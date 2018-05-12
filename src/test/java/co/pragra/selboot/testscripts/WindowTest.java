package co.pragra.selboot.testscripts;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import co.pragra.selboot.drivermanager.DriverManager;

public class WindowTest extends DriverManager {
	
	WebDriver driver = getDriverInstance();
	
	@BeforeTest
	public void setUp(){
		driver.get("https://pragra.co/sel.html");
	}
	
	@Test
	public void test1(){
		String currentWindow = driver.getWindowHandle();  // pragra.co/sel.html
		
		WebElement link = driver.findElement(By.id("window"));
		link.click();
		
//		WebElement link2 = driver.findElement(By.id("window1"));
//		link2.click();
		
		
		Set<String> windows = driver.getWindowHandles(); // give me all open windows --- it will include main window too or the window int he focus
		//for-- loop
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String window : windows){
			
			if(window.equals(currentWindow)){
				
			}else{
				driver.switchTo().window(window);
				
				WebElement discoverLink = driver.findElement(By.xpath("//li[@id='main_discover']/a[@href='discover.html']"));
				discoverLink.click();
				//driver.close();
				driver.switchTo().window(currentWindow);
		}
		
			
		}
		
				
	}
	
	@Test
	public void frameTest(){
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		
		int totalfram = frames.size();
		driver.switchTo().frame(0);
		driver.switchTo().frame(1);
		
		
		
		WebElement elm = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(elm);
		
		driver.findElement(By.xpath("//div[@class='wrapper_inner']/header//div[@class='header_top_bottom_holder']/div//a[@href='javascript:void(0)']/span[@class='icon_menu']")).click();
		
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("/html/body/div[8]/div[@class='row']/div[@class='col-4']/button[@class='btn btn-success']")).click();
	}
}
