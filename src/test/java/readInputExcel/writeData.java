package readInputExcel;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeData {
	public static void main(String agrs[])
	{
		String s1="viji";
		String s2="sri";
		XSSFWorkbook workbook =new XSSFWorkbook();
		Sheet sheet=workbook.createSheet("testdata3");
		Row row=sheet.createRow(0);
		Cell cell=row.createCell(0);
		cell.setCellValue(s1);
		Cell cell1=row.createCell(1);
		cell1.setCellValue(s2);
		FileOutputStream fis=null;
		try {
			fis= new FileOutputStream("./Excel/praticeData.xlsx");
			workbook.write(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
