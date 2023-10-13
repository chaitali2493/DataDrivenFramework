package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	static Workbook book;
	static Sheet sheet;
	static String FilePath="D://selenium/loginTest.xlsx";
	
public static Object[][] getData(String sheetName)  {
	
FileInputStream file= null;

try {
	file=new FileInputStream(FilePath);
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	book= WorkbookFactory.create(file);
} catch (InvalidFormatException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
sheet= book.getSheet(sheetName);
//Object[][] data= new Object[5][1]
Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	System.out.println(sheet.getLastRowNum());
	System.out.println(sheet.getRow(0).getLastCellNum());
	
	for(int i=0; i<sheet.getLastRowNum(); i++){
	for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++){
		data[i][j]=sheet.getRow(i+1).getCell(j);	//i+1 because to skip first row of username and password
	}
	}
	
	return data;
}	
	
}
