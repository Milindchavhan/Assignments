package helperClass;

import java.io.IOException;

import utility.ExcelFileUtilities;

public class ReadExcelFileData {
	
	public  ExcelFileUtilities excelFileUtilities = new ExcelFileUtilities();

	
	public String readURL() throws IOException
	{
		String excelFilePath = (System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.xlsx");
		String url = excelFileUtilities.getCellData(excelFilePath, "Sheet1",1,0);
		return url;
	}
	
	public String readPaymentType() throws IOException
	{
		String sucessPaymentType = excelFileUtilities.getCellData((System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.xlsx"), "Sheet1",1,1);
		return sucessPaymentType;
	}
	
	public String readSuccessCardNumber() throws IOException
	{
		String sucessCardNumber = excelFileUtilities.getCellData((System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.xlsx"), "Sheet1",1,2);
		return sucessCardNumber;
	}
	
	public String readSuccessExpiryDate() throws IOException
	{
		String sucessExpiryDate = excelFileUtilities.getCellData((System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.xlsx"), "Sheet1",1,3);
		return sucessExpiryDate;
	}
	
	public String readSuccessCVVNumber() throws IOException
	{
		String sucessCVVNumber = excelFileUtilities.getCellData((System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.xlsx"), "Sheet1",1,4);
		return sucessCVVNumber;
	}
	
	public String readSuccessOTP() throws IOException
	{
		String sucessOTP = excelFileUtilities.getCellData((System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.xlsx"), "Sheet1",1,5);
		return sucessOTP;
	}
//---------------------------
	public String readFailPaymentType() throws IOException
	{
		String failPaymentType = excelFileUtilities.getCellData((System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.xlsx"), "Sheet1",2,1);
		return failPaymentType;
	}
	
	public String readFailCardNumber() throws IOException
	{
		String failCardNumber = excelFileUtilities.getCellData((System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.xlsx"), "Sheet1",2,2);
		return failCardNumber;
	}
	
	public String readFailExpiryDate() throws IOException
	{
		String failExpiryDate = excelFileUtilities.getCellData((System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.xlsx"), "Sheet1",2,3);
		return failExpiryDate;
	}
	
	public String readFailCVVNumber() throws IOException
	{
		String failCVVNumber = excelFileUtilities.getCellData((System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.xlsx"), "Sheet1",2,4);
		return failCVVNumber;
	}
	
	public String readFailOTP() throws IOException
	{
		String failOTP = excelFileUtilities.getCellData((System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.xlsx"), "Sheet1",2,5);
		return failOTP;
	}
//--------------------------------------------------------------------------------------------------
	
	public String[][] readAPIFromExcel() throws IOException
	{
		String excelFilePath = (System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.xlsx");
		
		int rowNum = excelFileUtilities.getRowCount(excelFilePath, "Sheet2");
		int cellNum = excelFileUtilities.getCellCount(excelFilePath, "Sheet2", 1);
		String API[][] = new String [rowNum][cellNum];
		for(int i =1; i<=rowNum; i++)
		{
			for(int j =0; j<=cellNum-1; j++)
			{
				API[i-1][j] = excelFileUtilities.getCellData(excelFilePath, "sheet2", i, j);
				System.out.println(API[i-1][j] = excelFileUtilities.getCellData(excelFilePath, "sheet2", i, j));
			}
		}
		return API;
	}
}

