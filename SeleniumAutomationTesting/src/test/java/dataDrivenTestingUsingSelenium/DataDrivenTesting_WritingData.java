package dataDrivenTestingUsingSelenium;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTesting_WritingData {

	public static void main(String[] args) throws IOException {

		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\Test-File\\TestBook2.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet1 = workbook.createSheet("Sheet1");
		
		
		//Add data in row 1
		XSSFRow row1 = sheet1.createRow(0);		
		row1.createCell(0).setCellValue("Name");
		row1.createCell(1).setCellValue("ID");
		row1.createCell(2).setCellValue("UserName");
		row1.createCell(3).setCellValue("Password");
		
		//Add data in row 2
		XSSFRow row2 = sheet1.createRow(1);		
		row2.createCell(0).setCellValue("John Smith");
		row2.createCell(1).setCellValue("100");
		row2.createCell(2).setCellValue("John123");
		row2.createCell(3).setCellValue("John@123Password");
		
		//Add data in row 3
		XSSFRow row3 = sheet1.createRow(2);		
		row3.createCell(0).setCellValue("James Nathan");
		row3.createCell(1).setCellValue("200");
		row3.createCell(2).setCellValue("James234");
		row3.createCell(3).setCellValue("James@234Password");
		
		//Add data in row 4
		XSSFRow row4 = sheet1.createRow(3);		
		row4.createCell(0).setCellValue("Jessica Singh");
		row4.createCell(1).setCellValue("300");
		row4.createCell(2).setCellValue("Jessica556");
		row4.createCell(3).setCellValue("Jessica@556Password");
		
		
		//Add data in row 5
		XSSFRow row5 = sheet1.createRow(4);		
		row5.createCell(0).setCellValue("Morgan Freeman");
		row5.createCell(1).setCellValue("400");
		row5.createCell(2).setCellValue("Morgan897");
		row5.createCell(3).setCellValue("Morgan@879Password");		
		
		//Add data in row 6
		XSSFRow row6 = sheet1.createRow(5);		
		row6.createCell(0).setCellValue("Tessa Flower");
		row6.createCell(1).setCellValue("500");
		row6.createCell(2).setCellValue("Tessa369");
		row6.createCell(3).setCellValue("Tessa@369Password");		
		
		workbook.write(file);
		workbook.close();
		file.close();		

		
		System.out.println("================File is created================");
	}

}
