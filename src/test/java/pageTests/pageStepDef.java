package pageTests;


import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.*;
import pageObjects.HomePage;
import pageObjects.MakeBookingPage;
import pageSteps.HomePageSteps;
import pageSteps.MakeBookingSteps;
import Utils.Dataset;
import Utils.WebdriverUtils;

public class pageStepDef {
	
	public WebDriver driver;
	public static FileInputStream fis=null;
	public static Properties appProperties=null;
	public HomePageSteps homepageSteps;
	public MakeBookingSteps makeBookingSteps;
	Dataset dataset;
	
	private final Logger log= Logger.getLogger("ManualLogger");
	
	static{
		BasicConfigurator.configure();	
			try {
					fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//app.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				appProperties=new Properties();
				try {
					appProperties.load(fis);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
	}
	
	@Given("^\"([^\"]*)\" launched in \"([^\"]*)\"$")
	public void launched_in(String application, String browser) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    try {
		switch (browser){
		case "chrome":
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver=new ChromeDriver();
			log.info("Browser Opened");
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "");
			driver=new FirefoxDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "");
			driver=new InternetExplorerDriver();
			break;
		}
		driver.get(appProperties.getProperty("application"));
		log.info("Application Launched Successfully");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    }catch (Exception e) {
			WebdriverUtils.captureScreenshot(driver);
			Assert.fail();
		}
	}

	@When("^search flights by source and destination for the day$")
	public void search_flights_by_source_and_destination_for_the_day(List<Dataset> inputValues) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		try {
		dataset=inputValues.get(0);
		homepageSteps=new HomePageSteps (PageFactory.initElements(driver, HomePage.class),driver);
		homepageSteps.searchFlights(driver,dataset);
		log.info("Entered Source, Destination & Date as " + dataset.getSrc() +" "+ dataset.getDest()+"  "+ dataset.getDay());
		} catch (Exception e) {
			WebdriverUtils.captureScreenshot(driver);
			Assert.fail();
		}
	}

	@Then("^display the lowest price$")
	public void display_the_lowest_price() throws Throwable {
		try {
		makeBookingSteps= new MakeBookingSteps(PageFactory.initElements(driver, MakeBookingPage.class),driver);
		System.out.println(makeBookingSteps.displayLowestPrices(driver));
		log.info("All the Lowest Price fetched and displayed successfully");
		log.info("Browsre Closed Successfully");
		driver.quit();
		}catch (Exception e) {
			WebdriverUtils.captureScreenshot(driver);
			Assert.fail();
		}
	}

}
