package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPopUp {
	
	public OrderSummaryPopUp(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how = How.XPATH, using = "//p[@class= 'text-page-title-content']")
	public WebElement orderSummaryPageHeader;
	
	@FindBy(how = How.XPATH, using = "//a[@class= 'button-main-content']")
	public WebElement orderSummaryContinueButton;
	
	@FindBy(how = How.XPATH, using = "//div[@class= 'list-title text-actionable-bold' and contains(text(),'Credit')]")
	public WebElement creditCartOption;
	
	@FindBy(how = How.NAME, using = "cardnumber")
	public WebElement cardNumberTextField;
	
	@FindBy(how = How.XPATH, using = "//*[@placeholder= 'MM / YY']")
	public WebElement cardExpiryDateField;
	
	@FindBy(how = How.XPATH, using = "//*[@maxlength= '6']")
	public WebElement CVVNumberField;
	
	@FindBy(how = How.XPATH, using = "//*[@class= 'button-main-content']")
	public WebElement payNowButton;
	
	@FindBy(how = How.ID, using = "PaRes")
	public WebElement otpTextField;
	
	@FindBy(how = How.NAME, using = "ok")
	public WebElement otpOKButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"application\"]/div[3]/div/div/div/div/div/div[1]/span")
	public WebElement transactionFailMessage;
	
	@FindBy(how = How.XPATH, using = "//*[@class= 'notification-wrapper']")
	public WebElement transactionSuccessMessageOnHome;
}
