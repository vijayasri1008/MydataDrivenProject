package readInputExcel;

import org.testng.annotations.DataProvider;


public class dataGiven {
	@DataProvider(name = "login")
	public Object[][] getLoginData() 
{

		return utilExcel.converExcelToArray("testdata");

}
}