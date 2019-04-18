package pageObjects;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.WebdriverUtils;

public class MakeBookingPage {

	@FindBy(xpath="//h1[text()='Make a booking']") private WebElement MakeABookingLabel;
	@FindBy(id="modifySearchButton") private WebElement ChangeSearchButton;
	@FindBy(xpath="//select/option[text()='Show all flights']") private WebElement ShowAllFlights;
	@FindBy(xpath="//div[@class='ts-fbr-flight-list__body']/div/div/div/div  [2]/div[1]/div[2]/div/p[contains(text(),'Lowest price')]/../strong[1]") private WebElement LowestPrice;
	
	public void pageToLoad(WebDriver driver)
	{
		WebdriverUtils.waitForElementPresent(driver, ChangeSearchButton);
	}
	
	public List<String> lowestPrice(WebDriver driver)
	{
	List<String> li=new ArrayList<>();
	WebElement lowestprice=driver.findElement(By.xpath("//div[@class='ts-fbr-flight-list__body']/div/div/div/div[2]/div[1]/div[2]/div/p[contains(text(),'Lowest price')]/../strong[1]"));
	WebdriverUtils.waitForElementPresent(driver, lowestprice);
	List<WebElement> lowestprices=driver.findElements(By.xpath("//div[@class='ts-fbr-flight-list__body']/div/div/div/div[2]/div[1]/div[2]/div/p[contains(text(),'Lowest price')]/../strong[1]"));
	for(WebElement e:lowestprices)
	{
		li.add(e.getText());
	}
	return li;
	}
	
}
