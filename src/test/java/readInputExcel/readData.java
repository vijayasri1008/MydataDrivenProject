package readInputExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class readData {
	Object[][] data=null;
	
	@DataProvider(name="logindata")
	public Object[][]logindataprovider( ) throws IOException  {
		data=readData(0);
		return data;
	}
		@Test(dataProvider="logindata")
		public Object[][] readData(int sheetno) throws IOException 
		{
			File src=new File("C:\\Users\\Hp\\Documents\\testxlapi.xlsx");
			FileInputStream excel;
			XSSFWorkbook workbook;
			Sheet sheet=null;
			Cell cell=null;
			try {
				excel = new FileInputStream(src);
				workbook=new XSSFWorkbook(excel);
				sheet=workbook.getSheetAt(sheetno);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
            Row row=sheet.getRow(0);
			int noOfRows = sheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfCells = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println(noOfCells);
			Object[][] data = new Object[noOfRows][noOfCells];
			 for(int i=1;i<noOfRows;i++) 
			{
				 for(int j=0;j<noOfCells;j++) 
					
				 {
					 cell = sheet.getRow(i-1).getCell(j);
						if (cell.getCellType() == CellType.STRING) {
							data[i][j] = cell.getStringCellValue();
						} else if (cell.getCellType() == CellType.BOOLEAN) {
							data[i][j] = cell.getBooleanCellValue();
						} else if (cell.getCellType() == CellType.NUMERIC) {
							data[i][j] = (long) cell.getNumericCellValue();
						} else {
							data[i][j] = "";
						}
									
			        
			          }
				
			}
			 return data;	
			 }
						@Test(dataProvider="logindata")
						public void test1(String username,String password) throws InterruptedException
						{
							WebDriverManager.chromedriver().setup();
							 WebDriver driver= new ChromeDriver();
							driver.get("https://opensource-demo.orangehrmlive.com/");
							WebElement user=driver.findElement(By.id("txtUsername"));
							user.sendKeys(username);
							WebElement pass=driver.findElement(By.id("txtPassword"));
							pass.sendKeys(password);
							WebElement submit=driver.findElement(By.id("btnLogin"));
							submit.click();
							Thread.sleep(2000);
							driver.quit();

						}

						
									


}
