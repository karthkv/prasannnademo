package pageSteps;

import org.openqa.selenium.WebDriver;

import Utils.Dataset;
import pageObjects.HomePage;

public class HomePageSteps {

	HomePage page;
	WebDriver driver;
	
	public HomePageSteps(HomePage page, WebDriver driver) {
		this.page=page;
		this.driver=driver;
		this.page.pageToLoad(driver);		
	}
	
	public void searchFlights(WebDriver driver, Dataset ds) throws Exception
	{
		page.enterDeparture(ds.getSrc());
		page.enterArrival(ds.getDest());
		page.selectDate(driver, ds.getDay());
		page.clickOneWay();
		page.clickSearchFlights(driver);
	}
	
}
