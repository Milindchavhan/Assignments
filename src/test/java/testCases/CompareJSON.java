package testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import helperClass.ReadExcelFileData;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CompareJSON {
	
	ReadExcelFileData readExcelFileData = new ReadExcelFileData();
	
	public String response1(String URI)
	{
		RestAssured.baseURI =URI;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET);
		String responseBody = response.getBody().asString();
		//System.out.println("response is " +responseBody);
		return responseBody;
	}
	
	public String response2(String URI)
	{
		RestAssured.baseURI =URI;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET);
		String responseBody = response.getBody().asString();
		//System.out.println("response is " +responseBody);
		return responseBody;
	}
	
	@Test(dataProvider =  "readAPIFromExcelFile")
	public void compareJSONResponse(String APIFromFile1, String APIFromFile2)
	{
		response1(APIFromFile1);
		response2(APIFromFile2);
		if(response1(APIFromFile1).equalsIgnoreCase(response2(APIFromFile2)))
		{
			System.out.println(APIFromFile1 +" equals "+ APIFromFile2);
		}
		else
		{
			System.out.println(APIFromFile1 +" not equals "+ APIFromFile2);
		}
	}
	
	@DataProvider
	public String[][] readAPIFromExcelFile() throws IOException
	{
		return readExcelFileData.readAPIFromExcel();
	}
}
 