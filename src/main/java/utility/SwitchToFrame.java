package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwitchToFrame {
	WebDriver driver;
	public SwitchToFrame(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void switchToFrameWithID(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void switchToDefault()
	{
		driver.switchTo().defaultContent();
	}

}
