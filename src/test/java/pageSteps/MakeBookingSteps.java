package pageSteps;

import java.util.List;

import org.openqa.selenium.WebDriver;

import pageObjects.MakeBookingPage;

public class MakeBookingSteps {


	MakeBookingPage page;
	WebDriver driver;
	
	public MakeBookingSteps(MakeBookingPage page, WebDriver driver) {
		this.page=page;
		this.driver=driver;
		this.page.pageToLoad(driver);
	}
	
	public List<String> displayLowestPrices(WebDriver driver)
	{
		return page.lowestPrice(driver);
	}

}
