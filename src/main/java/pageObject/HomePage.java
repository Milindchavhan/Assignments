package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class= 'btn buy']")
	public WebElement buyNowButton;
	
	@FindBy(how = How.XPATH, using = "//div[@class= 'cart-checkout']")
	public WebElement cartCheckoutButton;

}
