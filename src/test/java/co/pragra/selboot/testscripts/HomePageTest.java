package co.pragra.selboot.testscripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import co.pragra.selboot.drivermanager.DriverManager;
import co.pragra.selboot.listener.ScreenShotListener;
import co.pragra.selboot.pageobjects.HomePage;

@Listeners(ScreenShotListener.class)
public class HomePageTest extends DriverManager {
	
	WebDriver driver = getDriverInstance();
	
	HomePage homepage;
//	
//	@Test
//	@BeforeSuite
//	//@Parameters("url")
//	public void testSetup(){
//		
//		driver.manage().window().maximize();
//		driver.get("http://pragra.co/sel.html");
//		//driver.get("https://www.cn.ca");
//		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		homepage = new HomePage(driver);
//	}
//	
//	@Test
//	public void testInputBoxWrite(){
////		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
////		driver.findElement(By.name("ss")).sendKeys("Hawaii");
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
////		WebElement adultSelect = homepage.getNumberOfAdults();
////	
////		
////		Select sel = new Select(adultSelect);
////		// I am checking I should see 30 option, i should not see more than 30.
////		Assert.assertEquals(sel.getOptions().size(), 30);
////		sel.selectByValue("12");
////		Assert.assertTrue(sel.getFirstSelectedOption().getText().contains("12"));
//		
//	}
//	
//	@Test
//	public void testCheckBox(){
////		WebElement travelPurpose = driver.findElement(By.name("sb_travel_purpose"));
////		if(!travelPurpose.isSelected()){
////			travelPurpose.click();
////		}
////		
//		
//		//Assert.assertEquals(travelPurpose.getAttribute("value"), "business");
//	}
//	
////	@Test
////	public void testRadioButton(){
////		 WebElement female = driver.findElement(By.xpath("//input[@value='f']"));
////	        if (!female.isSelected()) {
////	        female.click();
////	        }  
////	        Assert.assertTrue(female.isSelected());    
////	}
////	
////	@Test
////	public void handleAllRadios(){
////		List<WebElement> radioGroup  = driver.findElements(By.xpath("//input[@type='radio' and @class='rbutton']"));
////		int enableButtons =0;
////		int disableButton = 0;
////		for(WebElement elm : radioGroup){
////			if(elm.isEnabled()){
////				enableButtons++;
////				System.out.println(" Button is enbled "+ elm.getText());
////			}else{
////				disableButton++;
////				System.out.println(" Button is not enbled "+ elm.getText());
////				elm.click();
////			}
////		}
////		
////		System.out.println("Enable is = "+ enableButtons + "and Disable is "+ disableButton);
////	}
////	
////	
////	@Test
////	public void testDoubleClick(){
////		WebElement button = driver.findElement(By.id("dblclik"));
////		Actions builder = new Actions(driver);
////		builder.doubleClick(button).perform();
////		WebElement span = driver.findElement(By.id("msg"));
////		Assert.assertTrue(span.getText().contains("Yeah"));
////	}
////	
////	@Test
////	public void testDragAndDrop(){
////		WebElement source = driver.findElement(By.id("draggable"));
////		WebElement target = driver.findElement(By.id("droppable"));
////		Actions builder = new Actions(driver);
////		builder.dragAndDrop(source, target).perform();
////		Assert.assertTrue(target.getText().contains("Dropped"));
////	}
////	
//	@Test
//	public void testAlert(){
//		WebElement alertButton = driver.findElement(By.xpath("//body/div[8]/div[@class='row']/div[@class='col-4']/button[@class='btn btn-success']"));
//		alertButton.click();
//		
//		WebDriverWait wait = new WebDriverWait(driver, 1);
//		
//	
//		
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		
//		driver.switchTo().alert();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		AssertJUnit.assertEquals(alert.getText(), "Enjoy");
//		alert.dismiss();
//	
//	}
//	
//	@Test
//	public void checkSlider(){
//		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
//		
//		//WebDriverWait wait = new WebDriverWait(driver, 10);
//		
//		//WebElement elm = wait.until(ExpectedConditions.elementToBeClickable(By.className("q_slider")));
//		
////		driver.findElement(By.className("q_slider"));
////		driver.findElement(By.className("q_slider"));
////		driver.findElement(By.className("q_slider"));
////		driver.findElement(By.className("q_slider"));
////		driver.findElement(By.className("q_slider"));
////		driver.findElement(By.className("q_slider"));
////		driver.findElement(By.className("q_slider"));
////		driver.findElement(By.className("q_slider"));
////		driver.findElement(By.className("q_slider"));
////		
//		
//		
//	}
//	
//	@Test
//	public void test(){
//		
//		
//
//	}
//	
//////	@Test
//////	public void testInputBoxClear(){
//////		homepage.clearInputBox();
//////	}
////	
//	
//	/*
//	 * Simulate the Mouse over
//	 */
////	@Test
////	public void testMouseOver(){
////			
////		WebElement ourServiceLink = driver.findElement(By.id("ctl07_repMainNav_topLevelLink_1"));
////		
////		WebElement supplyChainLink = driver.findElement(By.id("ctl07_repMainNav_repSecondLevel_1_secondLevelLink_3"));
////		
////		WebElement marineLink = driver.findElement(By.id("ctl07_repMainNav_repSecondLevel_1_repThirdLevel_3_thirdLevelLink_4"));
////		
////		Actions builder = new Actions(driver);
////		builder.moveToElement(ourServiceLink).moveToElement(supplyChainLink).moveToElement(marineLink).click().perform();
////		
////		builder.perform();
////		
////		Assert.assertTrue(driver.getTitle().contains("Marine"));
////	}
////	
//	@Test(dataProvider="dataProvider")
//	public void testCSVDriver(String firstName, String lastName, String r, String s, String f){
//			System.out.println("First Name "+firstName);
//			System.out.println("Last Name "+lastName);
//			System.out.println("City"+r);
//			System.out.println("Address"+s);
//			System.out.println("Another Vlaue"+f);
//	}	
//	
//	
//	//Test to Read from Excel
//	
////	@Test(dataProvider ="excelProvider")
////	public void testExcelReader(String username, String password){
////		System.out.println("UserName "+ username);
////		System.out.println("Password " + password);
////	}
//	
//	
//	//Reading CSV file 
//	
//	@DataProvider
//	private Iterator<String[]> dataProvider(){
//        // I am creating 2 Dimension array 
//		List<String[]> list = new ArrayList<>();
//        
//		try {
//			FileReader fileReader = new FileReader("/Users/atinsingh/Desktop/Test.csv");
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line = "";
//            
//            while((line=bufferedReader.readLine())!=null){
//            	// "My Name is Selenium".split(" ");  
//                String[] tokens = line.split(",");
//                list.add(tokens);
//            }
//            bufferedReader.close();
//        }catch (IOException ex){
//
//        }
//		
//        return  list.iterator();
//    }
//	
//	
//	
//	//Reading Excel using Apache POI
//	//Reading excel file is very simple using Apache POI, Apache POI is most advance library,
//	//Our scope is limited to read excel 
//	
//	@DataProvider
//	private Iterator<Object[]> excelProvider(){
//		
//		//Create ArrayList to hold data
//		List<Object[]> data = new ArrayList<>();
//		//Open File input stream to read file 
//		
//		try {
//			FileInputStream excel = new FileInputStream("/Users/atinsingh/Desktop/Data.xlsx");
//			// You have got file, convert into XSSWorkBook
//			Workbook excelBook = new XSSFWorkbook(excel);
//			// Now you have excel// Let get the sheet We are looking at 
//			Sheet loginsheet = excelBook.getSheet("LoginTest");
//			//Open a iterator to loop through sheet.
//			Iterator<Row> rows = loginsheet.rowIterator();
//			//Now lets loop 
//			// lets discard header by calling rows next()
//			rows.next();  //Skipping  the Header
//			//Lets add our cells to simple arrayList
//	
//			while(rows.hasNext()){
//				Row currentRow = rows.next();
//				// We have rows no we need cell iterator to for cells
//				Iterator<Cell> cells  = currentRow.cellIterator();
//				List<Object> cellList = new ArrayList<>();
//				while(cells.hasNext()){
//					Cell cell = cells.next();
//					if(cell.getCellTypeEnum() == CellType.NUMERIC){
//						cellList.add(cell.getNumericCellValue());
//					}else
//					if(cell.getCellTypeEnum() == CellType.STRING){
//						cellList.add(cell.getStringCellValue());
//					}
//					
//				}
//				
//				data.add(cellList.toArray());
//				
//			}
//			excelBook.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(data.toString());
//		return data.iterator();
//	}
//	
//	
//	//Take Screen Shot 
//
//	
//	@Parameters("url")
//	public void test2( String url){
//		Map<Integer , String> mymap = new HashMap<>();
//		mymap.put(1, "Atin");
//		mymap.put(2, "Vivek");
//		
//	}
//	
//	@AfterSuite
//	public void close(){
//		driver.quit();
//	}
	
	
	
	
	
}

