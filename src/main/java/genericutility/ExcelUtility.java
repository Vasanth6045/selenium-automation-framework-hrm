package genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetname, int rownum, int cellnum) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/atlascoretestdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		wb.close();
		return data;
		
	}
	
	public int getRowCount(String sheetname) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/atlascoretestdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return rowcount;
	}
	
	public void setDataIntoExcel(String sheetname, int rownum, int cellnum, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/atlascoretestdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(rownum).createCell(cellnum);
		FileOutputStream fos=new FileOutputStream("./src/test/resources/atlascoretestdata.xlsx");
		wb.write(fos);
		wb.close();
		
	}
}
