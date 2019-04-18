package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.WebdriverUtils;

public class HomePage {

	@FindBy(xpath="//input[@name='Departure airport']") private WebElement DepartureAirport;
	@FindBy(xpath="//input[@name='Arrival airport']") private WebElement ArrivalAirport;
	@FindBy(xpath="//table[@class='ek-datepicker__table']/tbody/tr/td[contains(@class,'day--notselected')]/a") private WebElement DateNotSelected;	
	@FindBy(xpath="//table[@class='ek-datepicker__table']/tbody/tr/td[contains(@class,'day--notselected')]/a/../../../tr/td[@data-date='23']/a") private WebElement selecteddate;
	@FindBy(xpath="//label[@class='checkbox one-way']/input") private WebElement OneWay;
	@FindBy(xpath="//button[@type='submit']/span[text()='Search flights']") private WebElement SearchButton;
	@FindBy(xpath="//a/span[text()='Continue']") private WebElement ContinueButton;
	
	public void pageToLoad(WebDriver driver)
	{
		WebdriverUtils.scrollToElement(driver, ContinueButton);
		WebdriverUtils.waitForElementPresent(driver, SearchButton);
	}
	
	public void enterDeparture(String src)
	{
		DepartureAirport.click();
		DepartureAirport.sendKeys(src);
		DepartureAirport.sendKeys(Keys.TAB);
	}
	
	public void enterArrival(String des) throws Exception
	{
		ArrivalAirport.click();
		Thread.sleep(2000);
		ArrivalAirport.sendKeys(des);
		Thread.sleep(2000);
		ArrivalAirport.sendKeys(Keys.TAB);
	}
	
	public void selectDate(WebDriver driver, String date)
	{
	WebElement day= driver.findElement(By.xpath("//table[@class='ek-datepicker__table']/tbody/tr/td[contains(@class,'day--notselected')]/a/../../../tr/td[@data-date=\'"+date+"\']/a"));
	day.click();
	}
	
	public void clickOneWay()
	{
		OneWay.click();
	}
	public void clickSearchFlights(WebDriver driver)
	{
		WebdriverUtils.waitForElementPresent(driver, SearchButton);
		SearchButton.click();
	}
	
}
