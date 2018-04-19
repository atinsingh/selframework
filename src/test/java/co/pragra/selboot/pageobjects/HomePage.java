package co.pragra.selboot.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	
	
	// Your assignment is to add checkoutDate
	@FindBy(xpath="//form[@id='frm']/div[3]/div/div[1]/div[2]/div[@class='sb-date-field__wrapper']/div/div[1]/div/div[@class='sb-date-field__display']")
	WebElement checkoutDate;
	
	@FindBy(id="group_adults")
	WebElement numberOfAdults;
	
	@FindBy(name="sb_travel_purpose")
	WebElement travelPurposeCheckBox;
	
	
	@FindBy(xpath = "//button/span[contains(text(),'Search')]")
	WebElement searchButton;
	
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public HomePage popuplateInputDestiNation(String destinameName){
		this.destinationInput.sendKeys(destinameName);
		this.destinationInput.sendKeys(Keys.TAB);
		return this;
	}
	
	public HomePage clearInputBox(){
		this.destinationInput.clear();
		return this;
	}
	


	
	/*
	 * This method is used to select the checkin date
	 * You need to pass 2 params 
	 * MonthandYear in specific format like "April 2018'
	 */
	
	public HomePage selectcheckInDate(String monthandYear, String date){
		this.checkinDate.click();
		this.selectCalander(monthandYear, date);
		return this;
	}
	
	public HomePage selectChecoutDate(String monthandYear, String date){
		this.checkoutDate.click();
		this.selectCalander(monthandYear, date);
		return this;
		
	}
	
	
	private void selectCalander(String monthandYear, String date){
		String path = "//table[@class='c2-month-table' and ./thead/tr/th[contains(.,'"+monthandYear+"')]]/tbody/tr/td";
		List<WebElement> dateTable = driver.findElements(By.xpath(path));

			for(WebElement elm :dateTable){
					if(elm.getText().equals(date)){
						elm.click();
					}
				}
				
	}
	
	public HomePage selectNumberOfAdult(String adults){
		Select adultSelect = new Select(this.numberOfAdults);
		adultSelect.selectByValue(adults);
		return this;
	}
	
	
	public HomePage selectTravelPurpose(){
		if(!this.travelPurposeCheckBox.isSelected()){
			this.travelPurposeCheckBox.click();
		}
		return this;
	}

	public HomePage clickSearchButton(){
		this.searchButton.click();
		return this;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFlightsButton() {
		return flightsButton;
	}

	public WebElement getDestinationInput() {
		return destinationInput;
	}

	public WebElement getCheckinDate() {
		return checkinDate;
	}

	public WebElement getCheckoutDate() {
		return checkoutDate;
	}

	public WebElement getNumberOfAdults() {
		return numberOfAdults;
	}

	public WebElement getTravelPurposeCheckBox() {
		return travelPurposeCheckBox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	
	
}
