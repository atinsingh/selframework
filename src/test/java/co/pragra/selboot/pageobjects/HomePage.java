package co.pragra.selboot.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath="//a/span[.='Flights']")
	WebElement flightsButton;
	
	//WebElement flightAndHotelButton;
	
	//WebElement carRentalButton;
	
	@FindBy(id="ss")
	WebElement destinationInput;
	
	@FindBy(xpath="//form[@id='frm']/div[3]/div/div[1]/div[1]/div[@class='sb-date-field__wrapper']/div/div[1]/div/div[@class='sb-date-field__display']")
	WebElement checkinDate;
	
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public HomePage popuplateInputDestiNation(String destinameName){
		this.destinationInput.sendKeys(destinameName);
		return this;
	}
	
	public HomePage clearInputBox(){
		this.destinationInput.clear();
		return this;
	}
	
	public HomePage checkInDate(String monthandYear, String date){
		this.checkinDate.click();
		String path = "//table[@class='c2-month-table' and ./thead/tr/th[contains(.,'"+monthandYear+"')]]/tbody/tr/td";
		List<WebElement> checkInTable = driver.findElements(By.xpath(path));
		for(WebElement elm :checkInTable){
			if(elm.getText().equals(date)){
				elm.click();
			}
		}
		return this;
	}

	
}
