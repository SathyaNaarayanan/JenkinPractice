package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperation {

	static File f;
	static FileInputStream fs;
	static XSSFWorkbook wb;
	static XSSFSheet ws;
	
	public List<String> read_data() throws IOException {
		List<String> lst = new ArrayList<String>();
		try {
		f = new File(System.getProperty("user.dir")+"\\TestData.xlsx");
		fs = new FileInputStream(f);
		wb = new XSSFWorkbook(fs);
		ws = wb.getSheet("Sheet1");
		
		int rows = ws.getLastRowNum();
		
		String data = "";
		for(int i=0; i<=rows; i++) {
			data = ws.getRow(i).getCell(0).getStringCellValue();
			lst.add(data);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			wb.close();
		}
		return lst;
		
	}
	
	
}
