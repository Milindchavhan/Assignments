package utility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Waits {
	
	WebDriver driver;
	WebDriverWait wait;
	public Waits(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,15);
	}
	
	public void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	public void fluentWait(final By locator)
	{
	 Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
			 	.withTimeout(Duration.ofSeconds(100))
		        .pollingEvery(Duration.ofMillis(600)).ignoreAll(new ArrayList<Class<? extends Throwable>>() {
		        {	add(StaleElementReferenceException.class);
		            add(NoSuchElementException.class);
		            add(TimeoutException.class);
		            add(InvalidElementStateException.class);
		            add(WebDriverException.class);
		            add(IndexOutOfBoundsException.class);
		        }
		        });
	 		WebElement element = wait1.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(locator);
		     }
		   });
	}
	
	public void expliciteWaitForElementClickable(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	

}
