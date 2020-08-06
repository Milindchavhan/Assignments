package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helperClass.ReadExcelFileData;
import pageObject.HomePage;
import pageObject.OrderSummaryPopUp;
import resources.Base;
import utility.SwitchToFrame;
import utility.Waits;

public class UITestAutomation extends Base{
	
	ReadExcelFileData readExcelFileData = new ReadExcelFileData();
	HomePage homePage;
	Waits waits;
	OrderSummaryPopUp orderSummaryPopUp;
	SwitchToFrame switchToFrame;
	@BeforeClass
	public void startUp() throws IOException
	{
		initializeBrowser();
		homePage = new HomePage(driver);
		waits = new Waits(driver);
		waits.implicitWait();
		orderSummaryPopUp = new OrderSummaryPopUp(driver);
		switchToFrame = new SwitchToFrame(driver);
		driver.get(readExcelFileData.readURL());
	}
	
	@Test
	public void successfullPayment() throws IOException, InterruptedException
	{
		homePage.buyNowButton.click();
		waits.expliciteWaitForElementClickable(homePage.cartCheckoutButton);
		homePage.cartCheckoutButton.click();
		switchToFrame.switchToFrameWithID(driver.findElement(By.id("snap-midtrans")));
		waits.expliciteWaitForElementClickable(orderSummaryPopUp.orderSummaryContinueButton);
		orderSummaryPopUp.orderSummaryContinueButton.click();
		orderSummaryPopUp.creditCartOption.click();
		orderSummaryPopUp.cardNumberTextField.sendKeys(readExcelFileData.readSuccessCardNumber());
		orderSummaryPopUp.cardExpiryDateField.sendKeys(readExcelFileData.readSuccessExpiryDate());
		orderSummaryPopUp.CVVNumberField.sendKeys(readExcelFileData.readSuccessCVVNumber());
		orderSummaryPopUp.payNowButton.click();
		Thread.sleep(12000);
		switchToFrame.switchToFrameWithID(driver.findElement(By.xpath("//*[@id='application']/div[3]/div/div/div/iframe")));
		orderSummaryPopUp.otpTextField.sendKeys(readExcelFileData.readSuccessOTP());
		orderSummaryPopUp.otpOKButton.click();
		switchToFrame.switchToDefault();
		waits.expliciteWaitForElementClickable(orderSummaryPopUp.transactionSuccessMessageOnHome);
		Assert.assertTrue(orderSummaryPopUp.transactionSuccessMessageOnHome.isDisplayed());
	}
	
	@Test
	public void unsuccessfullPayment() throws IOException, InterruptedException
	{
		homePage.buyNowButton.click();
		waits.expliciteWaitForElementClickable(homePage.cartCheckoutButton);
		//waits.fluentWait(By.xpath("//div[@class= 'cart-checkout']"));
		homePage.cartCheckoutButton.click();
		switchToFrame.switchToFrameWithID(driver.findElement(By.id("snap-midtrans")));
		waits.expliciteWaitForElementClickable(orderSummaryPopUp.orderSummaryContinueButton);
		orderSummaryPopUp.orderSummaryContinueButton.click();
		orderSummaryPopUp.creditCartOption.click();
		orderSummaryPopUp.cardNumberTextField.sendKeys(readExcelFileData.readFailCardNumber());
		orderSummaryPopUp.cardExpiryDateField.sendKeys(readExcelFileData.readSuccessExpiryDate());
		orderSummaryPopUp.CVVNumberField.sendKeys(readExcelFileData.readFailCVVNumber());
		orderSummaryPopUp.payNowButton.click();
		Thread.sleep(12000);
		switchToFrame.switchToFrameWithID(driver.findElement(By.xpath("//*[@id='application']/div[3]/div/div/div/iframe")));
		orderSummaryPopUp.otpTextField.sendKeys(readExcelFileData.readFailOTP());
		orderSummaryPopUp.otpOKButton.click();
		Thread.sleep(3000);
		switchToFrame.switchToFrameWithID(driver.findElement(By.id("snap-midtrans")));
		Assert.assertTrue(orderSummaryPopUp.transactionFailMessage.isDisplayed());
	}
	
	@AfterClass(alwaysRun = true)
	public void closeUp()
	{
		driver.quit();
	}

}
