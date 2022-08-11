package readInputExcel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utilExcel {
	public static Object[][] converExcelToArray(String sheetName) {

		File file = new File("./Excel/praticeData.xlsx");

		FileInputStream fis = null;

//		HSSFWorkbook wb = new HSSFWorkbook();
		XSSFWorkbook workbook;
		Sheet sheet = null;
		Cell cell = null;
		try {
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfCells = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data = new Object[noOfRows][noOfCells];
		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < noOfCells; j++) {
				cell = sheet.getRow(i).getCell(j);
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
			

		
		 



}
