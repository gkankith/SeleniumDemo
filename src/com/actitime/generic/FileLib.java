package com.actitime.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
/**
 * this is a generic class for external property files
 * @author Dell
 *
 */
public class FileLib {
	/**
	 * this is a generic method to read the data from the property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	@Test
	public String getPropertyData(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./data/procommondata.property");
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(key);
		return data;
		
	}
	/**
	 * this is a generic method to read the data from the excel file
	 * @param sheet
	 * @param r
	 * @param c
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@Test
	public String getExcelData(String sheet,int r,int c) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream("./data/protestscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data=wb.getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
		return data;
		
	}
	/**
	 * this is a generic method to write the data into excel
	 * @param sheet
	 * @param r
	 * @param c
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@Test
	public void writeExcelData(String sheet,int r,int c,String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream("./data/protestscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(r).getCell(c).setCellValue(value);
		FileOutputStream fos=new FileOutputStream("./data/protestscript.xlsx");
		wb.write(fos);
	}
	

}
