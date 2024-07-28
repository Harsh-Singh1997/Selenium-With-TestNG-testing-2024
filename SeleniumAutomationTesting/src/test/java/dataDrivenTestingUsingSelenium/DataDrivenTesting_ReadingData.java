package dataDrivenTestingUsingSelenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class DataDrivenTesting_ReadingData {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\Test-File\\TestBook1.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int row = sheet.getLastRowNum();
		System.out.println("Row Number: " + row);
		
		int totalCells = sheet.getRow(1).getLastCellNum();
		System.out.println("Total cell number: " + totalCells);
		
		System.out.println("CELL DATA:");
		System.out.println();
		
		for(int i = 1;i<row;i++) {
			
			XSSFRow currentrow = sheet.getRow(i);
			
			for(int j=0; j<totalCells;j++) {
				
				XSSFCell cell = currentrow.getCell(j);
				
				System.out.print(cell.toString() + "\t");
				
			}
			System.out.println();
		}
		
	}

}
