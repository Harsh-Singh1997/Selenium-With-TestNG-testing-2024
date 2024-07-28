package dataDrivenTestingUsingSelenium;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DynamicDataDrivenTesting_Writing {

	public static void main(String[] args) throws IOException {
		
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\Test-File\\TestBook3_Dynamic.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet1 = workbook.createSheet("Dynamic_Data");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of rows:");
		int row = sc.nextInt();
		
		System.out.println("Enter number of column:");
		int col = sc.nextInt();
		
		for(int r = 0; r< row; r++) {
			XSSFRow currentrow = sheet1.createRow(r);
			for(int c =0; c< col;c++) {
				XSSFCell currentcell = currentrow.createCell(c);
				currentcell.setCellValue(sc.next());
				
			}
		}
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("<<...............Dynamic FIle Created...............>>");

	}

}
