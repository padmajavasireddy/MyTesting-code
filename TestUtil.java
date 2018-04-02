package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	/*public static void handleAlert()
	{
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='intercom-borderless-frame']")));
		driver.findElement(By.xpath("//div[@class='intercom-borderless-dismiss-button']")).click();
		driver.switchTo().defaultContent();
		}
	*/
	public static String readExcel(String fname, int sheetno, int rowno, int colno) throws IOException
	{
		System.out.println("reading Excel");
		//Specify the path of the file
		File src = new File(fname);
		//load file
		FileInputStream fis = new FileInputStream(src);
		 // Load workbook
		   XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Load sheet- Here we are loading first sheet only
		      XSSFSheet sh1= wb.getSheetAt(sheetno);
		   // getRow() specify which row we want to read.
		  // and getCell() specify which column to read.
		  // getStringCellValue() specify that we are reading String data.
		    return  sh1.getRow(rowno).getCell(colno).getStringCellValue();
		      
	}
	
	public static void takeScreenshot(String methodName) throws IOException
	{
		Calendar calendar = Calendar.getInstance(); 
	    SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	        try {
	        	String fname = ("failure screenshots" + methodName +"_"+ formater.format(calendar.getTime())+".png");			
	        	File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    		FileUtils.copyFile(srcfile, new File(fname));
	        	
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
		//File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(srcfile, new File("d://screenshot.png"));
	      //  Path path = PathConverter.convert("failure_screenshots/"+methodName+"_"+formater.format(calendar.getTime())+".png");
            //FileUtils.copyFile(srcFile, new File((String) PathConverter.convert("failure_screenshots/"+methodName+"_"+formater.format(calendar.getTime())+".png")));
		System.out.println("taken screenshot");
		
	}
	
}
