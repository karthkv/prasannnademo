package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtils {

	public static WebElement waitForElementPresent(WebDriver driver, WebElement element)
	{
		WebElement locater= (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(element));
		return locater;
	}
	
	public static void scrollToElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
		
	}
	
	public static void captureScreenshot(WebDriver driver) throws IOException
	{
		File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timeStamp= new SimpleDateFormat("dd_MM_yyyy_HM_mm_ss").format(Calendar.getInstance().getTime());
		String path=System.getProperty("user.dir")+"\\screenshots\\"+driver.getTitle()+timeStamp+".png";
		FileUtils.copyFile(screenshot, new File(path));
	}
}
