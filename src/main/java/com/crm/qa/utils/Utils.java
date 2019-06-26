package com.crm.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;
//import com.sun.jna.platform.FileUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Utils extends TestBase  {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	



	public static Map<String, String> getTestData(String filename2, String sheetname2, String classname) throws IOException {
		// TODO Auto-generated method stub
		
		Map<String, String> map = new HashMap<String, String>();
		FileInputStream ExcelFile = new FileInputStream(filename2);

		   // Access the required test data sheet

		   ExcelWBook = new XSSFWorkbook(ExcelFile);

		   ExcelWSheet = ExcelWBook.getSheet(sheetname2);
		   int startRow = 1;

		   int startCol = 1;

		   int ci,cj;
		   int totalRows = ExcelWSheet.getLastRowNum();
		   int totalCols = 2;


		   for (int i=startRow;i<=totalRows;i++) {           	   

			  if(null!=classname && classname.equalsIgnoreCase(ExcelWSheet.getRow(i).getCell(0).getStringCellValue())){
				   for (int j=startCol;j<=totalCols;j++){
	
					   map.put(ExcelWSheet.getRow(0).getCell(j).getStringCellValue(), ExcelWSheet.getRow(i).getCell(j).getStringCellValue());
	
					}
			  }
	}
		  
		return map;
	}



	public static void takeScreenshotAtEndOfTest() throws IOException {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		
		//File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(SrcFile, new File("/Users/548817u/Movies/SeleniumScreenshot" + "/screenshots/" +  System.currentTimeMillis() + ".png"));
		
	}
		
	}

